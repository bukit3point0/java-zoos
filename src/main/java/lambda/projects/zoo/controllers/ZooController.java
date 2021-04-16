package lambda.projects.zoo.controllers;

import lambda.projects.zoo.models.Zoo;
import lambda.projects.zoo.services.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/zoos")
public class ZooController {
    @Autowired
    ZooService zooService;

    // http://localhost:2019/zoos/zoos
    @GetMapping(value = "/zoos", produces = "application/json")
    public ResponseEntity<?> findAllZoos() {
        List<Zoo> zooList = zooService.findAll();
        return new ResponseEntity<>(zooList, HttpStatus.OK);
    }

    // http://localhost:2019/zoos/zoo/:id
    @GetMapping(value = "/zoo/{zooid}", produces = "application/json")
    public ResponseEntity<?> findZooById(@PathVariable long zooid) {
        Zoo zooAtId = zooService.findZooById(zooid);
        return new ResponseEntity<>(zooAtId, HttpStatus.OK);
    }

    // stretch
    // POST http://localhost:2019/zoos/zoo

    // stretch
    // PUT http://localhost:2019/zoos/zoo/:id

    // stretch
    // PATCH http://localhost:2019/zoos/zoo/:id

    // stretch
    // DELETE http://localhost:2019/zoos/zoo/:id
}
