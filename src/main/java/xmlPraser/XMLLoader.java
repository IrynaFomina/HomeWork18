package xmlPraser;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

public abstract class XMLLoader {

    public static Document load(String fileName) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        InputStream is = XMLLoader.class.getClassLoader().getResourceAsStream(fileName);
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(is);
    }

}
