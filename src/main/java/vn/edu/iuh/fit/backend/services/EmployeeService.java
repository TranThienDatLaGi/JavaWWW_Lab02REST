package vn.edu.iuh.fit.backend.services;

import vn.edu.iuh.fit.backend.models.Employee;
import vn.edu.iuh.fit.backend.repositories.EmployeeRepo;

import java.util.List;
import java.util.Optional;

public class EmployeeService {
    private EmployeeRepo repo;

    public EmployeeService(EmployeeRepo repo) {
        this.repo = repo;
    }

    public boolean insertEmployee(Employee employee) {return repo.insertEmployee(employee);}
    public boolean updateEmployee(Employee employee) {return repo.updateEmployee(employee);}
    public Optional<Employee> findEmployee(long id) {return repo.findEmployee(id);}
    public boolean deleteEmployee(long id) {return repo.deleteEmployee(id);}
    public List<Employee> getAllEmployee(){return repo.getAllEmployee();}
}
