package org.openapi.quarkus.api_yaml.api.auth;

import javax.inject.Inject;
import javax.annotation.PostConstruct;
import javax.ws.rs.Priorities;

import io.quarkus.arc.Priority;

import io.quarkiverse.openapi.generator.OpenApiGeneratorConfig;

import io.quarkiverse.openapi.generator.providers.ApiKeyAuthenticationProvider;
import io.quarkiverse.openapi.generator.providers.ApiKeyIn;
import io.quarkiverse.openapi.generator.providers.OAuth2AuthenticationProvider;
import io.quarkiverse.openapi.generator.providers.AbstractCompositeAuthenticationProvider;
import io.quarkiverse.openapi.generator.providers.OperationAuthInfo;

@Priority(Priorities.AUTHENTICATION)
public class CompositeAuthenticationProvider extends AbstractCompositeAuthenticationProvider {

    @Inject
    OpenApiGeneratorConfig generatorConfig;

    @PostConstruct
    public void init() {
        this.addAuthenticationProvider(new OAuth2AuthenticationProvider("api_yaml", sanitizeAuthName("congregation_auth"), generatorConfig)
        );
        this.addAuthenticationProvider(new ApiKeyAuthenticationProvider("api_yaml", sanitizeAuthName("api_key"), ApiKeyIn.header, "api_key", generatorConfig)
            .addOperation(OperationAuthInfo.builder()
                .withPath("/v2/publisher/{publisherId}")
                .withId("getPublisherById")
                .withMethod("GET")
                .build())
        );
    }

}