package com.restapi.api.Service;

import com.restapi.api.DTO.DepartmentDTO;
import com.restapi.api.Entity.DepartmentEntity;
import com.restapi.api.Repository.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;
    DepartmentService(DepartmentRepository departmentRepository,ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.modelMapper=modelMapper;
    }
    public boolean existById(Long departmentId){
        return departmentRepository.existsById(departmentId);
    }
    public List<DepartmentDTO> getAllDepartments() {
        List<DepartmentEntity> department = departmentRepository.findAll();
        return department.stream()
                .map(departmentEntity -> modelMapper
                        .map(departmentEntity, DepartmentDTO.class))
                .collect(Collectors.toList());
    }
    public Optional<DepartmentDTO> getDepartmentById(Long departmentId) {
      Optional<DepartmentEntity> entity=departmentRepository.findById(departmentId);
      return entity.map(departmentEntity -> modelMapper.map(departmentEntity,DepartmentDTO.class));

    }
    public String createNewDepartment(DepartmentDTO departmentDTO) {
        DepartmentEntity entity=modelMapper.map(departmentDTO, DepartmentEntity.class);
        DepartmentEntity savedEntity= departmentRepository.save(entity);
        return "User Created";
    }

    public boolean deleteDepartment(Long departmentId) {
        if(departmentRepository.existsById(departmentId)){
            departmentRepository.deleteById(departmentId);
            return true;
        }
        return false;
    }


    public DepartmentDTO updateDepartmentDetails(DepartmentDTO departmentDTO,Long departmentId){
        if(departmentRepository.existsById(departmentId)){
            DepartmentEntity departmentEntity=modelMapper.map(departmentDTO,DepartmentEntity.class);
            departmentEntity.setId(departmentId);
            DepartmentEntity savedEntity= departmentRepository.save(departmentEntity);
            return modelMapper.map(savedEntity,DepartmentDTO.class);
        }
return null;
    }

    public void deleteAllDepartment() {
        departmentRepository.deleteAll();
    }
}
