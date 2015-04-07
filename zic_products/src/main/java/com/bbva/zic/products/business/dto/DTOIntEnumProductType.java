
package com.bbva.zic.products.business.dto;




public class DTOIntEnumProductType {

    public final static long serialVersionUID = 1L;
    private static String AC;
    private static String CA;
    private static String LO;
    private static String SI;

    public DTOIntEnumProductType() {
        //default constructor
    }

    public static String getAC() {
        return AC;
    }

    public void setAC(String AC) {
        this.AC = AC;
    }

    public static String getCA() {
        return CA;
    }

    public void setCA(String CA) {
        this.CA = CA;
    }

    public static String getLO() {
        return LO;
    }

    public void setLO(String LO) {
        this.LO = LO;
    }

    public static String getSI() {
        return SI;
    }

    public void setSI(String SI) {
        this.SI = SI;
    }

}
