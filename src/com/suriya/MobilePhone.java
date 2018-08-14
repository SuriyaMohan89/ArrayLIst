package com.suriya;

import com.suriya.Contacts;

import java.util.ArrayList;

public class  MobilePhone {
    private String myNumber;
    private ArrayList<Contacts> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contacts>();
    }
    private int checkExists(Contacts contact){
        return this.myContacts.indexOf(contact);
        }


    public int checkExists(String contactName){
        for (int i=0; i < myContacts.size(); i++){
            Contacts contact = myContacts.get(i);
            if (contact.getName().equals(contactName)){
                return i;
            }
        }
        return -1;
    }

    public boolean addContact(Contacts contact){
        if (checkExists(contact.getName()) >= 0){
            System.out.println("Already In File");
            return false;

        } else {
            this.myContacts.add(contact);
            System.out.println("Successfully Added");
            return true;
        }
    }

    public void updateContact( Contacts oldContact, Contacts newContact){
        int position = checkExists(oldContact);
        if (position < 0){
            System.out.println("Contact not found");
        } else{
            this.myContacts.set(position, newContact);
            System.out.println("Successfully added");
        }
    }
    public Contacts getContact ( int position){
        Contacts contact = this.myContacts.get(position);
        return contact;
    }

    public String queryContact(Contacts contact){
        if (checkExists(contact) >=0){
            int position = checkExists(contact);

            return this.myContacts.get(position).getName();

        } else {
            return "Not Found";
        }
    }

    public void removeContact(Contacts contact){
        if (checkExists(contact) >=0){
            this.myContacts.remove(contact);
            System.out.println("Successfully Removed");
        } else{
            System.out.println("Not found in File To remove");
        }
    }

    public void printcontacts(){
        for (int i = 0; i < this.myContacts.size(); i++){
            System.out.println(this.myContacts.get(i).getName()+ this.myContacts.get(i).getPhoneNumber());
        }
    }

}
