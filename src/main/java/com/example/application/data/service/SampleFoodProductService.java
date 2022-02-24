package com.example.application.data.service;

import com.example.application.data.entity.SampleFoodProduct;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vaadin.artur.helpers.CrudService;

@Service
public class SampleFoodProductService extends CrudService<SampleFoodProduct, UUID> {

    private SampleFoodProductRepository repository;

    public SampleFoodProductService(@Autowired SampleFoodProductRepository repository) {
        this.repository = repository;
    }

    @Override
    protected SampleFoodProductRepository getRepository() {
        return repository;
    }

}
