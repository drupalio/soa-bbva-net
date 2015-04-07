/*
 * Orika - simpler, better and faster Java bean mapping
 * 
 * Copyright (C) 2011 Orika authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bbva.zic.routine.mapper.impl.generator;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

import com.bbva.zic.routine.mapper.impl.GeneratedMapperBase;
import com.bbva.zic.routine.mapper.metadata.ClassMap;
import com.bbva.zic.routine.mapper.metadata.MapperKey;
import com.bbva.zic.routine.mapper.metadata.Type;
import javassist.CannotCompileException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bbva.zic.routine.mapper.BoundMapperFacade;
import com.bbva.zic.routine.mapper.Converter;
import com.bbva.zic.routine.mapper.MapperFactory;
import com.bbva.zic.routine.mapper.MappingContext;
import com.bbva.zic.routine.mapper.MappingException;
import com.bbva.zic.routine.mapper.metadata.FieldMap;

public final class MapperGenerator {
    
    private static Logger LOGGER = LoggerFactory.getLogger(MapperGenerator.class);
    
    private final MapperFactory mapperFactory;
    private final CompilerStrategy compilerStrategy;
    
    public MapperGenerator(MapperFactory mapperFactory, CompilerStrategy compilerStrategy) {
        this.mapperFactory = mapperFactory;
        this.compilerStrategy = compilerStrategy;
    }
    
    public GeneratedMapperBase build(ClassMap<?, ?> classMap, MappingContext context) {
        
        try {
            compilerStrategy.assureTypeIsAccessible(classMap.getAType().getRawType());
            compilerStrategy.assureTypeIsAccessible(classMap.getBType().getRawType());
            
            final GeneratedSourceCode mapperCode = new GeneratedSourceCode(
                    classMap.getMapperClassName(), GeneratedMapperBase.class,
                    compilerStrategy);
            
            UsedTypesContext usedTypes = new UsedTypesContext();
            UsedConvertersContext usedConverters = new UsedConvertersContext();
            UsedMapperFacadesContext usedMapperFacades = new UsedMapperFacadesContext();
            
            StringBuilder logDetails;
            if (LOGGER.isDebugEnabled()) {
            	logDetails = new StringBuilder();
            	logDetails.append("Generating new mapper for (" + classMap.getAType()+", " + classMap.getBTypeName() +")");
            } else {
            	logDetails = null;
            }
            
            Set<FieldMap> mappedFields = new LinkedHashSet<FieldMap>();
            mappedFields.addAll(addMapMethod(mapperCode, true, classMap, usedTypes, usedConverters, usedMapperFacades, logDetails));
            mappedFields.addAll(addMapMethod(mapperCode, false, classMap, usedTypes, usedConverters, usedMapperFacades, logDetails));
            
            GeneratedMapperBase instance = mapperCode.getInstance();
            instance.setAType(classMap.getAType());
            instance.setBType(classMap.getBType());
            
            Type<Object>[] usedTypesArray = usedTypes.toArray();
            Converter<Object,Object>[] usedConvertersArray = usedConverters.toArray();
            BoundMapperFacade<Object, Object>[] usedMapperFacadesArray = usedMapperFacades.toArray();
            if (logDetails != null) {
            	if (usedTypesArray.length > 0) {
            		logDetails.append("\n\t" + Type.class.getSimpleName() + "s used: " + Arrays.toString(usedTypesArray));
            	}
            	if (usedConvertersArray.length > 0) {
            		logDetails.append("\n\t" + Converter.class.getSimpleName() + "s used: " + Arrays.toString(usedConvertersArray));
            	}
            	if (usedMapperFacadesArray.length > 0) {
            	    logDetails.append("\n\t" + BoundMapperFacade.class.getSimpleName() + "s used: " + Arrays.toString(usedMapperFacadesArray));
            	}
            } 
            instance.setUsedTypes(usedTypesArray);
            instance.setUsedConverters(usedConvertersArray);
            instance.setUsedMapperFacades(usedMapperFacadesArray);
            if (logDetails != null) {
            	LOGGER.debug(logDetails.toString());
            }
            
            /*
             * Add a copy of the ClassMap to the current mapping context, which only contains the field
             * maps that were processed by this mapper generation; this can later be used by ObjectFactory
             * generation when selecting a constructor -- since we only need a constructor which handles 
             * the fields not mapped by the generated mapper
             */
            classMap = classMap.copy(mappedFields);
            context.registerMapperGeneration(classMap);
            
            return instance;
            
        } catch (final Exception e) {
            throw new MappingException(e);
        }
    }
    
    private String getFieldTag(FieldMap fieldMap) {
    	return "\n\t Field(" + fieldMap.getSource() + ", " + fieldMap.getDestination() + ") : ";
    }
    
    private Set<FieldMap> addMapMethod(GeneratedSourceCode code, boolean aToB, ClassMap<?, ?> classMap, UsedTypesContext usedTypes, UsedConvertersContext usedConverters, UsedMapperFacadesContext usedMappers,StringBuilder logDetails) throws CannotCompileException {
        
        
        Set<FieldMap> mappedFields = new LinkedHashSet<FieldMap>();
    	if (logDetails != null) {
        	if (aToB) {
        		logDetails.append("\n\t" +code.getClassSimpleName() + ".mapAToB("+ classMap.getAType()+", " + classMap.getBTypeName() +") {");
        	} else {
        		logDetails.append("\n\t" +code.getClassSimpleName() + ".mapBToA("+ classMap.getBType()+", " + classMap.getATypeName() +") {");
        	}
        }
    	
        final CodeSourceBuilder out = new CodeSourceBuilder(usedTypes, usedConverters, usedMappers, mapperFactory);
        final String mapMethod = "map" + (aToB ? "AtoB" : "BtoA");
        out.append("\tpublic void ")
                .append(mapMethod)
                .append("(java.lang.Object a, java.lang.Object b, %s mappingContext) {\n\n", MappingContext.class.getCanonicalName());
        
        VariableRef source;
        VariableRef destination;
        if (aToB) {
            source = new VariableRef(classMap.getAType(), "source");
            destination = new VariableRef(classMap.getBType(), "destination"); 
        } else {
            source = new VariableRef(classMap.getBType(), "source");
            destination = new VariableRef(classMap.getAType(), "destination");
        }
         
        out.statement("super.%s(a, b, mappingContext);", mapMethod);
        out.statement(source.declare("a"));
        out.statement(destination.declare("b"));
        LinkedList<FieldMap> nestedFieldMaps = new LinkedList<FieldMap>();
        
        for (FieldMap currentFieldMap : classMap.getFieldsMapping()) {
            
        	
            if (currentFieldMap.isExcluded()) {
            	if (logDetails != null) {
            		logDetails.append(getFieldTag(currentFieldMap) + "excuding (explicitly)");
            	}
                continue;
            }
            
            if (isAlreadyExistsInUsedMappers(currentFieldMap, classMap)) {
            	if (logDetails != null) {
            		logDetails.append(getFieldTag(currentFieldMap) + "excluding because it is already handled by another mapper in this hierarchy");
            		
            	}
            	continue;
            }
            
            FieldMap fieldMap = currentFieldMap;
            if (!aToB) {
                fieldMap = fieldMap.flip();
            }
            
            if (fieldMap.getElementMap() != null) {
            	nestedFieldMaps.add(fieldMap);
            	continue;
            }
            
            if (logDetails != null) {
        		logDetails.append(getFieldTag(fieldMap));
        	}
            
            if (!fieldMap.isIgnored()) {
                try {
                    FieldMap f = generateFieldMapCode(out, fieldMap, classMap, destination.type(), logDetails);
                    if (f != null) {
                        mappedFields.add(currentFieldMap);
                    }
                } catch (final Exception e) {
                    MappingException me = new MappingException(e);
                    me.setSourceProperty(fieldMap.getSource());
                    me.setDestinationProperty(fieldMap.getDestination());
                    me.setSourceType(source.type());
                    me.setDestinationType(destination.type());
                    throw me;
                }
            } else if (logDetails !=null) {
            	logDetails.append("ignored for this mapping direction");
            }
        }
        
        while (!nestedFieldMaps.isEmpty()) {
        	Set<FieldMap> associated = out.getAssociatedMappings(nestedFieldMaps, nestedFieldMaps.getFirst());
        	nestedFieldMaps.removeAll(associated);
        	mappedFields.addAll(out.fromMultiOccurrenceToMultiOccurrence(associated, logDetails));
        }
        
        out.append("\n\t\tif(customMapper != null) { \n\t\t\t customMapper.")
                .append(mapMethod)
                .append("(source, destination, mappingContext);\n\t\t}");
        
        out.append("\n\t}");
        
        if (logDetails != null) {
        	logDetails.append("\n\t}");
        }
        
        code.addMethod(out.toString());
        
        return mappedFields;
    }
    
    private boolean isAlreadyExistsInUsedMappers(FieldMap fieldMap, ClassMap<?, ?> classMap) {
        
        Set<ClassMap<Object, Object>> usedClassMapSet = mapperFactory.lookupUsedClassMap(new MapperKey(classMap.getAType(),
                classMap.getBType()));
        
        if (!fieldMap.isByDefault()) {
        	return false;
        }
        
        for (ClassMap<Object, Object> usedClassMap : usedClassMapSet) {
            for(FieldMap usedFieldMap: usedClassMap.getFieldsMapping()) {
            	if (usedFieldMap.getSource().equals(fieldMap.getSource())
            			&& usedFieldMap.getDestination().equals(fieldMap.getDestination())) {
            		return true;
            	}
            }
        }
        
        return false;
    }
    
    private FieldMap generateFieldMapCode(CodeSourceBuilder code, FieldMap fieldMap, ClassMap<?, ?> classMap, Type<?> destinationType, StringBuilder logDetails) throws Exception {
        
        final VariableRef sourceProperty = new VariableRef(fieldMap.getSource(), "source");
        final VariableRef destinationProperty = new VariableRef(fieldMap.getDestination(), "destination");
        
        if (!sourceProperty.isReadable() || ((!destinationProperty.isAssignable()) && !destinationProperty.isCollection() && !destinationProperty.isArray() && !destinationProperty.isMap())) {
            if (logDetails != null) {
                
            	logDetails.append("excluding because ");
    			if (!sourceProperty.isReadable()) {
    			    Type<?> sourceType = classMap.getAType().equals(destinationType) ? classMap.getBType() : classMap.getAType();
    				logDetails.append(sourceType + "." + fieldMap.getSource().getName() + "(" + fieldMap.getSource().getType() + ") is not readable");
    			} else {
    				// TODO: this brings up an important case: sometimes the destination is not assignable, 
    				// but it's properties can still be mapped in-place. Should we handle it?
    			    
    				logDetails.append(destinationType + "." + fieldMap.getSource().getName() + "(" + fieldMap.getSource().getType() + ") is neither assignable nor an array, collection, or map");
    			}		
            }
        	return null;
        }
        
        // Make sure the source and destination types are accessible to the builder
        compilerStrategy.assureTypeIsAccessible(sourceProperty.rawType());
        compilerStrategy.assureTypeIsAccessible(destinationProperty.rawType());

        return code.mapFields(fieldMap, sourceProperty, destinationProperty, destinationType, logDetails);
    }
    
}
