package io.kcdhbp.tododemo.todoboard.adapter.outbound.persistence.dao;

import io.kcdhbp.tododemo.todoboard.adapter.outbound.persistence.dto.아이템Dto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface 아이템Dao extends JpaRepository<아이템Dto, Integer> {

  List<아이템Dto> findAllBy보드Id(Integer Todo보드Id);

  void deleteAllBy보드Id(Integer Todo보드Id);
}
