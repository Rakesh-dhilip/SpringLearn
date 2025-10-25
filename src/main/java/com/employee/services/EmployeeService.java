package com.employee.services;

import com.employee.dto.EmployeeDTO;
import com.employee.entities.EmployeeEntity;
import com.employee.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {


    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public EmployeeDTO getEmployeeById(Long id) {
        Optional<EmployeeEntity> employeeEntity = this.employeeRepository.findById(id);
        return modelMapper.map(employeeEntity.get(), EmployeeDTO.class);
    }

    public EmployeeDTO createNewEmployee(EmployeeDTO inputEmployee) {
        return modelMapper.map(this.employeeRepository.save(modelMapper.map(inputEmployee, EmployeeEntity.class)), EmployeeDTO.class);
    }
}
