package repository;

import model.Employee;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EmployeeRepository implements IEmployeeRepository{
    @Override
    public void loadFromFile(ArrayList<Employee> employeeList) {
        String line = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader(path + employeesPath));
            while((line = br.readLine()) != null){
                String[] toEString = line.split(",");
                Date dob = new SimpleDateFormat("dd/MM/yyyy").parse(toEString[2]);
                double salary = Double.parseDouble(toEString[9]);
                Employee newEmployee = new Employee(toEString[0], toEString[1], dob, toEString[3], toEString[4], toEString[5], toEString[6], toEString[7], toEString[8], salary);
                employeeList.add(newEmployee);
            }
        } catch (IOException | ParseException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void writeIntoFile(ArrayList<Employee> employeesList) {
        try {
            PrintWriter w = new PrintWriter(path + employeesPath);
            for (Employee employee: employeesList){
                w.println(employee.toStringWriteInFile());
            }
            w.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }

}
