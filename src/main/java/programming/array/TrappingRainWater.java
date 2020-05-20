package programming.array;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * <p>
 * <p>
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 * <p>
 * <img src="../../../resources/rainwatertrap.png">
 * <p>
 * Example:
 * <p>
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        System.out.println(findTrappedRainWater(new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    /**
     *
     * @param height
     * @return
     */
    public static int findTrappedRainWater(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int ans = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (leftMax <= height[left]) {
                    leftMax = height[left];
                } else {
                    ans += leftMax - height[left];
                }
                left++;
            } else {
                if(rightMax <= height[right]) {
                    rightMax = height[right];
                } else {
                    ans += rightMax - height[right];
                }
                right--;
            }
        }
        return ans;
    }
}
