package za.co.discovery.assignment.zwakelemgabhi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jgrapht.graph.DefaultEdge;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Edge Entity, represents a path between two Nodes Node a and Node b.
 */

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="edge")
@IdClass(EdgeId.class)
public class Edge extends DefaultEdge implements Serializable {

  @Id
  @Column(name = "a")
  private String a;

  @Id
  @Column(name = "b")
  private String b;
}
