package za.co.discovery.assignment.zwakelemgabhi.model;

import java.io.Serializable;

/**
 * A primary key for the Edge class, JPA wants a separate class
 * for an entity with composite primary key
 */
public class EdgeId implements Serializable {

  private String a;

  private String b;
}
