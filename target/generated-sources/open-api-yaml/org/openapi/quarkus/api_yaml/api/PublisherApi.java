package org.openapi.quarkus.api_yaml.api;

import org.openapi.quarkus.api_yaml.model.Publisher;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.openapi.quarkus.api_yaml.api.auth.CompositeAuthenticationProvider;
import org.openapi.quarkus.api_yaml.api.auth.AuthenticationPropagationHeadersFactory;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

import javax.enterprise.context.ApplicationScoped;

import io.quarkiverse.openapi.generator.annotations.GeneratedClass;
import io.quarkiverse.openapi.generator.annotations.GeneratedMethod;
import io.quarkiverse.openapi.generator.annotations.GeneratedParam;

/**
  * Swagger Publisher Service
  * <p/>This is a sample Swagger Congregation Publisher service server.  You can find out more about Swagger at [https://swagger.io](https://swagger.io) or on [irc.freenode.net, #swagger](https://swagger.io/irc/).  For this sample, the authorization is just for illustration.
  */
@Path("/publisher")
@RegisterRestClient(baseUri="http://localhost/v2", configKey="api_yaml")
@GeneratedClass(value="api.yaml", tag = "Publisher")
@RegisterProvider(CompositeAuthenticationProvider.class)
@RegisterClientHeaders(AuthenticationPropagationHeadersFactory.class)
@ApplicationScoped
public interface PublisherApi {

    /**
     * Add a new publisher to the congregation
     *
     */
    @POST
    @Consumes({"application/json", "application/xml"})
    @GeneratedMethod ("addPublisher")
    public void addPublisher(
        Publisher body
    );


    /**
     * Deletes a publisher
     *
     */
    @DELETE
    @Path("/{publisherId}")
    @GeneratedMethod ("deletePublisher")
    public void deletePublisher(
        @GeneratedParam("publisherId") @PathParam("publisherId") Long publisherId, 
        @GeneratedParam("api_key") @HeaderParam("api_key") String apiKey
    );


    /**
     * Find publisher by ID
     *
     * Returns a single publisher
     *
     */
    @GET
    @Path("/{publisherId}")
    @Produces({"application/json"})
    @GeneratedMethod ("getPublisherById")
    public Publisher getPublisherById(
        @GeneratedParam("publisherId") @PathParam("publisherId") Long publisherId
    );


    /**
     * Update an existing publisher
     *
     */
    @PUT
    @Consumes({"application/json", "application/xml"})
    @GeneratedMethod ("updatePublisher")
    public void updatePublisher(
        Publisher body
    );


    /**
     * Updates a publisher in the congregation with form data
     *
     */
    @POST
    @Path("/{publisherId}")
    @Consumes({"application/x-www-form-urlencoded"})
    @GeneratedMethod ("updatePublisherWithForm")
    public void updatePublisherWithForm(
        @org.jboss.resteasy.annotations.providers.multipart.MultipartForm UpdatePublisherWithFormMultipartForm multipartForm,@GeneratedParam("publisherId") @PathParam("publisherId") Long publisherId
    );

    public static class UpdatePublisherWithFormMultipartForm {
        @FormParam("name")
        @org.jboss.resteasy.annotations.providers.multipart.PartType(MediaType.TEXT_PLAIN)
        public String name;
    }

}