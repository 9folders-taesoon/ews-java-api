package microsoft.exchange.webservices.data.property.complex;

import microsoft.exchange.webservices.data.core.XmlElementNames;

public class PersonaId extends ServiceId {
    @Override
    public String getXmlElementName() {
        return XmlElementNames.PersonaId;
    }

    public PersonaId(String uniqueId) throws Exception {
        super(uniqueId);
    }
}
