package io.kcdhbp.tododemo.todoboard.domain;

import io.kcdhbp.tododemo.shared.marker.식별자;
import lombok.NonNull;

public record Todo보드ID(@NonNull Integer value) implements 식별자<Integer> {
}
