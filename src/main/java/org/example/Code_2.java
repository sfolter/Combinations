package org.example;


public class Code_2 {

    public static void main(String[] args) {
        String text = "абвгдe";

        for (int i = 1; i < text.length(); i++) {
            for (int j = i+1; j < text.length(); j++) {
                String sub1 = text.substring(0, i);
                String sub2 = text.substring(i, j);
                String sub3 = text.substring(j);
                System.out.printf("%s.%s.%s\n", sub1, sub2, sub3);
            }
        }
    }
}
