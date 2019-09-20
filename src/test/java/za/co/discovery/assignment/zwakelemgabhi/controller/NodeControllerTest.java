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
import za.co.discovery.assignment.zwakelemgabhi.model.Node;
import za.co.discovery.assignment.zwakelemgabhi.service.NodeService;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(NodeController.class)
public class NodeControllerTest {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private NodeService nodeService;

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void whenGetAllNodes_thenReturnAllNodes() throws Exception {

    List<Node> nodes = new ArrayList<>();
    nodes.add(new Node("B"));
    nodes.add(new Node("A"));
    nodes.add(new Node("K*"));

    given(nodeService.getAllNodes()).willReturn(nodes);

    mvc.perform(get("/spaceApp/v1/node/getAll")
      .contentType(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$", hasSize(3)))
      .andExpect(jsonPath("$[1].name", is("A")))
      .andExpect(jsonPath("$[0].name", is("B")));
  }
}
