package bookstore;

/**
 * 注:
 *  1. 数组在初始化声明时可以使用{a, b, c}, 而只初始化而没有声明的情况下, 需要使用new 类型(){a, b, c}来声明;
 *  2. 在进行String对象操作的时候, 要避免长度和null的相关问题发生;
 *  3. 写死代码是件令人遗憾的事情;
 *
 * @author YC
 * @create 2018/4/12 10:59.
 */
public class BooksService {

    private static Books[] book_info;
    private static BooksService booksService = new BooksService();

    /**
     * 实现单例模式(饿汉模式), 并初始化类时赋值书籍信息
     *
     * @author YC
     * @create 2018/4/12 10:51.
     */
    private BooksService() {
        Books books = new Books("三国演义", 15, true);
        Books books1 = new Books("西游记", 17, true);
        Books books2 = new Books("水浒传", 15, true);
        Books books3 = new Books("红楼梦", 19, true);
        book_info = new Books[]{books, books1, books2, books3};
    }

    /**
     * 借书的业务逻辑
     * 1. 实现一次多借的情景
     * 2. 实现一次通知借书后的信息
     *
     * @author YC
     * @create 2018/4/12 10:45.
     */
    public static void lend(String book_name) {
        String book_name_filter = data_filter_space(book_name);
        String[] book_name_split = book_name_filter.split(" ");
        String book_name_lend = "";
        String book_name_lended = "";
        for (String book_name_index : book_name_split) {
            for (Books books : book_info) {
                String book_info_name = books.getBook_name();
                boolean book_info_status = books.isBooK_status();
                if (book_info_name.equals(book_name_index)) {
                    if (book_info_status) {
                        books.setBooK_status(false);
                        book_name_lend += book_name_index + ", ";
                    } else {
                        book_name_lended += book_name_index + ", ";
                    }
                    break;
                }
            }
        }
        int book_name_lend_length = book_name_lend.length();
        if (book_name_lend_length > 0) {
            book_name_lend = book_name_lend.substring(0, book_name_lend_length - 2);
            System.out.println("成功借出:\t" + book_name_lend);
        }

        int book_name_lended_length = book_name_lended.length();
        if (book_name_lended_length > 0) {
            book_name_lended = book_name_lend.substring(0, book_name_lended_length - 2);
            System.out.println("抱歉此书:\t" + book_name_lended + "已被别人借出");
        }

        if (book_name_lended_length == 0 && book_name_lend_length == 0) {
            System.out.println("输入的书籍名不存在!");
        }
    }

    /**
     * 还书的业务逻辑
     * 1. 实现一次多还的情景
     * 2. 实现一次通知还书后的信息
     *
     * @author YC
     * @create 2018/4/12 10:47.
     */
    public static void borrow(String book_name) {
        String book_name_filter = data_filter_space(book_name);
        String[] book_name_split = book_name_filter.split(" ");
        String book_name_borrow = "";
        String book_name_borrowed = "";
        for (String book_name_index : book_name_split) {
            for (Books books : book_info) {
                String book_info_name = books.getBook_name();
                boolean book_info_status = books.isBooK_status();
                if (book_info_name.equals(book_name_index)) {
                    if (!book_info_status) {
                        books.setBooK_status(true);
                        book_name_borrow += book_name_index + ", ";
                    } else {
                        book_name_borrowed += book_name_index + ", ";
                    }
                    break;
                }
            }
        }
        int book_name_borrow_length = book_name_borrow.length();
        if (book_name_borrow_length > 0) {
            book_name_borrow = book_name_borrow.substring(0, book_name_borrow_length - 2);
            System.out.println("成功归还:\t" + book_name_borrow);
        }

        int book_name_borrowed_length = book_name_borrowed.length();
        if (book_name_borrowed_length > 0) {
            book_name_borrowed = book_name_borrow.substring(0, book_name_borrowed_length - 2);
            System.out.println("书籍:\t" + book_name_borrowed + "已经归还无需再还");
        }
    }

    /**
     * 书籍状态一览
     *
     * @author YC
     * @create 2018/4/12 10:50.
     */
    public static void status() {
        System.out.println("书籍状态一览:");
        for (Books books : book_info) {
            System.out.println("书名:\t" + books.getBook_name() + ", 价格:\t" + books.getBook_price() + ", 状态:\t" + books.isBooK_status());
        }
    }

    /**
     * 过滤多余空格为一个空格
     *
     * @author YC
     * @create 2018/4/12 10:48.
     */
    public static String data_filter_space(String book_name) {
        // 去除前后空格 Created by YC.
        book_name = book_name.trim();
        // 通过正则去除多余的空格为单空格 Created by YC.
        String str = book_name.replaceAll("\\s+", " ");
        return str;
    }

}
