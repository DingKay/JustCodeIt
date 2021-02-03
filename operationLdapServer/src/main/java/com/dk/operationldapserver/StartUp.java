package com.dk.operationldapserver;

import com.dk.operationldapserver.service.OperationLdapServer;
import com.dk.operationldapserver.util.LdapConfigUtil;

/**
 * @author Kay
 */
public class StartUp {
    public static void main(String[] args) {
        LdapConfigUtil instance = LdapConfigUtil.getInstance();
        System.out.println(instance.getPassword());
        System.out.println(instance.getUrl());
        System.out.println(instance.getUsername());
        System.out.println(instance.getSearchBaseDn());
        System.out.println(instance.getSearchFilter());
        String a = "OPEN_LDAP";
        String b = "openLdap";
        System.out.println(a.equals(LdapType.OPEN_LDAP.name()));
        System.out.println(b.equals(LdapType.OPEN_LDAP.getType()));
        new OperationLdapServer().showSomething();
    }
}
