package lambda.projects.zoo.services;

import lambda.projects.zoo.models.Telephone;
import lambda.projects.zoo.repository.TelephoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value = "telephoneService")
public class TelephoneServiceImplemention implements TelephoneService{

    @Autowired
    TelephoneRepository telephoneRepository;

    @Override
    public Telephone save(Telephone telephone) {
        return null;
    }
}
