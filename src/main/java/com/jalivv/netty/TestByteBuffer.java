package com.jalivv.netty;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


@Slf4j
public class TestByteBuffer {
    private static final Logger logger= LoggerFactory.getLogger(TestByteBuffer.class);

    public static void main(String[] args) {


        try (FileChannel channel = new FileInputStream("./data.txt").getChannel()) {
            ByteBuffer buffer = ByteBuffer.allocate(10);
            while (channel.read(buffer) != -1) {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    logger.info("读取字节:{}", (char) buffer.get());
                    System.out.println(buffer.get());
                }
                buffer.clear();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
