//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.03.29 at 03:46:39 PM CEST 
//


package org.vamdc.tapservice.validator.report;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Validation report
 * 
 * <p>Java class for reportRoot complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="reportRoot">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nodeCapabilitiesUrl" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *         &lt;element name="nodeTapSyncUrl" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *         &lt;element name="nodeAvailable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="queryString" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="queryDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="documentInfo" type="{http://vamdc.org/tapservice/validator/report}docInfo"/>
 *         &lt;element name="validationError" type="{http://vamdc.org/tapservice/validator/report}docError" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reportRoot", propOrder = {
    "nodeCapabilitiesUrl",
    "nodeTapSyncUrl",
    "nodeAvailable",
    "queryString",
    "queryDate",
    "documentInfo",
    "validationErrors"
})
@XmlRootElement(name = "report")
public class Report {

    @XmlElement(required = true)
    @XmlSchemaType(name = "anyURI")
    protected String nodeCapabilitiesUrl;
    @XmlElement(required = true)
    @XmlSchemaType(name = "anyURI")
    protected String nodeTapSyncUrl;
    protected boolean nodeAvailable;
    @XmlElement(required = true)
    protected String queryString;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar queryDate;
    @XmlElement(required = true)
    protected DocInfo documentInfo;
    @XmlElement(name = "validationError")
    protected List<DocError> validationErrors;

    /**
     * Gets the value of the nodeCapabilitiesUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNodeCapabilitiesUrl() {
        return nodeCapabilitiesUrl;
    }

    /**
     * Sets the value of the nodeCapabilitiesUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNodeCapabilitiesUrl(String value) {
        this.nodeCapabilitiesUrl = value;
    }

    /**
     * Gets the value of the nodeTapSyncUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNodeTapSyncUrl() {
        return nodeTapSyncUrl;
    }

    /**
     * Sets the value of the nodeTapSyncUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNodeTapSyncUrl(String value) {
        this.nodeTapSyncUrl = value;
    }

    /**
     * Gets the value of the nodeAvailable property.
     * 
     */
    public boolean isNodeAvailable() {
        return nodeAvailable;
    }

    /**
     * Sets the value of the nodeAvailable property.
     * 
     */
    public void setNodeAvailable(boolean value) {
        this.nodeAvailable = value;
    }

    /**
     * Gets the value of the queryString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQueryString() {
        return queryString;
    }

    /**
     * Sets the value of the queryString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQueryString(String value) {
        this.queryString = value;
    }

    /**
     * Gets the value of the queryDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getQueryDate() {
        return queryDate;
    }

    /**
     * Sets the value of the queryDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setQueryDate(XMLGregorianCalendar value) {
        this.queryDate = value;
    }

    /**
     * Gets the value of the documentInfo property.
     * 
     * @return
     *     possible object is
     *     {@link DocInfo }
     *     
     */
    public DocInfo getDocumentInfo() {
        return documentInfo;
    }

    /**
     * Sets the value of the documentInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocInfo }
     *     
     */
    public void setDocumentInfo(DocInfo value) {
        this.documentInfo = value;
    }

    /**
     * Gets the value of the validationErrors property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the validationErrors property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValidationErrors().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocError }
     * 
     * 
     */
    public List<DocError> getValidationErrors() {
        if (validationErrors == null) {
            validationErrors = new ArrayList<DocError>();
        }
        return this.validationErrors;
    }

}