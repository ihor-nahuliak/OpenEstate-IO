//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.03.01 at 03:36:40 AM CET 
//


package org.openestate.io.daft_ie.xml;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class Adapter7
    extends XmlAdapter<java.lang.String, String>
{


    public String unmarshal(java.lang.String value) {
        return (org.openestate.io.daft_ie.DaftIeUtils.parseCountry(value));
    }

    public java.lang.String marshal(String value) {
        return (org.openestate.io.daft_ie.DaftIeUtils.printCountry(value));
    }

}
