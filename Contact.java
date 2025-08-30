public class Contact {
    private String name;
    private String phone;
    private String email;
    
    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
    
    // Getters
    public String getName() {
        return name;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public String getEmail() {
        return email;
    }
    
    // Setters
    public void setName(String name) {
        this.name = name;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    // Override toString for display
    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phone + ", Email: " + email;
    }
    
    // Override equals for duplicate checking
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Contact contact = (Contact) obj;
        return name.equalsIgnoreCase(contact.name) || 
               phone.equals(contact.phone) || 
               email.equalsIgnoreCase(contact.email);
    }
    
    @Override
    public int hashCode() {
        return name.toLowerCase().hashCode() + 
               phone.hashCode() + 
               email.toLowerCase().hashCode();
    }
} 