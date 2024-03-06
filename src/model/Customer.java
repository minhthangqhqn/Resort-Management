package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Customer extends Person{
    private String cusType;
    private String address;

    public Customer(String id, String fullName, Date dateOfBirth, String gender, String identity, String phoneNumber, String email, String cusType, String address) {
        super(id, fullName, dateOfBirth, gender, identity, phoneNumber, email);
        this.cusType = cusType;
        this.address = address;
    }

    public String getCusType() {
        return cusType;
    }

    public void setCusType(String cusType) {
        this.cusType = cusType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        String dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").format(super.getDateOfBirth());
        return super.getId() + ", " + super.getFullName() + ", " + dateOfBirth + ", " + super.getGender() + ", "
                + super.getIdentity() + ", " + super.getPhoneNumber() + ", " + super.getEmail() + ", " + cusType + ", "
                + address;
    }
}
