package microsoft.exchange.webservices.data.core.request;

import microsoft.exchange.webservices.data.core.EwsServiceXmlReader;
import microsoft.exchange.webservices.data.core.EwsServiceXmlWriter;
import microsoft.exchange.webservices.data.core.ExchangeService;
import microsoft.exchange.webservices.data.core.XmlElementNames;
import microsoft.exchange.webservices.data.core.enumeration.misc.ExchangeVersion;
import microsoft.exchange.webservices.data.core.enumeration.misc.XmlNamespace;
import microsoft.exchange.webservices.data.core.response.FindPeopleResponse;
import microsoft.exchange.webservices.data.misc.FolderIdWrapper;
import microsoft.exchange.webservices.data.misc.people.IndexedPageItemView;

public class FindPeopleRequest extends SimpleServiceRequestBase<FindPeopleResponse> {

    private FolderIdWrapper folderId;

    private IndexedPageItemView view;
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
    protected FolderIdWrapper getFolderId() {
        return this.folderId;
    }

    public void setFolderId(FolderIdWrapper value) {
        this.folderId = value;
    }


    protected IndexedPageItemView getIndexedItemView() {
        return this.view;
    }

    public void setIndexedItemView(IndexedPageItemView value) {
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
        // Don't have parameter in request

        this.getIndexedItemView().writeToXml(writer);
        this.getIndexedItemView().writeOrderByToXml(writer);

        writer.writeStartElement(XmlNamespace.Messages,
                XmlElementNames.ParentFolderId);
        this.getFolderId().writeToXml(writer);
        writer.writeEndElement();

        writer.writeElementValue(XmlNamespace.Messages,
                XmlElementNames.QueryString, "SMTP:");
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
