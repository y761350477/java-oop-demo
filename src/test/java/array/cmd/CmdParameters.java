package array.cmd;

/**
 * 命令行参数的操作
 *  执行命令: java array.CmdParameters -g hello world(CmdParameters后为命令行参数,"-g"为args[0])
 *  发现: 使用默认的执行方法文件被编译成gbk字符,通过-encoding utf8解决这个问题.详情参看本包下的命令行参数.gif文件.
 *
 * @author YC
 * @create 2018/5/22 13:36.
 */
public class CmdParameters {

    public static void main(String[] args) {
        if (args.length == 0 || args[0].equals("-h")) {
            System.out.println("Hello,");
        } else if (args[0].equals("-g")) {
            System.out.print("Goodbye,");
        }

        for (String arg : args) {
            System.out.print(arg + " ");
        }
        System.out.print("!");
    }
}
