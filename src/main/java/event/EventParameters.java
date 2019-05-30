package event;

public class EventParameters {
    private int priority;
    private String log_level;
    private String source;

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
        return "event.EventParameters{" +
                "priority=" + priority +
                ", log_level='" + log_level + '\'' +
                ", source='" + source + '\'' +
                '}';
    }
}
