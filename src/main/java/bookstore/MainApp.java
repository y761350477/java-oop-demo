package bookstore;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        BooksService.status();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入要办理的业务:\t1. 借书、2. 还书、3. 浏览、4. 退出!");
            int service_num = scanner.nextInt();
            String books_name = null;
            switch (service_num) {
                case 1:
                    BooksService.status();
                    System.out.println("请输入要借出的书籍名称:");
                    books_name = scanner.next();
                    BooksService.lend(books_name);
                    break;
                case 2:
                    System.out.println("请输入要还入的书籍名称:");
                    books_name = scanner.next();
                    BooksService.borrow(books_name);
                    break;
                case 3:
                    BooksService.status();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("请核实业务信息是否错误!");
            }
        }

    }
}
