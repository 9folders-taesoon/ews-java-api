package microsoft.exchange.webservices.data.property.complex;

import java.util.ArrayList;
import java.util.List;

import microsoft.exchange.webservices.data.core.EwsServiceXmlReader;
import microsoft.exchange.webservices.data.core.EwsUtilities;
import microsoft.exchange.webservices.data.core.XmlElementNames;
import microsoft.exchange.webservices.data.core.enumeration.misc.XmlNamespace;
import microsoft.exchange.webservices.data.core.exception.misc.ArgumentNullException;
import microsoft.exchange.webservices.data.security.XmlNodeType;

public class AttributedString extends ComplexProperty {
    private List<String> attributionList;
    private String value;

    public AttributedString() { }

    public AttributedString(String value) throws Exception {
        EwsUtilities.validateParam(value, "value");
        this.value = value;
    }

    public AttributedString(String value, List<String> attributions) throws Exception {
        this(value);

        if (attributions == null)
        {
            throw new ArgumentNullException("attributions");
        }

        for (String s : attributions) {
            EwsUtilities.validateParam(s, "attributions");
        }

        this.attributionList = attributions;
    }

    public List<String> getAttributionList() {
        return attributionList;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    @Override
    public boolean tryReadElementFromXml(EwsServiceXmlReader reader) throws Exception {
        String localName = reader.getLocalName();
        if (localName.equalsIgnoreCase(XmlElementNames.Value)) {
            value = reader.readElementValue();
            return true;
        } else if (localName.equalsIgnoreCase(XmlElementNames.Attributions)) {
            return loadAttributesFromXml(reader);
        } else {
            return false;
        }
    }

    private boolean loadAttributesFromXml(EwsServiceXmlReader reader) {
        if (!reader.isEmptyElement()) {
            String localName = reader.getLocalName();
            List<String> attributeList = new ArrayList<String>();
            try {
                XmlNodeType element = new XmlNodeType(XmlNodeType.START_ELEMENT);
                do {
                    reader.read();
                    if (reader.getNodeType().equals(element)
                            && reader.getLocalName().equalsIgnoreCase(XmlElementNames.Attribution)) {
                        String s = reader.readElementValue();
                        if (s != null && s.length() > 0) {
                            attributeList.add(s);
                        }
                    }
                } while (!reader.isEndElement(XmlNamespace.Types, localName));

                this.attributionList.clear();
                this.attributionList.addAll(attributeList);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return true;
    }
}
