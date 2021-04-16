package lambda.projects.zoo.services;

import lambda.projects.zoo.models.Animal;
import lambda.projects.zoo.views.CountAnimalsInZoo;

import java.util.ArrayList;
import java.util.List;

public interface AnimalService {
    Animal save(Animal animal);

    public void deleteAll();

    // animals/count
    ArrayList<CountAnimalsInZoo> getCountAnimalInZoo();
}

