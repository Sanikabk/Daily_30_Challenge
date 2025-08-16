import java.util.Scanner;

public class MissingNo {
    
    public static void MissingNum(int arr[],int n)
    {
        int Total_sum= (n*(n+1))/2;
        int sum=0;
        for(int i=0; i<arr.length; i++)
        {
            sum=sum+arr[i];
        }
        int num= Total_sum-sum;
        System.out.println("The Missing Number is: "+num);
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        System.out.println("Enter the length of array:");
        int n= sc.nextInt();
        int arr[]=new int[n-1];
        for(int i=0; i<arr.length; i++){
            arr[i]=sc.nextInt();
        }

        MissingNum(arr,n);

    }
}
