CREATE TABLE IF NOT EXISTS todo_users
(
    user_id    UUID PRIMARY KEY,
    user_name  VARCHAR(20) UNIQUE,
    created_at TIMESTAMP WITH TIME ZONE
);

CREATE SEQUENCE IF NOT EXISTS todo_boards_seq;
CREATE TABLE IF NOT EXISTS todo_boards
(
    board_id         BIGINT DEFAULT NEXTVAL(todo_boards_seq) PRIMARY KEY,
    owner_id         UUID                     NOT NULL,
    board_name       VARCHAR(100)             NOT NULL UNIQUE,
    created_at       TIMESTAMP WITH TIME ZONE NOT NULL,
    last_modified_at TIMESTAMP WITH TIME ZONE
);

CREATE SEQUENCE IF NOT EXISTS todo_items_seq;
CREATE TABLE IF NOT EXISTS todo_items
(
    item_id          BIGINT DEFAULT NEXTVAL(todo_items_seq) PRIMARY KEY,
    board_id         BIGINT                   NOT NULL,
    description      VARCHAR(255)             NOT NULL,
    completed        BOOLEAN                  NOT NULL,
    created_at       TIMESTAMP WITH TIME ZONE NOT NULL,
    last_modified_at TIMESTAMP WITH TIME ZONE
);