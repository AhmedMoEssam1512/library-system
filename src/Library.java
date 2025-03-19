import items.LibraryItem;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List <LibraryItem> items = new ArrayList<LibraryItem>();

    public boolean addItem(LibraryItem item){
        return items.add(item);
    }

    public void listAvailableItems(){
        for(LibraryItem item : items){
            if(item.isAvailable()){
                System.out.println(item);
            }
        }
    }

    public boolean processBorrowing(LibraryItem item, LibraryUser libraryUser){
        if(item.isAvailable())
            return libraryUser.borrowItem(item);
        else
            return false;
    }

    public boolean processReturning(LibraryItem item, LibraryUser libraryUser){
        return libraryUser.returnItem(item);
    }

    @Override
    public String toString() {
        return "Library{" +
                "items=" + items +
                '}';
    }
}
