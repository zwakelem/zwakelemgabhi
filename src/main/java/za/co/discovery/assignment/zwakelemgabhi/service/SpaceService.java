package za.co.discovery.assignment.zwakelemgabhi.service;

import org.apache.commons.lang3.StringUtils;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.interfaces.ShortestPathAlgorithm;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultEdge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.discovery.assignment.zwakelemgabhi.exception.NodeDoesNotExistException;
import za.co.discovery.assignment.zwakelemgabhi.model.Node;
import za.co.discovery.assignment.zwakelemgabhi.model.SpaceGraphCreator;
import za.co.discovery.assignment.zwakelemgabhi.util.Constants;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Has all the business logic for space travel operations
 */
@Service
public class SpaceService {

  private static final Logger LOG = LoggerFactory.getLogger(SpaceService.class);

  @Autowired
  private SpaceGraphCreator spaceGraphCreator;

  /**
   * calculates the shortest path between two points on a Graph
   *
   * @param pointA starting point
   * @param pointB destination
   *
   * @return a Set of Strings that represent Node names in the journey from
   * pointA to pointB
   *
   * @throws NodeDoesNotExistException if any of the Nodes does not exist
   */
  public Set<String> shortestPathBetween(String pointA, String pointB) throws NodeDoesNotExistException {
    LOG.info("Shortest path from point{} to point{}",pointA, pointB);
    GraphPath shortestPathGraph = getNodeDefaultEdgeSingleSourcePaths(new Node(pointA), new Node(pointB));
    Set<String> nodesPath = convertEdgeListToStringCollection(shortestPathGraph);
    LOG.info(nodesPath.toString());
    return nodesPath;
  }

  private GraphPath<Node, DefaultEdge> getNodeDefaultEdgeSingleSourcePaths(Node pointA, Node pointB) throws NodeDoesNotExistException {
    DijkstraShortestPath<Node, DefaultEdge> dijkstraAlg = new DijkstraShortestPath<>(spaceGraphCreator.getInstance());
    if (nodeExistsInDatabase(pointA) && nodeExistsInDatabase(pointB)) {
      ShortestPathAlgorithm.SingleSourcePaths<Node, DefaultEdge> iPaths =  dijkstraAlg.getPaths(pointA);
      return iPaths.getPath(pointB);
    } else {
      LOG.warn(Constants.NODE_NOT_EXIST);
      throw new NodeDoesNotExistException(Constants.NODE_NOT_EXIST);
    }
  }

  private Set convertEdgeListToStringCollection(GraphPath shortestPathGraph) {
    Set nodeNames = new LinkedHashSet<>();
    String startNode = ((Node)shortestPathGraph.getStartVertex()).getName();
    String lastNode = ((Node)shortestPathGraph.getEndVertex()).getName();
    List edgeList = shortestPathGraph.getEdgeList();
    addNodesInOrderOfPath(nodeNames, startNode, lastNode, edgeList);
    return nodeNames;
  }

  private void addNodesInOrderOfPath(Set nodeNames, String startNode, String lastNode, List edgeList) {
    nodeNames.add(startNode);
    List<String> nodesInPath = Arrays.asList(StringUtils.substringsBetween(edgeList.toString(),"=",")"));
    nodesInPath.stream().filter(n -> (!n.equals(startNode) && !n.equals(lastNode))).forEach(n -> nodeNames.add(n));
    nodeNames.add(lastNode);
  }

  private boolean nodeExistsInDatabase(Node node) {
    return spaceGraphCreator.getInstance().containsVertex(node);
  }

}
