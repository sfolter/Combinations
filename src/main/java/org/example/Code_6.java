package org.example;

public class Code_6 {
    public static void main(String[] args) {
        String inputString = "абвгдеж";
        int n = 3;
        generateDotCombinations(inputString, n);
    }

    public static void generateDotCombinations(String inputString, int n) {
        int[] indexes = new int[n];
        for (int i = 0; i < n; i++) {
            indexes[i] = i + 1;
        }
        int row = 1;
        while (indexes[0] <= inputString.length() - n) {
            StringBuilder sb = new StringBuilder(inputString);
            for (int i = n - 1; i >= 0; i--) {
                sb.insert(indexes[i], ".");
            }
            if (!sb.toString().endsWith(".")) {
                System.out.println("" + row + ". " + sb);
                row++;
            }

            if (!updateIndexes(indexes, inputString.length())) {
                break;
            }
        }
    }

    public static boolean updateIndexes(int[] indexes, int maxLength) {
        int n = indexes.length;
        int i = n - 1;
        while (i >= 0 && indexes[i] == maxLength - (n - i - 1)) {
            i--;
        }
        if (i < 0) {
            return false;
        }
        indexes[i]++;
        for (int j = i + 1; j < n; j++) {
            indexes[j] = indexes[j - 1] + 1;
        }
        return true;
    }
}
