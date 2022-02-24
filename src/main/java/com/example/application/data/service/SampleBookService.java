package com.example.application.data.service;

import com.example.application.data.entity.SampleBook;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vaadin.artur.helpers.CrudService;

@Service
public class SampleBookService extends CrudService<SampleBook, UUID> {

    private SampleBookRepository repository;

    public SampleBookService(@Autowired SampleBookRepository repository) {
        this.repository = repository;
    }

    @Override
    protected SampleBookRepository getRepository() {
        return repository;
    }

}
