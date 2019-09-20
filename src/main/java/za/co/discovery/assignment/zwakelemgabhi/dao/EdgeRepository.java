package za.co.discovery.assignment.zwakelemgabhi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.discovery.assignment.zwakelemgabhi.model.Edge;
import za.co.discovery.assignment.zwakelemgabhi.model.EdgeId;

@Repository
public interface EdgeRepository extends JpaRepository<Edge, EdgeId> {

}
