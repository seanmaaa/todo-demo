package io.kcdhbp.tododemo.todoboard.domain;

import io.kcdhbp.tododemo.shared.marker.식별자;
import lombok.NonNull;

import java.util.UUID;

// FIXME 보드ID to Integer
public record Todo보드ID(@NonNull UUID value) implements 식별자 {
}
