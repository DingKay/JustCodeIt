package com.dk.operationldapserver.util;

import com.dk.operationldapserver.entity.LdapConfig;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Kay
 */
@Slf4j
public class LdapConfigUtil extends LdapConfig {
    private static LdapConfigUtil INSTANCE = new LdapConfigUtil();

    private LdapConfigUtil() {
        super();
        try {
            Properties properties = new Properties();
            InputStream asStream = LdapConfigUtil.class.getClassLoader().getResourceAsStream("config.properties");
            properties.load(asStream);
            this.url = properties.getProperty("ldap.url");
            this.username = properties.getProperty("ldap.username");
            this.password = properties.getProperty("ldap.password");
            this.searchBaseDn = properties.getProperty("ldap.search.baseDN");
            this.searchFilter = properties.getProperty("ldap.search.filter");
            this.type = properties.getProperty("ldap.server.type");
        } catch (IOException e) {
            log.error("LdapConfigUtil getResourceAsStream error => {}", e.getMessage());
        }
    }

    public static LdapConfigUtil getInstance() {
        return INSTANCE;
    }

}
