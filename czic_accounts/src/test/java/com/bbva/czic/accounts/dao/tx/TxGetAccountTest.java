package com.bbva.czic.accounts.dao.tx;

import com.bbva.czic.accounts.business.dto.DTOIntAccount;
import com.bbva.czic.accounts.business.dto.DTOIntFilterAccount;
import com.bbva.czic.accounts.business.impl.SrvIntAccounts;
import com.bbva.czic.accounts.dao.mappers.TxAccountMapper;
import com.bbva.czic.accounts.dao.model.ozna.FormatoOZNCENA0;
import com.bbva.czic.accounts.dao.model.ozna.FormatoOZNCSNA0;
import com.bbva.czic.accounts.dao.model.ozna.PeticionTransaccionOzna;
import com.bbva.czic.accounts.dao.model.ozna.RespuestaTransaccionOzna;
import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.czic.routine.commons.rm.utils.test.SpringContextBbvaTest;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import javax.annotation.Resource;

/**
 * Created by Entelgy on 12/02/2015.
 */
public class TxGetAccountTest extends SpringContextBbvaTest {

    @Mock
    private InvocadorTransaccion<PeticionTransaccionOzna, RespuestaTransaccionOzna> transaccionOzna;

    @Mock
    private TxAccountMapper txAccountMapper;

    @InjectMocks
    private TxGetAccount txGetAccount;

    private BusinessServiceException bsn;

    @Before
    public void init(){
        txGetAccount = new TxGetAccount();
        MockitoAnnotations.initMocks(this);
        bsn = new BusinessServiceException(EnumError.TECHNICAL_ERROR.getAlias());
    }

    @Test(expected = BusinessServiceException.class)
    public void testMapDtoInToRequestFormatException(){
        final DTOIntFilterAccount filter = new DTOIntFilterAccount();

        when(txAccountMapper.mapInOzna(any(DTOIntFilterAccount.class))).thenThrow(bsn);

        txGetAccount.mapDtoInToRequestFormat(filter);
    }

    @Test
    public void testMapDtoInToRequestFormat(){
        final DTOIntFilterAccount filter = new DTOIntFilterAccount();
        final FormatoOZNCENA0 formato = new FormatoOZNCENA0();

        when(txAccountMapper.mapInOzna(any(DTOIntFilterAccount.class))).thenReturn(formato);

        FormatoOZNCENA0 salida = txGetAccount.mapDtoInToRequestFormat(filter);
        assertNotNull(salida);
    }

    @Test(expected = BusinessServiceException.class)
    public void testMapResponseFormatToDtoOutException(){
        final FormatoOZNCSNA0 formato = new FormatoOZNCSNA0();

        when(txAccountMapper.mapOutOzna(any(FormatoOZNCSNA0.class))).thenThrow(bsn);

        txGetAccount.mapResponseFormatToDtoOut(formato, new DTOIntFilterAccount());
    }

    @Test
    public void testMapResponseFormatToDtoOut(){
        final FormatoOZNCSNA0 formato = new FormatoOZNCSNA0();
        final DTOIntAccount acc = new DTOIntAccount();

        when(txAccountMapper.mapOutOzna(any(FormatoOZNCSNA0.class))).thenReturn(acc);

        DTOIntAccount salida = txGetAccount.mapResponseFormatToDtoOut(formato, new DTOIntFilterAccount());
        assertNotNull(salida);
    }

    @Test
    public void testGetTransaction(){
        InvocadorTransaccion<PeticionTransaccionOzna, RespuestaTransaccionOzna> transaccion =
                (InvocadorTransaccion<PeticionTransaccionOzna, RespuestaTransaccionOzna>) txGetAccount.getTransaction();
        assertNotNull(transaccion);
    }
}
