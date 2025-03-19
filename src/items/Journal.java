package items;

public class Journal extends LibraryItem implements UnBorrowable{
    @Override
    public boolean borrow() {
        return false;
    }
}
