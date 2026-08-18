class Solution {
    public String multiply(String num1, String num2) {

        String result = "";

        for (int i = num2.length() - 1; i >= 0; i--) {
            String num = multiply(num1, num2.charAt(i));
            String padded = pad(num, num2.length() - i - 1);
            result = add(padded, result);
        }

        StringBuilder sb = new StringBuilder(result);
        while (!sb.isEmpty() && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        if (sb.isEmpty()) {
            return "0";
        } else {
            return sb.toString();
        }
    }

    private String multiply(String num1, char c) {
        String result = "";
        int carry = 0;

        int a = (int) (c - '0');
        for (int i = num1.length() - 1; i >= 0; i--) {
            int b = (int) (num1.charAt(i) - '0');

            int res = a * b;
            res = res + carry;
            
            carry = res / 10;
            int val = res % 10;
            result = val + result;
        }

        if (carry > 0) {
            result = carry + result;
        }

        return result;
    }

    private String pad(String num, int zeros) {
        for (int i = 0; i < zeros; i++) {
            num = num + '0';
        }
        return num;
    }

    private String add(String num1, String num2) {
        String result = "";

        int i = num1.length() - 1;
        int j = num2.length() - 1;

        boolean carry = false;
        while (i >= 0 && j >= 0) {
            int a = (int) (num1.charAt(i) - '0');
            int b = (int) (num2.charAt(j) - '0');

            int res = a + b;
            if (carry) {
                res = res + 1;
                carry = false;
            }

            if (res >= 10) {
                carry = true;
                res = res % 10;
            }

            result = res + result;
            i--;
            j--;
        }

        while (i >= 0) {
            int res = (int) (num1.charAt(i) - '0');
            if (carry) {
                res = res + 1;
                carry = false;
            }

            if (res >= 10) {
                carry = true;
                res = res % 10;
            }

            result = res + result;
            i--;
        }
        while (j >= 0) {
            int res = (int) (num2.charAt(j) - '0');
            if (carry) {
                res = res + 1;
                carry = false;
            }

            if (res >= 10) {
                carry = true;
                res = res % 10;
            }

            result = res + result;
            j--;
        }

        if (carry) {
            result = '1' + result;
        }

        return result;
    }
}
