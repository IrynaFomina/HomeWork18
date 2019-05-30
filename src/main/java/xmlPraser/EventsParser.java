package xmlPraser;

import event.Event;
import event.EventParameters;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class EventsParser implements IDOMXMLParser{
//    private Document document;
private List<Event> eventList;

    public EventsParser() {
    }

    @Override
    public List<Event> parse(Document document) {
        NodeList nodeList = document.getDocumentElement().getElementsByTagName("event");
        eventList = new ArrayList<>();

        for (int i = 0; i < nodeList.getLength(); i++) {
            eventList.add(createEvent(nodeList.item(i)));
        }
        return eventList;
    }

    private Event createEvent(Node eventNode) {
//        eventList = event.EventParameters().
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

    private  EventParameters createEventParameters (Node parameters){
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
