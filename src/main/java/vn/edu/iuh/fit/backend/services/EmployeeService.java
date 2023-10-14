package vn.edu.iuh.fit.backend.services;

import vn.edu.iuh.fit.backend.models.Employee;
import vn.edu.iuh.fit.backend.repositories.EmployeeDAO;

import java.util.List;
import java.util.Optional;

public class EmployeeService {
    private final EmployeeDAO repo=new EmployeeDAO();

    public EmployeeService() {

    }

    public boolean insertEmployee(Employee employee) {return repo.insertEmployee(employee);}
    public boolean updateEmployee(Employee employee) {return repo.updateEmployee(employee);}
    public Optional<Employee> findEmployee(long id) {return repo.findEmployee(id);}
    public boolean deleteEmployee(long id) {return repo.deleteEmployee(id);}
    public List<Employee> getAllEmployee(){return repo.getAllEmployee();}
    public List<Employee> getActiveEmployee(){return repo.getActiveEmployee();}
}
