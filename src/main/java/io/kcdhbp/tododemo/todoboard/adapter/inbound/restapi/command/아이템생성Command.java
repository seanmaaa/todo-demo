package io.kcdhbp.tododemo.todoboard.adapter.inbound.restapi.command;

import jakarta.validation.constraints.NotNull;

public record 아이템생성Command(@NotNull String description) {
}
