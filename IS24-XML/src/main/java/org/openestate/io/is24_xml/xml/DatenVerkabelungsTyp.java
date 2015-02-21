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
 * <p>Java class for DatenVerkabelungsTyp.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DatenVerkabelungsTyp">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="keineAngabe"/>
 *     &lt;enumeration value="ja"/>
 *     &lt;enumeration value="true"/>
 *     &lt;enumeration value="nein"/>
 *     &lt;enumeration value="false"/>
 *     &lt;enumeration value="nachVereinbarung"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DatenVerkabelungsTyp")
@XmlEnum
public enum DatenVerkabelungsTyp {

    @XmlEnumValue("keineAngabe")
    KEINE_ANGABE("keineAngabe"),
    @XmlEnumValue("ja")
    JA("ja"),

    /**
     * entspricht 'ja'
     *             (aus Kompatibilitaetsgruenden, wird in zukuenftigen Versionen nicht mehr unterstuetzt)
     *           
     * 
     */
    @XmlEnumValue("true")
    TRUE("true"),
    @XmlEnumValue("nein")
    NEIN("nein"),

    /**
     * entspricht 'nein'
     *             (aus Kompatibilitaetsgruenden, wird in zukuenftigen Versionen nicht mehr unterstuetzt)
     *           
     * 
     */
    @XmlEnumValue("false")
    FALSE("false"),
    @XmlEnumValue("nachVereinbarung")
    NACH_VEREINBARUNG("nachVereinbarung");
    private final String value;

    DatenVerkabelungsTyp(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DatenVerkabelungsTyp fromValue(String v) {
        for (DatenVerkabelungsTyp c: DatenVerkabelungsTyp.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
