package com.restapi.api.Controller;

import com.restapi.api.DTO.DepartmentDTO;
import com.restapi.api.Service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<DepartmentDTO>> getAllDepartments() {
       List<DepartmentDTO> dept=departmentService.getAllDepartments();
        return ResponseEntity.ok(dept);
    }

    @GetMapping(path = "/{departmentId}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable Long departmentId) {
        return departmentService
                .getDepartmentById(departmentId).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<String> createNewDepartment(@RequestBody @Valid DepartmentDTO departmentDTO) {
         departmentService.createNewDepartment(departmentDTO);
         return ResponseEntity.status(HttpStatus.CREATED).body("User is created");
    }

    @PutMapping("/{departmentId}")
    public ResponseEntity<DepartmentDTO> updateDepartmentDetails(@RequestBody DepartmentDTO departmentDTO,@PathVariable Long departmentId){
        DepartmentDTO deptDto= departmentService.updateDepartmentDetails(departmentDTO,departmentId);
        return ResponseEntity.status(HttpStatus.OK).body(deptDto);
    }
    @DeleteMapping("/{departmentId}")
    public ResponseEntity<String> deleteDepartmentById(@PathVariable Long departmentId){
        departmentService.deleteDepartment(departmentId);
        return ResponseEntity.status(HttpStatus.OK).body("Department Deleted");
    }

    @DeleteMapping
    public ResponseEntity deleteAllDepartment(){
        departmentService.deleteAllDepartment();
        return ResponseEntity.status(HttpStatus.OK).body("All User Deleted");
    }
}

