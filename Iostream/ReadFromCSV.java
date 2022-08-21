package com.Bridgelabz.Iostream;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadFromCSV {
    public static String writeData1(Map<String, AddressBook> addressBookMap) {
        System.out.println("inside file");
        File file = new File("B:\\ADDRESSBOOK git\\Contact.csv");
        BufferedWriter bf = null;
        try {
            //creating buffer writer for the output file
            bf = new BufferedWriter(new FileWriter(file));

            //itrate Map entries
            for (Map.Entry<String, AddressBook> entry : addressBookMap.entrySet()) {
                System.out.println(entry.getKey() + " :" + entry.getValue());
                //put ket and values seprated by a colon
                bf.write(entry.getKey() + ":" + entry.getValue());
                bf.newLine();
            }
            bf.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static boolean ReadDataCSV() {
        String fileName = "B:\\ADDRESSBOOK git\\Contact.csv";
        try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
            List<List<String>> values = lines.map(line -> Arrays.asList(line.split(","))).collect(Collectors.toList());
            values.forEach(value -> System.out.println(value));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
