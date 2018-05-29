package io;

public class UseTimeTool {
    private static UseTimeTool utt = new UseTimeTool();

    private UseTimeTool() {
    }

    public static UseTimeTool getInstance() {
        return utt;
    }

    private long start;

    public void start() {
        start = System.currentTimeMillis();
    }

    public void stop() {
        long end = System.currentTimeMillis();
        System.out.println("所用时间:\t" + (end - start) + "毫秒");
    }
}
