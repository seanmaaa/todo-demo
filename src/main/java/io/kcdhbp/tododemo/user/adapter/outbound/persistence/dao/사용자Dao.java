package io.kcdhbp.tododemo.user.adapter.outbound.persistence.dao;

import io.kcdhbp.tododemo.user.adapter.outbound.persistence.dto.사용자Dto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface 사용자Dao extends JpaRepository<사용자Dto, UUID> {
  Optional<사용자Dto> findBy이름(String 이름);

  boolean existsBy이름(String 이름);
}
