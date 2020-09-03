package microsoft.exchange.webservices.data.core.service.item;

import org.joda.time.DateTime;

import microsoft.exchange.webservices.data.attribute.Attachable;
import microsoft.exchange.webservices.data.attribute.ServiceObjectDefinition;
import microsoft.exchange.webservices.data.core.ExchangeService;
import microsoft.exchange.webservices.data.core.PropertySet;
import microsoft.exchange.webservices.data.core.XmlElementNames;
import microsoft.exchange.webservices.data.core.enumeration.misc.ExchangeVersion;
import microsoft.exchange.webservices.data.core.exception.service.local.ServiceLocalException;
import microsoft.exchange.webservices.data.core.service.schema.PersonaSchema;
import microsoft.exchange.webservices.data.core.service.schema.ServiceObjectSchema;
import microsoft.exchange.webservices.data.property.complex.AttributedStringCollection;
import microsoft.exchange.webservices.data.property.complex.AttributionCollection;
import microsoft.exchange.webservices.data.property.complex.EmailAddress;
import microsoft.exchange.webservices.data.property.complex.EmailAddressCollection;
import microsoft.exchange.webservices.data.property.complex.ItemId;
import microsoft.exchange.webservices.data.property.definition.PropertyDefinition;

@Attachable
@ServiceObjectDefinition(xmlElementName = XmlElementNames.Persona)
public class Persona extends Item {
    public Persona(ExchangeService service) throws Exception {
        super(service);
    }

    public static Persona bind(ExchangeService service, ItemId id,
                                PropertySet propertySet) throws Exception {
        return service.bindToItem(Persona.class, id, propertySet);
    }

    @Override
    public ServiceObjectSchema getSchema() {
        return PersonaSchema.Instance;
    }

    @Override
    public ExchangeVersion getMinimumRequiredServerVersion() {
        return ExchangeVersion.Exchange2013_SP1;
    }

    @Override
    public PropertyDefinition getIdPropertyDefinition() {
        return PersonaSchema.PersonaId;
    }

    public ItemId getPersonaId() throws ServiceLocalException {
        return getPropertyBag().getObjectFromPropertyDefinition(
                PersonaSchema.PersonaId);
    }

    public String getPersonaType() throws ServiceLocalException {
        return getPropertyBag().getObjectFromPropertyDefinition(
                PersonaSchema.PersonaType);
    }
    public DateTime getCreationTime()throws ServiceLocalException {
        return getPropertyBag().getObjectFromPropertyDefinition(
                PersonaSchema.CreationTime);
    }

    public String getDisplayNameFirstLastHeader()throws ServiceLocalException {
        return getPropertyBag().getObjectFromPropertyDefinition(
                PersonaSchema.DisplayNameFirstLastHeader);
    }

    public String getDisplayNameLastFirstHeader() throws ServiceLocalException {
        return getPropertyBag().getObjectFromPropertyDefinition(
                PersonaSchema.DisplayNameLastFirstHeader);
    }

    public String getDisplayName() throws ServiceLocalException {
        return getPropertyBag().getObjectFromPropertyDefinition(
                PersonaSchema.DisplayName);
    }

    public String getDisplayNameFirstLast() throws ServiceLocalException {
        return getPropertyBag().getObjectFromPropertyDefinition(
                PersonaSchema.DisplayNameFirstLast);
    }

    public String getDisplayNameLastFirst() throws ServiceLocalException {
        return getPropertyBag().getObjectFromPropertyDefinition(
                PersonaSchema.DisplayNameLastFirst);
    }

    public String getFileAs() throws ServiceLocalException {
        return getPropertyBag().getObjectFromPropertyDefinition(
                PersonaSchema.FileAs);
    }

    public String getGeneration() throws ServiceLocalException {
        return getPropertyBag().getObjectFromPropertyDefinition(
                PersonaSchema.Generation);
    }

    public String getDisplayNamePrefix() throws ServiceLocalException {
        return getPropertyBag().getObjectFromPropertyDefinition(
                PersonaSchema.DisplayNamePrefix);
    }

    public String getGivenName() throws ServiceLocalException {
        return getPropertyBag().getObjectFromPropertyDefinition(
                PersonaSchema.GivenName);
    }

    public String getSurname() throws ServiceLocalException {
        return getPropertyBag().getObjectFromPropertyDefinition(
                PersonaSchema.Surname);
    }

    public String getTitle() throws ServiceLocalException {
        return getPropertyBag().getObjectFromPropertyDefinition(
                PersonaSchema.Title);
    }

    public String getCompanyName() throws ServiceLocalException {
        return getPropertyBag().getObjectFromPropertyDefinition(
                PersonaSchema.CompanyName);
    }

    public EmailAddress getEmailAddress() throws ServiceLocalException {
        return getPropertyBag().getObjectFromPropertyDefinition(
                PersonaSchema.EmailAddress);
    }


    public EmailAddressCollection getEmailAddresses() throws ServiceLocalException {
        return getPropertyBag().getObjectFromPropertyDefinition(
                PersonaSchema.EmailAddresses);
    }

    public String getImAddress() throws ServiceLocalException {
        return getPropertyBag().getObjectFromPropertyDefinition(
                PersonaSchema.ImAddress);
    }


    public String getHomeCity() throws ServiceLocalException {
        return getPropertyBag().getObjectFromPropertyDefinition(
                PersonaSchema.HomeCity);
    }

    public String getWorkCity() throws ServiceLocalException {
        return getPropertyBag().getObjectFromPropertyDefinition(
                PersonaSchema.WorkCity);
    }


    public String getAlias() throws ServiceLocalException {
        return getPropertyBag().getObjectFromPropertyDefinition(
                PersonaSchema.Alias);
    }


    public int getRelevanceScore() throws ServiceLocalException {
        return getPropertyBag().getObjectFromPropertyDefinition(
                PersonaSchema.RelevanceScore);
    }

    public AttributionCollection getAttributions() throws ServiceLocalException {
        return getPropertyBag().getObjectFromPropertyDefinition(
                PersonaSchema.Attributions);
    }

    public AttributedStringCollection getOfficeLocations() throws ServiceLocalException {
        return getPropertyBag().getObjectFromPropertyDefinition(
                PersonaSchema.OfficeLocations);
    }

    public AttributedStringCollection getImAddresses() throws ServiceLocalException {
        return getPropertyBag().getObjectFromPropertyDefinition(
                PersonaSchema.ImAddress);
    }

    public AttributedStringCollection getDepartments() throws ServiceLocalException {
        return getPropertyBag().getObjectFromPropertyDefinition(
                PersonaSchema.Departments);
    }

    public AttributedStringCollection getThirdPartyPhotoUrls() throws ServiceLocalException {
        return getPropertyBag().getObjectFromPropertyDefinition(
                PersonaSchema.ThirdPartyPhotoUrls);
    }

}
