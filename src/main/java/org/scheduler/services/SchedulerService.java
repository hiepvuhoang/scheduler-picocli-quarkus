package org.scheduler.services;

import io.quarkus.rest.client.reactive.NotBody;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedMap;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.scheduler.resources.BuildInfo;
import org.scheduler.resources.Oauth2Resource;

import java.util.List;

@RegisterRestClient
public interface SchedulerService {

    @PUT
    @Path("api/v1/run-configurations/{id}/execute")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ClientHeaderParam(name = "Authorization", value = "Bearer {token}")
    List<BuildInfo> trigger(@PathParam("id") Long id, @NotBody String token);

    @POST
    @Path("oauth/token")
    @Produces(MediaType.APPLICATION_FORM_URLENCODED)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    Oauth2Resource getToken(MultivaluedMap<String,?> params);
}
