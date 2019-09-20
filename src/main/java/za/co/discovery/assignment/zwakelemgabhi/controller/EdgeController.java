package za.co.discovery.assignment.zwakelemgabhi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import za.co.discovery.assignment.zwakelemgabhi.model.Edge;
import za.co.discovery.assignment.zwakelemgabhi.service.EdgeService;

import java.util.List;

/**
 * A Controller for the Edge entity, this contains all the REST
 * endpoints to perform CRUD operations on the Edge entity.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/spaceApp/v1/edge")
public class EdgeController {

  @Autowired
  private EdgeService edgeService;

  @GetMapping("/getAll")
  public List<Edge> getAllEdges() {
    return edgeService.getAllEdges();
  }

  @PostMapping("/add")
  public ResponseEntity<Edge> addEdge(@RequestParam String start, @RequestParam String destination) {
    HttpStatus status = HttpStatus.CREATED;
    Edge createdEdge = edgeService.addEdge(start, destination);
    return new ResponseEntity<>(createdEdge, status);
  }

  @DeleteMapping("/delete")
  public void deleteEdge(@RequestParam String start, @RequestParam String destination) {
    edgeService.deleteEdge(start, destination);
  }
}
