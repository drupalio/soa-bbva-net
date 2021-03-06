package com.bbva.czic.products.dao.tx;

import javax.annotation.Resource;

import com.bbva.czic.dto.net.Holder;
import com.bbva.czic.products.business.dto.DTOIntHolder;
import com.bbva.czic.products.dao.model.oznt.*;
import com.bbva.czic.routine.commons.rm.utils.tx.impl.DoubleBbvaTransaction;
import com.bbva.czic.routine.commons.rm.utils.tx.impl.SimpleDobleFormatBbvaTransaction;
import org.springframework.stereotype.Component;

import com.bbva.czic.products.business.dto.DTOIntConditions;
import com.bbva.czic.products.business.dto.DTOIntProduct;
import com.bbva.czic.products.dao.mapper.TxProductsMapper;
import com.bbva.czic.routine.commons.rm.utils.tx.impl.SimpleBbvaTransaction;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrador on 05/01/2015.
 */
@Component("tx-get-conditions")
public class TxGetConditions extends SimpleDobleFormatBbvaTransaction<DTOIntProduct, FormatoOZECNTE0, DTOIntConditions, FormatoOZECNTS0, FormatoOZECNTS1> {

	@Resource(name="transaccionOznt")
	private transient InvocadorTransaccion<PeticionTransaccionOznt, RespuestaTransaccionOznt> transaccionOznt;
	
	@Resource(name = "txProductMapper")
	private TxProductsMapper txProductMapper;


	@Override
	protected FormatoOZECNTE0 mapDtoInToRequestFormat(DTOIntProduct dtoIn) {
		return txProductMapper.mapInOznt(dtoIn);
	}

	@Override
	protected DTOIntConditions mapResponseFormatToDtoOut(FormatoOZECNTS0 formatOutput, DTOIntProduct dtoIn, DTOIntConditions dtoOut) {
		return txProductMapper.mapOutOznt(formatOutput);
	}

	@Override
	protected DTOIntConditions mapResponseFormatToInnerDtoOfOutDto(FormatoOZECNTS1 formatInnerOutput, DTOIntConditions dtoOut) {
		List<DTOIntHolder> holderList = new ArrayList<DTOIntHolder>();
		holderList.add(txProductMapper.mapOutOznt1(formatInnerOutput));
		dtoOut.setHolders(holderList);
		return dtoOut;
	}

	@Override
	protected InvocadorTransaccion<?, ?> getTransaction() {
		return transaccionOznt;
	}
}
