package za.co.discovery.assignment.zwakelemgabhi.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import za.co.discovery.assignment.zwakelemgabhi.schema.GetShortestPathRequest;
import za.co.discovery.assignment.zwakelemgabhi.schema.GetShortestPathResponse;
import za.co.discovery.assignment.zwakelemgabhi.service.SpaceService;
import za.co.discovery.assignment.zwakelemgabhi.util.Constants;

@Endpoint
public class SpaceTravelEndpoint {

  @Autowired
  private SpaceService spaceService;

  /**
   * method for the SOAP service to call to get shortest possible path
   *
   * @param request a request object with pointA and pointB
   *
   * @return a response object that has shortest possible path from pointA to pointB
   */
  @PayloadRoot(namespace= Constants.WS_NAMESPACE, localPart = "getShortestPathRequest")
  @ResponsePayload
  public GetShortestPathResponse computeShortestPathBetweenNodes(@RequestPayload GetShortestPathRequest request) {
    GetShortestPathResponse response = new GetShortestPathResponse();
    String pointA = request.getPointA();
    String pointB = request.getPointB();
    response.setPath(spaceService.shortestPathBetween(pointA, pointB).toString());
    return response;
  }
}
