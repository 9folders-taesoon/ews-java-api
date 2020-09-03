package microsoft.exchange.webservices.data.core.service.schema;

import java.util.EnumSet;

import microsoft.exchange.webservices.data.attribute.Schema;
import microsoft.exchange.webservices.data.core.XmlElementNames;
import microsoft.exchange.webservices.data.core.enumeration.misc.ExchangeVersion;
import microsoft.exchange.webservices.data.core.enumeration.property.PropertyDefinitionFlags;
import microsoft.exchange.webservices.data.property.complex.AttributedPhoneNumberCollection;
import microsoft.exchange.webservices.data.property.complex.AttributedStringCollection;
import microsoft.exchange.webservices.data.property.complex.AttributionCollection;
import microsoft.exchange.webservices.data.property.complex.EmailAddress;
import microsoft.exchange.webservices.data.property.complex.EmailAddressCollection;
import microsoft.exchange.webservices.data.property.complex.ICreateComplexPropertyDelegate;
import microsoft.exchange.webservices.data.property.complex.ItemId;
import microsoft.exchange.webservices.data.property.definition.ComplexPropertyDefinition;
import microsoft.exchange.webservices.data.property.definition.DateTimePropertyDefinition;
import microsoft.exchange.webservices.data.property.definition.IntPropertyDefinition;
import microsoft.exchange.webservices.data.property.definition.PropertyDefinition;
import microsoft.exchange.webservices.data.property.definition.StringPropertyDefinition;

@Schema
public class PersonaSchema extends ItemSchema {

    private interface FieldUris {
        String PersonaId = "persona:PersonaId";
        String PersonaType = "persona:PersonaType";
        String CreationTime = "persona:CreationTime";
        String DisplayNameFirstLastHeader = "persona:DisplayNameFirstLastHeader";
        String DisplayNameLastFirstHeader = "persona:DisplayNameLastFirstHeader";
        String DisplayName = "persona:DisplayName";
        String DisplayNameFirstLast = "persona:DisplayNameFirstLast";
        String DisplayNameLastFirst = "persona:DisplayNameLastFirst";
        String FileAs = "persona:FileAs";
        String Generation = "persona:Generation";
        String DisplayNamePrefix = "persona:DisplayNamePrefix";
        String GivenName = "persona:GivenName";
        String Surname = "persona:Surname";
        String Title = "persona:Title";
        String CompanyName = "persona:CompanyName";
        String EmailAddress = "persona:EmailAddress";
        String EmailAddresses = "persona:EmailAddresses";
        String ImAddress = "persona:ImAddress";
        String HomeCity = "persona:HomeCity";
        String WorkCity = "persona:WorkCity";
        String Alias = "persona:Alias";
        String RelevanceScore = "persona:RelevanceScore";
        String Attributions = "persona:Attributions";
        String OfficeLocations = "persona:OfficeLocations";
        String ImAddresses = "persona:ImAddresses";
        String Departments = "persona:Departments";
        String MobilePhones = "persona:MobilePhones";
        String ThirdPartyPhotoUrls = "persona:ThirdPartyPhotoUrls";
    }

    public static final PropertyDefinition PersonaId =
            new ComplexPropertyDefinition<ItemId>(
                    ItemId.class,
                    XmlElementNames.PersonaId, FieldUris.PersonaId,
                    EnumSet.of(PropertyDefinitionFlags.AutoInstantiateOnRead ,PropertyDefinitionFlags.CanSet ,PropertyDefinitionFlags.CanUpdate,PropertyDefinitionFlags.CanDelete,PropertyDefinitionFlags.CanFind),
                    ExchangeVersion.Exchange2013_SP1, new ICreateComplexPropertyDelegate<ItemId>() {
                public ItemId createComplexProperty() {
                    return new ItemId();
                }
            });


    public static final PropertyDefinition PersonaType =
            new StringPropertyDefinition(
                    XmlElementNames.PersonaType, FieldUris.PersonaType,
                    EnumSet.of(PropertyDefinitionFlags.CanSet ,PropertyDefinitionFlags.CanUpdate,PropertyDefinitionFlags.CanDelete,PropertyDefinitionFlags.CanFind),
                    ExchangeVersion.Exchange2013_SP1);

    public static final PropertyDefinition CreationTime =
            new DateTimePropertyDefinition(
                    XmlElementNames.CreationTime, FieldUris.CreationTime,
                    EnumSet.of(PropertyDefinitionFlags.CanSet ,PropertyDefinitionFlags.CanUpdate,PropertyDefinitionFlags.CanDelete,PropertyDefinitionFlags.CanFind),
                    ExchangeVersion.Exchange2013_SP1);


    public static final PropertyDefinition DisplayNameFirstLastHeader =
            new StringPropertyDefinition(
                    XmlElementNames.DisplayNameFirstLastHeader, FieldUris.DisplayNameFirstLastHeader,
                    EnumSet.of(PropertyDefinitionFlags.CanSet ,PropertyDefinitionFlags.CanUpdate,PropertyDefinitionFlags.CanDelete,PropertyDefinitionFlags.CanFind),
                    ExchangeVersion.Exchange2013_SP1);

    public static final PropertyDefinition DisplayNameLastFirstHeader =
            new StringPropertyDefinition(
                    XmlElementNames.DisplayNameLastFirstHeader, FieldUris.DisplayNameLastFirstHeader,
                    EnumSet.of(PropertyDefinitionFlags.CanSet ,PropertyDefinitionFlags.CanUpdate,PropertyDefinitionFlags.CanDelete,PropertyDefinitionFlags.CanFind),
                    ExchangeVersion.Exchange2013_SP1);

    public static final PropertyDefinition DisplayName =
            new StringPropertyDefinition(
                    XmlElementNames.DisplayName, FieldUris.DisplayName,
                    EnumSet.of(PropertyDefinitionFlags.CanSet ,PropertyDefinitionFlags.CanUpdate,PropertyDefinitionFlags.CanDelete,PropertyDefinitionFlags.CanFind),
                    ExchangeVersion.Exchange2013_SP1);

    public static final PropertyDefinition DisplayNameFirstLast =
            new StringPropertyDefinition(
                    XmlElementNames.DisplayNameFirstLast, FieldUris.DisplayNameFirstLast,
                    EnumSet.of(PropertyDefinitionFlags.CanSet ,PropertyDefinitionFlags.CanUpdate,PropertyDefinitionFlags.CanDelete,PropertyDefinitionFlags.CanFind),
                    ExchangeVersion.Exchange2013_SP1);

    public static final PropertyDefinition DisplayNameLastFirst =
            new StringPropertyDefinition(
                    XmlElementNames.DisplayNameLastFirst, FieldUris.DisplayNameLastFirst,
                    EnumSet.of(PropertyDefinitionFlags.CanSet ,PropertyDefinitionFlags.CanUpdate,PropertyDefinitionFlags.CanDelete,PropertyDefinitionFlags.CanFind),
                    ExchangeVersion.Exchange2013_SP1);

    public static final PropertyDefinition FileAs =
            new StringPropertyDefinition(
                    XmlElementNames.FileAs, FieldUris.FileAs,
                    EnumSet.of(PropertyDefinitionFlags.CanSet ,PropertyDefinitionFlags.CanUpdate,PropertyDefinitionFlags.CanDelete,PropertyDefinitionFlags.CanFind),
                    ExchangeVersion.Exchange2013_SP1);

    public static final PropertyDefinition Generation =
            new StringPropertyDefinition(
                    XmlElementNames.Generation, FieldUris.Generation,
                    EnumSet.of(PropertyDefinitionFlags.CanSet ,PropertyDefinitionFlags.CanUpdate,PropertyDefinitionFlags.CanDelete,PropertyDefinitionFlags.CanFind),
                    ExchangeVersion.Exchange2013_SP1);

    public static final PropertyDefinition DisplayNamePrefix =
            new StringPropertyDefinition(
                    XmlElementNames.DisplayNamePrefix, FieldUris.DisplayNamePrefix,
                    EnumSet.of(PropertyDefinitionFlags.CanSet ,PropertyDefinitionFlags.CanUpdate,PropertyDefinitionFlags.CanDelete,PropertyDefinitionFlags.CanFind),
                    ExchangeVersion.Exchange2013_SP1);

    public static final PropertyDefinition GivenName =
            new StringPropertyDefinition(
                    XmlElementNames.GivenName, FieldUris.GivenName,
                    EnumSet.of(PropertyDefinitionFlags.CanSet ,PropertyDefinitionFlags.CanUpdate,PropertyDefinitionFlags.CanDelete,PropertyDefinitionFlags.CanFind),
                    ExchangeVersion.Exchange2013_SP1);

    public static final PropertyDefinition Surname =
            new StringPropertyDefinition(
                    XmlElementNames.Surname, FieldUris.Surname,
                    EnumSet.of(PropertyDefinitionFlags.CanSet ,PropertyDefinitionFlags.CanUpdate,PropertyDefinitionFlags.CanDelete,PropertyDefinitionFlags.CanFind),
                    ExchangeVersion.Exchange2013_SP1);


    public static final PropertyDefinition Title =
            new StringPropertyDefinition(
                    XmlElementNames.Title, FieldUris.Title,
                    EnumSet.of(PropertyDefinitionFlags.CanSet ,PropertyDefinitionFlags.CanUpdate,PropertyDefinitionFlags.CanDelete,PropertyDefinitionFlags.CanFind),
                    ExchangeVersion.Exchange2013_SP1);

    public static final PropertyDefinition CompanyName =
            new StringPropertyDefinition(
                    XmlElementNames.CompanyName, FieldUris.CompanyName,
                    EnumSet.of(PropertyDefinitionFlags.CanSet ,PropertyDefinitionFlags.CanUpdate,PropertyDefinitionFlags.CanDelete,PropertyDefinitionFlags.CanFind),
                    ExchangeVersion.Exchange2013_SP1);

    public static final PropertyDefinition EmailAddress =
            new ComplexPropertyDefinition<EmailAddress>(
                    EmailAddress.class,
                    XmlElementNames.EmailAddress, FieldUris.EmailAddress,
                    EnumSet.of(PropertyDefinitionFlags.AutoInstantiateOnRead, PropertyDefinitionFlags.CanSet ,PropertyDefinitionFlags.CanUpdate,PropertyDefinitionFlags.CanDelete,PropertyDefinitionFlags.CanFind),
                    ExchangeVersion.Exchange2013_SP1, new ICreateComplexPropertyDelegate<EmailAddress>() {

                @Override
                public EmailAddress createComplexProperty() {
                    return new EmailAddress();
                }
            });

    public static final PropertyDefinition EmailAddresses =
            new ComplexPropertyDefinition<EmailAddressCollection>(
                    EmailAddressCollection.class,
                    XmlElementNames.EmailAddresses, FieldUris.EmailAddresses,
                    EnumSet.of(PropertyDefinitionFlags.AutoInstantiateOnRead, PropertyDefinitionFlags.CanSet ,PropertyDefinitionFlags.CanUpdate,PropertyDefinitionFlags.CanDelete,PropertyDefinitionFlags.CanFind),
                    ExchangeVersion.Exchange2013_SP1, new ICreateComplexPropertyDelegate<EmailAddressCollection>() {

                @Override
                public EmailAddressCollection createComplexProperty() {
                    return new EmailAddressCollection();
                }
            });

    public static final PropertyDefinition ImAddress =
            new StringPropertyDefinition(
                    XmlElementNames.ImAddress, FieldUris.ImAddress,
                    EnumSet.of(PropertyDefinitionFlags.CanSet ,PropertyDefinitionFlags.CanUpdate,PropertyDefinitionFlags.CanDelete,PropertyDefinitionFlags.CanFind),
                    ExchangeVersion.Exchange2013_SP1);

    public static final PropertyDefinition HomeCity =
            new StringPropertyDefinition(
                    XmlElementNames.HomeCity, FieldUris.HomeCity,
                    EnumSet.of(PropertyDefinitionFlags.CanSet ,PropertyDefinitionFlags.CanUpdate,PropertyDefinitionFlags.CanDelete,PropertyDefinitionFlags.CanFind),
                    ExchangeVersion.Exchange2013_SP1);

    public static final PropertyDefinition WorkCity =
            new StringPropertyDefinition(
                    XmlElementNames.WorkCity, FieldUris.WorkCity,
                    EnumSet.of(PropertyDefinitionFlags.CanSet ,PropertyDefinitionFlags.CanUpdate,PropertyDefinitionFlags.CanDelete,PropertyDefinitionFlags.CanFind),
                    ExchangeVersion.Exchange2013_SP1);

    public static final PropertyDefinition Alias =
            new StringPropertyDefinition(
                    XmlElementNames.Alias, FieldUris.Alias,
                    EnumSet.of(PropertyDefinitionFlags.CanSet ,PropertyDefinitionFlags.CanUpdate,PropertyDefinitionFlags.CanDelete,PropertyDefinitionFlags.CanFind),
                    ExchangeVersion.Exchange2013_SP1);

    public static final PropertyDefinition RelevanceScore =
            new IntPropertyDefinition(
                    XmlElementNames.RelevanceScore, FieldUris.RelevanceScore,
                    EnumSet.of(PropertyDefinitionFlags.CanSet ,PropertyDefinitionFlags.CanUpdate,PropertyDefinitionFlags.CanDelete,PropertyDefinitionFlags.CanFind),
                    ExchangeVersion.Exchange2013_SP1, true);

    public static final PropertyDefinition Attributions =
            new ComplexPropertyDefinition<AttributionCollection>(
                    AttributionCollection.class,
                    XmlElementNames.Attributions, FieldUris.Attributions,
                    EnumSet.of(PropertyDefinitionFlags.AutoInstantiateOnRead, PropertyDefinitionFlags.CanSet ,PropertyDefinitionFlags.CanUpdate,PropertyDefinitionFlags.CanDelete,PropertyDefinitionFlags.CanFind),
                    ExchangeVersion.Exchange2013_SP1, new ICreateComplexPropertyDelegate<AttributionCollection>() {

                @Override
                public AttributionCollection createComplexProperty() {
                    return new AttributionCollection();
                }
            });

    public static final PropertyDefinition OfficeLocations =
            new ComplexPropertyDefinition<AttributedStringCollection>(
                    AttributedStringCollection.class,
                    XmlElementNames.OfficeLocations, FieldUris.OfficeLocations,
                    EnumSet.of(PropertyDefinitionFlags.AutoInstantiateOnRead, PropertyDefinitionFlags.CanSet ,PropertyDefinitionFlags.CanUpdate,PropertyDefinitionFlags.CanDelete,PropertyDefinitionFlags.CanFind),
                    ExchangeVersion.Exchange2013_SP1, new ICreateComplexPropertyDelegate<AttributedStringCollection>() {

                @Override
                public AttributedStringCollection createComplexProperty() {
                    return new AttributedStringCollection();
                }
            });


    public static final PropertyDefinition ImAddresses =
            new ComplexPropertyDefinition<AttributedStringCollection>(
                    AttributedStringCollection.class,
                    XmlElementNames.ImAddresses, FieldUris.ImAddresses,
                    EnumSet.of(PropertyDefinitionFlags.AutoInstantiateOnRead, PropertyDefinitionFlags.CanSet ,PropertyDefinitionFlags.CanUpdate,PropertyDefinitionFlags.CanDelete,PropertyDefinitionFlags.CanFind),
                    ExchangeVersion.Exchange2013_SP1, new ICreateComplexPropertyDelegate<AttributedStringCollection>() {

                @Override
                public AttributedStringCollection createComplexProperty() {
                    return new AttributedStringCollection();
                }
            });

    public static final PropertyDefinition MobilePhones =
            new ComplexPropertyDefinition<AttributedPhoneNumberCollection>(
                    AttributedPhoneNumberCollection.class,
                    XmlElementNames.MobilePhones, FieldUris.MobilePhones,
                    EnumSet.of(PropertyDefinitionFlags.AutoInstantiateOnRead, PropertyDefinitionFlags.CanSet ,PropertyDefinitionFlags.CanUpdate,PropertyDefinitionFlags.CanDelete,PropertyDefinitionFlags.CanFind),
                    ExchangeVersion.Exchange2013_SP1, new ICreateComplexPropertyDelegate<AttributedPhoneNumberCollection>() {

                @Override
                public AttributedPhoneNumberCollection createComplexProperty() {
                    return new AttributedPhoneNumberCollection();
                }
            });


    public static final PropertyDefinition Departments =
            new ComplexPropertyDefinition<AttributedStringCollection>(
                    AttributedStringCollection.class,
                    XmlElementNames.Departments, FieldUris.Departments,
                    EnumSet.of(PropertyDefinitionFlags.AutoInstantiateOnRead, PropertyDefinitionFlags.CanSet ,PropertyDefinitionFlags.CanUpdate,PropertyDefinitionFlags.CanDelete,PropertyDefinitionFlags.CanFind),
                    ExchangeVersion.Exchange2013_SP1, new ICreateComplexPropertyDelegate<AttributedStringCollection>() {

                @Override
                public AttributedStringCollection createComplexProperty() {
                    return new AttributedStringCollection();
                }
            });


    public static final PropertyDefinition ThirdPartyPhotoUrls =
            new ComplexPropertyDefinition<AttributedStringCollection>(
                    AttributedStringCollection.class,
                    XmlElementNames.ThirdPartyPhotoUrls, FieldUris.ThirdPartyPhotoUrls,
                    EnumSet.of(PropertyDefinitionFlags.AutoInstantiateOnRead, PropertyDefinitionFlags.CanSet ,PropertyDefinitionFlags.CanUpdate,PropertyDefinitionFlags.CanDelete,PropertyDefinitionFlags.CanFind),
                    ExchangeVersion.Exchange2013_SP1, new ICreateComplexPropertyDelegate<AttributedStringCollection>() {

                @Override
                public AttributedStringCollection createComplexProperty() {
                    return new AttributedStringCollection();
                }
            });

    public static PersonaSchema Instance = new PersonaSchema();

    @Override
    protected void registerProperties() {
        super.registerProperties();

        this.registerProperty(PersonaId);
        this.registerProperty(PersonaType);
        this.registerProperty(CreationTime);
        this.registerProperty(DisplayNameFirstLastHeader);
        this.registerProperty(DisplayNameLastFirstHeader);
        this.registerProperty(DisplayName);
        this.registerProperty(DisplayNameFirstLast);
        this.registerProperty(DisplayNameLastFirst);
        this.registerProperty(FileAs);
        this.registerProperty(Generation);
        this.registerProperty(DisplayNamePrefix);
        this.registerProperty(GivenName);
        this.registerProperty(Surname);
        this.registerProperty(Title);
        this.registerProperty(CompanyName);
        this.registerProperty(EmailAddress);
        this.registerProperty(EmailAddresses);
        this.registerProperty(ImAddress);
        this.registerProperty(HomeCity);
        this.registerProperty(WorkCity);
        this.registerProperty(Alias);
        this.registerProperty(RelevanceScore);
        this.registerProperty(Attributions);
        this.registerProperty(OfficeLocations);
        this.registerProperty(ImAddresses);
        this.registerProperty(Departments);
        this.registerProperty(ThirdPartyPhotoUrls);
    }
}
