package service;

import model.Employee;
import repository.EmployeeRepository;
import utils.Validation;
import view.Menu;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Date;

public class EmployeeService implements IEmployeeService{
    EmployeeRepository er = new EmployeeRepository();
    ArrayList<Employee>  employeeList = new ArrayList<>();
    Validation val;
    public EmployeeService(){
        val = new Validation();
        er.loadFromFile(employeeList);
    }
    @Override
    public void display() {
        for(Employee employee: employeeList){
            System.out.println(employee);
        }
    }

    @Override
    public void add() {
        while(true){
            String id = val.getAndValidEmployeeId("Enter Your Employee's ID (EMP-xxxx): ");
            String fullName = val.getAndCheckName("Enter Full Name: ");
            Date dob = val.getAndCheckDate("Enter Date Of Birth: ");
            String gender = val.getAndValidGender("Enter your gender (Male/Female): ");
            String identity = val.getAndValidIdentity("Enter your Identity: ");
            String phoneNumber = val.getAndValidPhoneNumber("Enter your phone number: ");
            String email = val.getAndValidEmail("Enter your email: ");
            String qualification = val.getAndValidQualification("Enter your qualification (Intermediate, University, College ,Postgraduate):");
            String level = val.getAndValidLevel("Enter your level (Receptionist, Supervisor, Auditor, Waiter, HR Manager, F&B Manager)");
            double salary = val.getAndValidSalary("Enter your salary: ");
            Employee newEmployee = new Employee(id, fullName, dob, gender, identity, phoneNumber, email, qualification, level, salary);
            employeeList.add(newEmployee);
            String choice = val.getAndValidChoice("Do you want to continue (Y/N)");
            if(choice.equalsIgnoreCase("Y"))
                continue;
            else
                break;
        }
    }

    @Override
    public void save() {
        er.writeIntoFile(employeeList);
    }

    @Override
    public void update(Employee e) {
        String title = "Update Menu: ";
        String[] options = {"Update id", "Update full name: ", "Update date of birth: ",
                "Update gender", "Update identity: ", "Update phone number: ", "Update email", "Update qualification",
                "Update level", "Update salary", "Back"};
        Menu updateMenu = new Menu(title, options) {
            @Override
            public void execute(int ch) {
                switch (ch){
                    case 1:
                        System.out.println("ID is fixed, can not update new ID!");
                        break;
                    case 2:
                        String newName = val.getAndCheckName("Enter new name: ");
                        e.setFullName(newName);
                        System.out.println("Update successfully");
                        break;
                    case 3:
                        Date newDoB = val.getAndCheckDate("Enter new Date Of Birth: ");
                        e.setDateOfBirth(newDoB);
                        System.out.println("Update successfully");
                        break;
                    case 4:
                        String newGender = val.getAndValidGender("Enter new gender: ");
                        e.setGender(newGender);
                        System.out.println("Update successfully");
                        break;
                    case 5:
                        String newIdentity = val.getAndValidIdentity("Enter new identity: ");
                        e.setIdentity(newIdentity);
                        System.out.println("Update successfully");
                        break;
                    case 6:
                        String newPhoneNumber = val.getAndValidPhoneNumber("Enter new phone number: ");
                        e.setPhoneNumber(newPhoneNumber);
                        System.out.println("Update successfully");
                        break;
                    case 7:
                        String newEmail = val.getAndValidEmail("Enter new Email:");
                        e.setEmail(newEmail);
                        System.out.println("Update successfully");
                        break;
                    case 8:
                        String newQualification = val.getAndValidQualification("Enter your qualification (Intermediate, University, College ,Postgraduate):");
                        e.setQualification(newQualification);
                        System.out.println("Update successfully");
                        break;
                    case 9:
                        String newLevel = val.getAndValidLevel("Enter your level (Receptionist, Supervisor, Auditor, Waiter, HR Manager, F&B Manager)");
                        e.setLevel(newLevel);
                        System.out.println("Update successfully");
                        break;
                    case 10:
                        double newSalary = val.getAndValidSalary("Enter new salary: ");
                        e.setSalary(newSalary);
                        System.out.println("Update successfully");
                        break;
                    case 11:
                        return;
                    default:
                        System.out.println("Invalid choice!");
                }
            }
        };
        updateMenu.run();
    }

    @Override
    public Employee findById(String id) {
        for(Employee employee: employeeList){
            if(employee.getId().equalsIgnoreCase(id)){
                return employee;
            }
        }
        System.out.println("No Employee found!");
        return null;
    }

    public static void main(String[] args) {
        EmployeeService es = new EmployeeService();
        es.display();
    }
}
