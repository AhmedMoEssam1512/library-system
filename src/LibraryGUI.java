import items.LibraryItem;
import utils.ObjectFactory;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class LibraryGUI extends JFrame {
    private JPanel panel;
    private JButton addItemButton, listItemsButton, borrowItemButton, returnItemButton, exitButton;
    private Library library; // Use Library class instead of separate HashMap
    private Map<String, LibraryUser> users;

    public LibraryGUI() {
        setTitle("Library Management System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        library = new Library(); // Initialize Library instance
        users = new HashMap<>();

        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        addItemButton = new JButton("Add New Item");
        listItemsButton = new JButton("List All Items");
        borrowItemButton = new JButton("Borrow Item");
        returnItemButton = new JButton("Return Item");
        exitButton = new JButton("Exit");

        panel.add(addItemButton);
        panel.add(listItemsButton);
        panel.add(borrowItemButton);
        panel.add(returnItemButton);
        panel.add(exitButton);

        add(panel);

        addItemButton.addActionListener(e -> showAddItemDialog());
        listItemsButton.addActionListener(e -> showLibraryItems());
        borrowItemButton.addActionListener(e -> borrowItem());
        returnItemButton.addActionListener(e -> returnItem());
        exitButton.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    private void showAddItemDialog() {
        String[] options = {"CD", "DVD", "Ebook", "Physical Book", "Reference Book", "Journal"};
        JComboBox<String> comboBox = new JComboBox<>(options);
        JTextField authorField = new JTextField();
        JTextField titleField = new JTextField();
        JTextField ISBNField = new JTextField();
        JTextField quantityField = new JTextField();

        Object[] fields = {
                "Select Item Type:", comboBox,
                "Enter Author:", authorField,
                "Enter Title:", titleField,
                "Enter ISBN:", ISBNField,
                "Enter Quantity:", quantityField
        };

        int option = JOptionPane.showConfirmDialog(null, fields, "Add New Item", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            int choice = comboBox.getSelectedIndex();
            LibraryItem item = ObjectFactory.createObject(choice);
            item.setAuthor(authorField.getText());
            item.setTitle(titleField.getText());
            item.setISBN(ISBNField.getText());
            item.setQuantity(Integer.parseInt(quantityField.getText()));

            library.addItem(item); // Use Library class to add item
            JOptionPane.showMessageDialog(null, "Item Added Successfully!\n" + item.toString());
        }
    }

    private void showLibraryItems() {
        StringBuilder availableItems = library.listAvailableItems();
        if (availableItems.length() == 0) {
            JOptionPane.showMessageDialog(null, "No available items in the library.", "Library Items", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, availableItems, "Library Items", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void borrowItem() {
        JTextField ISBNField = new JTextField();
        JTextField userIdField = new JTextField();

        Object[] fields = {
                "Enter ISBN:", ISBNField,
                "Enter User ID:", userIdField
        };

        int option = JOptionPane.showConfirmDialog(null, fields, "Borrow Item", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String ISBN = ISBNField.getText();
            String userId = userIdField.getText();

            LibraryUser user = users.get(userId);
            if (user == null) {
                String userName = JOptionPane.showInputDialog("User not found. Enter name to create new user:");
                if (userName == null || userName.isEmpty()) {
                    return;
                }
                user = new LibraryUser(userName, userId);
                users.put(userId, user);
            }

            if (library.processBorrowing(ISBN, user)) {
                JOptionPane.showMessageDialog(null, "Item borrowed successfully by " + user.getName());
            } else {
                JOptionPane.showMessageDialog(null, "Item is not available or already borrowed.");
            }
        }
    }

    private void returnItem() {
        JTextField ISBNField = new JTextField();
        JTextField userIdField = new JTextField();

        Object[] fields = {
                "Enter ISBN:", ISBNField,
                "Enter User ID:", userIdField
        };

        int option = JOptionPane.showConfirmDialog(null, fields, "Return Item", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String ISBN = ISBNField.getText();
            String userId = userIdField.getText();

            LibraryUser user = users.get(userId);
            if (user == null) {
                JOptionPane.showMessageDialog(null, "User not found.");
                return;
            }

            if (library.processReturning(ISBN, user)) {
                JOptionPane.showMessageDialog(null, "Item returned successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to return item.");
            }
        }
    }

    public static void main(String[] args) {
        new LibraryGUI();
    }
}