
package org.openestate.io.is24_xml.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.jvnet.jaxb2_commons.lang.CopyStrategy2;
import org.jvnet.jaxb2_commons.lang.CopyTo2;
import org.jvnet.jaxb2_commons.lang.Equals2;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy2;
import org.jvnet.jaxb2_commons.lang.JAXBCopyStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString2;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy2;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;


/**
 * <p>Java class for AnbieterTyp complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AnbieterTyp"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="ScoutKundenID" use="required" type="{http://www.immobilienscout24.de/immobilientransfer}Text15Typ" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AnbieterTyp")
@XmlSeeAlso({
    org.openestate.io.is24_xml.xml.ImmobilienTransferTyp.Anbieter.class
})
public class AnbieterTyp implements Cloneable, CopyTo2, Equals2, ToString2
{

    @XmlAttribute(name = "ScoutKundenID", required = true)
    @XmlJavaTypeAdapter(Adapter3 .class)
    protected String scoutKundenID;

    /**
     * Gets the value of the scoutKundenID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScoutKundenID() {
        return scoutKundenID;
    }

    /**
     * Sets the value of the scoutKundenID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScoutKundenID(String value) {
        this.scoutKundenID = value;
    }

    public String toString() {
        final ToStringStrategy2 strategy = JAXBToStringStrategy.INSTANCE;
        final StringBuilder buffer = new StringBuilder();
        append(null, buffer, strategy);
        return buffer.toString();
    }

    public StringBuilder append(ObjectLocator locator, StringBuilder buffer, ToStringStrategy2 strategy) {
        strategy.appendStart(locator, this, buffer);
        appendFields(locator, buffer, strategy);
        strategy.appendEnd(locator, this, buffer);
        return buffer;
    }

    public StringBuilder appendFields(ObjectLocator locator, StringBuilder buffer, ToStringStrategy2 strategy) {
        {
            String theScoutKundenID;
            theScoutKundenID = this.getScoutKundenID();
            strategy.appendField(locator, this, "scoutKundenID", buffer, theScoutKundenID, (this.scoutKundenID!= null));
        }
        return buffer;
    }

    public Object clone() {
        return copyTo(createNewInstance());
    }

    public Object copyTo(Object target) {
        final CopyStrategy2 strategy = JAXBCopyStrategy.INSTANCE;
        return copyTo(null, target, strategy);
    }

    public Object copyTo(ObjectLocator locator, Object target, CopyStrategy2 strategy) {
        final Object draftCopy = ((target == null)?createNewInstance():target);
        if (draftCopy instanceof AnbieterTyp) {
            final AnbieterTyp copy = ((AnbieterTyp) draftCopy);
            {
                Boolean scoutKundenIDShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.scoutKundenID!= null));
                if (scoutKundenIDShouldBeCopiedAndSet == Boolean.TRUE) {
                    String sourceScoutKundenID;
                    sourceScoutKundenID = this.getScoutKundenID();
                    String copyScoutKundenID = ((String) strategy.copy(LocatorUtils.property(locator, "scoutKundenID", sourceScoutKundenID), sourceScoutKundenID, (this.scoutKundenID!= null)));
                    copy.setScoutKundenID(copyScoutKundenID);
                } else {
                    if (scoutKundenIDShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.scoutKundenID = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new AnbieterTyp();
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final AnbieterTyp that = ((AnbieterTyp) object);
        {
            String lhsScoutKundenID;
            lhsScoutKundenID = this.getScoutKundenID();
            String rhsScoutKundenID;
            rhsScoutKundenID = that.getScoutKundenID();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "scoutKundenID", lhsScoutKundenID), LocatorUtils.property(thatLocator, "scoutKundenID", rhsScoutKundenID), lhsScoutKundenID, rhsScoutKundenID, (this.scoutKundenID!= null), (that.scoutKundenID!= null))) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy2 strategy = JAXBEqualsStrategy.INSTANCE;
        return equals(null, null, object, strategy);
    }

}
