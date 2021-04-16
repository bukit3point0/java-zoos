package lambda.projects.zoo.services;

import lambda.projects.zoo.models.Zoo;
import lambda.projects.zoo.repository.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "zooService")
public class ZooServiceImplementation implements ZooService{
    @Autowired
    ZooRepository zooRepository;

    @Autowired
    UserAuditing userAudit;

    @Override
    public Zoo save(Zoo zoo) {
        if (zoo.getAnimals().size() > 0) {
            throw new EntityNotFoundException("Zoos are not updated through Zoo.");
        }
        return zooRepository.save(zoo);
    }

    @Override
    public List<Zoo> findAll() {
        List<Zoo> list = new ArrayList<>();
        zooRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Zoo findZooById(long id) {
        return zooRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Zoo " + " not found"));
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void deleteAll() {
        zooRepository.deleteAll();
    }
}
