package com.bbva.czic.loan.facade.v01.utils.impl;


import com.bbva.czic.loan.dao.model.ozni.FormatoOZNCSNI0;
import com.bbva.czic.loan.dao.model.oznj.FormatoOZNCSNJ0;
import com.bbva.czic.loan.dao.model.oznk.FormatoOZNCSNK0;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class LoanDAOMock  {

    public static List<FormatoOZNCSNI0> listRotaryQuotaMovements() throws BusinessServiceException {

        FormatoOZNCSNI0 dtoIntMovement = new FormatoOZNCSNI0();
        List<FormatoOZNCSNI0> dtoIntMovementList = new ArrayList<FormatoOZNCSNI0>();
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(new Date());
        dtoIntMovement.setNumeope("0000000001");
        dtoIntMovement.setFechaop(new Date());
        dtoIntMovement.setResto("HABILITADO");
        dtoIntMovement.setValorop("200000");
        dtoIntMovement.setBalance("70000");
        dtoIntMovement.setTipope("Retiro");


        dtoIntMovementList.add(dtoIntMovement);

        FormatoOZNCSNI0 dtoIntMovement2 = new FormatoOZNCSNI0();

        dtoIntMovement2.setNumeope("0000000001");
        dtoIntMovement2.setFechaop(new Date());
        dtoIntMovement2.setResto("HABILITADO");
        dtoIntMovement2.setValorop("150000");
        dtoIntMovement2.setBalance("50000");
        dtoIntMovement2.setTipope("Abono");

        dtoIntMovementList.add(dtoIntMovement2);

        FormatoOZNCSNI0 dtoIntMovement3 = new FormatoOZNCSNI0();

        dtoIntMovement3.setNumeope("0000000001");
        dtoIntMovement3.setFechaop(new Date());
        dtoIntMovement3.setResto("HABILITADO");
        dtoIntMovement3.setValorop("600000");
        dtoIntMovement3.setBalance("50000");
        dtoIntMovement3.setTipope("Retiro");

        dtoIntMovementList.add(dtoIntMovement3);

        return dtoIntMovementList;
    }


    public static FormatoOZNCSNJ0 getRotaryQuota() throws BusinessServiceException {
        FormatoOZNCSNJ0 formatoOZNCSNJ0 = new FormatoOZNCSNJ0();

        formatoOZNCSNJ0.setPagomin("23000");
        formatoOZNCSNJ0.setSaldoto("250000");
        formatoOZNCSNJ0.setNumcont("00236666666666665432");
        formatoOZNCSNJ0.setHonorar("2300");
        formatoOZNCSNJ0.setSaldope("56000");
        formatoOZNCSNJ0.setFechaco(new Date());
        formatoOZNCSNJ0.setFechali(new Date());
        formatoOZNCSNJ0.setFechaca(new Date());
        formatoOZNCSNJ0.setCuotato("450000");
        formatoOZNCSNJ0.setDesctar("3456");
        formatoOZNCSNJ0.setMntosol("103000");
        formatoOZNCSNJ0.setTipprod("Credito");
        return formatoOZNCSNJ0;
    }


    public static FormatoOZNCSNK0 getRotaryQuotaMovement() throws BusinessServiceException {

        FormatoOZNCSNK0 formatoOZNCSNK0 = new FormatoOZNCSNK0();

        formatoOZNCSNK0.setFechaop(new Date());
        formatoOZNCSNK0.setBalance("4500");
        formatoOZNCSNK0.setResto("4000");
        formatoOZNCSNK0.setCoutaf("750000");
        formatoOZNCSNK0.setCoutat("800000");
        formatoOZNCSNK0.setEstado("HABILITADO");
        formatoOZNCSNK0.setImporte("93000");
        formatoOZNCSNK0.setNumemov("123");
        formatoOZNCSNK0.setDescop("3000");
        return formatoOZNCSNK0;
    }
}