package microsoft.exchange.webservices.data.property.complex;

import microsoft.exchange.webservices.data.core.XmlElementNames;

public class AttributedPhoneNumberCollection extends ComplexPropertyCollection<AttributedPhoneNumber> {
    private String collectionItemXmlElementName;

    public AttributedPhoneNumberCollection() {
        this(XmlElementNames.PhoneNumberAttributedValue);
    }

    public AttributedPhoneNumberCollection(String collectionItemXmlElementName) {
        this.collectionItemXmlElementName = collectionItemXmlElementName;
    }

    public String getCollectionItemXmlElementName() {
        return collectionItemXmlElementName;
    }

    public void add(AttributedPhoneNumber attribution) {
        this.internalAdd(attribution);
    }

    public void addRange(Iterable<AttributedPhoneNumber> attributions) {
        if (attributions != null) {
            for (AttributedPhoneNumber a : attributions) {
                add(a);
            }
        }
    }

    public void clear() {
        internalClear();
    }

    @Override
    protected AttributedPhoneNumber createComplexProperty(String xmlElementName) {
        if (xmlElementName != null && xmlElementName.equalsIgnoreCase(this.collectionItemXmlElementName)) {
            return new AttributedPhoneNumber();
        } else {
            return null;
        }
    }

    @Override
    protected String getCollectionItemXmlElementName(AttributedPhoneNumber complexProperty) {
        return collectionItemXmlElementName;
    }

    @Override
    public boolean shouldWriteToXml() {
        return true;
    }
}
