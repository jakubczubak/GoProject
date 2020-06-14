package com.jczubak.crm.service;

import com.jczubak.crm.model.Oauth2AuthenticationUrls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ResolvableType;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class LoginService {

    private static String authorizationRequestBaseUri = "oauth2/authorization";

    @Autowired
    private ClientRegistrationRepository clientRegistrationRepository;

    public Set<Oauth2AuthenticationUrls> createOauth2AuthenticationUrlsSet(){
      Set<Oauth2AuthenticationUrls> oauth2AuthenticationUrlsSet = new HashSet<>();

        Iterable<ClientRegistration> clientRegistrations = null;
        ResolvableType type = ResolvableType.forInstance(clientRegistrationRepository)
                .as(Iterable.class);
        if (type != ResolvableType.NONE &&
                ClientRegistration.class.isAssignableFrom(type.resolveGenerics()[0])) {
            clientRegistrations = (Iterable<ClientRegistration>) clientRegistrationRepository;
        }

        clientRegistrations.forEach(registration ->
                oauth2AuthenticationUrlsSet.add(new Oauth2AuthenticationUrls(authorizationRequestBaseUri + "/" + registration.getRegistrationId(),registration.getClientName()+".png")));

        return oauth2AuthenticationUrlsSet;
    }
}
