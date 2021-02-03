package com.dk.operationldapserver;

/**
 * @author Kay
 */
public enum LdapType {
    /**
     * linux   :openLdap service
     */
    OPEN_LDAP("openLdap"),
    /**
     * windows :active directory domain service
     */
    ACTIVE_DIRECTORY_DOMAIN_SERVICE("activeLdap");

    /**
     * service type
     */
    String type;

    LdapType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
