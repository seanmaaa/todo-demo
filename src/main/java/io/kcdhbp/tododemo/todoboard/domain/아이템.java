package io.kcdhbp.tododemo.todoboard.domain;

import io.kcdhbp.tododemo.shared.marker.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@AllArgsConstructor
@Accessors(fluent = true)
@Data
public class 아이템 implements Entity<아이템ID> {

  private final 아이템ID id;
  private final Todo보드ID 소속보드;
  @NonNull
  private String 설명;
  @NonNull
  private Boolean 완료여부;
  @NonNull
  private LocalDateTime 등록시간;
  private LocalDateTime 수정시간;
}
