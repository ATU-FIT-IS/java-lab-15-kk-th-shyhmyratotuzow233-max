import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 2. Екі санның үлкенін табу
        int a = sc.nextInt();
        int b = sc.nextInt();

        if (a > b) {
            System.out.println(a);
        } else if (b > a) {
            System.out.println(b);
        } else {
            System.out.println("Equal");
        }

        // 3. 1-ден N-ге дейінгі сандардың қосындысы
        int n = sc.nextInt();
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        System.out.println(sum);

        // 4. Факториалды есептеу
        int num = sc.nextInt();
        long fact = 1;

        for (int i = 1; i <= num; i++) {
            fact *= i;
        }
        System.out.println(fact);

        sc.close();
    }
}
