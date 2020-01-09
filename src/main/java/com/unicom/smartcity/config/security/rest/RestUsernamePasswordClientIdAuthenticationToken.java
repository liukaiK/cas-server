package com.unicom.smartcity.config.security.rest;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;

import java.util.Collection;

/**
 * @author liukai
 */
public class RestUsernamePasswordClientIdAuthenticationToken extends AbstractAuthenticationToken {


    private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;


    private final Object principal;
    private Object credentials;
    private String clientId;


    public RestUsernamePasswordClientIdAuthenticationToken(Object principal, Object credentials, String clientId) {
        super(null);
        this.principal = principal;
        this.credentials = credentials;
        this.clientId = clientId;
        setAuthenticated(false);
    }

    public RestUsernamePasswordClientIdAuthenticationToken(Object principal, Object credentials, String clientId, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        this.credentials = credentials;
        this.clientId = clientId;
        super.setAuthenticated(true);
    }


    @Override
    public Object getCredentials() {
        return this.credentials;
    }

    @Override
    public Object getPrincipal() {
        return this.principal;
    }

    public String getClientId() {
        return this.clientId;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        if (isAuthenticated) {
            throw new IllegalArgumentException("Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
        }

        super.setAuthenticated(false);
    }

    @Override
    public void eraseCredentials() {
        super.eraseCredentials();
        credentials = null;
    }


}
