package com.myblog10.controller;

import com.myblog10.payload.EmployeeDto;
import com.myblog10.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
public class EmployeeController {
//http://localhost:8080/api/post
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto Dto = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(Dto, HttpStatus.CREATED);
    }

    //http://localhost:8080/api/post/5
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Employee is deleted",HttpStatus.OK);
    }
    //http://localhost:8080/api/post/5
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") long id,@RequestBody EmployeeDto employeeDto){
        employeeService.updateEmployee(id,employeeDto);
        return null;
    }
}
