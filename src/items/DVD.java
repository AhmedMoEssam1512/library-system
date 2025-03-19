package items;

public class DVD extends LibraryItem implements Borrowable {

    @Override
    public boolean borrow() {
        if(quantity <= 0){
            return false;
        }
        quantity--;
        return true;
    }
}
