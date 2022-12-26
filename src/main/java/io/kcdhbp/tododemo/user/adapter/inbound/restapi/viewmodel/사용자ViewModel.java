package io.kcdhbp.tododemo.user.adapter.inbound.restapi.viewmodel;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record 사용자ViewModel(@NotNull UUID user_id,
                           @NotNull String user_name) {
}
