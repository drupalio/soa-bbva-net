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

package com.bbva.czic.routine.mapper.metadata;

import com.bbva.czic.routine.mapper.MappedTypePair;


public class MapperKey implements MappedTypePair<Object,Object>{

	private Type<Object> aType;
	private Type<Object> bType;

	@SuppressWarnings("unchecked")
    public MapperKey(Type<?> aType, Type<?> bType) {
		this.aType = (Type<Object>) aType;
		this.bType = (Type<Object>) bType;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
            return true;
        }
		if (o == null || getClass() != o.getClass()) {
            return false;
        }

		final MapperKey mapperKey = (MapperKey) o;

		return equals(aType, mapperKey.aType) && equals(bType, mapperKey.bType)
				|| equals(aType, mapperKey.bType) || equals(bType, mapperKey.aType);

	}

	private boolean equals(Type<?> a, Type<?> b) {
		return a == null ? b == null : a.equals(b);
	}

	public String toString() {
	    return "{[A]"+aType+",[B]"+bType+"}";
	}
	
	@Override
	public int hashCode() {
		int result = aType != null ? aType.hashCode() : 0;
		result = result + (bType != null ? bType.hashCode() : 0);
		return result;
	}

	public Type<Object> getAType() {
		return aType;
	}

	@SuppressWarnings("unchecked")
    public void setAType(Type<? super Object> aType) {
		this.aType = (Type<Object>) aType;
	}

	public Type<Object> getBType() {
		return bType;
	}

	@SuppressWarnings("unchecked")
    public void setBType(Type<?> bType) {
		this.bType = (Type<Object>) bType;
	}
}