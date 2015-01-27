package com.bbva.czic.executives.facade.v01.mapper.impl;

import com.bbva.czic.dto.net.Account;
import com.bbva.czic.dto.net.Executive;
import com.bbva.czic.dto.net.Office;
import com.bbva.czic.executives.business.dto.DTOIntExecutive;
import com.bbva.czic.executives.business.dto.DTOIntExecutivesFilter;
import com.bbva.czic.executives.business.dto.DTOIntOffice;
import com.bbva.czic.executives.facade.v01.mapper.IExecutivesMapper;
import com.bbva.czic.routine.commons.rm.utils.fiql.FiqlType;
import com.bbva.czic.routine.commons.rm.utils.mappers.AbstractBbvaConfigurableMapper;
import com.bbva.czic.routine.commons.rm.utils.mappers.Mapper;
import com.bbva.czic.routine.mapper.MapperFactory;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
@Mapper(value = "executives-mapper")
public class ExecutivesMapper extends AbstractBbvaConfigurableMapper implements IExecutivesMapper {


		private static I18nLog log = I18nLogFactory
				.getLogI18n(ExecutivesMapper.class, "META-INF/spring/i18n/log/mensajesLog");

		@Override
		protected void configure(MapperFactory factory) {

			super.configure(factory);

			// Map Executive <-> DTOIntExecutive
			factory.classMap(Executive.class, DTOIntExecutive.class).field("id", "executiveId").field("name", "name")
					.field("phone", "phone").field("office", "office").field("email", "email").byDefault().register();

			// Map Office <-> DTOIntOffice
			factory.classMap(Office.class, DTOIntOffice.class).field("code", "code").field("name", "name")
					.field("postalAddress", "postalAddress").byDefault().register();


		}




	@Override
	public DTOIntExecutivesFilter getDTOIntFilter(String filter) {

		final String id = this.getEqValue(filter, FiqlType.id.name());
		final String type = this.getEqValue(filter, FiqlType.type.name());

		final DTOIntExecutivesFilter dtoIntExecutivesFilter = new DTOIntExecutivesFilter();
		dtoIntExecutivesFilter.setId(id);
		dtoIntExecutivesFilter.setType(type);

		return dtoIntExecutivesFilter;

	}

	/**
	 * Metodo encargado de mapear un DTO interno de tipo DTOIntAccount a un DTO externo de tipo Account
	 *
	 * @author David Tafur
	 * @param dtoIntExecutive
	 * @return
	 */
	@Override
	public Executive map(DTOIntExecutive dtoIntExecutive) {
		log.info("map- return:Executive-parameter:dtoIntExecutive");
		return map(dtoIntExecutive, Executive.class);
	}

}
