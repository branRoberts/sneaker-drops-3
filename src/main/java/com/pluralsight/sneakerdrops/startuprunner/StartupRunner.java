package com.pluralsight.sneakerdrops.startuprunner;

import com.pluralsight.sneakerdrops.data.BrandRepository;
import com.pluralsight.sneakerdrops.models.Brand;
import com.pluralsight.sneakerdrops.service.DropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupRunner implements CommandLineRunner {

    private final BrandRepository brandRepository;
    private DropService dropService;

    @Autowired
    public StartupRunner(DropService dropService, BrandRepository brandRepository) {
        this.dropService = dropService;
        this.brandRepository = brandRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(dropService.getStatus());
        seedData();
        brandRepository.findAll().forEach(b -> System.out.println(b.getId() + " " + b.getName()));
    }
    private void seedData(){
        if(brandRepository.count()==0){
            brandRepository.save(new Brand("Nike"));
            brandRepository.save(new Brand("Adidas"));
            brandRepository.save(new Brand("New Balance"));
            brandRepository.save(new Brand("Puma"));
            brandRepository.save(new Brand("Reebok"));
        }
    }
}
