package items;

public class Ebook extends LibraryItem implements Borrowable {

    @Override
    public boolean borrow() {
        if(quantity <= 0){
            return false;
        }
        quantity--;
        return true;
    }
}
