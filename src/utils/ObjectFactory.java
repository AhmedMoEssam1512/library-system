package utils;

import java.util.ArrayList;
import java.util.List;
import items.*;
import java.util.function.Supplier;

public class ObjectFactory {
    private static final List<Supplier<LibraryItem>> objects = new ArrayList<>();
    static {
        objects.add(CD::new);
        objects.add(DVD::new);
        objects.add(Ebook::new);
        objects.add(Journal::new);
        objects.add(PhyiscalBook::new);
        objects.add(ReferenceBook::new);
    }

    public static LibraryItem createObject(int choice){
        if(choice < 0 || choice > objects.size())
            throw new IndexOutOfBoundsException();
        Supplier<LibraryItem> supplier = objects.get(choice);
        return supplier.get();
    }
}