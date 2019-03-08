package cn.letcode.my;

public class FullCharactor {

    public int max(int allowChanges, String s) {
        int c = maxLeft(allowChanges, s);
        int r = maxLeft(allowChanges, new StringBuilder(s).reverse().toString());
        if (c > r) {
            return c;
        }
        return r;
    }

    public int maxLeft(int allowChanges, String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char[] chars = s.toCharArray();
            int index = 0;

            for (int j = i; j < chars.length && index < allowChanges; j++) {
                if (chars[j] == '0') {
                    index++;
                    chars[j] = '1';
                }
            }

            char[] newChars = new char[chars.length - i];
            for (int k = 0; k < newChars.length; k++) {
                if ((i + k) < newChars.length) {
                    newChars[k] = chars[i + k];
                }
            }
            //System.out.println(new String(newChars));
            int temp = findMaxLength(newChars);
            if (max < temp) {
                max = temp;
            }
        }
        return max;
    }

    private int findMaxLength(char[] chars) {
        int max = 0;
        for (int i = 0; i < chars.length; i++) {
            int temp = 0;
            for (int j = i; j < chars.length; j++) {
                if (chars[j] == '1') {
                    temp++;
                    if (temp > max) {
                        max = temp;
                    }
                } else {
                    temp = 0;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "1110111000111111111";
        int count = new FullCharactor().max(2, s);
        System.out.println(count);

        int maxLength2 = new FullCharactor().findMaxLength2("110111".toCharArray());
        System.out.println(maxLength2);
    }


    private int findMaxLength2(char[] chars) {
        int max = 0;
        int temp = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1') {
                temp++;
                if (temp > max) {
                    max = temp;
                }
            } else {
                temp = 0;
            }
        }
        return max;
    }
}
