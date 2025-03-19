import items.LibraryItem;

import java.util.ArrayList;
import java.util.List;

public class LibraryUser {
    private String name;
    private String userId;
    private List<LibraryItem> borrowed = new ArrayList<>();


    public boolean borrowItem(LibraryItem libraryItem){
        libraryItem.borrow();
        return borrowed.add(libraryItem);
    }

    public boolean returnItem(LibraryItem libraryItem){
        libraryItem.returnItem();
        return borrowed.remove(libraryItem);
    }

    public LibraryUser(String name, String userId) {
        this.name = name;
        this.userId = userId;
    }

    public LibraryUser() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<LibraryItem> getBorrowed() {
        return borrowed;
    }

    public void setBorrowed(List<LibraryItem> borrowed) {
        this.borrowed = borrowed;
    }

    @Override
    public String toString() {
        return "LibraryUser{" +
                "name='" + name + '\'' +
                ", userId='" + userId + '\'' +
                ", borrowed=" + borrowed +
                '}';
    }
}
