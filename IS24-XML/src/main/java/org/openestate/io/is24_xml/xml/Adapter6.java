//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.02.21 at 12:37:47 AM CET 
//


package org.openestate.io.is24_xml.xml;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class Adapter6
    extends XmlAdapter<String, Long>
{


    public Long unmarshal(String value) {
        return (org.openestate.io.is24_xml.Is24XmlUtils.parseZahl2(value));
    }

    public String marshal(Long value) {
        return (org.openestate.io.is24_xml.Is24XmlUtils.printZahl2Including0(value));
    }

}
