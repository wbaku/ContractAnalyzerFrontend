package com.sciamus.contractanalyzerfrontend.control;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.RequiredArgsConstructor;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.RefreshableKeycloakSecurityContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;

public class FeignClientsConfig {


    @Bean
    protected RequestInterceptor keycloakRequestInterceptor(KeycloakSecurityContext keycloakSecurityContext) {
        return new KeycloakRequestInterceptor(keycloakSecurityContext);
    }

    @RequiredArgsConstructor
    static class KeycloakRequestInterceptor implements RequestInterceptor {


        private final KeycloakSecurityContext keycloakSecurityContext;

        @Override
        public void apply(RequestTemplate template) {

            ensureTokenIsStillValid();

            // We use the Access-Token of the current user to call the service
            // Authorization: Bearer
            // eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJMT0Rx....

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
