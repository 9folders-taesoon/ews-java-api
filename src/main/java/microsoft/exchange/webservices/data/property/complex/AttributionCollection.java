package microsoft.exchange.webservices.data.property.complex;

import microsoft.exchange.webservices.data.core.XmlElementNames;

public class AttributionCollection extends ComplexPropertyCollection<Attribution> {
    private String collectionItemXmlElementName;

    public AttributionCollection() {
        this(XmlElementNames.Attribution);
    }

    public AttributionCollection(String collectionItemXmlElementName) {
        this.collectionItemXmlElementName = collectionItemXmlElementName;
    }

    public String getCollectionItemXmlElementName() {
        return collectionItemXmlElementName;
    }

    public void add(Attribution attribution) {
        this.internalAdd(attribution);
    }

    public void addRange(Iterable<Attribution> attributions) {
        if (attributions != null) {
            for (Attribution a : attributions) {
                add(a);
            }
        }
    }

    public void clear() {
        internalClear();
    }

    @Override
    protected Attribution createComplexProperty(String xmlElementName) {
        if (xmlElementName != null && xmlElementName.equalsIgnoreCase(this.collectionItemXmlElementName)) {
            return new Attribution();
        } else {
            return null;
        }
    }

    @Override
    protected String getCollectionItemXmlElementName(Attribution complexProperty) {
        return collectionItemXmlElementName;
    }

    @Override
    public boolean shouldWriteToXml() {
        return true;
    }
}
