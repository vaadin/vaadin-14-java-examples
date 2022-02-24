package com.example.application.data.generator;

import com.example.application.data.entity.SampleAddress;
import com.example.application.data.entity.SampleBook;
import com.example.application.data.entity.SampleFoodProduct;
import com.example.application.data.entity.SamplePerson;
import com.example.application.data.service.SampleAddressRepository;
import com.example.application.data.service.SampleBookRepository;
import com.example.application.data.service.SampleFoodProductRepository;
import com.example.application.data.service.SamplePersonRepository;
import com.vaadin.exampledata.DataType;
import com.vaadin.exampledata.ExampleDataGenerator;
import com.vaadin.flow.spring.annotation.SpringComponent;
import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringComponent
public class DataGenerator {

    @Bean
    public CommandLineRunner loadData(SamplePersonRepository samplePersonRepository,
            SampleAddressRepository sampleAddressRepository, SampleBookRepository sampleBookRepository,
            SampleFoodProductRepository sampleFoodProductRepository) {
        return args -> {
            Logger logger = LoggerFactory.getLogger(getClass());
            if (samplePersonRepository.count() != 0L) {
                logger.info("Using existing database");
                return;
            }
            int seed = 123;

            logger.info("Generating demo data");

            logger.info("... generating 100 Sample Person entities...");
            ExampleDataGenerator<SamplePerson> samplePersonRepositoryGenerator = new ExampleDataGenerator<>(
                    SamplePerson.class, LocalDateTime.of(2022, 2, 24, 0, 0, 0));
            samplePersonRepositoryGenerator.setData(SamplePerson::setFirstName, DataType.FIRST_NAME);
            samplePersonRepositoryGenerator.setData(SamplePerson::setLastName, DataType.LAST_NAME);
            samplePersonRepositoryGenerator.setData(SamplePerson::setEmail, DataType.EMAIL);
            samplePersonRepositoryGenerator.setData(SamplePerson::setPhone, DataType.PHONE_NUMBER);
            samplePersonRepositoryGenerator.setData(SamplePerson::setDateOfBirth, DataType.DATE_OF_BIRTH);
            samplePersonRepositoryGenerator.setData(SamplePerson::setOccupation, DataType.OCCUPATION);
            samplePersonRepositoryGenerator.setData(SamplePerson::setImportant, DataType.BOOLEAN_10_90);
            samplePersonRepository.saveAll(samplePersonRepositoryGenerator.create(100, seed));

            logger.info("... generating 100 Sample Address entities...");
            ExampleDataGenerator<SampleAddress> sampleAddressRepositoryGenerator = new ExampleDataGenerator<>(
                    SampleAddress.class, LocalDateTime.of(2022, 2, 24, 0, 0, 0));
            sampleAddressRepositoryGenerator.setData(SampleAddress::setStreet, DataType.ADDRESS);
            sampleAddressRepositoryGenerator.setData(SampleAddress::setPostalCode, DataType.ZIP_CODE);
            sampleAddressRepositoryGenerator.setData(SampleAddress::setCity, DataType.CITY);
            sampleAddressRepositoryGenerator.setData(SampleAddress::setState, DataType.STATE);
            sampleAddressRepositoryGenerator.setData(SampleAddress::setCountry, DataType.COUNTRY);
            sampleAddressRepository.saveAll(sampleAddressRepositoryGenerator.create(100, seed));

            logger.info("... generating 100 Sample Book entities...");
            ExampleDataGenerator<SampleBook> sampleBookRepositoryGenerator = new ExampleDataGenerator<>(
                    SampleBook.class, LocalDateTime.of(2022, 2, 24, 0, 0, 0));
            sampleBookRepositoryGenerator.setData(SampleBook::setImage, DataType.BOOK_IMAGE_URL);
            sampleBookRepositoryGenerator.setData(SampleBook::setName, DataType.BOOK_TITLE);
            sampleBookRepositoryGenerator.setData(SampleBook::setAuthor, DataType.FULL_NAME);
            sampleBookRepositoryGenerator.setData(SampleBook::setPublicationDate, DataType.DATE_OF_BIRTH);
            sampleBookRepositoryGenerator.setData(SampleBook::setPages, DataType.NUMBER_UP_TO_1000);
            sampleBookRepositoryGenerator.setData(SampleBook::setIsbn, DataType.EAN13);
            sampleBookRepository.saveAll(sampleBookRepositoryGenerator.create(100, seed));

            logger.info("... generating 100 Sample Food Product entities...");
            ExampleDataGenerator<SampleFoodProduct> sampleFoodProductRepositoryGenerator = new ExampleDataGenerator<>(
                    SampleFoodProduct.class, LocalDateTime.of(2022, 2, 24, 0, 0, 0));
            sampleFoodProductRepositoryGenerator.setData(SampleFoodProduct::setImage, DataType.FOOD_PRODUCT_IMAGE);
            sampleFoodProductRepositoryGenerator.setData(SampleFoodProduct::setName, DataType.FOOD_PRODUCT_NAME);
            sampleFoodProductRepositoryGenerator.setData(SampleFoodProduct::setEanCode, DataType.FOOD_PRODUCT_EAN);
            sampleFoodProductRepository.saveAll(sampleFoodProductRepositoryGenerator.create(100, seed));

            logger.info("Generated demo data");
        };
    }

}