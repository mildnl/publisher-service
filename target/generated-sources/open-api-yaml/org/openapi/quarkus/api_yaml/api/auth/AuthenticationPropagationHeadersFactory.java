package org.openapi.quarkus.api_yaml.api.auth;

import javax.inject.Inject;
import javax.enterprise.context.ApplicationScoped;

import io.quarkiverse.openapi.generator.OpenApiGeneratorConfig;
import io.quarkiverse.openapi.generator.providers.AbstractAuthenticationPropagationHeadersFactory;
import io.quarkiverse.openapi.generator.providers.HeadersProvider;

public class AuthenticationPropagationHeadersFactory extends AbstractAuthenticationPropagationHeadersFactory {

    @Inject
    public AuthenticationPropagationHeadersFactory(CompositeAuthenticationProvider compositeProvider, OpenApiGeneratorConfig generatorConfig, HeadersProvider headersProvider) {
        super(compositeProvider, generatorConfig, headersProvider);
    }

}