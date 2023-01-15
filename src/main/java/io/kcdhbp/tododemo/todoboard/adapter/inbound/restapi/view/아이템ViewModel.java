package io.kcdhbp.tododemo.todoboard.adapter.inbound.restapi.view;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.kcdhbp.tododemo.todoboard.domain.아이템;
import lombok.NonNull;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record 아이템ViewModel(
    Integer item_id,
    String description,
    Boolean completed,
    LocalDateTime created_at,
    LocalDateTime modified_at
) {

  public static 아이템ViewModel of(@NonNull 아이템 source) {
    return new 아이템ViewModel(source.id().value(),
        source.설명(),
        source.완료여부(),
        source.등록시간(),
        source.수정시간());
  }

}
