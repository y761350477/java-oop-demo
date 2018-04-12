package bookstore;

import java.util.Scanner;

/**
 * 注:
 *  1. Scanner对象的nextLine()方法如果已经使用了next()方法, 则会出现跳过nextLine()方法的情况;
 *
 * @author YC
 * @create 2018/4/12 11:02.
 */
public class MainApp {

    public static void main(String[] args) {
        // 控制台输入信息 Created by YC.
        Scanner scanner = new Scanner(System.in);

        // 死循环来进行多次业务操作 Created by YC.
        while (true) {
            BooksService.status();
            System.out.println("请输入要办理的业务:\t1. 借书、2. 还书、3. 退出!");
            int service_num = scanner.nextInt();
            String books_name = null;
            switch (service_num) {
                case 1:
                    System.out.println("请输入要借出的书籍名称(多个书籍以空格分隔):");
                    books_name = scanner.nextLine();
                    books_name = scanner.nextLine();
                    BooksService.lend(books_name);
                    break;
                case 2:
                    System.out.println("请输入要还入的书籍名称(多个书籍以空格分隔):");
                    books_name = scanner.nextLine();
                    books_name = scanner.nextLine();
                    BooksService.borrow(books_name);
                    break;
                case 3:
                    System.out.println("已退出当前业务!");
                    return;
                default:
                    System.out.println("业务信息有误, 请重新输入!");
            }
        }

    }

}
