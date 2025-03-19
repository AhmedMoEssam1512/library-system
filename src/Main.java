import items.LibraryItem;
import items.UnBorrowable;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("--------------------------------------------");
            System.out.println("---------Library Management System ---------");
            System.out.println("--------------------------------------------");
            System.out.println("Enter 1 for add new item");
            System.out.println("Enter 2 for listing all items");
            System.out.println("Enter 3 for borrow item");
            System.out.println("Enter 4 for return item");
            System.out.println("Enter 5 exit");
            int choice = sc.nextInt();
            if(choice == 5){
                System.out.println("See you soon!");
                break;
            }
            else if(choice == 1){
                System.out.println("Enter the item name");
                String itemName = sc.next();
                System.out.println("Enter 1 : CD , 2 : DVD" +
                        " 3 : Ebook , 4 : physical book , " +
                        "5 : reference book , 6 : journal ");
                int choice1 = sc.nextInt();
            }
        }
    }
}