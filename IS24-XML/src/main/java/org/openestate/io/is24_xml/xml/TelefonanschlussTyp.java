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
 * <p>Java class for TelefonanschlussTyp.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TelefonanschlussTyp">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="keineAngabe"/>
 *     &lt;enumeration value="analog"/>
 *     &lt;enumeration value="ISDN"/>
 *     &lt;enumeration value="nichtVorhanden"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TelefonanschlussTyp")
@XmlEnum
public enum TelefonanschlussTyp {

    @XmlEnumValue("keineAngabe")
    KEINE_ANGABE("keineAngabe"),
    @XmlEnumValue("analog")
    ANALOG("analog"),
    ISDN("ISDN"),
    @XmlEnumValue("nichtVorhanden")
    NICHT_VORHANDEN("nichtVorhanden");
    private final String value;

    TelefonanschlussTyp(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TelefonanschlussTyp fromValue(String v) {
        for (TelefonanschlussTyp c: TelefonanschlussTyp.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
