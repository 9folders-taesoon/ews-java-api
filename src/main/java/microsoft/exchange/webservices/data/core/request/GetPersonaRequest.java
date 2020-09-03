package microsoft.exchange.webservices.data.core.request;

import java.util.List;

import microsoft.exchange.webservices.data.core.EwsServiceXmlReader;
import microsoft.exchange.webservices.data.core.EwsServiceXmlWriter;
import microsoft.exchange.webservices.data.core.ExchangeService;
import microsoft.exchange.webservices.data.core.XmlElementNames;
import microsoft.exchange.webservices.data.core.enumeration.misc.ExchangeVersion;
import microsoft.exchange.webservices.data.core.enumeration.misc.XmlNamespace;
import microsoft.exchange.webservices.data.core.response.GetPersonaResponse;
import microsoft.exchange.webservices.data.property.complex.PersonaId;

public class GetPersonaRequest extends SimpleServiceRequestBase<GetPersonaResponse> {
    public GetPersonaRequest(ExchangeService service)
            throws Exception {
        super(service);
    }

    /**
     * Gets the name of the XML element.
     *
     * @return XML element name
     */
    @Override public String getXmlElementName() {
        return XmlElementNames.GetPersona;
    }

    /**
     * Writes XML elements.
     *
     * @param writer the writer
     * @throws Exception the exception
     */
    @Override
    protected void writeElementsToXml(EwsServiceXmlWriter writer)
            throws Exception {
        for (PersonaId id : personaIdList) {
            writer.writeStartElement(XmlNamespace.Messages, XmlElementNames.PersonaId);
            writer.writeAttributeValue("Id", id.getUniqueId());
            writer.writeEndElement();
        }
    }

    /**
     * Gets the name of the response XML element.
     *
     * @return XML element name.
     */
    @Override
    protected String getResponseXmlElementName() {
        return XmlElementNames.GetPersonaResponseMessage;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected GetPersonaResponse parseResponse(EwsServiceXmlReader reader)
            throws Exception {
        GetPersonaResponse response = new GetPersonaResponse();
        response.loadFromXml(reader, XmlElementNames.GetPersonaResponseMessage);
        return response;
    }

    /**
     * Gets the request version.
     *
     * @return Earliest Exchange version in which this request is supported.
     */
    @Override
    protected ExchangeVersion getMinimumRequiredServerVersion() {
        return ExchangeVersion.Exchange2010;
    }

    /**
     * Executes this request.
     *
     * @return Service response.
     * @throws Exception the exception
     */
    public GetPersonaResponse execute() throws Exception {
        GetPersonaResponse serviceResponse = internalExecute();
        serviceResponse.throwIfNecessary();
        return serviceResponse;
    }

    protected List<PersonaId> getPersonaIdList() {
        return this.personaIdList;
    }

    /**
     * Sets the room list.
     *
     * @param value the new room list
     */
    public void setPersonaIdList(List<PersonaId> value) {
        this.personaIdList = value;
    }

    /**
     * The room list.
     */
    private List<PersonaId> personaIdList;
}
