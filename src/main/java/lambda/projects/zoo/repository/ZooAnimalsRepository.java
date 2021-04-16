package lambda.projects.zoo.repository;

import lambda.projects.zoo.models.ZooAnimals;
import lambda.projects.zoo.models.ZooAnimalsId;
import org.springframework.data.repository.CrudRepository;

public interface ZooAnimalsRepository extends CrudRepository<ZooAnimals, ZooAnimalsId> {
}
