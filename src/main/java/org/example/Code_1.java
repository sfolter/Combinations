package org.example;


public class Code_1 {

    public static void main(String[] args) {
        String text = "абвгдe";

        for (int i = 1; i < text.length(); i++) {
            String sub1 = text.substring(0, i);
            String sub2 = text.substring(i);
            System.out.printf("%s.%s\n", sub1, sub2);
        }
    }
}
