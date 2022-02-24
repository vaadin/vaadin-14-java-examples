package com.example.application.data.service;

import com.example.application.data.entity.SampleAddress;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vaadin.artur.helpers.CrudService;

@Service
public class SampleAddressService extends CrudService<SampleAddress, UUID> {

    private SampleAddressRepository repository;

    public SampleAddressService(@Autowired SampleAddressRepository repository) {
        this.repository = repository;
    }

    @Override
    protected SampleAddressRepository getRepository() {
        return repository;
    }

}
