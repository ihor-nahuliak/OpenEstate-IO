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
 * <p>Java class for ErschliessungszustandTyp.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ErschliessungszustandTyp">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Erschlossen"/>
 *     &lt;enumeration value="Teilerschlossen"/>
 *     &lt;enumeration value="Unerschlossen"/>
 *     &lt;enumeration value="Unbekannt"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ErschliessungszustandTyp")
@XmlEnum
public enum ErschliessungszustandTyp {

    @XmlEnumValue("Erschlossen")
    ERSCHLOSSEN("Erschlossen"),
    @XmlEnumValue("Teilerschlossen")
    TEILERSCHLOSSEN("Teilerschlossen"),
    @XmlEnumValue("Unerschlossen")
    UNERSCHLOSSEN("Unerschlossen"),
    @XmlEnumValue("Unbekannt")
    UNBEKANNT("Unbekannt");
    private final String value;

    ErschliessungszustandTyp(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ErschliessungszustandTyp fromValue(String v) {
        for (ErschliessungszustandTyp c: ErschliessungszustandTyp.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
