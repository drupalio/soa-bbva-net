package com.bbva.czic.routine.commons.rm.utils;

import javax.swing.text.EditorKit;

/**
 * Created by Entelgy on 28/01/2015.
 */
public enum EDateFormat {

    ANIO_MES_DIA("yyyy-MM-dd");

    private String pattern;

    private EDateFormat(String pattern){
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }
}
