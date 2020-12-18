package fr.km.designpattern.trywithresources;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class AppService {
    public static void main(String[] args) {

        /** only  > java7
         * we have not need finally bloc to close the scanner
         * the resource is closed automatically
         */
        // 1
        try (Scanner scanner = new Scanner(new File("test.txt"))) {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
    }
}
