package org.scheduler.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nullable;

import java.util.List;
import java.util.Map;

public class BuildLog {
    @JsonProperty("name")
    private String name;

    private String logFileUrl;

    @Nullable
    private String content;

    private void unpackNested(@JsonProperty("actions") List<Map<String, String>> actions) {
        this.logFileUrl = actions.get(0).get("output_url");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogFileUrl() {
        return logFileUrl;
    }

    public void setLogFileUrl(String logFileUrl) {
        this.logFileUrl = logFileUrl;
    }

    @Nullable
    public String getContent() {
        return content;
    }

    public void setContent(@Nullable String content) {
        this.content = content;
    }
}
