package org.zhengzhipeng.adb;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 服务端和客户端的传输类
 *
 * @author zhengzhipeng
 * @since 2017/5/24
 */
public class Transport extends Socket{

    public Transport(String host, int port) throws IOException {
        super(host, port);
    }

    public void send(String command) throws IOException {
        DataOutputStream os = new DataOutputStream(getOutputStream());
        os.writeUTF(getHexLength(command));
        os.writeUTF(command);
        os.flush();
        String status = read(4);
        if (!"OKAY".equals(status)) {
            System.out.println("失败");
        }
    }

    public String read(int length) throws IOException {
        DataInputStream is = new DataInputStream(getInputStream());
        byte[] buffer = new byte[4];
        is.readFully(buffer);
        return new String(buffer, 0, length);
    }

    public String read() throws IOException {
        DataInputStream is = new DataInputStream(getInputStream());
        return is.readUTF();
    }

    /**
     * 获取16进制长度
     * @return 16进制长度
     */
    private String getHexLength(String command) {
        return String.format("%04x", command.length());
    }

}
