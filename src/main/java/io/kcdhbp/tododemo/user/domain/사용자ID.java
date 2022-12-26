package io.kcdhbp.tododemo.user.domain;

import io.kcdhbp.tododemo.shared.marker.식별자;
import lombok.NonNull;

import java.util.UUID;

public record 사용자ID(@NonNull UUID value) implements 식별자 {

}
