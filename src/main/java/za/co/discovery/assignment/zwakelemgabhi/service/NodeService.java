package za.co.discovery.assignment.zwakelemgabhi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.discovery.assignment.zwakelemgabhi.dao.NodeRepository;
import za.co.discovery.assignment.zwakelemgabhi.model.Node;

import java.util.List;

/**
 * NodeService has all the business logic for the Node entity
 */
@Service
public class NodeService {

  @Autowired
  private NodeRepository nodeRepository;

  /**
   * calls data layer to return all Nodes
   *
   * @return List of all Nodes
   */
  public List<Node> getAllNodes() {
    return nodeRepository.findAll();
  }

  /**
   * calls data layer to add Node to database
   *
   * @param node to add to database
   *
   * @return Node entity added to database
   */
  public Node addNode(String node) {
    return nodeRepository.save(new Node(node));
  }

  /**
   * calls data layer to delete Node from database
   *
   * @param node to delete from database
   */
  public void deleteNode(String node) {
    nodeRepository.delete(new Node(node));
  }
}
