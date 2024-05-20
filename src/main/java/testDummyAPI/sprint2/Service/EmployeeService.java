package testDummyAPI.sprint2.Service;
import testDummyAPI.sprint2.Model.Employee;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private List<Employee> employees = new ArrayList<>();

    @PostConstruct
    public void init() {
        // Add some dummy data
        employees.add(new Employee(1, "James", "Nguyen", "james@gmail.com"));
        employees.add(new Employee(2, "Duy", "Le", "Duy@gmail.com"));
        employees.add(new Employee(2, "Hoang", "Mai", "Hoang@gmail.com"));
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public Optional<Employee> getEmployeeById(int id) {
        return employees.stream().filter(e -> e.getId() == id).findFirst();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void updateEmployee(int id, Employee employee) {
        getEmployeeById(id).ifPresent(e -> {
            e.setFirstName(employee.getFirstName());
            e.setLastName(employee.getLastName());
            e.setEmail(employee.getEmail());
        });
    }

    public void deleteEmployee(int id) {
        employees.removeIf(e -> e.getId() == id);
    }
}
