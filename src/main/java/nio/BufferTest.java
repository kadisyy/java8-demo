package nio;

import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * 负责数据的存储 缓存区底层就是数组
 * ByteBuffer
 * CharBuffer
 * ShortBuffer
 * LongBuffer
 * FloatBuffer
 * ...
 * 都是通过allocate()方法获取缓冲区
 * <p>
 * 两个核心方法：
 * put 放数据
 * get 取数据
 * <p>
 * 缓冲区核心属性：
 * private int mark = -1;   记录positon位置
 * private int position = 0;  缓冲区中正在操作的位置
 * private int limit;  可以操作的组大数据 Limit后的数据不能够读写
 * private int capacity;  缓冲区最大存储容量，一旦声明不能修改！
 * <p>
 * position <= limit <=capacity
 *
 * 非直接缓冲区，使用allocate 缓冲建立在JVM内存
 * 直接缓冲区，通过allocateDirect 缓冲区建立在物理内存 提高效率
 */
public class BufferTest {

    @Test
    public void test1() {
        ByteBuffer buf = ByteBuffer.allocate(1024);
        System.out.println("allocate");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());
        buf.put("abc".getBytes());
        System.out.println("put");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());
        ;
        buf.flip();
        System.out.println("flip");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        byte[] dst = new byte[buf.limit()];
        buf.get(dst);
        System.out.println(new String(dst, 0, dst.length));
        System.out.println("get");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        // 代表可以重读
        buf.rewind();
        System.out.println("rewind");

        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        // 清空缓冲区 但是数据依然存在 处于一种被遗忘状态
        buf.clear();
        System.out.println("clear");

        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        System.out.println((char) buf.get());
    }

    @Test
    public void test2() {
        String str = "abcde";
        ByteBuffer buf = ByteBuffer.allocate(1024);
        buf.put(str.getBytes());
        System.out.println("put");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        buf.flip();
        byte[] dst = new byte[buf.limit()];
        buf.get(dst,0,2);
        System.out.println(new String(dst,0,2));
        System.out.println(buf.position());

        buf.mark();
        buf.get(dst,2,2);
        System.out.println(new String(dst,2,2));
        System.out.println(buf.position());

        buf.reset();
        System.out.println(buf.position());

        //判断缓冲区还有剩余的数据
        if(buf.hasRemaining()) {
            System.out.println(buf.remaining());
        }
    }
    @Test
    public void test3(){
        //VM.isDirectMemoryPageAligned()
        ByteBuffer buf = ByteBuffer.allocateDirect(1024);
        System.out.println(buf.isDirect());

        ByteBuffer buf1 = ByteBuffer.allocate(1024);
        System.out.println(buf1.isDirect());

    }
}
