package za.co.discovery.assignment.zwakelemgabhi.model;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.co.discovery.assignment.zwakelemgabhi.dao.EdgeRepository;
import za.co.discovery.assignment.zwakelemgabhi.dao.NodeRepository;

import java.util.List;

/**
 * A Singleton, this class creates a Graph that represents the different Nodes
 * and Edges in the interstellar transport system.
 */
@Component
public class SpaceGraphCreator {

  private static Graph<Node, DefaultEdge> graphInstance = null;

  @Autowired
  private NodeRepository nodeRepository;

  @Autowired
  private EdgeRepository edgeRepository;

  /**
   * The only way to get a object of this class, it creates one
   * if none exist. It returns existing one if one has been created.
   *
   * @return
   * A Graph from the Nodes and Edge in the database
   */
  public Graph<Node, DefaultEdge> getInstance() {
    if (graphInstance == null) {
      graphInstance = initialiseSpaceGraph();
      return graphInstance;
    }
    return graphInstance;
  }

  /**
   * Constructs and Initialises SpaceGraph
   *
   * @return an instance of SpaceGraph
   */
  private Graph<Node, DefaultEdge> initialiseSpaceGraph() {
    Graph<Node, DefaultEdge> g = new SimpleGraph<>(DefaultEdge.class);
    g = addNodes(g);
    g = addEdges(g);
    return g;
  }

  /**
   * get all Edges from the database and adds them to Graph
   *
   * @param g Graph to add Edges to
   *
   * @return Graph with Edges added to it
   */
  private Graph<Node, DefaultEdge> addEdges(Graph<Node, DefaultEdge> g) {
    List<Edge> edges = edgeRepository.findAll();
    edges.forEach(e -> g.addEdge(new Node(e.getA()), new Node(e.getB())));
    return g;
  }

  /**
   * gets all Nodes from the database and adds them to Graph
   *
   * @param g Graph to add Nodes to
   *
   * @return Graph with nodes added to it
   */
  private Graph<Node, DefaultEdge> addNodes(Graph<Node, DefaultEdge> g) {
    List<Node> nodes = nodeRepository.findAll();
    nodes.forEach(g::addVertex);
    return g;
  }

}
