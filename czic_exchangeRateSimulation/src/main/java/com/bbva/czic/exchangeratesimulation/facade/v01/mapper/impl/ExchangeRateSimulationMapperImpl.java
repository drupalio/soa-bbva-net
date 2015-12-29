package com.bbva.czic.exchangeratesimulation.facade.v01.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import com.bbva.czic.dto.net.ExchangeRate;
import com.bbva.czic.dto.net.ExchangeRateAssessments;
import com.bbva.czic.dto.net.ExchangeRateSimulation;
import com.bbva.czic.exchangeratesimulation.business.dto.DTOIntExchangeRate;
import com.bbva.czic.exchangeratesimulation.business.dto.DTOIntExchangeRateSimulation;
import com.bbva.czic.exchangeratesimulation.business.dto.DTOIntExchangeRateValues;
import com.bbva.czic.exchangeratesimulation.business.dto.DTOIntMoney;
import com.bbva.czic.exchangeratesimulation.business.dto.DTOIntOptionsList;
import com.bbva.czic.exchangeratesimulation.facade.v01.mapper.IExchangeRateSimulationMapper;
import com.bbva.czic.routine.commons.rm.utils.mappers.Mapper;

@Mapper(value = "exchangeRateSimulation-mapper")
public class ExchangeRateSimulationMapperImpl implements IExchangeRateSimulationMapper {

	@Override
	public ExchangeRateSimulation map(DTOIntExchangeRateSimulation dtoIntExchangeRateSimulation) {

		ExchangeRateSimulation exchangeRateSimulation = new ExchangeRateSimulation();

		List<ExchangeRate> listExchangeRates = new ArrayList<ExchangeRate>();

		for (DTOIntExchangeRate exchangeRates : dtoIntExchangeRateSimulation.getExchangeRates()) {
			ExchangeRateAssessments exchangeRateAssessments = new ExchangeRateAssessments();
			exchangeRateAssessments.setType(exchangeRates.getExchangeRateAssessments().getType());
			exchangeRateAssessments.setValue(exchangeRates.getExchangeRateAssessments().getValue());

			ExchangeRate exchangeRate = new ExchangeRate();
			exchangeRate.setExchangeRateAssessments(exchangeRateAssessments);
			listExchangeRates.add(exchangeRate);

		}
		exchangeRateSimulation.setExchangeRates(listExchangeRates);

		return exchangeRateSimulation;
	}

	@Override
	public DTOIntExchangeRateSimulation map(ExchangeRateSimulation exchangeRateSimulation) {
		DTOIntExchangeRateSimulation dtoIntExchangeRateSimulation = new DTOIntExchangeRateSimulation();
		DTOIntOptionsList dtoOptionsList = new DTOIntOptionsList();
		dtoOptionsList.setId(exchangeRateSimulation.getType().getId());
		dtoIntExchangeRateSimulation.setType(dtoOptionsList);

		List<DTOIntExchangeRate> listExchangeRates = new ArrayList<DTOIntExchangeRate>();
		DTOIntExchangeRate dtoIntExchangeRate = new DTOIntExchangeRate();
		DTOIntExchangeRateValues dtoIntExchangeRateValues = new DTOIntExchangeRateValues();

		if (exchangeRateSimulation.getExchangeRates().get(0).getExchangeRateValues().getPurchaseValue() != null) {
			DTOIntMoney dtoIntMoney = new DTOIntMoney();
			dtoIntMoney.setCurrency(exchangeRateSimulation.getExchangeRates().get(0).getExchangeRateValues()
					.getPurchaseValue().getCurrency());
			dtoIntMoney.setAmount(exchangeRateSimulation.getExchangeRates().get(0).getExchangeRateValues()
					.getPurchaseValue().getAmount());
			dtoIntExchangeRateValues.setPurchaseValue(dtoIntMoney);
			dtoIntExchangeRate.setExchangeRateValues(dtoIntExchangeRateValues);
			listExchangeRates.add(dtoIntExchangeRate);
			dtoIntExchangeRateSimulation.setExchangeRates(listExchangeRates);
		}
		if (exchangeRateSimulation.getExchangeRates().get(0).getExchangeRateValues().getSaleValue() != null) {
			DTOIntMoney dtoIntMoney = new DTOIntMoney();
			dtoIntMoney.setCurrency(exchangeRateSimulation.getExchangeRates().get(0).getExchangeRateValues()
					.getSaleValue().getCurrency());
			dtoIntMoney.setAmount(exchangeRateSimulation.getExchangeRates().get(0).getExchangeRateValues()
					.getSaleValue().getAmount());
			dtoIntExchangeRateValues.setPurchaseValue(dtoIntMoney);
			dtoIntExchangeRate.setExchangeRateValues(dtoIntExchangeRateValues);
			listExchangeRates.add(dtoIntExchangeRate);
			dtoIntExchangeRateSimulation.setExchangeRates(listExchangeRates);
		}
		if (exchangeRateSimulation.getExchangeRates().get(0).getExchangeRateValues().getPurchaseValue() == null
				&& exchangeRateSimulation.getExchangeRates().get(0).getExchangeRateValues().getSaleValue() == null) {
			return null;
		} else {
			return dtoIntExchangeRateSimulation;
		}
	}

}
