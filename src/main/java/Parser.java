import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    static List<Event> eventList = new ArrayList<>();

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        InputStream is = Parser.class.getClassLoader().getResourceAsStream("Events.xml");
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(is);

        Element rootElement = document.getDocumentElement();
        NodeList nodeList = rootElement.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i).getNodeName() == "event") {
                eventList.add(createEvent(nodeList.item(i)));
            }
            System.out.println(nodeList.item(i).getNodeName());
        }

        System.out.println(eventList);
    }

    private static Event createEvent(Node eventNode) {
        NodeList nodeList = eventNode.getChildNodes();
        Event event = new Event();
        for (int i = 0; i < nodeList.getLength(); i++) {
            switch (nodeList.item(i).getNodeName()){
                case "event_id" :
                    event.setSource(nodeList.item(i).getNodeValue());
                    break;
                case "event_date" :
                    event.setEvent_date(nodeList.item(i).getNodeValue());
                    break;
                case "event_parameters":
                    NodeList params = nodeList.item(i).getChildNodes();
                    for (int j = 0; j < params.getLength(); j++) {
                        switch (nodeList.item(i).getNodeName()){
                            case "priority" :
                                event.setPriority(Integer.parseInt(params.item(i).getNodeValue()));
                                break;
                            case "log_level":
                                event.setLog_level(params.item(i).getNodeValue());
                                break;
                            case "source":
                                event.setSource(params.item(i).getNodeValue());
                                break;
                        }
                    }
                    break;
            }

        }
        return event;
    }
}
