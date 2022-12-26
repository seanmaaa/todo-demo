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
@Table(name = "todo_boards")
@Entity
public class Todo보드Dto implements Persistable<UUID> {

  @Id
  @GeneratedValue
  @Column(name = "board_id", updatable = false)
  private UUID id;

  @Column(name = "owner_id", updatable = false, nullable = false)
  private UUID 소유자;

  @Column(name = "board_name", length = 100, nullable = false)
  private String 이름;

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
