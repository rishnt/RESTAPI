package com.restapi.api.Controller;

import com.restapi.api.DTO.DepartmentDTO;
import com.restapi.api.Entity.DepartmentEntity;
import com.restapi.api.Repository.DepartmentRepository;
import com.restapi.api.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private final DepartmentService departmentService;
    DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public List<DepartmentDTO> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping(path = "/{departmentId}")
    public DepartmentDTO getDepartmentById(@PathVariable Long departmentId) {
        return departmentService.getDepartmentById(departmentId);
    }

    @PostMapping
    public DepartmentDTO createNewDepartment(@RequestBody DepartmentDTO departmentDTO) {
        return departmentService.createNewDepartment(departmentDTO);
    }

    @PutMapping
    public DepartmentDTO updateDepartmentDetails(@RequestBody DepartmentDTO departmentDTO,@PathVariable Long departmentId){
        return departmentService.updateDepartmentDetails(departmentDTO,departmentId);
    }

    @DeleteMapping("/{departmentId}")
    public void deleteDepartmentById(@PathVariable Long departmentId){
        departmentService.deleteDepartment(departmentId);
    }
}

