//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2017.12.28 at 05:49:44 PM GMT
//

package net.sf.mpxj.ganttproject.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

/**
 * <p>Java class for depend complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="depend">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="difference" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="hardness" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@SuppressWarnings("all") @XmlAccessorType(XmlAccessType.FIELD) @XmlType(name = "depend", propOrder =
{
   "value"
}) public class Depend
{

   @XmlValue protected String value;
   @XmlAttribute(name = "id") protected Integer id;
   @XmlAttribute(name = "type") protected Integer type;
   @XmlAttribute(name = "difference") protected Integer difference;
   @XmlAttribute(name = "hardness") protected String hardness;

   /**
    * Gets the value of the value property.
    *
    * @return
    *     possible object is
    *     {@link String }
    *
    */
   public String getValue()
   {
      return value;
   }

   /**
    * Sets the value of the value property.
    *
    * @param value
    *     allowed object is
    *     {@link String }
    *
    */
   public void setValue(String value)
   {
      this.value = value;
   }

   /**
    * Gets the value of the id property.
    *
    * @return
    *     possible object is
    *     {@link Integer }
    *
    */
   public Integer getId()
   {
      return id;
   }

   /**
    * Sets the value of the id property.
    *
    * @param value
    *     allowed object is
    *     {@link Integer }
    *
    */
   public void setId(Integer value)
   {
      this.id = value;
   }

   /**
    * Gets the value of the type property.
    *
    * @return
    *     possible object is
    *     {@link Integer }
    *
    */
   public Integer getType()
   {
      return type;
   }

   /**
    * Sets the value of the type property.
    *
    * @param value
    *     allowed object is
    *     {@link Integer }
    *
    */
   public void setType(Integer value)
   {
      this.type = value;
   }

   /**
    * Gets the value of the difference property.
    *
    * @return
    *     possible object is
    *     {@link Integer }
    *
    */
   public Integer getDifference()
   {
      return difference;
   }

   /**
    * Sets the value of the difference property.
    *
    * @param value
    *     allowed object is
    *     {@link Integer }
    *
    */
   public void setDifference(Integer value)
   {
      this.difference = value;
   }

   /**
    * Gets the value of the hardness property.
    *
    * @return
    *     possible object is
    *     {@link String }
    *
    */
   public String getHardness()
   {
      return hardness;
   }

   /**
    * Sets the value of the hardness property.
    *
    * @param value
    *     allowed object is
    *     {@link String }
    *
    */
   public void setHardness(String value)
   {
      this.hardness = value;
   }

}