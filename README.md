# Contact Management System

A simple Java-based CRUD application for managing contacts with name, phone number, and email address.

## Features

### Core CRUD Operations
- **Create**: Add new contacts with validation
- **Read**: View all contacts and search by keyword
- **Update**: Modify existing contact information
- **Delete**: Remove contacts with confirmation

### Additional Features
- **Duplicate Validation**: Prevents adding contacts with same name, phone, or email
- **Keyword Search**: Search contacts by name, phone, or email
- **Sorting**: Sort contacts alphabetically by name
- **File Export/Import**: Export contacts to CSV file and import from CSV
- **Input Validation**: Ensures all required fields are provided
- **User-Friendly Interface**: Console-based menu system

## File Structure

```
Contact Management/
├── Contact.java              # Contact entity class with encapsulation
├── ContactManager.java       # Business logic and CRUD operations
├── ContactManagementApp.java # Main application with user interface
└── README.md                # This file
```

## How to Compile and Run

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Command line/terminal access

### Compilation
1. Open command prompt/terminal in the project directory
2. Compile all Java files:
   ```bash
   javac *.java
   ```

### Running the Application
1. After compilation, run the main application:
   ```bash
   java ContactManagementApp
   ```

## Usage Guide

### Main Menu Options
1. **Add New Contact** - Create a new contact entry
2. **View All Contacts** - Display all stored contacts
3. **Search Contacts** - Find contacts by keyword
4. **Update Contact** - Modify existing contact information
5. **Delete Contact** - Remove a contact (with confirmation)
6. **Sort Contacts by Name** - Arrange contacts alphabetically
7. **Export Contacts to File** - Save contacts to CSV file
8. **Import Contacts from File** - Load contacts from CSV file
9. **Exit** - Close the application

### Adding a Contact
- Enter name, phone number, and email
- System validates for duplicates and empty fields
- Contact is added if validation passes

### Searching Contacts
- Enter any keyword (name, phone, or email)
- System searches case-insensitively
- Displays all matching contacts

### File Export/Import
- **Export**: Creates a CSV file with all contacts
- **Import**: Loads contacts from a CSV file (skips duplicates)
- CSV format: `Name,Phone,Email`

## Technical Details

### Object-Oriented Programming
- **Encapsulation**: Private fields with public getters/setters
- **Inheritance**: Proper class hierarchy
- **Polymorphism**: Method overriding for equals() and toString()

### Data Structures
- **ArrayList**: Dynamic storage for contacts
- **Collections**: Built-in sorting functionality
- **String manipulation**: Input validation and formatting

### Error Handling
- Input validation for all user inputs
- File I/O exception handling
- Duplicate detection and prevention

## Sample CSV File Format

```
Name,Phone,Email
John Doe,123-456-7890,john@example.com
Jane Smith,987-654-3210,jane@example.com
Bob Johnson,555-123-4567,bob@example.com
```

## Skills Demonstrated

- **OOP Concepts**: Encapsulation, inheritance, polymorphism
- **Data Structures**: ArrayList operations and manipulation
- **Search and Sort**: Custom search algorithms and sorting
- **File I/O**: Reading and writing CSV files
- **Input Validation**: Robust error checking
- **User Interface**: Console-based menu system

## Future Enhancements

- Database integration
- GUI interface
- Advanced search filters
- Contact categories/groups
- Birthday reminders
- Contact photo support 