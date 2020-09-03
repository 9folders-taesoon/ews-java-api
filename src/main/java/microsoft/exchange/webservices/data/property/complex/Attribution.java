package microsoft.exchange.webservices.data.property.complex;

import microsoft.exchange.webservices.data.core.EwsServiceXmlReader;
import microsoft.exchange.webservices.data.core.EwsUtilities;
import microsoft.exchange.webservices.data.core.XmlElementNames;

public class Attribution extends ComplexProperty {
    private String id;
    private ItemId sourceId;
    private String displayName;
    private boolean isWriteable;
    private boolean isQuickContact;
    private boolean isHidden;
    private FolderId folderId;

    public Attribution() {

    }

    public Attribution(String id, ItemId sourceId, String displayName) throws Exception {
        this(id, sourceId, displayName, false, false, false, null);
    }

    public Attribution(String id, ItemId sourceId, String displayName, boolean isWriteable, boolean isQuickContact, boolean isHidden, FolderId folderId) throws Exception {
        EwsUtilities.validateParam(id, "id");
        EwsUtilities.validateParam(displayName, "displayName");

        this.id = id;
        this.sourceId = sourceId;
        this.displayName = displayName;
        this.isWriteable = isWriteable;
        this.isQuickContact = isQuickContact;
        this.isHidden = isHidden;
        this.folderId = folderId;
    }

    @Override
    public boolean tryReadElementFromXml(EwsServiceXmlReader reader) throws Exception {
        String localName = reader.getLocalName();
        if (localName.equalsIgnoreCase(XmlElementNames.Id)) {
            this.id = reader.readElementValue();
            return true;
        } else if (localName.equalsIgnoreCase(XmlElementNames.SourceId)) {
            this.sourceId = new ItemId();
            this.sourceId.loadFromXml(reader, localName);
            return true;
        } else if (localName.equalsIgnoreCase(XmlElementNames.DisplayName)) {
            this.displayName = reader.readElementValue();
            return true;
        } else if (localName.equalsIgnoreCase(XmlElementNames.IsWritable)) {
            this.isWriteable = reader.readElementValue(Boolean.class);
            return true;
        } else if (localName.equalsIgnoreCase(XmlElementNames.IsQuickContact)) {
            this.isQuickContact = reader.readElementValue(Boolean.class);
            return true;
        } else if (localName.equalsIgnoreCase(XmlElementNames.IsHidden)) {
            this.isHidden = reader.readElementValue(Boolean.class);
            return true;
        } else if (localName.equalsIgnoreCase(XmlElementNames.LastResponseTime)) {
            this.folderId = new FolderId();
            this.folderId.loadFromXml(reader, localName);
            return true;
        } else {
            return super.tryReadElementFromXml(reader);
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ItemId getSourceId() {
        return sourceId;
    }

    public void setSourceId(ItemId sourceId) {
        this.sourceId = sourceId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public boolean isWriteable() {
        return isWriteable;
    }

    public void setWriteable(boolean writeable) {
        isWriteable = writeable;
    }

    public boolean isQuickContact() {
        return isQuickContact;
    }

    public void setQuickContact(boolean quickContact) {
        isQuickContact = quickContact;
    }

    public boolean isHidden() {
        return isHidden;
    }

    public void setHidden(boolean hidden) {
        isHidden = hidden;
    }

    public FolderId getFolderId() {
        return folderId;
    }

    public void setFolderId(FolderId folderId) {
        this.folderId = folderId;
    }
}
