//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.02.20 at 01:58:20 AM CET 
//


package org.openestate.io.immobiliare_it.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for propertyTypeSimple.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="propertyTypeSimple">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Appartamento"/>
 *     &lt;enumeration value="Attico"/>
 *     &lt;enumeration value="Mansarda"/>
 *     &lt;enumeration value="Garage"/>
 *     &lt;enumeration value="Casa Indipendente"/>
 *     &lt;enumeration value="Palazzo"/>
 *     &lt;enumeration value="Stabile"/>
 *     &lt;enumeration value="Rustico"/>
 *     &lt;enumeration value="Casale"/>
 *     &lt;enumeration value="Villa"/>
 *     &lt;enumeration value="Villetta a schiera"/>
 *     &lt;enumeration value="Loft"/>
 *     &lt;enumeration value="Open Space"/>
 *     &lt;enumeration value="Multipropriet\u00e0"/>
 *     &lt;enumeration value="Villetta"/>
 *     &lt;enumeration value="Agriturismo"/>
 *     &lt;enumeration value="Bed and Breakfast"/>
 *     &lt;enumeration value="Barca"/>
 *     &lt;enumeration value="Bungalow"/>
 *     &lt;enumeration value="Chalet"/>
 *     &lt;enumeration value="Baita"/>
 *     &lt;enumeration value="Hotel"/>
 *     &lt;enumeration value="Parco Vacanze"/>
 *     &lt;enumeration value="Residence"/>
 *     &lt;enumeration value="Roulotte"/>
 *     &lt;enumeration value="Stanza"/>
 *     &lt;enumeration value="Camera"/>
 *     &lt;enumeration value="Casa per ferie (gruppi)"/>
 *     &lt;enumeration value="Other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "propertyTypeSimple")
@XmlEnum
public enum PropertyTypeSimple {

    @XmlEnumValue("Appartamento")
    APPARTAMENTO("Appartamento"),
    @XmlEnumValue("Attico")
    ATTICO("Attico"),
    @XmlEnumValue("Mansarda")
    MANSARDA("Mansarda"),
    @XmlEnumValue("Garage")
    GARAGE("Garage"),
    @XmlEnumValue("Casa Indipendente")
    CASA_INDIPENDENTE("Casa Indipendente"),
    @XmlEnumValue("Palazzo")
    PALAZZO("Palazzo"),
    @XmlEnumValue("Stabile")
    STABILE("Stabile"),
    @XmlEnumValue("Rustico")
    RUSTICO("Rustico"),
    @XmlEnumValue("Casale")
    CASALE("Casale"),
    @XmlEnumValue("Villa")
    VILLA("Villa"),
    @XmlEnumValue("Villetta a schiera")
    VILLETTA_A_SCHIERA("Villetta a schiera"),
    @XmlEnumValue("Loft")
    LOFT("Loft"),
    @XmlEnumValue("Open Space")
    OPEN_SPACE("Open Space"),
    @XmlEnumValue("Multipropriet\u00e0")
    MULTIPROPRIET\u00c0("Multipropriet\u00e0"),
    @XmlEnumValue("Villetta")
    VILLETTA("Villetta"),
    @XmlEnumValue("Agriturismo")
    AGRITURISMO("Agriturismo"),
    @XmlEnumValue("Bed and Breakfast")
    BED_AND_BREAKFAST("Bed and Breakfast"),
    @XmlEnumValue("Barca")
    BARCA("Barca"),
    @XmlEnumValue("Bungalow")
    BUNGALOW("Bungalow"),
    @XmlEnumValue("Chalet")
    CHALET("Chalet"),
    @XmlEnumValue("Baita")
    BAITA("Baita"),
    @XmlEnumValue("Hotel")
    HOTEL("Hotel"),
    @XmlEnumValue("Parco Vacanze")
    PARCO_VACANZE("Parco Vacanze"),
    @XmlEnumValue("Residence")
    RESIDENCE("Residence"),
    @XmlEnumValue("Roulotte")
    ROULOTTE("Roulotte"),
    @XmlEnumValue("Stanza")
    STANZA("Stanza"),
    @XmlEnumValue("Camera")
    CAMERA("Camera"),
    @XmlEnumValue("Casa per ferie (gruppi)")
    CASA_PER_FERIE_GRUPPI("Casa per ferie (gruppi)"),
    @XmlEnumValue("Other")
    OTHER("Other");
    private final String value;

    PropertyTypeSimple(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PropertyTypeSimple fromValue(String v) {
        for (PropertyTypeSimple c: PropertyTypeSimple.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}