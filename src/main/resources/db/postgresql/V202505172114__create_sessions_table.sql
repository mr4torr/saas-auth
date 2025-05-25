-- V202505172114__create_sessions_table.sql

CREATE TABLE IF NOT EXISTS sessions (
    id UUID PRIMARY KEY,
    user_id UUID NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    ip_address VARCHAR(32),
    user_agent VARCHAR(255),
    payload JSONB,
    last_activity_at TIMESTAMP NOT NULL,
    created_at TIMESTAMP NOT NULL
);
