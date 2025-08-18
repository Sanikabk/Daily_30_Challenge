public class MergeSortedArraysInPlace {

    public static void merge(int[] arr1, int[] arr2, int m, int n) {
        int gap = (int) Math.ceil((double)(m + n) / 2);

        while (gap > 0) {
            int i = 0;
            int j = gap;

            while (j < (m + n)) {
                // Case 1: both pointers in arr1
                if (i < m && j < m) {
                    if (arr1[i] > arr1[j]) {
                        int temp = arr1[i];
                        arr1[i] = arr1[j];
                        arr1[j] = temp;
                    }
                }
                // Case 2: i in arr1, j in arr2
                else if (i < m && j >= m) {
                    if (arr1[i] > arr2[j - m]) {
                        int temp = arr1[i];
                        arr1[i] = arr2[j - m];
                        arr2[j - m] = temp;
                    }
                }
                // Case 3: both pointers in arr2
                else {
                    if (arr2[i - m] > arr2[j - m]) {
                        int temp = arr2[i - m];
                        arr2[i - m] = arr2[j - m];
                        arr2[j - m] = temp;
                    }
                }
                i++;
                j++;
            }

            // reduce gap
            if (gap == 1) {
                gap = 0;
            } else {
                gap = (int) Math.ceil((double) gap / 2);
            }
        }
    }

    public static void main(String[] args) {
        // Example Test Case
        Scanner sc= new Scanner(System.in);

        System.out.println("Enter the size of first array:");
        int m= sc.nextInt();
        int arr1[]= new int[m];
        System.out.println("Enter the size of second array:");
        int n= sc.nextInt();
        int arr2[]= new int[n];


        System.out.println("Enter the elements of first sorted array:");
        for (int i=0; i<arr1.length; i++)
        {
            arr1[i]=sc.nextInt();
        }

        System.out.println("Enter the elements of second sorted array:");
        for (int i=0; i<arr2.length; i++)
        {
            arr2[i]=sc.nextInt();
        }

        merge(arr1,arr2,m,n);

        System.out.print("[");
        for (int i=0; i<arr1.length; i++)
        {
            System.out.print(arr1[i]);
        }
        System.out.print("]");
        System.out.print("[");
        for (int i=0; i<arr2.length; i++)
        {
            System.out.print(arr2[i]);
        }
        System.out.print("]");
    }
}
