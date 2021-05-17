package com.sciamus.contractanalyzerfrontend.control;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.RefreshableKeycloakSecurityContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;

public class FeignClientsConfig {


    @Bean
    protected RequestInterceptor keycloakRequestInterceptor(KeycloakSecurityContext keycloakSecurityContext) {
        return new KeycloakRequestInterceptor(keycloakSecurityContext);
    }

    static class KeycloakRequestInterceptor implements RequestInterceptor {


        public KeycloakRequestInterceptor(KeycloakSecurityContext keycloakSecurityContext) {
            this.keycloakSecurityContext = keycloakSecurityContext;
        }

        private final KeycloakSecurityContext keycloakSecurityContext;


        @Override
        public void apply(RequestTemplate template) {

            ensureTokenIsStillValid();


            template.header(HttpHeaders.AUTHORIZATION, "Bearer " + keycloakSecurityContext.getTokenString());

            System.out.println("JESTEM TUTAJ " + keycloakSecurityContext.getTokenString());
        }

        private void ensureTokenIsStillValid() {
            if (keycloakSecurityContext instanceof RefreshableKeycloakSecurityContext) {
                RefreshableKeycloakSecurityContext.class.cast(keycloakSecurityContext).refreshExpiredToken(true);
            }
        }
    }
}
