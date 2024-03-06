package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee extends Person{
    private String qualification;
    private String level;
    private double salary;

    public Employee(String id, String fullName, Date dateOfBirth, String gender, String identity, String phoneNumber, String email,String qualification, String level, double salary) {
        super(id, fullName, dateOfBirth, gender, identity, phoneNumber, email);
        this.qualification = qualification;
        this.level = level;
        this.salary = salary;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String toStringWriteInFile() {
        String dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").format(super.getDateOfBirth());
        return super.getId() + "," + super.getFullName() + "," + dateOfBirth + "," + super.getGender() + "," + super.getIdentity()
                + "," + super.getPhoneNumber() + "," + super.getEmail() + "," + qualification + "," + level + "," + salary;
    }

    @Override
    public String toString() {
        String dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").format(super.getDateOfBirth());
        return String.format("| %-10s | %-20s | %-15s | %-15s | %-7s | %-12s | %-25s | %-15s | %-15s | %-7s$ |",
                super.getId(), super.getFullName(), dateOfBirth, super.getIdentity(), super.getGender(), super.getPhoneNumber(),
                super.getEmail(), qualification, level, salary);
    }
}
