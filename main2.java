import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1-ден N-ге дейінгі жұп сандардың қосындысы
        int n = sc.nextInt();
        int sum = 0;

        for (int i = 2; i <= n; i += 2) {
            sum += i;
        }

        System.out.println(sum);

        sc.close();
    }
}
