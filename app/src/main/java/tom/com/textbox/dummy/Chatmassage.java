package tom.com.textbox.dummy;

public class Chatmassage {

    public String chatSender;
    public String chatSendTime;
    public String chatText;

    public Chatmassage() {
    }

    public String getChatSender() {
        return chatSender;
    }

    public String getChatSendTime() {
        return chatSendTime;
    }

    public String getChatText() {
        return chatText;
    }

    public String toString(){
        String result = "Chat Message: [ "+chatSender+ "]Time["+chatSendTime+"] [ "+chatText+"]";
        return result;
    }
}
