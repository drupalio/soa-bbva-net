// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bbva.czic.customers.dao.model.oznb;

import java.lang.String;

privileged aspect FormatoOZNCSNB0_Roo_ToString {
    
    public String FormatoOZNCSNB0.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Anosvda: ").append(getAnosvda()).append(", ");
        sb.append("Ciudofi: ").append(getCiudofi()).append(", ");
        sb.append("Ciudvia: ").append(getCiudvia()).append(", ");
        sb.append("Correo: ").append(getCorreo()).append(", ");
        sb.append("Depaofi: ").append(getDepaofi()).append(", ");
        sb.append("Depavia: ").append(getDepavia()).append(", ");
        sb.append("Descofi: ").append(getDescofi()).append(", ");
        sb.append("Descvia: ").append(getDescvia()).append(", ");
        sb.append("Estrato: ").append(getEstrato()).append(", ");
        sb.append("Nomclie: ").append(getNomclie()).append(", ");
        sb.append("Nropnas: ").append(getNropnas()).append(", ");
        sb.append("Numclie: ").append(getNumclie()).append(", ");
        sb.append("Paisofi: ").append(getPaisofi()).append(", ");
        sb.append("Paisvia: ").append(getPaisvia()).append(", ");
        sb.append("Segment: ").append(getSegment()).append(", ");
        sb.append("Tpovvda: ").append(getTpovvda()).append(", ");
        sb.append("Ultcone: ").append(getUltcone());
        return sb.toString();
    }
    
}
