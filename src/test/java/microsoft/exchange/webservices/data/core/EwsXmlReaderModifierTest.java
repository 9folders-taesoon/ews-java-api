package microsoft.exchange.webservices.data.core;

import microsoft.exchange.webservices.data.security.XmlNodeType;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayInputStream;

import javax.xml.stream.XMLStreamException;

public class EwsXmlReaderModifierTest {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testReadValidDocumentXml10() throws Exception {
        final String validDocument = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><test>testContent</test>";
        byte[] bytes = validDocument.getBytes("UTF-8");
        EwsXmlReader impl = new EwsXmlReader(new ByteArrayInputStream(bytes));
        impl.read(new XmlNodeType(XmlNodeType.START_DOCUMENT));
        impl.read(new XmlNodeType(XmlNodeType.START_ELEMENT));
        String content = impl.readValue();
        Assert.assertEquals(content, "testContent");
        impl.read(new XmlNodeType(XmlNodeType.END_DOCUMENT));
    }

    @Test
    public void testReadInvalidDocumentXml10With0xA1() throws Exception {
        final String invalidDocument = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><test>test\u001AContent</test>";
        byte[] bytes = invalidDocument.getBytes("UTF-8");
        EwsXmlReader impl = new EwsXmlReader(new ByteArrayInputStream(bytes));
        impl.read(new XmlNodeType(XmlNodeType.START_DOCUMENT));
        impl.read(new XmlNodeType(XmlNodeType.START_ELEMENT));
        String content = impl.readValue();
        Assert.assertEquals(content, "testContent");
        impl.read(new XmlNodeType(XmlNodeType.END_DOCUMENT));
    }

    @Test
    public void testReadInvalidDocumentXml10WithNullCharacter() throws Exception {
        final String
                invalidDocument =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?><test>test\u0000Content\0</test>";
        byte[] bytes = invalidDocument.getBytes("UTF-8");
        EwsXmlReader impl = new EwsXmlReader(new ByteArrayInputStream(bytes));
        impl.read(new XmlNodeType(XmlNodeType.START_DOCUMENT));
        impl.read(new XmlNodeType(XmlNodeType.START_ELEMENT));
        String content = impl.readValue();
        Assert.assertEquals(content, "testContent");
        impl.read(new XmlNodeType(XmlNodeType.END_DOCUMENT));
    }

    @Test
    public void testReadValidDocumentXml11() throws Exception {
        final String validDocument = "<?xml version=\"1.1\" encoding=\"UTF-8\"?><test>testContent</test>";
        byte[] bytes = validDocument.getBytes("UTF-8");
        EwsXmlReader impl = new EwsXmlReader(new ByteArrayInputStream(bytes));
        impl.read(new XmlNodeType(XmlNodeType.START_DOCUMENT));
        impl.read(new XmlNodeType(XmlNodeType.START_ELEMENT));
        String content = impl.readValue();
        Assert.assertEquals(content, "testContent");
        impl.read(new XmlNodeType(XmlNodeType.END_DOCUMENT));
    }

    @Test
    public void testReadInvalidDocumentXml11With0xA1() throws Exception {
        final String invalidDocument = "<?xml version=\"1.1\" encoding=\"UTF-8\"?><test>test\u001AContent</test>";
        byte[] bytes = invalidDocument.getBytes("UTF-8");
        EwsXmlReader impl = new EwsXmlReader(new ByteArrayInputStream(bytes));
        impl.read(new XmlNodeType(XmlNodeType.START_DOCUMENT));
        impl.read(new XmlNodeType(XmlNodeType.START_ELEMENT));
        String content = impl.readValue();
        Assert.assertEquals(content, "testContent");
        impl.read(new XmlNodeType(XmlNodeType.END_DOCUMENT));
    }

    @Test
    public void testReadInvalidDocumentXml11WithNullCharacter() throws Exception {
        final String invalidDoc = "<?xml version=\"1.1\" encoding=\"UTF-8\"?><test>test\u0000Content\0</test>";
        byte[] bytes = invalidDoc.getBytes("UTF-8");
        EwsXmlReader impl = new EwsXmlReader(new ByteArrayInputStream(bytes));
        impl.read(new XmlNodeType(XmlNodeType.START_DOCUMENT));
        impl.read(new XmlNodeType(XmlNodeType.START_ELEMENT));
        String content = impl.readValue();
        Assert.assertEquals(content, "testContent");
        impl.read(new XmlNodeType(XmlNodeType.END_DOCUMENT));
    }

    @Test
    public void testReadInvalidDocumentWithNullCharacter() throws Exception {
        final String invalidDoc = "<test>test\u0000Content\0</test>";
        byte[] bytes = invalidDoc.getBytes();
        EwsXmlReader impl = new EwsXmlReader(new ByteArrayInputStream(bytes));
        impl.read(new XmlNodeType(XmlNodeType.START_DOCUMENT));
        impl.read(new XmlNodeType(XmlNodeType.START_ELEMENT));
        String content = impl.readValue();
        Assert.assertEquals(content, "testContent");
        impl.read(new XmlNodeType(XmlNodeType.END_DOCUMENT));
    }


    final String validDocument = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<test>testContent</test>";

    final String invalidDocument = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<test>test&#x5;Content</test>";

    @Test
    public void testReadValidDocument() throws Exception {
        byte[] bytes = validDocument.getBytes("UTF-8");
        EwsXmlReader impl = new EwsXmlReader(new ByteArrayInputStream(bytes), false);
        impl.read(new XmlNodeType(XmlNodeType.START_DOCUMENT));
        impl.read(new XmlNodeType(XmlNodeType.START_ELEMENT));
        String content = impl.readValue();
        Assert.assertEquals(content, "testContent");
        impl.read(new XmlNodeType(XmlNodeType.END_DOCUMENT));
    }

    @Test
    public void testReadInValidDocumentAsXml10() throws Exception {
        byte[] bytes = invalidDocument.getBytes("UTF-8");
        EwsXmlReader impl = new EwsXmlReader(new ByteArrayInputStream(bytes), false);
        impl.read(new XmlNodeType(XmlNodeType.START_DOCUMENT));
        impl.read(new XmlNodeType(XmlNodeType.START_ELEMENT));
        exception.expect(XMLStreamException.class);
        String content = impl.readValue();
        Assert.assertEquals(content, "test\u0005Content");
    }

    @Test
    public void testReadInvalidDocumentAsXml11() throws Exception {
        byte[] bytes = invalidDocument.getBytes("UTF-8");
        EwsXmlReader impl = new EwsXmlReader(new ByteArrayInputStream(bytes), true);
        impl.read(new XmlNodeType(XmlNodeType.START_DOCUMENT));
        impl.read(new XmlNodeType(XmlNodeType.START_ELEMENT));
        String content = impl.readValue();
        Assert.assertEquals(content, "test\u0005Content");
        impl.read(new XmlNodeType(XmlNodeType.END_DOCUMENT));
    }
}

