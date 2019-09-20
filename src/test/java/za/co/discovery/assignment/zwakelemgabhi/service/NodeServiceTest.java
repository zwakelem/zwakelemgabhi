package za.co.discovery.assignment.zwakelemgabhi.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import za.co.discovery.assignment.zwakelemgabhi.dao.NodeRepository;
import za.co.discovery.assignment.zwakelemgabhi.model.Node;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class NodeServiceTest {

  @Mock
  private NodeRepository nodeRepository;

  @InjectMocks
  private NodeService nodeService;

  @Test
  public void whenGetAllNodes_thenReturnNodeList() {
    List<Node> expectedNodes = new ArrayList<>();
    expectedNodes.add(new Node("W"));
    expectedNodes.add(new Node("G"));

    doReturn(expectedNodes).when(nodeRepository).findAll();

    List<Node> actualNodes = nodeService.getAllNodes();

    assertThat(actualNodes).isEqualTo(expectedNodes);
  }

  @Test
  public void whenAddNode_thenReturnNode() {

    Node expectedNode = new Node("G");

    doReturn(expectedNode).when(nodeRepository).save(expectedNode);

    Node actualNode = nodeService.addNode("G");

    assertThat(actualNode).isEqualTo(actualNode);
  }



}
