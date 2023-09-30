package com.myblog10.service;

import com.myblog10.payload.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    void deleteEmployee(Long id);

    void updateEmployee(long id, EmployeeDto employeeDto);
}
