package com.smartsolutions.eshoponcontainersjava.catalogservice.events;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.id.GUIDGenerator;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class IntegrationEvent {
    @JsonProperty("id")
    private UUID id;
    @JsonProperty("creationDate")
    private Date creationDate;

    public IntegrationEvent() {
        this(UUID.randomUUID(), new Date());
    }

    public IntegrationEvent(UUID id, Date creationDate) {
        this.id = id;
        this.creationDate = creationDate;
    }
}
