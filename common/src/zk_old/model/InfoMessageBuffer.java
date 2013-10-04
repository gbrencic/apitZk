package zk_old.model;

/**
 * User: gbrencic
 * Date: 28.03.12.
 * Time: 09:15
 */
public class InfoMessageBuffer {
    private static final String LINE_START = "<p style=\"padding:-4;\">";
    private static final String LINE_END = "</p>";
    private static StringBuilder infoMessages = new StringBuilder("<html>");

    public static String getInfoMessages() {
        return infoMessages.append(LINE_END).toString();
    }

    public static void addInfoMessage(String infoMessage) {
        infoMessages.append("<p style=\"padding:-4;\">").append(infoMessage).append(LINE_END);
    }

    public static void clearInfoMessages() {
        infoMessages = new StringBuilder("<html>");
    }
}
