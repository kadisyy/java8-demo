package nio;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;

/**
 * 源节点和目标节点连接点
 * 本身不存储数据 配合缓冲区使用
 * java.nio.channels.Channel
 * -- FileChannel    本地
 * -- SocketChannel  网络
 * -- ServerSockerChannel  网络
 * -- DatagramChannel  网络
 * <p>
 * 获取通道
 * 1. getChannels
 * 2. jdk7  nio.2
 */
public class ChannelTest {
    @Test
    public void test1() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream("2.jpg");
            fis = new FileInputStream("1.jpg");
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }

        //非直接内存
        //ByteBuffer buf = ByteBuffer.allocate(1024);

        //直接存储
        ByteBuffer buf = ByteBuffer.allocateDirect(1024);
        FileChannel fc = fis.getChannel();
        FileChannel fo = fos.getChannel();

        try{
            while(fc.read(buf) != -1){
                buf.flip();
                fo.write(buf);
                buf.clear();
            }
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            if(fo != null) {
                try{
                    fo.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }

            if(fc != null) {
                try{
                    fc.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }

            if(fos != null) {
                try{
                    fos.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }

            if(fis != null) {
                try{
                    fis.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //内存映射文件
    @Test
    public void test2() throws IOException {
        FileChannel fi = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);
        FileChannel fo = FileChannel.open(Paths.get("2.jpg"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE_NEW);

        //内存映射文件
        MappedByteBuffer inmap = fi.map(FileChannel.MapMode.READ_ONLY, 0, fi.size());
        MappedByteBuffer outmap = fo.map(FileChannel.MapMode.READ_WRITE, 0, fi.size());

        //直接对缓冲区读取
        byte[] dst = new byte[inmap.limit()];
        inmap.get(dst);
        outmap.put(dst);

        fi.close();
        fo.close();

    }

    // 分散（Scatter）和聚集（Gather）
    // 1. 通道数据分散到各个缓冲区  2. 多个缓冲区的数据聚集到通道中
    // 按顺序写满
    @Test
    public void test3() throws Exception {
        RandomAccessFile file = new RandomAccessFile("1.txt", "rw");

        FileChannel channel = file.getChannel();

        ByteBuffer buffer1 = ByteBuffer.allocate(10);
        ByteBuffer buffer2 = ByteBuffer.allocate(20);
        ByteBuffer[] buffers = {buffer1, buffer2};
        channel.read(buffers);

        for(ByteBuffer b:buffers){
            b.flip();
        }

        System.out.println(new String(buffers[0].array(),0,buffers[0].limit()));
        System.out.println(new String(buffers[1].array(),0,buffers[1].limit()));

        RandomAccessFile file1 = new RandomAccessFile("2.txt","rw");
        FileChannel channel1 = file1.getChannel();
        channel1.write(buffers);

    }

}

