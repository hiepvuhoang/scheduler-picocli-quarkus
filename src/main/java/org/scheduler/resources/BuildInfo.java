package org.scheduler.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

public class BuildInfo {
    @JsonProperty("build_num")
    private Long buildNumber;

    @JsonProperty("job_id")
    private Long jobId;

    @JsonProperty("build_time_millis")
    private Long buildTime;

    @JsonProperty("status")
    private String status;

    @JsonProperty("usage_queued_at")
    private Date queuedAt;

    @JsonProperty("start_time")
    private Date startTime;

    @JsonProperty("stop_time")
    private Date stopTime;

    @JsonProperty("steps")
    private List<BuildLog> buildLogs;

    public Long getBuildNumber() {
        return buildNumber;
    }

    public void setBuildNumber(Long buildNumber) {
        this.buildNumber = buildNumber;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public Long getBuildTime() {
        return buildTime;
    }

    public void setBuildTime(Long buildTime) {
        this.buildTime = buildTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getQueuedAt() {
        return queuedAt;
    }

    public void setQueuedAt(Date queuedAt) {
        this.queuedAt = queuedAt;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getStopTime() {
        return stopTime;
    }

    public void setStopTime(Date stopTime) {
        this.stopTime = stopTime;
    }

    public List<BuildLog> getBuildLogs() {
        return buildLogs;
    }

    public void setBuildLogs(List<BuildLog> buildLogs) {
        this.buildLogs = buildLogs;
    }
}
