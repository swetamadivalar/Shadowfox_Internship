import java.util.*;
import java.io.*;

public class ContactManager {
    private ArrayList<Contact> contacts;
    
    public ContactManager() {
        contacts = new ArrayList<>();
    }
 
    public boolean addContact(String name, String phone, String email) {

        if (name == null || name.trim().isEmpty()) {
            System.out.println("Error: Name cannot be empty!");
            return false;
        }
        
        if (phone == null || phone.trim().isEmpty()) {
            System.out.println("Error: Phone number cannot be empty!");
            return false;
        }
        
        if (email == null || email.trim().isEmpty()) {
            System.out.println("Error: Email cannot be empty!");
            return false;
        }
        
        Contact newContact = new Contact(name.trim(), phone.trim(), email.trim());

        if (isDuplicate(newContact)) {
            System.out.println("Error: Contact already exists! (Duplicate name, phone, or email)");
            return false;
        }
        
        contacts.add(newContact);
        System.out.println("Contact added successfully!");
        return true;
    }
  
    public void displayAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }
        
        System.out.println("\n=== ALL CONTACTS ===");
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println((i + 1) + ". " + contacts.get(i));
        }
    }
    
    public void searchContacts(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            System.out.println("Error: Search keyword cannot be empty!");
            return;
        }
        
        keyword = keyword.toLowerCase().trim();
        ArrayList<Contact> results = new ArrayList<>();
        
        for (Contact contact : contacts) {
            if (contact.getName().toLowerCase().contains(keyword) ||
                contact.getPhone().contains(keyword) ||
                contact.getEmail().toLowerCase().contains(keyword)) {
                results.add(contact);
            }
        }
        
        if (results.isEmpty()) {
            System.out.println("No contacts found matching '" + keyword + "'");
        } else {
            System.out.println("\n=== SEARCH RESULTS FOR '" + keyword + "' ===");
            for (int i = 0; i < results.size(); i++) {
                System.out.println((i + 1) + ". " + results.get(i));
            }
        }
    }
    
    public boolean updateContact(int index, String name, String phone, String email) {
        if (index < 1 || index > contacts.size()) {
            System.out.println("Error: Invalid contact index!");
            return false;
        }
        
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Error: Name cannot be empty!");
            return false;
        }
        
        if (phone == null || phone.trim().isEmpty()) {
            System.out.println("Error: Phone number cannot be empty!");
            return false;
        }
        
        if (email == null || email.trim().isEmpty()) {
            System.out.println("Error: Email cannot be empty!");
            return false;
        }
        
        Contact updatedContact = new Contact(name.trim(), phone.trim(), email.trim());
        
        Contact currentContact = contacts.get(index - 1);
        for (Contact contact : contacts) {
            if (contact != currentContact && contact.equals(updatedContact)) {
                System.out.println("Error: Contact already exists! (Duplicate name, phone, or email)");
                return false;
            }
        }
        
        contacts.set(index - 1, updatedContact);
        System.out.println("Contact updated successfully!");
        return true;
    }
    public boolean deleteContact(int index) {
        if (index < 1 || index > contacts.size()) {
            System.out.println("Error: Invalid contact index!");
            return false;
        }
        
        Contact removedContact = contacts.remove(index - 1);
        System.out.println("Contact deleted: " + removedContact.getName());
        return true;
    }
    
    public void sortContactsByName() {
        Collections.sort(contacts, (c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        System.out.println("Contacts sorted by name!");
    }
    
    private boolean isDuplicate(Contact newContact) {
        for (Contact contact : contacts) {
            if (contact.equals(newContact)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean exportToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println("Name,Phone,Email");
            for (Contact contact : contacts) {
                writer.println(contact.getName() + "," + contact.getPhone() + "," + contact.getEmail());
            }
            System.out.println("Contacts exported to " + filename + " successfully!");
            return true;
        } catch (IOException e) {
            System.out.println("Error exporting to file: " + e.getMessage());
            return false;
        }
    }
    public boolean importFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine(); // Skip header
            int importedCount = 0;
            
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    Contact contact = new Contact(parts[0].trim(), parts[1].trim(), parts[2].trim());
                    if (!isDuplicate(contact)) {
                        contacts.add(contact);
                        importedCount++;
                    }
                }
            }
            System.out.println("Imported " + importedCount + " contacts from " + filename);
            return true;
        } catch (IOException e) {
            System.out.println("Error importing from file: " + e.getMessage());
            return false;
        }
    }
    
    public int getContactCount() {
        return contacts.size();
    }
} 