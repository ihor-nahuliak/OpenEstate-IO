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
 * <p>Java class for WazZeiteinheitenTyp.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="WazZeiteinheitenTyp">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Tag"/>
 *     &lt;enumeration value="Woche"/>
 *     &lt;enumeration value="Monat"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "WazZeiteinheitenTyp")
@XmlEnum
public enum WazZeiteinheitenTyp {

    @XmlEnumValue("Tag")
    TAG("Tag"),
    @XmlEnumValue("Woche")
    WOCHE("Woche"),
    @XmlEnumValue("Monat")
    MONAT("Monat");
    private final String value;

    WazZeiteinheitenTyp(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WazZeiteinheitenTyp fromValue(String v) {
        for (WazZeiteinheitenTyp c: WazZeiteinheitenTyp.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
