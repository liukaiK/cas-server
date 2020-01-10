package com.unicom.smartcity.security.oauth2;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.util.StringUtils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/**
 * @author liukai
 */
@Setter
@Getter
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

    private String loginUrl;

    private Integer accessTokenValiditySeconds;

    private Integer refreshTokenValiditySeconds;

    @CreatedDate
    private LocalDateTime createTime;

    @LastModifiedDate
    private LocalDateTime updateTime;

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


}
