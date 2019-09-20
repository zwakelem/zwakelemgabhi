
package za.co.discovery.assignment.zwakelemgabhi.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pointA" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="pointB" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "pointA",
    "pointB"
})
@XmlRootElement(name = "getShortestPathRequest", namespace = "http://discovery.co.za/space-travel-service")
public class GetShortestPathRequest {

    @XmlElement(namespace = "http://discovery.co.za/space-travel-service", required = true)
    protected String pointA;
    @XmlElement(namespace = "http://discovery.co.za/space-travel-service", required = true)
    protected String pointB;

    /**
     * Gets the value of the pointA property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPointA() {
        return pointA;
    }

    /**
     * Sets the value of the pointA property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPointA(String value) {
        this.pointA = value;
    }

    /**
     * Gets the value of the pointB property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPointB() {
        return pointB;
    }

    /**
     * Sets the value of the pointB property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPointB(String value) {
        this.pointB = value;
    }

}
