package kg.megacom.storeservice.services;

import kg.megacom.storeservice.models.dtos.TransactionDto;

import java.util.List;

public interface BaseCrudService<S, T> {

    S save(S s);
    S update(S s);
    S findById(T id);
    List<S> findAll();
}