package io.kcdhbp.tododemo.todoboard.adapter.outbound.persistence.dto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

import static java.util.Objects.isNull;

@NoArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
@Table(name = "todo_items")
@Entity
public class 아이템Dto implements Persistable<UUID> {
  @Id
  @GeneratedValue
  @Column(name = "item_id", updatable = false)
  private UUID id;

  @Column(name = "board_id", updatable = false, nullable = false)
  private UUID 보드Id;

  @Column(name = "description", updatable = false, nullable = false)
  private String 설명;

  @Column(name = "completed", nullable = false)
  private Boolean 완료여부;

  @CreatedDate
  @Column(name = "created_at", updatable = false, nullable = false)
  private LocalDateTime 등록시간;

  @LastModifiedDate
  @Column(name = "last_modified_at")
  private LocalDateTime 마지막수정일시;

  @Override
  public boolean isNew() {
    return isNull(id);
  }
}
