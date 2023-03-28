package org.example;


import java.util.Optional;

public class Code_5 {

    public static void main(String[] args) {
        String text = "1abf343412";
        int row = 0;
        for (int i = 1; i < text.length(); i++) {
            for (int j = i + 1; j < text.length(); j++) {
                for (int k = j + 1; k < text.length(); k++) {
                    for (int l = k + 1; l < text.length(); l++) {
                        for (int m = l + 1; m < text.length(); m++) {
                            for (int n = m + 1; n < text.length(); n++) {
                                for (int o = n + 1; o < text.length(); o++) {
                                    String sub1 = text.substring(0, i);
                                    String sub2 = text.substring(i, j);
                                    String sub3 = text.substring(j, k);
                                    String sub4 = text.substring(k, l);
                                    String sub5 = text.substring(l, m);
                                    String sub6 = text.substring(m, n);
                                    String sub7 = text.substring(n, o);
                                    String sub8 = text.substring(o);
                                    final Optional<int[]> ipAddressOpt = getIPAddress(
                                            new String[] {sub1, sub2, sub3, sub4, sub5, sub6, sub7, sub8});
                                    if (ipAddressOpt.isPresent()) {
                                        final int[] hextets = ipAddressOpt.get();
                                        System.out.printf("%s. - %s:%s:%s:%s:%s:%s:%s:%s\n",
                                                ++row, //защо не row++
                                                Integer.toHexString(hextets[0]),
                                                Integer.toHexString(hextets[1]),
                                                Integer.toHexString(hextets[2]),
                                                Integer.toHexString(hextets[3]),
                                                Integer.toHexString(hextets[4]),
                                                Integer.toHexString(hextets[5]),
                                                Integer.toHexString(hextets[6]),
                                                Integer.toHexString(hextets[7])
                                        );
                                    }
                                }
                            }
                        }
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
            final Integer integer = Integer.valueOf(octet, 16);
            final boolean isValid = 0 <= integer && integer <= 65535;

            return isValid ? Optional.of(integer) : Optional.empty();
        } catch (NumberFormatException ex) {
            return Optional.empty();
        }
    }
}
