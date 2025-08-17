import java.util.Scanner;

public class FindDuplicate {
    public static int findDuplicate(int[] arr) {
         HashSet<Integer> map = new HashSet<>();
        for (int num : arr) {
            if (map.contains(num)) {
                return num;
            }
            map.add(num);
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array (n+1): ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter the elements of the array (values between 1 and n):");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int duplicate = findDuplicate(arr);
        System.out.println("The duplicate number is: " + duplicate);

        sc.close();
    }
}
