package microsoft.exchange.webservices.data.misc.people;

import javax.xml.stream.XMLStreamException;

import microsoft.exchange.webservices.data.core.EwsServiceXmlWriter;
import microsoft.exchange.webservices.data.core.XmlElementNames;
import microsoft.exchange.webservices.data.core.enumeration.misc.XmlNamespace;
import microsoft.exchange.webservices.data.core.enumeration.service.ServiceObjectType;
import microsoft.exchange.webservices.data.core.exception.service.local.ServiceValidationException;
import microsoft.exchange.webservices.data.core.exception.service.local.ServiceVersionException;
import microsoft.exchange.webservices.data.core.exception.service.local.ServiceXmlSerializationException;
import microsoft.exchange.webservices.data.core.request.ServiceRequestBase;
import microsoft.exchange.webservices.data.search.Grouping;
import microsoft.exchange.webservices.data.search.PagedView;

public class IndexedPageItemView extends PagedView {
    /**
     * Gets the type of service object this view applies to.
     *
     * @return A ServiceObjectType value.
     */
    @Override
    protected ServiceObjectType getServiceObjectType() {
        return ServiceObjectType.Persona;
    }

    /**
     * Writes the attribute to XML.
     *
     * @param writer The writer.
     */
    @Override public void writeAttributesToXml(EwsServiceXmlWriter writer) {
        // Do nothing
    }

    /**
     * Gets the name of the view XML element.
     *
     * @return XML element name.
     */
    @Override
    protected String getViewXmlElementName() {
        return XmlElementNames.IndexedPageItemView;
    }

    /**
     * Validates this view.
     *
     * @param request The request using this view.
     */
    @Override public void internalValidate(ServiceRequestBase request)
            throws ServiceVersionException, ServiceValidationException {
        super.internalValidate(request);
    }

    /**
     * Internals the write search settings to XML.
     *
     * @param writer  The writer.
     * @param groupBy The group by.
     */
    @Override
    protected void internalWriteSearchSettingsToXml(EwsServiceXmlWriter writer,
                                                    Grouping groupBy) throws ServiceXmlSerializationException,
            XMLStreamException {
        super.internalWriteSearchSettingsToXml(writer, groupBy);
    }

    /**
     * Writes to XML.
     *
     * @param writer The writer
     */
    public void writeToXml(EwsServiceXmlWriter writer) throws Exception {
        writer.writeStartElement(XmlNamespace.Messages,
                this.getViewXmlElementName());

        this.internalWriteViewToXml(writer);

        writer.writeEndElement(); // this.GetViewXmlElementName()
    }

    /**
     * Initializes a new instance of the <see cref="ItemView"/> class.
     *
     * @param pageSize The maximum number of elements the search operation should return.
     */
    public IndexedPageItemView(int pageSize) {
        super(pageSize);
    }

    /**
     * Initializes a new instance of the ItemView class.
     *
     * @param pageSize The maximum number of elements the search operation should return.
     * @param offset   The offset of the view from the base point.
     */
    public IndexedPageItemView(int pageSize, int offset) {
        super(pageSize, offset);
        this.setOffset(offset);
    }
}
