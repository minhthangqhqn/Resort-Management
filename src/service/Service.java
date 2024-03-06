package service;

public interface Service<T> {
    T findById(String id);

    void display();

    void add();

    void save();
}