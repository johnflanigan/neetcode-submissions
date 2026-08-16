class Solution {
    public int reverse(int x) {
    
        String number = "";

        int pos = Math.abs(x);

        while (pos > 0) {

            int digit = pos % 10;
            pos = pos / 10;

            number = number + digit;
        }

        try {
            int num = Integer.parseInt(number);
            if (x < 0) {
                return 0 - num;
            }
            return num;
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
}
