package com.app.repositories;

import com.app.entities.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EmployeeRepository {

    private static Map<Long, Employee> employeeMap = new HashMap<>();

    public List<Employee> findAll(){
        return new ArrayList<>(employeeMap.values());
    }

    public Employee findById(Long id){
        return employeeMap.get(id);
    }

    public Employee save(Employee employee){
        if(0 == employee.getId()){
            employee.setId(employeeMap.size()+1);
        }
        employeeMap.put(employee.getId(), employee);
        return employee;
    }

    public void delete(Employee employee){
        employeeMap.remove(employee.getId(), employee);
    }
}
