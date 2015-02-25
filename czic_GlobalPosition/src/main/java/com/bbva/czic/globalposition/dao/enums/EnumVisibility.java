package com.bbva.czic.globalposition.dao.enums;

/**
 * @author Entelgy Colombia.
 */
public enum EnumVisibility {
    SHOW("MO  "),
    HIDE("OC  ");

    private String alias;

    EnumVisibility(final String alias) {
        this.alias = alias;
    }

    public String getAlias() {
        return this.alias;
    }

    public static EnumVisibility fromAlias(final String name) {
        for(final EnumVisibility visibility : values()) {
            if (visibility.alias.equals(name)){
                return visibility;
            }
        }
        return null;
    }
}
