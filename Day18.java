import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int count = 0;
        
        for (long i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                count += (i * i == n) ? 1 : 2;
            }
        }
        
        System.out.println(count);
    }
}
