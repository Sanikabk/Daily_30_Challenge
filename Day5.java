import java.util.Scanner;
public class Leaders {

    public static void findleader(int arr[])
    {
        int k=0;
        int n= arr.length;
        int leaders[]= new int[arr.length];
        leaders[k++]=arr[n-1];
        for(int i=n-2; i>=0; i--)
        {
            if(arr[i]>leaders[k-1])
            {
                leaders[k++]=arr[i];
            }
        }

        System.out.print("[");
        for (int i = k - 1; i >= 0; i--) {
            System.out.print(leaders[i]);
            if (i != 0) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the size of an array: ");
        int n=sc.nextInt();
        int arr[]= new int[n];

        System.out.println("Enter the elements in an array:");
        for (int i=0; i<arr.length; i++)
        {
            arr[i]=sc.nextInt();
        }

        findleader(arr);
    }
}
