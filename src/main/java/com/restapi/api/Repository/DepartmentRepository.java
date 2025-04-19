package com.restapi.api.Repository;

import com.restapi.api.Entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Long> {

    List<DepartmentEntity> findByTitle(String title);

    List<DepartmentEntity> findDistinctByHodName(String hodName);
}
