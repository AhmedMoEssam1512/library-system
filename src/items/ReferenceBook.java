package items;

public class ReferenceBook extends LibraryItem implements UnBorrowable{
    @Override
    public boolean borrow() {
        return false;
    }
}
