package com.suriya;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone= new MobilePhone("345 555 6666");

    public static void main(String[] args) {

        boolean quit = false;
        startPhone();
        printActions();
        while (!quit) {
            System.out.println("\n Enter action: (6 to show available actions");
            int action = scanner.nextInt();
            switch (action) {
                case 0:
                    System.out.println("System shutting down");
                    quit = true;
                    break;
                case 1:
                    mobilePhone.printcontacts();
                    break;
                case 2 :
                    System.out.println("Enter name");
                    String name = scanner.nextLine();
                    System.out.println("Enter Phone Number");
                    String phone = scanner.nextLine();
                    Contacts newContact = Contacts.createRecord(name,phone);
                    if (mobilePhone.addContact(newContact)) {
                        System.out.println("Added" + name +" "+ phone);
                    } else {
                        System.out.println("Already In file");
                    }
                    break;
                case 3 :
                    System.out.println("Enter old Contact name");
                    String old = scanner.nextLine();
                    int index = mobilePhone.checkExists(old);
                    if (index < 0){
                        System.out.println("Contact Not Found");
                    } else {
                        System.out.println("Enter New Contact to Add");
                        System.out.println("Enter name");
                        String name1 = scanner.nextLine();
                        System.out.println("Enter Phone Number");
                        String phone1 = scanner.nextLine();
                        Contacts newContact1 = Contacts.createRecord(name1,phone1);
                        Contacts oldContact = mobilePhone.getContact(index);
                        mobilePhone.updateContact(oldContact,newContact1);
                    }
                    break;
                case 4:
                    Contacts contact = ;
                    mobilePhone.removeContact();
                    break;
                case 5:
                    mobilePhone.queryContact(contact);
                    break;

                case 6:
                    printActions();
                    break;

            }

        }
    }
    private static void startPhone(){
            System.out.println("Starting Phone ...");
        }

     private static void printActions(){
         System.out.println("Available Actions: \n ");
         System.out.println("0 - to shutdown \n"+
                 "1- toPrint contacts\n" +"2 - to add new contacts\n" + "3 - to update contact \n" +
                 "4 - to remove an existing contact \n" + "5 - query if an existing contact exists\n"+
                 "6 - to print a list of available actions.");
         System.out.println("Chhose your option: ");
     }

    }

