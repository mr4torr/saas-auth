package io.github.mr4torr.system.core.auth.entities;

import java.time.LocalDateTime;
import java.util.UUID;

public class Session {
    public final UUID id;
    public UUID userId;
    public String ipAddress;
    public String userAgent;
    public String payload;
    public LocalDateTime lastActivity;
    public final LocalDateTime createdAt;

    public Session() {
        this.id = UUID.randomUUID();
        this.createdAt = LocalDateTime.now();
    }

    public Session(
        UUID id,
        UUID userId,
        String ipAddress,
        String userAgent,
        String payload,
        LocalDateTime lastActivity,
        LocalDateTime createdAt
    ) {
        this.id = id;
        this.userId = userId;
        this.ipAddress = ipAddress;
        this.userAgent = userAgent;
        this.payload = payload;
        this.lastActivity = lastActivity;
        this.createdAt = createdAt;
    }
}