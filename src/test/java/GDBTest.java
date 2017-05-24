import org.zhengzhipeng.adb.ADBClient;
import org.zhengzhipeng.adb.Transport;

import java.io.IOException;

/**
 * gdb test
 */
public class GDBTest {

    public static void main(String[] args) throws IOException {
        ADBClient adbClient = new ADBClient();
        Transport transport = adbClient.getTransport();
        transport.send("host:version");
        String read = transport.read();
        System.out.println();
        transport.close();
    }
}
