package lambda.projects.zoo;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import lambda.projects.zoo.models.Animal;
import lambda.projects.zoo.models.Telephone;
import lambda.projects.zoo.models.Zoo;
import lambda.projects.zoo.models.ZooAnimals;
import lambda.projects.zoo.services.AnimalService;
import lambda.projects.zoo.services.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;

@Transactional
//@Component
public class SeedData implements CommandLineRunner {
    @Autowired
    AnimalService animalService;

    @Autowired
    ZooService zooService;

    @Transactional
    @Override
    public void run(String[] arg) throws Exception {
        zooService.deleteAll();
        animalService.deleteAll();

        Animal a1 = new Animal("lion");
        Animal a2 = new Animal("bear");
        Animal a3 = new Animal("monkey");
        Animal a4 = new Animal("penguin");
        Animal a5 = new Animal("tiger");
        Animal a6 = new Animal("llama");
        Animal a7 = new Animal("turtle");

        a1 = animalService.save(a1);
        a2 = animalService.save(a2);
        a3 = animalService.save(a3);
        a4 = animalService.save(a4);
        a5 = animalService.save(a5);
        a6 = animalService.save(a6);
        a7 = animalService.save(a7);

        Zoo z1 = new Zoo("Gladys Porter Zoo");
        z1.getTelephones().add(new Telephone("555-555-5555",
                                    "MAIN",
                                    z1));
        z1.getTelephones().add(new Telephone("555-555-1234",
                                    "EDUCATION",
                                    z1));
        z1.getTelephones().add(new Telephone("555-555-4321",
                                    "MEMBERSHIP",
                                    z1));
        z1.getAnimals().add(new ZooAnimals(z1, a1, "Gladys Porter Zoo"));
        z1.getAnimals().add(new ZooAnimals(z1, a2, "Gladys Porter Zoo"));
        zooService.save(z1);

        Zoo z2 = new Zoo("Point Defiance Zoo");
        z2.getAnimals().add(new ZooAnimals(z2, a2, "Point Defiance Zoo"));
        zooService.save(z2);

        Zoo z3 = new Zoo("San Diego Zoo");
        z3.getTelephones().add(new Telephone("555-123-5555",
                                            "MAIN",
                                            z3));
        z3.getAnimals().add(new ZooAnimals(z3, a1, "San Diego Zoo"));
        z3.getAnimals().add(new ZooAnimals(z3, a2, "San Diego Zoo"));
        zooService.save(z3);

        Zoo z4 = new Zoo("San Antonio Zoo");
        z4.getTelephones().add(new Telephone("123-555-5555",
                                            "MAIN",
                                                z4));
        zooService.save(z4);

        Zoo z5 = new Zoo("Smithsonian National Zoo");
        z5.getAnimals().add(new ZooAnimals(z5, a7, "Smithsonian National Zoo"));
        z5.getAnimals().add(new ZooAnimals(z5, a6, "Smithsonian National Zoo"));
        z5.getAnimals().add(new ZooAnimals(z5, a5, "Smithsonian National Zoo"));
        z5.getAnimals().add(new ZooAnimals(z5, a1, "Smithsonian National Zoo"));
        zooService.save(z5);
    }
}
