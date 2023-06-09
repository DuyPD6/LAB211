package Controller;

import java.math.BigInteger;

public class ChangeBase {
    public BigInteger anyToBase10(String inputBase, String inputValue) {
        int inputBaseInteger = Integer.parseInt(inputBase);
        BigInteger decimalValue = BigInteger.ZERO;

        if (inputBase.isEmpty() || inputValue.isEmpty() || inputValue.equals("0")) {
            return BigInteger.ZERO;
        }

        for (int i = 0; i < inputValue.length(); i++) {
            char c = inputValue.charAt(i);
            BigInteger digitValue;

            if (Character.isDigit(c)) {
                digitValue = BigInteger.valueOf(Character.getNumericValue(c));
            } else if (c >= 'A' && c <= 'F') {
                digitValue = BigInteger.TEN.add(BigInteger.valueOf(c - 'A'));
            } else {
                System.out.println("Input value is not valid! ");
                return BigInteger.ZERO;
            }

            decimalValue = decimalValue.multiply(BigInteger.valueOf(inputBaseInteger)).add(digitValue);
        }

        return decimalValue;
    }

    public String base10ToAny(String outputBase, BigInteger base10Value) {
        int baseOutputInteger = Integer.parseInt(outputBase);
        StringBuilder sb = new StringBuilder();

        if (base10Value.equals(BigInteger.ZERO)) {
            sb.append("0");
        }

        while (base10Value.compareTo(BigInteger.ZERO) > 0) {
            BigInteger[] quotientAndRemainder = base10Value.divideAndRemainder(BigInteger.valueOf(baseOutputInteger));
            BigInteger digit = quotientAndRemainder[1];

            if (digit.compareTo(BigInteger.TEN) < 0) {
                sb.append(digit);
            } else {
                sb.append((char) ('A' + (digit.intValue() - 10)));
            }

            base10Value = quotientAndRemainder[0];
        }

        String outputValue = sb.reverse().toString();
        System.out.println(outputValue);
        return outputValue;
    }
}
