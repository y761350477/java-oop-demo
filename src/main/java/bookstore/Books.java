package bookstore;

public class Books {

    private String book_name;
    private int book_price;
    private boolean booK_status;

    public Books() {

    }

    public Books(String book_name, int book_price, boolean booK_status) {
        this.book_name = book_name;
        this.book_price = book_price;
        this.booK_status = booK_status;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public int getBook_price() {
        return book_price;
    }

    public void setBook_price(int book_price) {
        this.book_price = book_price;
    }

    public boolean isBooK_status() {
        return booK_status;
    }

    public void setBooK_status(boolean booK_status) {
        this.booK_status = booK_status;
    }
}
