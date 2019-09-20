package za.co.discovery.assignment.zwakelemgabhi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.discovery.assignment.zwakelemgabhi.model.Node;

@Repository
public interface NodeRepository extends JpaRepository<Node, String> {

}
