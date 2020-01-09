package com.unicom.smartcity.config.security.oauth2;


import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.util.StringUtils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/**
 * @author liukai
 */
@Setter
@Entity(name = "oauth_client_details")
public class OAuthClientDetails implements ClientDetails {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String clientId;

    private String clientSecret;

    private String resourceIds;

    private String grantType;

    private String redirectUri;

    private String autoApprove;

    private String authorities;

    private String scope;

    private Integer accessTokenValiditySeconds;

    private Integer refreshTokenValiditySeconds;

    @Override
    public String getClientId() {
        return this.clientId;
    }

    @Override
    public Set<String> getResourceIds() {
        return StringUtils.commaDelimitedListToSet(this.resourceIds);
    }

    @Override
    public boolean isSecretRequired() {
        return false;
    }

    @Override
    public String getClientSecret() {
        return this.clientSecret;
    }

    @Override
    public boolean isScoped() {
        return false;
    }

    @Override
    public Set<String> getScope() {
        return StringUtils.commaDelimitedListToSet(this.scope);
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return StringUtils.commaDelimitedListToSet(this.grantType);
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return StringUtils.commaDelimitedListToSet(this.redirectUri);
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_CLIENT"));
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return this.accessTokenValiditySeconds;
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return this.refreshTokenValiditySeconds;
    }

    @Override
    public boolean isAutoApprove(String scope) {
        return Boolean.parseBoolean(this.autoApprove);
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return null;
    }


//
//    @Column
//    private String scope;
//    @Column
//    private String registeredRedirectUri;
//    @Column
//    private String authorities;
//    @Column(nullable = false)
//    private Integer accessTokenValiditySeconds;
//    @Column(nullable = false)
//    private Integer refreshTokenValiditySeconds;
//    @Column
//    private String autoApproveScope;
//    @Column
//    private String additionalInformation;
//
//    @Override
//    public Set<String> getResourceIds() {
//        if (StringUtils.isEmpty(this.resourceIds)) {
//            return new HashSet<>();
//        } else {
//            return StringUtils.commaDelimitedListToSet(this.resourceIds);
//        }
//    }
//
//    @Override
//    public boolean isSecretRequired() {
//        return !StringUtils.isEmpty(this.clientSecret);
//    }
//
//    @Override
//    public boolean isScoped() {
//        return this.getScope().size() > 0;
//    }
//
//    @Override
//    public Set<String> getAuthorizedGrantTypes() {
//        return StringUtils.commaDelimitedListToSet(this.authorizedGrantTypes);
//    }
//
//    @Override
//    public Set<String> getRegisteredRedirectUri() {
//        return StringUtils.commaDelimitedListToSet(this.registeredRedirectUri);
//    }
//
//    @Override
//    public Collection<GrantedAuthority> getAuthorities() {
//        Set<String> set = StringUtils.commaDelimitedListToSet(this.authorities);
//        Set<GrantedAuthority> result = new HashSet<>();
//        set.forEach(authority -> result.add(new GrantedAuthority() {
//            @Override
//            public String getAuthority() {
//                return authority;
//            }
//        }));
//        return result;
//    }
//
//    @Override
//    public boolean isAutoApprove(String scope) {
//        return this.getAutoApproveScope().contains(scope);
//    }
//
//    @Override
//    @SuppressWarnings("unchecked")
//    public Map<String, Object> getAdditionalInformation() {
//        try {
//            return mapper.readValue(this.additionalInformation, Map.class);
//        } catch (IOException e) {
//            return new HashMap<>();
//        }
//    }
//
//    public Set<String> getAutoApproveScope() {
//        return StringUtils.commaDelimitedListToSet(this.autoApproveScope);
//    }
//
//    public void setScope(Set<String> scope) {
//        this.scope = StringUtils.collectionToCommaDelimitedString(scope);
//    }
//
//    public void setRegisteredRedirectUri(Set<String> registeredRedirectUriList) {
//        this.registeredRedirectUri = StringUtils.collectionToCommaDelimitedString(registeredRedirectUriList);
//    }
//
//    public void setAuthorities(Set<GrantedAuthority> authorities) {
//        this.authorities = StringUtils.collectionToCommaDelimitedString(authorities);
//    }
//
//    public void setAutoApproveScope(Set<String> autoApproveScope) {
//        this.autoApproveScope = StringUtils.collectionToCommaDelimitedString(autoApproveScope);
//    }
//
//    public void setAdditionalInformation(Map<String, Object> additionalInformation) {
//        try {
//            this.additionalInformation = mapper.writeValueAsString(additionalInformation);
//        } catch (IOException e) {
//            this.additionalInformation = "";
//        }
//    }
}
