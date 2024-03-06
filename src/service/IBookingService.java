package service;

import model.Booking;

public interface IBookingService extends Service<Booking> {
    @Override
    Booking findById(String id);

    @Override
    void display();

    @Override
    void add();

    @Override
    void save();
}
