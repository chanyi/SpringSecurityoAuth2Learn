package com.chanyi.authention;

import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;

public class MyClientDetailsService implements ClientDetailsService {


	@Override
	public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
		return new MyClientDetails();
	}
}