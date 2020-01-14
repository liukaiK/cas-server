package com.unicom.smartcity.security.oauth2;

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
    private OAuthClientDetailsRepository clientDetailsRepository;

    @Override
    @Transient
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        Optional<OAuthClientDetails> client = clientDetailsRepository.getByClientId(clientId);
        if (client.isPresent()) {
            return client.get();
        }
        throw new NoSuchClientException("No client with requested id: " + clientId);
    }

}
