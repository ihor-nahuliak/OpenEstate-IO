//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.02.21 at 12:37:47 AM CET 
//


package org.openestate.io.is24_xml.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GrundstueckGewerbeKategorienTyp.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="GrundstueckGewerbeKategorienTyp">
 *   &lt;restriction base="{http://www.immobilienscout24.de/immobilientransfer}GrundstueckKategorienTyp">
 *     &lt;enumeration value="Gewerbe"/>
 *     &lt;enumeration value="LandForstwirtschaft"/>
 *     &lt;enumeration value="Freizeit"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "GrundstueckGewerbeKategorienTyp")
@XmlEnum(GrundstueckKategorienTyp.class)
public enum GrundstueckGewerbeKategorienTyp {

    @XmlEnumValue("Gewerbe")
    GEWERBE(GrundstueckKategorienTyp.GEWERBE),
    @XmlEnumValue("LandForstwirtschaft")
    LAND_FORSTWIRTSCHAFT(GrundstueckKategorienTyp.LAND_FORSTWIRTSCHAFT),
    @XmlEnumValue("Freizeit")
    FREIZEIT(GrundstueckKategorienTyp.FREIZEIT);
    private final GrundstueckKategorienTyp value;

    GrundstueckGewerbeKategorienTyp(GrundstueckKategorienTyp v) {
        value = v;
    }

    public GrundstueckKategorienTyp value() {
        return value;
    }

    public static GrundstueckGewerbeKategorienTyp fromValue(GrundstueckKategorienTyp v) {
        for (GrundstueckGewerbeKategorienTyp c: GrundstueckGewerbeKategorienTyp.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v.toString());
    }

}
