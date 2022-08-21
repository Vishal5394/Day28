package com.Bridgelabz.Iostream;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class AddressBookMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();
        Map<String, AddressBook> addressBookMap = new HashMap<String, AddressBook>();

        while (true) {
            System.out.println("1. New Address Book");
            System.out.println("2. Select Address Book");
            System.out.println("3. Delete Address Book");
            System.out.println("4. Search Contact Data");
            System.out.println("5. View Contact Data");
            System.out.println("6. Count Contacts ");
            System.out.println("7. Write data");
            System.out.println("8. Read data");
            System.out.println("9.writing csv");
            System.out.println("10.Reading csv");
            System.out.println("11. Exit");
            System.out.print("Enter Your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter Name of new Address Book: ");
                    String bookName = sc.next();
                    sc.nextLine();
                    addressBookMap.put(bookName, new AddressBook());// adding bookname as a key and vlue is allocating
                    // memory for addressbook obj
                    addressBook.addressBookOptions(addressBookMap.get(bookName));// call addressbook option method with
                    // passing key of hashmap
                    break;
                case 2:
                    System.out.println("List of available Address Book : ");
                    Set keys = addressBookMap.keySet();// retrived keys from hashmap to show addressbooklist
                    Iterator i = keys.iterator();
                    while (i.hasNext()) {
                        System.out.println(i.next());
                    }
                    System.out.println("Enter Address Book name you want to Open : ");
                    String name = sc.nextLine();
                    System.out.println("Current Address Book is : " + name);
                    addressBook.addressBookOptions(addressBookMap.get(name));// call method with passing address book name
                    break;
                case 3:
                    System.out.println("List of available Address Book : ");
                    Set keys1 = addressBookMap.keySet();// retrived keys from hashmap to show addressbooklist
                    Iterator i1 = keys1.iterator();
                    while (i1.hasNext()) {
                        System.out.println(i1.next());
                    }
                    System.out.println("Enter Address Book name to be delete: ");
                    name = sc.nextLine();
                    addressBookMap.remove(name);// delete hashmap using remove fun
                    break;

                case 4:
                    System.out.println("Welcome to the search option:");
                    addressBook.searchByOptions();
                    break;
                case 5:
                    System.out.println("Welcome to view By Option:");
                    addressBook.viewByOption(addressBookMap);
                    break;
                case 6:
                    System.out.println("Welcome to the couter");
                    addressBook.countByOption();
                    break;
                case 7:
                    System.out.println("Contact Details ");
                    AddressBookFileIO addressBookFileIO = new AddressBookFileIO();
                    addressBookFileIO.writeData(addressBookMap);
                    break;
                case 8:
                    // System.out.println("Contact Details ");
                    AddressBookFileIO addressBookFileIO2 = new AddressBookFileIO();
                    System.out.println(addressBookFileIO2.readData());
                case 9://ReadFromCSV fromCSV=new ReadFromCSV();

                    System.out.println(ReadFromCSV.writeData1(addressBookMap));
                case 10:
                    System.out.println("Read Csv");
                    ReadFromCSV fromCSV=new ReadFromCSV();
                    //System.out.println(fromCSV.writeData(addressBookMap));
                    System.out.println(fromCSV.ReadDataCSV());
                case 11:
                    sc.close();// for closing the Scanner Class
                    return;
                default:
                    System.out.println("You Entered Invalid Choice....!");
                    break;
            }
        }
    }
}
