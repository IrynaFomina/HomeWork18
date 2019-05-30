package event;

public class Event {
    private String event_id;
    private String event_date;
    private EventParameters eventParameters;


    public void setEvent_id(String event_id) {
        this.event_id = event_id;
    }

    public void setEvent_date(String event_date) {
        this.event_date = event_date;
    }

    public void setEventParameters(EventParameters eventParameters) {
        this.eventParameters = eventParameters;
    }

    @Override
    public String toString() {
        return "event.Event{" +
                "event_id='" + event_id + '\'' +
                ", event_date='" + event_date + '\'' +
                ", eventParameters=" + eventParameters +
                '}';
    }
}
