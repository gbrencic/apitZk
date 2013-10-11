package hr.zk.common.util.text;

/**
 * User: gbrencic
 * Date: 01.10.13.
 * Time: 15:57
 */
public class TextFormatter {
    //TODO test
    public String insertCharacter(String text, String insert, int position) {
        StringBuilder sb = new StringBuilder(text);
        sb.insert(position, insert);
        return sb.toString();
    }

    public String formatTextToBlock(String text, int charactersPerRow) {
        int rows = text.length() / charactersPerRow;
        for (int r = 0; r <= rows; r++) {
            text = insertCharacter(text, "\n", charactersPerRow * r);
        }
        return text;
    }
}
