package ru.ismoke;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("test.txt"));
        FileWriter writer = new FileWriter(new File("out.txt"));
        int count;
        String s;
        String[] str;
        ArrayList<String> list;

        while (scanner.hasNextLine()) {
            count = 0;
            list = new ArrayList<>();
            s = scanner.nextLine();
            str = s.split(" ");
            for (String aStr : str) {
                if ((aStr.length() <= 5) && (aStr.length() >= 3)) count++;
                list.add(aStr);
            }
            if (count % 2 != 0) count--;

            for (int i = list.size() - 1; i >= 0; i--) {
                if ((list.get(i).length() >= 3) && (list.get(i).length() <= 5) && count > 0) {
                    list.remove(i);
                    count--;
                }
            }
            s = String.join(" ", list) + System.getProperty("line.separator");
            writer.write(s);
        }
        writer.close();
        scanner.close();
    }
}