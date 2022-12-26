package io.kcdhbp.tododemo.todoboard.adapter.inbound.restapi.command;

import jakarta.validation.constraints.NotNull;

public record Todo보드생성Command(@NotNull String board_name) {
}
