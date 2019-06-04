
package org.openestate.io.immobar_it.xml;

import java.math.BigDecimal;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class Adapter4
    extends XmlAdapter<String, BigDecimal>
{


    public BigDecimal unmarshal(String value) {
        return (org.openestate.io.immobar_it.ImmobarItUtils.parseLongitudeValue(value));
    }

    public String marshal(BigDecimal value) {
        return (org.openestate.io.immobar_it.ImmobarItUtils.printLongitudeValue(value));
    }

}
