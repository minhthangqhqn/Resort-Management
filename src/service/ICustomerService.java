package service;

import model.Customer;

public interface ICustomerService extends Service<Customer> {
    @Override
    Customer findById (String id);

    @Override
    void display();

    @Override
    void add();

    void update(Customer c);

    @Override
    void save();
}
