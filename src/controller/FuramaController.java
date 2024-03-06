package controller;

import model.Employee;
import repository.EmployeeRepository;
import repository.IEmployeeRepository;
import service.EmployeeService;
import utils.Validation;
import view.Menu;

public class FuramaController extends Menu<String> {
    private static final String menuTitle = "FURAMA RESORT MANAGEMENT";
    private static final String[] menu = {"Employee Management", "Customer Management", "Facility Management",
            "Booking Management", "Promotion Management", "Exit"};
    Validation val;
    public FuramaController() {
        super(menuTitle, menu);
        val = new Validation();
    }
    @Override
    public void execute(int ch) {
        switch (ch){
            case 1:
                runEmployeeManagementMenu();
                break;
            case 2:

            case 3:

            case 4:

            case 5:

            case 6:
                System.out.println("Thank You!");
                System.exit(0);
                break;
        }
    }

    private void runEmployeeManagementMenu(){
        String title = "EMPLOYEE MANAGEMENT";
        String[] options = {"Display list employees", "Add new employee", "Edit employee information",
                "Return main menu"};
        EmployeeService es = new EmployeeService();
        Menu employeeManageMenu = new Menu(title, options) {
            @Override
            public void execute(int ch) {
                switch (ch){
                    case 1:
                        es.display();
                        break;
                    case 2:
                        es.add();
                        break;
                    case 3:
                        String id = val.getAndValidEmployeeId("Enter ID your want to update: ");
                        Employee findEmployee = es.findById(id);
                        es.update(findEmployee);
                        break;
                    case 4:
                        es.save();
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            }
        };
            employeeManageMenu.run();
    }
}
