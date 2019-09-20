package za.co.discovery.assignment.zwakelemgabhi.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import za.co.discovery.assignment.zwakelemgabhi.dao.EdgeRepository;
import za.co.discovery.assignment.zwakelemgabhi.model.Edge;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class EdgeServiceTest {

  @Mock
  private EdgeRepository edgeRepository;

  @InjectMocks
  private EdgeService edgeService;

  @Test
  public void whenGetAllEdges_thenReturnEdgeList() {

    List<Edge> expectedEdges = new ArrayList<>();
    expectedEdges.add(new Edge("W", "Z"));
    expectedEdges.add(new Edge("G", "K"));

    doReturn(expectedEdges).when(edgeRepository).findAll();

    List<Edge> actualEdges = edgeService.getAllEdges();

    assertThat(actualEdges).isEqualTo(expectedEdges);
  }

  @Test
  public void whenAddEdge_thenReturnEdge() {

    Edge expectedEdge = new Edge("G", "F");

    doReturn(expectedEdge).when(edgeRepository).save(expectedEdge);

    Edge actualEdge = edgeService.addEdge("G", "F");

    assertThat(actualEdge).isEqualTo(expectedEdge);
  }

}
