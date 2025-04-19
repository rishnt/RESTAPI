package com.restapi.api;

import com.restapi.api.Entity.DepartmentEntity;
import com.restapi.api.Repository.DepartmentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ApiApplicationTests {

	@Autowired
	 DepartmentRepository departmentRepository;
	@Test
	void contextLoads() {
	}

	@Test
	void testRepository(){
		DepartmentEntity entity= DepartmentEntity.builder()
				.title("Engineering")
				.collegeName("KIETGroup Of Institutions")
				.hodName("K.L Malik")
				.build();
		departmentRepository.save(entity);
	}

	@Test
	void getData(){
		List<DepartmentEntity> en=departmentRepository.findByTitle("CSE");
		List<DepartmentEntity> entity=departmentRepository.findDistinctByHodName("Prashant Mishra");
		System.out.println(entity);
		System.out.println(en);
	}
}
