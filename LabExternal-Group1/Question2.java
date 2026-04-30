package DAA;

public class longestPalandrom {
    
    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public static int lps(String s) {
        int n = s.length();
        int max = 0;

        for (int mask = 0; mask < (1 << n); mask++) {
            String sub = "";
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    sub += s.charAt(i);
                }
            }
            if (isPalindrome(sub)) {
                max = Math.max(max, sub.length());
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "bbbab";
        System.out.println(lps(s));
    }
}

