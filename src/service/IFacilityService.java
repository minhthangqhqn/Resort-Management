package service;

import model.Facility;

public interface IFacilityService extends Service<Facility> {
    @Override
    Facility findById(String id);

    @Override
    void display();

    @Override
    void add();

    @Override
    void save();
}
