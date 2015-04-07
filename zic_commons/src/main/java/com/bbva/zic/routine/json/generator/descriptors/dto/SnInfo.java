package com.bbva.zic.routine.json.generator.descriptors.dto;

/**
 * Created by Entelgy on 26/02/2015.
 */
public class SnInfo {

    private String targetDto;
    private String logicalId;
    private String registryId;
    private String version;
    private String description;

    public String getTargetDto() {
        return targetDto;
    }

    public void setTargetDto(String targetDto) {
        this.targetDto = targetDto;
    }

    public String getLogicalId() {
        return logicalId;
    }

    public void setLogicalId(String logicalId) {
        this.logicalId = logicalId;
    }

    public String getRegistryId() {
        return registryId;
    }

    public void setRegistryId(String registryId) {
        this.registryId = registryId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
