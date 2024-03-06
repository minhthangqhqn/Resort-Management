package repository;

import model.Employee;

import java.util.ArrayList;

public interface IEmployeeRepository extends Repository<Employee, ArrayList<Employee>> {
    final String employeesPath = "\\data\\Employee.csv";

    @Override
    public void loadFromFile(ArrayList<Employee> employeesList);

    @Override
    public void writeIntoFile(ArrayList<Employee> employeesList);
}
