import java.util.Scanner;

public class ContactManagementApp {
    private static ContactManager contactManager = new ContactManager();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("=== CONTACT MANAGEMENT SYSTEM ===");
        System.out.println("Welcome to your personal contact manager!");
        
        while (true) {
            displayMenu();
            int choice = getValidChoice();
            
            switch (choice) {
                case 1:
                    addNewContact();
                    break;
                case 2:
                    contactManager.displayAllContacts();
                    break;
                case 3:
                    searchContacts();
                    break;
                case 4:
                    updateContact();
                    break;
                case 5:
                    deleteContact();
                    break;
                case 6:
                    contactManager.sortContactsByName();
                    break;
                case 7:
                    exportContacts();
                    break;
                case 8:
                    importContacts();
                    break;
                case 9:
                    System.out.println("Thank you for using Contact Management System!");
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
            
            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();
        }
    }
    
    private static void displayMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("CONTACT MANAGEMENT SYSTEM MENU");
        System.out.println("=".repeat(50));
        System.out.println("1. Add New Contact");
        System.out.println("2. View All Contacts");
        System.out.println("3. Search Contacts");
        System.out.println("4. Update Contact");
        System.out.println("5. Delete Contact");
        System.out.println("6. Sort Contacts by Name");
        System.out.println("7. Export Contacts to File");
        System.out.println("8. Import Contacts from File");
        System.out.println("9. Exit");
        System.out.println("=".repeat(50));
        System.out.print("Enter your choice (1-9): ");
    }
    
    private static int getValidChoice() {
        while (true) {
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= 9) {
                    return choice;
                } else {
                    System.out.print("Please enter a number between 1 and 9: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }
    
    private static void addNewContact() {
        System.out.println("\n=== ADD NEW CONTACT ===");
        
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();
        
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        
        contactManager.addContact(name, phone, email);
    }
    
    private static void searchContacts() {
        System.out.println("\n=== SEARCH CONTACTS ===");
        System.out.print("Enter search keyword: ");
        String keyword = scanner.nextLine();
        contactManager.searchContacts(keyword);
    }
    
    private static void updateContact() {
        if (contactManager.getContactCount() == 0) {
            System.out.println("No contacts to update. Please add some contacts first.");
            return;
        }
        
        System.out.println("\n=== UPDATE CONTACT ===");
        contactManager.displayAllContacts();
        
        System.out.print("Enter the number of the contact to update: ");
        int index = getValidContactIndex();
        
        System.out.print("Enter new name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter new phone number: ");
        String phone = scanner.nextLine();
        
        System.out.print("Enter new email: ");
        String email = scanner.nextLine();
        
        contactManager.updateContact(index, name, phone, email);
    }
    
    private static void deleteContact() {
        if (contactManager.getContactCount() == 0) {
            System.out.println("No contacts to delete. Please add some contacts first.");
            return;
        }
        
        System.out.println("\n=== DELETE CONTACT ===");
        contactManager.displayAllContacts();
        
        System.out.print("Enter the number of the contact to delete: ");
        int index = getValidContactIndex();
        
        System.out.print("Are you sure you want to delete this contact? (y/n): ");
        String confirm = scanner.nextLine().toLowerCase();
        
        if (confirm.equals("y") || confirm.equals("yes")) {
            contactManager.deleteContact(index);
        } else {
            System.out.println("Deletion cancelled.");
        }
    }
    
    private static int getValidContactIndex() {
        while (true) {
            try {
                int index = Integer.parseInt(scanner.nextLine());
                if (index >= 1 && index <= contactManager.getContactCount()) {
                    return index;
                } else {
                    System.out.print("Please enter a valid contact number: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }
    
    private static void exportContacts() {
        System.out.println("\n=== EXPORT CONTACTS ===");
        System.out.print("Enter filename to export (e.g., contacts.csv): ");
        String filename = scanner.nextLine();
        
        if (filename.trim().isEmpty()) {
            filename = "contacts.csv";
        }
        
        contactManager.exportToFile(filename);
    }
    
    private static void importContacts() {
        System.out.println("\n=== IMPORT CONTACTS ===");
        System.out.print("Enter filename to import from: ");
        String filename = scanner.nextLine();
        
        if (filename.trim().isEmpty()) {
            System.out.println("No filename provided. Import cancelled.");
            return;
        }
        
        contactManager.importFromFile(filename);
    }
} 