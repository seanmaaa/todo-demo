CREATE TABLE IF NOT EXISTS todo_users
(
    user_id    UUID PRIMARY KEY,
    user_name  VARCHAR(20) UNIQUE,
    created_at TIMESTAMP WITH TIME ZONE
);

CREATE TABLE IF NOT EXISTS todo_boards
(
    board_id         UUID PRIMARY KEY,
    owner_id         UUID                     NOT NULL,
    board_name       VARCHAR(100)             NOT NULL UNIQUE,
    created_at       TIMESTAMP WITH TIME ZONE NOT NULL,
    last_modified_at TIMESTAMP WITH TIME ZONE
);

CREATE TABLE IF NOT EXISTS todo_items
(
    item_id          UUID PRIMARY KEY,
    board_id         UUID                     NOT NULL,
    description      VARCHAR(255)             NOT NULL,
    completed        BOOLEAN                  NOT NULL,
    created_at       TIMESTAMP WITH TIME ZONE NOT NULL,
    last_modified_at TIMESTAMP WITH TIME ZONE
);