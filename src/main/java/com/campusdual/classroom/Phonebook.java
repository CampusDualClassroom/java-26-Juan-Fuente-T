package com.campusdual.classroom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Phonebook {
    Map<String, Contact> contacts = new HashMap<>();

    public void addContact(Contact contact) {
        contacts.put(contact.code, contact);
//        return contacts.get(contactCode);
    }

    public void showPhonebook() {
        for (int i = 0; i < contacts.size(); i++) {
            List<String> keys = new ArrayList<>(contacts.keySet());
            String key = keys.get(i);
            Contact contact = contacts.get(key);
            System.out.println("Código: " + key);
            contact.showContactDetails();
        }
    }

    public Map<String, Contact> getData() {
        return this.contacts;
    }

    public void deleteContact(String contactCode) {
        contacts.remove(contactCode);
    }

}
