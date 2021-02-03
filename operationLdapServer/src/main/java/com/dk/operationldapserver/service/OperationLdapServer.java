package com.dk.operationldapserver.service;

import com.dk.operationldapserver.util.LdapConfigUtil;
import lombok.SneakyThrows;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import java.util.Properties;

/**
 * @author Kay
 */
public class OperationLdapServer {
    public static LdapConfigUtil ldapConfigUtil = LdapConfigUtil.getInstance();
    private InitialLdapContext ldapContext = LdapConnection.getInstance().getConnection();

    static class LdapConnection {
        private static LdapConnection ldapConnection = new LdapConnection();

        private LdapConnection() {}

        public static LdapConnection getInstance() {
            return ldapConnection;
        }

        @SneakyThrows
        private InitialLdapContext getConnection() {
            Properties env = new Properties();
            env.put(Context.INITIAL_CONTEXT_FACTORY,
                    "com.sun.jndi.ldap.LdapCtxFactory");
            env.put(Context.SECURITY_AUTHENTICATION, "simple");// "none","simple","strong"
            env.put(Context.SECURITY_PRINCIPAL, ldapConfigUtil.getUsername());
            env.put(Context.SECURITY_CREDENTIALS, ldapConfigUtil.getPassword());
            env.put(Context.PROVIDER_URL, ldapConfigUtil.getUrl());
            return new InitialLdapContext(env, null);
        }
    }
    @SneakyThrows
    public void showSomething() {
        SearchControls searchControls = new SearchControls();
        searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        NamingEnumeration<SearchResult> search = ldapContext.search(ldapConfigUtil.getSearchBaseDn(), ldapConfigUtil.getSearchFilter(), searchControls);

        while (search != null && search.hasMoreElements()) {
            SearchResult sr = search.next();
            // 获取Ldap中根组织
            String enname = sr.getName().substring(
                    sr.getName().lastIndexOf("=") + 1);
        }
    }
}
