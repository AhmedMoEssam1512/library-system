package items;

public abstract class LibraryItem {
    private String title;
    private String author;
    private String ISBN;
    protected int quantity = 0;


    public abstract boolean borrow();


    public void returnItem(){
        quantity++;
    };

    //setters/getters , toString

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public boolean isAvailable() {
        return (quantity > 0 ? true : false);
    }

    public void setQuantity(int quantity) {
        if(quantity >= 0)
            this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "items.LibraryItem{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}