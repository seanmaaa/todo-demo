package io.kcdhbp.tododemo.user.adapter.outbound.persistence.dto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

import static java.util.Objects.isNull;

@NoArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
@Table(name = "todo_users")
@Entity
public class 사용자Dto implements Persistable<UUID> {

  @Id
  @GeneratedValue
  @Column(name = "user_id", updatable = false)
  private UUID id;

  @Column(name = "user_name", length = 20, updatable = false, unique = true)
  private String 이름;

  @CreatedDate
  @Column(name = "created_at", updatable = false, nullable = false)
  private LocalDateTime 등록시간;

  @Override
  public boolean isNew() {
    return isNull(id);
  }
}
