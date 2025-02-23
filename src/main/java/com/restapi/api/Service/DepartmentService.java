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

    public List<DepartmentDTO> getAllDepartments() {
        List<DepartmentEntity> department = departmentRepository.findAll();
        return department.stream()
                .map(departmentEntity -> modelMapper
                        .map(departmentEntity, DepartmentDTO.class))
                .collect(Collectors.toList());
    }
    public DepartmentDTO getDepartmentById(Long departmentId) {
      DepartmentEntity entity=departmentRepository.findById(departmentId).orElse(null);
       return modelMapper.map(entity, DepartmentDTO.class);
    }
    public DepartmentDTO createNewDepartment(DepartmentDTO departmentDTO) {
        DepartmentEntity entity=modelMapper.map(departmentDTO, DepartmentEntity.class);
        DepartmentEntity savedEntity= departmentRepository.save(entity);
        return modelMapper.map(savedEntity, DepartmentDTO.class);
    }

    public void deleteDepartment(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    public DepartmentDTO updateDepartmentDetails(DepartmentDTO departmentDTO,Long departmentId) {
        if(departmentRepository.existsById(departmentId)){
            DepartmentEntity departmentEntity=modelMapper.map(departmentDTO,DepartmentEntity.class);
            departmentEntity.setId(departmentId);
            DepartmentEntity savedEntity= departmentRepository.save(departmentEntity);
            return modelMapper.map(savedEntity,DepartmentDTO.class);
        }
return null;
    }
}
