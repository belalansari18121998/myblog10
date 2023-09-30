package com.myblog10.service.impl;

import com.myblog10.entity.Employee;
import com.myblog10.exception.ResourceNotFound;
import com.myblog10.payload.EmployeeDto;
import com.myblog10.repository.EmployeeRepository;
import com.myblog10.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee=new Employee();

        employee.setId(employeeDto.getId());
        employee.setTitle(employeeDto.getTitle());
        employee.setDescription(employeeDto.getDescription());
        employee.setContent(employeeDto.getContent());

        Employee save = employeeRepository.save(employee);

        EmployeeDto dto=new EmployeeDto();

        dto.setId(save.getId());
        dto.setTitle(save.getTitle());
        dto.setDescription(save.getDescription());
        dto.setContent(save.getContent());

        return dto;
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public void updateEmployee(long id, EmployeeDto employeeDto) {
        Employee employee = employeeRepository.findById(id).orElseThrow(

                ()->new ResourceNotFound("Employee not found:"+id)
        );
    }
}
