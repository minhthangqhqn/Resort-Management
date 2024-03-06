package service;

import model.Contract;

public interface IContractService extends Service<Contract> {
    @Override
    Contract findById(String id);

    @Override
    void display();

    @Override
    void add();

    void update(Contract c);

    @Override
    void save();
}
