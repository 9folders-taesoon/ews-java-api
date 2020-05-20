package microsoft.exchange.webservices.data.property.complex;

import microsoft.exchange.webservices.data.core.EwsServiceXmlReader;
import microsoft.exchange.webservices.data.core.XmlElementNames;

public class Persona extends ComplexProperty {
    private String personaId;
    private String personaType;
    private String displayName;
    private String creationTime;
    private String displayFirstName;
    private String displayLastName;
    private String fileAs;
    private long relevanceScore;
    private EmailAddress emailAddress;

    /**
     * Initializes a new instance of the Persona class.
     */
    public Persona() {
        super();
    }

    public String getPersonaId() {
        return personaId;
    }

    public String getPersonaType() {
        return personaType;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public String getDisplayFirstName() {
        return displayFirstName;
    }

    public String getDisplayLastName() {
        return displayLastName;
    }

    public String getFileAs() {
        return fileAs;
    }

    public long getRelevanceScore() {
        return relevanceScore;
    }

    public EmailAddress getEmailAddressList() {
        return emailAddress;
    }

    /**
     * Gets or sets the name of this rule as it should be displayed to the user.
     */
    public String getDisplayName() {
        return this.displayName;
    }

    /**
     * Tries to read element from XML.
     *
     * @param reader The reader.
     * @return True if element was read.
     * @throws Exception
     */
    @Override
    public boolean tryReadElementFromXml(EwsServiceXmlReader
                                                 reader) throws Exception {

        if (reader.getLocalName().equals(XmlElementNames.PersonaId)) {
            this.personaId = reader.readElementValue();
            return true;
        } else if (reader.getLocalName().equals(XmlElementNames.PersonaType)) {
            this.personaType = reader.readElementValue();
            return true;
        } else if (reader.getLocalName().equals(XmlElementNames.CreationTime)) {
            this.creationTime = reader.readElementValue();
            return true;
        } else if (reader.getLocalName().equals(XmlElementNames.DisplayName)) {
            this.displayName = reader.readElementValue();
            return true;
        } else if (reader.getLocalName().equals(XmlElementNames.DisplayNameFirstLast)) {
            this.displayFirstName = reader.readElementValue();
            return true;
        } else if (reader.getLocalName().equals(XmlElementNames.DisplayNameLastFirst)) {
            this.displayLastName = reader.readElementValue();
            return true;
        } else if (reader.getLocalName().equals(XmlElementNames.FileAs)) {
            this.fileAs = reader.readElementValue();
            return true;
        } else if (reader.getLocalName().equals(XmlElementNames.EmailAddress)) {
            emailAddress = new EmailAddress();
            emailAddress.loadFromXml(reader, XmlElementNames.EmailAddress);
            return true;
        } else if (reader.getLocalName().equals(XmlElementNames.RelevanceScore)) {
            this.relevanceScore = reader.readElementValue(Long.class);
            return true;
        } else {
            return false;
        }
    }
}
