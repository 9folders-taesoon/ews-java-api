package microsoft.exchange.webservices.data.property.complex;

import microsoft.exchange.webservices.data.core.EwsServiceXmlWriter;
import microsoft.exchange.webservices.data.core.XmlAttributeNames;
import microsoft.exchange.webservices.data.core.XmlElementNames;
import microsoft.exchange.webservices.data.core.exception.service.local.ServiceXmlSerializationException;

public class AddressListId extends ServiceId {
    private final String uuid;

    public AddressListId(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String getXmlElementName() {
        return XmlElementNames.AddressListId;
    }

    public void writeAttributesToXml(EwsServiceXmlWriter writer)
            throws ServiceXmlSerializationException {
        writer.writeAttributeValue(XmlAttributeNames.Id, uuid);
    }
}
