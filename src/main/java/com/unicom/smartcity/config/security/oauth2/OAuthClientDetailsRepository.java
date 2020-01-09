package com.unicom.smartcity.config.security.oauth2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface OAuthClientDetailsRepository extends JpaRepository<OAuthClientDetails, String>, JpaSpecificationExecutor<OAuthClientDetails> {

    Optional<OAuthClientDetails> getByClientId(String clientId);

}
