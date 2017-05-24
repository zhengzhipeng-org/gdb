package org.zhengzhipeng.adb;

import java.io.IOException;

/**
 * Transport factory
 *
 * @author zhengzhipeng
 * @since 2017/5/24
 */
public interface TransportFactory {

    Transport getTransport() throws IOException;
}
