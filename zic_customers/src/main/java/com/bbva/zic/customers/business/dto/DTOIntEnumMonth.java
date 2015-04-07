package com.bbva.zic.customers.business.dto;

import java.util.Calendar;
import java.util.Date;

public enum DTOIntEnumMonth {
    JANUARY("01"),
    FEBRUARY("02"),
    MARCH("03"),
    APRIL("04"),
    MAY("05"),
    JUNE("06"),
    JULY("07"),
    AUGUST("08"),
    SEPTEMBER("09"),
    OCTOBER("10"),
    NOVEMBER("11"),
    DECEMBER("12");

    String code;

    private DTOIntEnumMonth(String codigo){
        this.code = codigo;
    }

    public String getCode() {
        return code;
    }

    public static Date getBycode(String code){
        Calendar cal = Calendar.getInstance();
        Integer month = null;
        for(DTOIntEnumMonth m : DTOIntEnumMonth.values()){
            if(m.getCode().equals(code)){
                month = Integer.valueOf(m.getCode());
            }
        }
        if(month != null){
            cal.set(Calendar.MONTH, month);
            return cal.getTime();
        }
        return null;
    }
}
