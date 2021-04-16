package lambda.projects.zoo.services;

import lambda.projects.zoo.models.Zoo;

import java.util.List;

public interface ZooService {
    Zoo save (Zoo zoo);

    List<Zoo> findAll();

    Zoo findZooById(long id);

    public void deleteAll();
}
