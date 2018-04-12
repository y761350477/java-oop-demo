package bookstore;

public class BooksService {

    private static Books[] book_info;
    private static BooksService booksService = new BooksService();

    private BooksService() {
        Books books = new Books("三国演义", 15, true);
        Books books1 = new Books("西游记", 17, true);
        Books books2 = new Books("水浒传", 15, true);
        Books books3 = new Books("红楼梦", 19, true);
        book_info = new Books[]{books, books1, books2, books3};
    }

    public static void lend(String book_name) {
        for (Books books : book_info) {
            String book_info_name = books.getBook_name();
            boolean book_info_status = books.isBooK_status();
            if (book_info_name.equals(book_name)) {
                if (book_info_status) {
                    books.setBooK_status(false);
                    System.out.println("成功借出:\t" + book_name);
                } else {
                    System.out.println("抱歉此书:\t" + book_name + "已被别人借出");
                }
            }
            break;
        }
    }

    public static void borrow(String book_name) {
        for (Books books : book_info) {
            String book_info_name = books.getBook_name();
            boolean booK_info_status = books.isBooK_status();
            if (book_info_name.equals(book_name)) {
                if (!booK_info_status) {
                    books.setBooK_status(true);
                    System.out.println("成功归还:\t" + book_name);
                } else {
                    System.out.println("此书已经归还, 无需再次归还");
                }
            }
            break;
        }
    }

    public static void status() {
        System.out.println("书籍状态一览:");
        for (Books books : book_info) {
            System.out.println("书名:\t" + books.getBook_name() + ", 价格:\t" + books.getBook_price() + ", 状态:\t" + books.isBooK_status());
        }
    }
}
