package org.example;


import java.util.Optional;

public class Code_5 {

    public static void main(String[] args) {
        String text = args[0];

        for (int i = 1; i < text.length(); i++) {
            for (int j = i + 1; j < text.length(); j++) {
                for (int k = j + 1; k < text.length(); k++) {
                    String sub1 = text.substring(0, i);
                    String sub2 = text.substring(i, j);
                    String sub3 = text.substring(j, k);
                    String sub4 = text.substring(k);
                    final Optional<int[]> ipAddressOpt = getIPAddress(new String[] {sub1, sub2, sub3, sub4});
                    if (ipAddressOpt.isPresent()) {
                        final int[] octets = ipAddressOpt.get();
                        System.out.printf("%s.%s.%s.%s\n", octets[0], octets[1], octets[2], octets[3]);
                    }
                }
            }
        }
    }

    private static Optional<int[]> getIPAddress(String[] group) {

        boolean isValid = true;
        final int ipv6GroupCount = 8;
        final int[] intGroups = new int[ipv6GroupCount];
        if (group.length == ipv6GroupCount) {
            for (int i = 0; i < group.length; i++) {
                String octet = group[i];
                final Optional<Integer> intOctet = getIntOctet(octet);
                if (intOctet.isEmpty()) {
                    return Optional.empty();
                }
                intGroups[i] = intOctet.get();
            }
            return Optional.of(intGroups);
        }
        return Optional.empty();
    }

    private static Optional<Integer> getIntOctet(String octet) {
        try {
            final Integer integer = Integer.valueOf(octet);
            final boolean isValid = 0 <= integer && integer <= 255;

            return isValid ? Optional.of(integer) : Optional.empty();
        } catch (NumberFormatException ex) {
            return Optional.empty();
        }
    }
}
