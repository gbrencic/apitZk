package hr.pleasantnightmare.gson;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import pleasantnightmare.stage.Tile;

/**
 * User: gbrencic
 * Date: 29.08.12.
 * Time: 09:19
 */
public class GsonTest {
    public static void main(String[] args) {
        new GsonTest();
    }

    public GsonTest() {
        Gson gson = new Gson();

        String jsonObj = gson.toJson(new Object1(22, "TestniObjekt1"));
        System.out.println(jsonObj);
        parseMessage(gson, jsonObj);

        jsonObj = gson.toJson(new Message(22, "TestMessage"));
        System.out.println(jsonObj);
        parseMessage(gson, jsonObj);

        jsonObj = gson.toJson(new Tile(22, 23));
        System.out.println(jsonObj);
        parseMessage(gson, jsonObj);
    }

    private void parseMessage(Gson gson, String jsonObj) {
        String message = TIP.OBJ_ + jsonObj;
        TIP tip = TIP.valueOf(message.substring(0, 4));

        if (tip.equals(TIP.OBJ_)) {
            Object1 obj1 = gson.fromJson(jsonObj, Object1.class);
            System.out.println(obj1);
        } else if (tip.equals(TIP.MSGE)) {
            Message obj1 = gson.fromJson(jsonObj, Message.class);
            System.out.println(obj1);
        }
    }

    public enum TIP {
        OBJ_, MSGE
    }

    private class Object1 {
        private final int id;
        private final String name;

        private Object1(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Object1{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    private class Message {
        private transient final int id;
        @SerializedName("msg")
        private final String message;

        private Message(int id, String message) {
            this.id = id;
            this.message = message;
        }

        @Override
        public String toString() {
            return "Object1{" +
                    "id=" + id +
                    ", name='" + message + '\'' +
                    '}';
        }
    }
}
