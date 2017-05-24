package org.zhengzhipeng.adb;

import java.io.IOException;

/**
 * adb 客户端
 *
 * @author zhengzhipeng
 * @since 2017/5/24
 */
public class ADBClient implements TransportFactory{

    /** 默认的主机 */
    public static final String DEFAULT_HOST = "127.0.0.1";
    /** 默认的端口号 */
    public static final int DEFAULT_PORT = 5037;
    /** 主机 */
    private String host;
    /** 端口号 */
    private int port;

    public ADBClient() {
        this.host = DEFAULT_HOST;
        this.port = DEFAULT_PORT;
    }

    public ADBClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public Transport getTransport() throws IOException {
        return new Transport(host, port);
    }

}
