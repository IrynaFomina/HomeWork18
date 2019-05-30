import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import xmlPraser.EventsParser;
import xmlPraser.XMLLoader;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Demo {

    Demo() throws IOException, SAXException, ParserConfigurationException {
        Document document = XMLLoader.load("Events.xml");
        System.out.println(new EventsParser().parse(document));
    }
}
