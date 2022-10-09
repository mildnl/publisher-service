import org.openapi.quarkus.api_yaml.api.PublisherApi;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Produces(MediaType.APPLICATION_JSON)
@Path("/petstore")
public class PublisherResource {

    @RestClient
    @Inject
    PublisherApi publisherApi;
}