import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    private static List<Event> eventList = new ArrayList<>();

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        InputStream is = Parser.class.getClassLoader().getResourceAsStream("Events.xml");
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(is);

        NodeList nodeList = document.getDocumentElement().getElementsByTagName("event");
        for (int i = 0; i < nodeList.getLength(); i++) {
                eventList.add(createEvent(nodeList.item(i)));
        }
        System.out.println(eventList);
    }

    private static Event createEvent(Node eventNode) {
        NodeList nodeList = eventNode.getChildNodes();
        Event event = new Event();

        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i) instanceof Element) {
                switch (nodeList.item(i).getNodeName()) {
                    case "event_id":
                        event.setEvent_id(nodeList.item(i).getTextContent());
                        break;
                    case "event_date":
                        event.setEvent_date(nodeList.item(i).getTextContent());
                        break;
                    case "event_parameters":
                        event.setEventParameters(createEventParameters(nodeList.item(i)));
                        break;
                }
            }

        }
        return event;
    }

    private static EventParameters createEventParameters (Node parameters){
        NodeList params = parameters.getChildNodes();
        EventParameters eventParameters = new EventParameters();
        for (int j = 0; j < params.getLength(); j++) {
            switch (params.item(j).getNodeName()) {
                case "priority":
                    eventParameters.setPriority(Integer.parseInt(params.item(j).getTextContent()));
                    break;
                case "log_level":
                    eventParameters.setLog_level(params.item(j).getTextContent());
                    break;
                case "source":
                    eventParameters.setSource(params.item(j).getTextContent());
                    break;
            }
        }
        return eventParameters;
    }
}
