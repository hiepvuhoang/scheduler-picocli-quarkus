package org.scheduler.commands;

import io.quarkus.picocli.runtime.annotations.TopCommand;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.scheduler.services.SchedulerService;
import picocli.CommandLine;
import picocli.CommandLine.Command;

import java.util.Base64;

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
        // Basic auth
        String basicToken = username + ":" + password;
        String encodedBasicToken = Base64.getEncoder().encodeToString(basicToken.getBytes());

        schedulerService.trigger(id, "Basic " + encodedBasicToken);
    }
}
