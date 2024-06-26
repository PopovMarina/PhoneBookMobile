package models;

import java.io.*;
import java.util.Objects;

public class Contact implements Serializable {

    private String name;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Contact(String name, String lastName, String email, String phone, String address, String description) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.description = description;
    }

    public Contact() {
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact contact)) return false;
        return Objects.equals(getName(), contact.getName()) && Objects.equals(getLastName(),
                contact.getLastName()) && Objects.equals(getEmail(),
                contact.getEmail()) && Objects.equals(getPhone(),
                contact.getPhone()) &&  Objects.equals(getAddress(),
                contact.getAddress()) && Objects.equals(getDescription(), contact.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getLastName(), getEmail(), getPhone(),  getAddress(), getDescription());
    }
    public static void serializeContact(Contact contact, String filename) throws IOException {
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename));
        outputStream.writeObject(contact);
    }
    public static Contact desiarializeContact(String filename) {
        try (
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename));) {
            return (Contact) inputStream.readObject();
        }catch (IOException | ClassNotFoundException e) {
            System.out.println("Error during contact desiarialization ");
            throw new RuntimeException(e);
        }
    }
}
