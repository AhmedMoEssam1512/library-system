package items;

public class PhyiscalBook extends LibraryItem implements Borrowable {

    @Override
    public boolean borrow() {
        if(quantity <= 0){
            return false;
        }
        quantity--;
        return true;
    }
}
