package microsoft.exchange.webservices.data.property.complex;

import microsoft.exchange.webservices.data.core.XmlElementNames;

public class AttributedStringCollection extends ComplexPropertyCollection<AttributedString> {
    private String collectionItemXmlElementName;

    public AttributedStringCollection() {
        this(XmlElementNames.StringAttributedValue);
    }

    public AttributedStringCollection(String collectionItemXmlElementName) {
        this.collectionItemXmlElementName = collectionItemXmlElementName;
    }

    public String getCollectionItemXmlElementName() {
        return collectionItemXmlElementName;
    }

    public void add(AttributedString attribution) {
        this.internalAdd(attribution);
    }

    public void addRange(Iterable<AttributedString> attributions) {
        if (attributions != null) {
            for (AttributedString a : attributions) {
                add(a);
            }
        }
    }

    public void clear() {
        internalClear();
    }

    @Override
    protected AttributedString createComplexProperty(String xmlElementName) {
        if (xmlElementName != null && xmlElementName.equalsIgnoreCase(this.collectionItemXmlElementName)) {
            return new AttributedString();
        } else {
            return null;
        }
    }

    @Override
    protected String getCollectionItemXmlElementName(AttributedString complexProperty) {
        return collectionItemXmlElementName;
    }

    @Override
    public boolean shouldWriteToXml() {
        return true;
    }
}
