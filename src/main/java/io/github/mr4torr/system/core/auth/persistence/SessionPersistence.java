package io.github.mr4torr.system.core.auth.persistence;

import io.github.mr4torr.system.core.auth.entities.Session;

public interface SessionPersistence {
        Session create(Session session);
}
