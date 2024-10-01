package com.campusdual.classroom;


public class Exercise26 {
    public static void main(String[] args) {
        Phonebook myPhoneBook = new Phonebook();

        Contact contact1 = new Contact("Javier", "López", "654321321");
        Contact contact2 = new Contact("Carlos", "Fernández-Simón", "654321321");
        Contact contact3 = new Contact("Jose Manuel", "Soria", "654321321");

        myPhoneBook.addContact(contact1);
        myPhoneBook.addContact(contact2);

        myPhoneBook.showPhonebook();

        myPhoneBook.addContact(contact3);
        myPhoneBook.deleteContact(contact1.code);

        contact2.showContactDetails();

        contact2.callMyNumber();

        contact3.callOtherNumber(contact2.getPhone());
    }
}