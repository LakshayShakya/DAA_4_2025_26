class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for (int pile : piles) {
            right = Math.max(pile, right);
        }
        while (left < right) {
            int mid = (left + right) / 2;
            if (canEat(piles, mid, h)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    boolean canEat(int[] piles, int speed, int h) {
        int totalSpeed = 0;
        for (int pile : piles) {
            totalSpeed += Math.ceil((double) pile / speed);
        }
        return totalSpeed <= h;
    }
}