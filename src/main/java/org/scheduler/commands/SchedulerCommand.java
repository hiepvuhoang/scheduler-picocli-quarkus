package org.scheduler.commands;

import io.quarkus.picocli.runtime.annotations.TopCommand;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.MultivaluedHashMap;
import jakarta.ws.rs.core.MultivaluedMap;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.scheduler.resources.BuildInfo;
import org.scheduler.resources.Oauth2Resource;
import org.scheduler.services.SchedulerService;
import picocli.CommandLine;
import picocli.CommandLine.Command;

import java.util.List;

@TopCommand
@Command(name = "scheduler", mixinStandardHelpOptions = true, subcommands = { TriggerCommand.class }, requiredOptionMarker = '*')
public class SchedulerCommand implements Runnable {
    @Override
    public void run() {
        System.out.printf("Starting scheduler...");
    }
}

@CommandLine.Command(name = "trigger", mixinStandardHelpOptions = true)
class TriggerCommand implements Runnable {
    @CommandLine.Option(names = { "-i", "--id" }, description = "Id of a specific run configuration/scheduler", help = true)
    Long id;

    @CommandLine.Option(names = { "-u", "--username" }, description = "username", help = true)
    String username;

    @CommandLine.Option(names = { "-p", "--password" }, description = "password", help = true)
    String password;

    @Inject
    @RestClient
    SchedulerService schedulerService;

    @Override
    public void run() {
        MultivaluedMap<String, String> params = new MultivaluedHashMap<>();
        params.add("grant_type", "password");
        params.add("username", username);
        params.add("password", password);
        Oauth2Resource token = schedulerService.getToken(params);

        System.out.println("Starting trigger scheduler id: " + id);
        List<BuildInfo> buildInfos = schedulerService.trigger(id, token.getAccessToken());
        System.out.println("Successfully triggered scheduler id: " + id);
        System.out.println("Trigger build info: " + buildInfos);
    }
}
