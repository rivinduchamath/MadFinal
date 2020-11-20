package lk.sliit.mad.today.entity;

public class MessageEtt {
    private String key;
    private String user;
    private String subject;
    private String message;

    public MessageEtt() {
    }

    public MessageEtt( String user, String subject, String message) {
        this.user = user;
        this.subject = subject;
        this.message = message;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "MessageEtt{" +
                "key='" + key + '\'' +
                ", user='" + user + '\'' +
                ", subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
