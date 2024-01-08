package org.scheduler.services;

import io.quarkus.rest.client.reactive.NotBody;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.scheduler.resources.BuildInfo;

import java.util.List;

@RegisterRestClient
public interface SchedulerService {

    @PUT
    @Path("api/v1/run-configurations/{id}/execute")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    List<BuildInfo> trigger(@PathParam("id") Long id, @HeaderParam("Authorization") String headerValue);

    @POST
    @Path("oauth/token")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    String getToken();
}
