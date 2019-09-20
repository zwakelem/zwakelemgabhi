package za.co.discovery.assignment.zwakelemgabhi.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import za.co.discovery.assignment.zwakelemgabhi.model.Edge;
import za.co.discovery.assignment.zwakelemgabhi.service.EdgeService;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(EdgeController.class)
public class EdgeControllerIntegrationTest {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private EdgeService edgeService;

  private List<Edge> edges = new ArrayList<>();

  @Before
  public void setUp() throws Exception {
    Edge edge1 = new Edge("a", "b");
    Edge edge2 = new Edge("f", "d");
    Edge edge3 = new Edge("e", "g");

    edges.add(edge1);
    edges.add(edge2);
    edges.add(edge3);
  }

  @Test
  public void whenGetAllEdge_thenReturnAllEdges() throws Exception {

    given(edgeService.getAllEdges()).willReturn(edges);

    mvc.perform(get("/spaceApp/v1/edge/getAll")
      .contentType(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$", hasSize(3)))
      .andExpect(jsonPath("$[1].a", is("f")))
      .andExpect(jsonPath("$[2].b", is("g")));
  }

}
