package microsoft.exchange.webservices.data.core.request;

import microsoft.exchange.webservices.data.core.EwsServiceXmlReader;
import microsoft.exchange.webservices.data.core.EwsServiceXmlWriter;
import microsoft.exchange.webservices.data.core.ExchangeService;
import microsoft.exchange.webservices.data.core.XmlElementNames;
import microsoft.exchange.webservices.data.core.enumeration.misc.ExchangeVersion;
import microsoft.exchange.webservices.data.core.enumeration.misc.XmlNamespace;
import microsoft.exchange.webservices.data.core.enumeration.service.ServiceObjectType;
import microsoft.exchange.webservices.data.core.response.FindPeopleResponse;
import microsoft.exchange.webservices.data.property.complex.FolderId;
import microsoft.exchange.webservices.data.property.complex.ServiceId;
import microsoft.exchange.webservices.data.search.ViewBase;
import microsoft.exchange.webservices.data.search.filter.SearchFilter;

public class FindPeopleRequest extends SimpleServiceRequestBase<FindPeopleResponse> {

    /**
     * The search filter.
     */
    private SearchFilter searchFilter;

    /**
     * The query string.
     */
    private String queryString;

    /**
     * The view.
     */
    private ViewBase view;

    private ServiceId folderId;

    /**
     * Initializes a new instance of the class.
     *
     * @param service the service
     * @throws Exception
     */
    public FindPeopleRequest(ExchangeService service)
            throws Exception {
        super(service);
    }

    /**
     * Gets or sets folder id
     */
    protected ServiceId getFolderId() {
        return this.folderId;
    }

    public void setQuery(String query) {
        this.queryString = query;
    }

    public void setFolderId(ServiceId value) {
        this.folderId = value;
    }

    public void setSearchFilter(SearchFilter searchFilter) {
        this.searchFilter = searchFilter;
    }

    protected ViewBase getIndexedItemView() {
        return this.view;
    }

    public void setIndexedItemView(ViewBase value) {
        this.view = value;
    }

    /**
     * Gets the name of the XML element.
     *
     * @return XML element name
     */
    @Override
    public String getXmlElementName() {
        return XmlElementNames.FindPeople;
    }


    /**
     * Writes XML elements.
     *
     * @param writer the writer
     */
    @Override
    protected void writeElementsToXml(EwsServiceXmlWriter writer) throws Exception {

        if (searchFilter != null) {
            writer.writeStartElement(XmlNamespace.Messages,
                    XmlElementNames.Restriction);
            searchFilter.writeToXml(writer);
            writer.writeEndElement(); // Restriction
        }

        view.writeToXml(writer, null);
        view.writeOrderByToXml(writer);

        if (this.folderId != null) {
            writer.writeStartElement(XmlNamespace.Messages, XmlElementNames.ParentFolderId);
            this.folderId.writeToXml(writer);
            writer.writeEndElement();
        }

        if (!(this.queryString == null || this.queryString.isEmpty())) {
            writer.writeStartElement(XmlNamespace.Messages, XmlElementNames.QueryString);
            writer.writeValue(queryString, XmlElementNames.QueryString);
            writer.writeEndElement();
        }

        if (getService().getRequestedServerVersion().ordinal() >= this.getMinimumRequiredServerVersion().ordinal()){
            if (view.getPropertySet() != null) {
                view.getPropertySet().writeToXml(writer, ServiceObjectType.Persona);
            }
        }
    }

    /**
     * Gets the name of the response XML element.
     *
     * @return XML element name
     */
    @Override
    protected String getResponseXmlElementName() {
        return XmlElementNames.FindPeopleResponse;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected FindPeopleResponse parseResponse(EwsServiceXmlReader reader)
            throws Exception {
        FindPeopleResponse response = new FindPeopleResponse();
        response.loadFromXml(reader, XmlElementNames.FindPeopleResponse);
        return response;
    }

    /**
     * Gets the request version.
     *
     * @return Earliest Exchange version in which this request is supported.
     */
    @Override
    protected ExchangeVersion getMinimumRequiredServerVersion() {
        return ExchangeVersion.Exchange2013;
    }

    /**
     * Executes this request.
     *
     * @return Service response
     * @throws Exception the exception
     */
    public FindPeopleResponse execute() throws Exception {
        FindPeopleResponse serviceResponse = internalExecute();
        serviceResponse.throwIfNecessary();
        return serviceResponse;
    }
}
