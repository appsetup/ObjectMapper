//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.04.05 at 02:29:03 PM BST 
//


package uk.co.britishgas.bertha;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Class complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Class">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ClassName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Column" type="{urn:britishgas.co.uk:Bertha}Column" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CollectionColumns" type="{urn:britishgas.co.uk:Bertha}CollectionColumns" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ObjectCreateCondition" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ObjectCreateConditionJavaProperty" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Class", propOrder = {
    "className",
    "column",
    "collectionColumns",
    "objectCreateCondition",
    "objectCreateConditionJavaProperty"
})
public class Class {

    @XmlElement(name = "ClassName", required = true)
    protected String className;
    @XmlElement(name = "Column")
    protected List<Column> column;
    @XmlElement(name = "CollectionColumns")
    protected List<CollectionColumns> collectionColumns;
    @XmlElement(name = "ObjectCreateCondition", required = true)
    protected String objectCreateCondition;
    @XmlElement(name = "ObjectCreateConditionJavaProperty", required = true)
    protected String objectCreateConditionJavaProperty;

    /**
     * Gets the value of the className property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClassName() {
        return className;
    }

    /**
     * Sets the value of the className property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClassName(String value) {
        this.className = value;
    }

    /**
     * Gets the value of the column property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the column property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getColumn().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Column }
     * 
     * 
     */
    public List<Column> getColumn() {
        if (column == null) {
            column = new ArrayList<Column>();
        }
        return this.column;
    }

    /**
     * Gets the value of the collectionColumns property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the collectionColumns property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCollectionColumns().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CollectionColumns }
     * 
     * 
     */
    public List<CollectionColumns> getCollectionColumns() {
        if (collectionColumns == null) {
            collectionColumns = new ArrayList<CollectionColumns>();
        }
        return this.collectionColumns;
    }

    /**
     * Gets the value of the objectCreateCondition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObjectCreateCondition() {
        return objectCreateCondition;
    }

    /**
     * Sets the value of the objectCreateCondition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObjectCreateCondition(String value) {
        this.objectCreateCondition = value;
    }

    /**
     * Gets the value of the objectCreateConditionJavaProperty property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObjectCreateConditionJavaProperty() {
        return objectCreateConditionJavaProperty;
    }

    /**
     * Sets the value of the objectCreateConditionJavaProperty property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObjectCreateConditionJavaProperty(String value) {
        this.objectCreateConditionJavaProperty = value;
    }

}
