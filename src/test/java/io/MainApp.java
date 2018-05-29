package io;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * 1. 读取信息会出现空格的原因在与byte数组的大小有关.
 * 2. 通过write(byte[] byte, int off, int len)可以避免输出过多的byte[]长度过长多余的信息.
 * 3. 文件格式不是utf8会导致乱码.
 * 4. file的list方法和file.listFiles()是检查文件夹的方法,如果是文件返回null.
 * 5. while循环判断读取时,应在while判断条件中判断读取字节是否为-1,而不是while体内.
 *
 * @author YC
 * @create 2018/5/8 9:53.
 */
public class MainApp {

    private final static String test_input = "src/test/resources/test/test_input.txt";
    private final static String test_output = "src/test/resources/test/test_output.txt";

    /**
     * 读: 使用字节流读取含有中文的文件"乱码"的情况
     * read()
     *
     * @author YC
     * @create 2018/5/8 12:32.
     */
    @Test
    public void test1() throws IOException {

        try (FileInputStream fileInputStream = new FileInputStream(test_input)) {
            int read = 0;
            while ((fileInputStream.read()) != -1) {
                System.out.print((char) read);
            }
        }

    }

    /**
     * 读: 使用字节流读取含有中文的文件"不乱码"的情况一
     * read(byte[] bytes)
     *
     * @author YC
     * @create 2018/5/8 12:35.
     */
    @Test
    public void test2() throws IOException {

        try (FileInputStream fileInputStream = new FileInputStream(test_output)) {
            // available方法,获取输入流的大小
            int available = fileInputStream.available();
            // 创建字节数组
            byte[] bytes = new byte[available];
            // 把数据读取到数组中
            fileInputStream.read(bytes);
            // 字节数据转换成字符串
            String s = new String(bytes);
            System.out.println(s);
        }
    }

    /**
     * 读: 使用字节流读取含有中文的文件"不乱码"的情况二
     * read(byte[] bytes, int off, int len)
     *
     * @author YC
     * @create 2018/5/8 12:38.
     */
    @Test
    public void test3() throws IOException {

        try (FileInputStream fileInputStream = new FileInputStream(test_input)) {
            int available = fileInputStream.available();
            byte[] bytes = new byte[available];
            fileInputStream.read(bytes, 0, available);
            String s = new String(bytes);
            System.out.println(s);
        }
    }

    /**
     * 读: 使用字符流读取含有中文的文件
     * read()
     * 问题:
     * 1.如果在while里面判断-1输出信息中多了一个￿符号.
     *
     * 解决方案:
     * 1.在while的括号中进行判断-1,而不是里面
     *
     * @author YC
     * @create 2018/5/8 12:49.
     */
    @Test
    public void test4() throws IOException {

        try (FileInputStream fileInputStream = new FileInputStream(test_input);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "utf-8")) {
            int read = 0;
            while ((read = inputStreamReader.read()) != -1) {
                System.out.print((char) read);
            }
        }
    }

    /**
     * 写: 使用字节流写入含有中文的信息
     * FileOutputStream(Sting str, boolean append)
     * FileOutputStream(File file, boolean append)
     * 如果append设置为true,则表示字节将写到文件末尾
     *
     * @author YC
     * @create 2018/5/8 12:56.
     */
    @Test
    public void test5() throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(test_output, true);
             FileInputStream fileInputStream = new FileInputStream(test_input)) {
            int available = fileInputStream.available();
            byte[] bytes = new byte[available];
            fileInputStream.read(bytes);
            fileOutputStream.write(bytes);
        }
    }

    /**
     * 写: 使用字符流写入含有中文的信息
     *
     * @author YC
     * @create 2018/5/9 10:58.
     */
    @Test
    public void test51() throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(test_output);
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "utf-8")) {
            outputStreamWriter.write("手动写了一些数据");
        }
    }

    /**
     * 操作:
     * 1. read(byte[] bytes)的方法使用.
     * 2. read(byte[] bytes, int off, int len)的方法使用.
     * 3. write(bytes[] bytes, int off, int len)的方法使用.
     *
     * 结论:
     * 1. read(byte[] bytes)方法是将读取的字节存入byte[]中
     * 2. ①如果bytes字节长度为20,而len为8,则分三次读取,1 -> 8, 2 -> 8, 3 -> 4.
     *    ②输入流的可读取字节长度available > bytes(自定义长度)的长度则乱码.
     *    ③输入流的可读取字节长度available < bytes(自定义长度)的长度则不乱码,但是会有多余的￿符号.
     * 3. 输出流使用read(byte[] bytes, int off, int len)方法则只输出有效的字节信息.(即bytes中不为0部分)
     *
     * @author YC
     * @create 2018/5/8 13:53.
     */
    @Test
    public void test6() throws IOException {
        File test_input = new File("src/test/resources/test/test_input.txt");
        File test_output = new File("src/test/resources/test/test_output.txt");

        try (FileOutputStream fileOutputStream = new FileOutputStream(test_input);
             FileInputStream fileInputStream = new FileInputStream(test_output)) {

            int available = fileInputStream.available();
            byte[] bytes = new byte[42];
            System.out.println("获取可读取的字节长度:\t" + available);
            int len = 0;
            while ((len = fileInputStream.read(bytes, 0, 8)) != -1) {
                //虽然数组长度的*5,但是这里我们设置了1024所以每次输出1024
                System.out.print(bytes[0] + ", "
                    + bytes[1] + ", "
                    + bytes[2] + ", "
                    + bytes[3] + ", "
                    + bytes[4] + ", "
                    + bytes[5] + ", "
                    + bytes[6] + ", "
                    + bytes[7]);
                System.out.println(" len : " + len);
                fileOutputStream.write(bytes, 0, len);
            }
            System.out.println("获取byte[]:");
            for (byte aByte : bytes) {
                System.out.print(aByte + ", ");
            }
            System.out.println();
            String s = new String(bytes);
            System.out.println(s);
        }
    }

    /**
     * 获取文件夹下面的文件信息
     *
     * @author YC
     * @create 2018/5/9 10:16.
     */
    @Test
    public void test7() throws IOException {
        File file = new File("src/test/resources/test");

        // 获取返回类型为Sting的数组
        String[] list = file.list();
        System.out.println("获取test目录下的文件:");
        for (String s : list) {
            System.out.println(s);
        }

        // 获取返回类型为File的数组
        File[] listFiles = file.listFiles();
        System.out.println("获取test目录下的文件路径:");
        for (File listFile : listFiles) {
            System.out.println(listFile.getPath());
        }
    }

    /**
     * 获取系统的分隔符用于跨平台操作
     *
     * @author YC
     * @create 2018/5/9 11:05.
     */
    @Test
    public void test8() {

        // 常量字符串separator用于获取当前系统文件分隔符.(用于跨平台)
        String separator = File.separator;
        System.out.println("当前系统的分隔符:\t" + separator);
        File file = new File("src" + separator + "test" + separator + "resources" + separator + "test_input.txt");
        System.out.println("文件名:\t" + file.getName());
    }

    /**
     * File的常用方法
     * getName(): 获取文件名
     * getPath(): 获取文件的绝对路径
     * getParent(): 获取文件的上级文件名.
     * exists(): 判断文件是否存在.
     *
     * 创建文件夹的方法：
     * mkdir()方法如果没有上级目录，就不创建；
     * mkdirs()方法如果没有上级目录，就都创建；
     *
     * @author YC
     * @create 2018/5/9 12:06.
     */
    @Test
    public void test9() {
        File file  = new File(test_input);
        System.out.println("getFileName:\t"+file.getName());
        System.out.println("getFilePath:\t"+file.getPath());
        System.out.println("getFileParent:\t"+file.getParent());
        System.out.println("getFileExists:\t"+file.exists());

        System.out.println(file.mkdir());
//        System.out.println(file.mkdirs());
    }
}
