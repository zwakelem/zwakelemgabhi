package za.co.discovery.assignment.zwakelemgabhi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.discovery.assignment.zwakelemgabhi.model.Node;
import za.co.discovery.assignment.zwakelemgabhi.service.NodeService;

import java.util.List;

/**
 * A Controller for the Node entity, this contains all the REST
 * endpoints to perform CRUD operations on the Node entity.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/spaceApp/v1/node")
public class NodeController {

  @Autowired
  private NodeService nodeService;


  @GetMapping("getAll")
  public List<Node> getAllNodes() {
    return nodeService.getAllNodes();
  }

  @GetMapping("ok")
  public List<Node> getAllNodes() {
    return "OK";
  }

  @PostMapping("create/{nodeName}")
  public Node addNode(@PathVariable String nodeName) {
    return nodeService.addNode(nodeName);
  }


  @DeleteMapping("delete/{nodeName}")
  public void deleteNode(@PathVariable String nodeName) {
    nodeService.deleteNode(nodeName);
  }
}
