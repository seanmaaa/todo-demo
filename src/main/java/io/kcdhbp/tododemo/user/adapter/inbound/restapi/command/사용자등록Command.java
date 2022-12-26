package io.kcdhbp.tododemo.user.adapter.inbound.restapi.command;

import jakarta.validation.constraints.NotNull;

public record 사용자등록Command(@NotNull String user_name) {
}
