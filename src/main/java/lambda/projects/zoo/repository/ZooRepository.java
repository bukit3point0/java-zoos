package lambda.projects.zoo.repository;

import lambda.projects.zoo.models.Zoo;
import org.springframework.data.repository.CrudRepository;

public interface ZooRepository extends CrudRepository<Zoo, Long> {
}
