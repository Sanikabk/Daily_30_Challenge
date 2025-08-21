import java.util.*;

public class TrappingRainWater {

    // Function to calculate trapped water
    public static int trap(int[] height) {
        int n = height.length;
        if (n < 3) return 0; // need at least 3 bars to trap water

        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }

        return water;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        // Input array
        int[] height = new int[n];
        System.out.println("Enter elements of array:");
        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }

        // Calculate trapped water
        int result = trap(height);

        // Output result
        System.out.println("Total trapped water: " + result);

        sc.close();
    }
}
