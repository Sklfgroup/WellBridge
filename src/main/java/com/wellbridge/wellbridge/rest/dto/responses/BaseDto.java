package com.wellbridge.wellbridge.rest.dto.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty(value = "uuid")
    protected String uuid;

    @JsonProperty(value = "deleted")
    protected boolean deleted;

    @JsonProperty(value = "createdAt")
    protected ZonedDateTime createdAt;

    @JsonProperty(value = "updatedAt")
    protected ZonedDateTime updatedAt;
}
