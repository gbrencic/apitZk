package hr.zk.common.util.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * User: gbrencic
 * Date: 01.10.13.
 * Time: 15:22
 */
public class ConsoleInput implements InputReader{
    public String readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = br.readLine();

        if (inputLine.length() == 0) {
            return "";
        }
        return inputLine;
    }
}
