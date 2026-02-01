import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int maxLength = 0;
        int balance = 0;

        Map<Integer, Integer> firstOccurrence = new HashMap<>();
        firstOccurrence.put(0, -1);

        for (int i = 0; i < n; i++) {
            String record = sc.nextLine().trim();

            if (record.equals("P")) {
                balance++;
            } else {
                balance--;
            }

            if (firstOccurrence.containsKey(balance)) {
                int windowLength = i - firstOccurrence.get(balance);
                maxLength = Math.max(maxLength, windowLength);
            } else {
                firstOccurrence.put(balance, i);
            }
        }

        System.out.println(maxLength);
    }
}