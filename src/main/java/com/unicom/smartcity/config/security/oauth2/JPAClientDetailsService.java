package com.unicom.smartcity.config.security.oauth2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.NoSuchClientException;

import javax.persistence.Transient;
import java.util.Optional;

/**
 * @author liukai
 */
public class JPAClientDetailsService implements ClientDetailsService {

    @Autowired
    private OAuthClientDetailsRepository OAuthClientDetailsRepository;

    @Override
    @Transient
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        Optional<OAuthClientDetails> client = OAuthClientDetailsRepository.getByClientId(clientId);
        if (client.isPresent()) {
            return client.get();
        }
        throw new NoSuchClientException("No client with requested id: " + clientId);
    }

}
