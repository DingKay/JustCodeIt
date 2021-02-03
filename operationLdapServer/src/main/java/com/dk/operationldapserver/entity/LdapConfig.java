package com.dk.operationldapserver.entity;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Kay
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LdapConfig {
    protected String url = null;
    protected String username = null;
    protected String password = null;
    protected String searchBaseDn = null;
    protected String searchFilter = null;
    protected String type = null;
}
