package za.co.discovery.assignment.zwakelemgabhi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import za.co.discovery.assignment.zwakelemgabhi.exception.NodeDoesNotExistException;
import za.co.discovery.assignment.zwakelemgabhi.service.SpaceService;

import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * A Controller that has the endpoints to perform space operations
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/spaceApp/v1/space")
public class SpaceController {

  @Autowired
  private SpaceService spaceService;

  /**
   * takes two parameters and returns a Set of Nodes representing
   * the shortest path between the two nodes
   * @param start starting point in calculating shortest path
   * @param destination destination in calculating shortest path
   * @return
   * @throws NodeDoesNotExistException
   */
  @GetMapping(value = "/traverse", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
  public Set<String> getShortestPathFromAToB(@RequestParam @NotNull String start,
    @RequestParam @NotNull String destination) throws NodeDoesNotExistException {
    return spaceService.shortestPathBetween(start, destination);
  }

}
