package com.restapi.api.Controller;

import com.restapi.api.DTO.DepartmentDTO;
import com.restapi.api.Entity.DepartmentEntity;
import com.restapi.api.Service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;

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
    @GetMapping(path = "/{departmentId:[0-9]+}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable Long departmentId) {
        return departmentService
                .getDepartmentById(departmentId).map(ResponseEntity::ok)
                .orElseThrow(() -> new NoSuchElementException("user not Found"));
    }
    @PostMapping
    public ResponseEntity<DepartmentDTO> createNewDepartment(@RequestBody @Valid DepartmentDTO departmentDTO) {
         DepartmentDTO dept=departmentService.createNewDepartment(departmentDTO);
         return new ResponseEntity<>(dept,HttpStatus.CREATED);
    }

    @PutMapping("/{departmentId}")
    public ResponseEntity<DepartmentDTO> updateDepartmentDetails(@RequestBody DepartmentDTO departmentDTO,@PathVariable Long departmentId){
        DepartmentDTO  deptDto= departmentService.updateDepartmentDetails(departmentDTO,departmentId);
        return ResponseEntity.status(HttpStatus.OK).body(deptDto);
    }
    @DeleteMapping("/{departmentId}")
    public ResponseEntity<String> deleteDepartmentById(@PathVariable Long departmentId){
       boolean status= departmentService.deleteDepartment(departmentId);
       if(status) return ResponseEntity.status(HttpStatus.OK).body("Department Deleted");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("department does not exist");
    }
    @DeleteMapping
    public ResponseEntity deleteAllDepartment(){
        departmentService.deleteAllDepartment();
        return ResponseEntity.status(HttpStatus.OK).body("All User Deleted");
    }

    @GetMapping("/{sort}")
    public List<DepartmentEntity> sortData(@RequestParam(defaultValue = "id") String sortBy,
                                           @RequestParam(defaultValue = "hodName",required = false) String thenBy){
       return departmentService.sortData(sortBy,thenBy);
    }

}

