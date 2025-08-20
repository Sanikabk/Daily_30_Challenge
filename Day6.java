import java.util.*;

public class ZeroSumSubarrays {

    // Function to find all subarrays with sum 0
    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        List<int[]> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        int sum = 0;
        
        // Initialize with sum = 0 at index -1
        map.put(0, new ArrayList<>());
        map.get(0).add(-1);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // If sum is already present, it means subarray(s) exist
            if (map.containsKey(sum)) {
                for (int startIndex : map.get(sum)) {
                    result.add(new int[]{startIndex + 1, i});
                }
            }

            // Add current index to the list for this sum
            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }
        
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        // Input array
        int[] arr = new int[n];
        System.out.println("Enter elements of array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Find subarrays with sum 0
        List<int[]> subarrays = findZeroSumSubarrays(arr);

        // Output result
        if (subarrays.isEmpty()) {
            System.out.println("No subarrays with zero sum found.");
        } else {
            System.out.println("Subarrays with zero sum:");
            for (int[] pair : subarrays) {
                System.out.println("(" + pair[0] + ", " + pair[1] + ")");
            }
        }

        sc.close();
    }
}
