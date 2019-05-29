public class Event {
    private String event_id;
    private String event_date;
    private int priority;
    private String log_level;
    private String source;

    public void setEvent_id(String event_id) {
        this.event_id = event_id;
    }

    public void setEvent_date(String event_date) {
        this.event_date = event_date;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setLog_level(String log_level) {
        this.log_level = log_level;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "Event{" +
                "event_id='" + event_id + '\'' +
                ", event_date='" + event_date + '\'' +
                ", priority=" + priority +
                ", log_level='" + log_level + '\'' +
                ", source='" + source + '\'' +
                '}';
    }
}
