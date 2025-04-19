package com.restapi.api.Repository;

import com.restapi.api.Entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Long> {

    @Query("Select e from DepartmentEntity e Where e.title=:title")
    Optional<DepartmentEntity> findByTitle(String title);

    List<DepartmentEntity> findDistinctByHodName(String hodName);
}
