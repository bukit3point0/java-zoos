package lambda.projects.zoo.services;

import lambda.projects.zoo.models.Animal;
import lambda.projects.zoo.repository.AnimalRepository;
import lambda.projects.zoo.views.CountAnimalsInZoo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "animalService")
public class AnimalServiceImplementation implements AnimalService{
    @Autowired
    AnimalRepository animalRepository;

    @Autowired
    UserAuditing userAudit;

    @Override
    public Animal save(Animal animal) {
        if (animal.getZoos().size() > 0) {
            throw new EntityNotFoundException("Animals are not updated through Animal");
        }
        return animalRepository.save(animal);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void deleteAll() {
        animalRepository.deleteAll();
    }

    @Override
    public ArrayList<CountAnimalsInZoo> getCountAnimalInZoo() {
        return animalRepository.getCountAnimalInZoo();
    }
}
