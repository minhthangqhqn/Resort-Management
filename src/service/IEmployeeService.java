package service;

import model.Employee;

public interface IEmployeeService extends Service<Employee> {
    @Override
    void display();
    @Override
    void add();
    void update(Employee e);
    @Override
    Employee findById(String id);

}
