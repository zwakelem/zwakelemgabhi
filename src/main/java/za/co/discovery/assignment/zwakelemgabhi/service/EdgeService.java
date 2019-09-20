package za.co.discovery.assignment.zwakelemgabhi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.discovery.assignment.zwakelemgabhi.dao.EdgeRepository;
import za.co.discovery.assignment.zwakelemgabhi.model.Edge;

import java.util.List;

/**
 * EdgeService has all the business logic for the Edge entity
 */
@Service
public class EdgeService {

  @Autowired
  private EdgeRepository edgeRepository;

  /**
   * calls data layer to return all Edges
   *
   * @return List of all Edges
   */
  public List<Edge> getAllEdges() {
    return edgeRepository.findAll();
  }

  /**
   * calls data layer to add Edge to database
   *
   * @param a attribute a of Edge
   * @param b attribute b of Edge
   *
   * @return Edge object created
   */
  public Edge addEdge(String a, String b) {
    return edgeRepository.save(new Edge(a,b));
  }

  /**
   * calls data layer to delete Edge from database
   *
   * @param a attribute a of Edge
   * @param b attribute b of Edge
   */
  public void deleteEdge(String a, String b) {
    edgeRepository.delete(new Edge(a,b));
  }
}
