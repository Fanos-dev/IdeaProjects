import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(fib(100));
    }

    public static long fib(long n ) {
        long f0 = 0; // For fib(0)
        long f1 = 1; // For fib(1)
        long f2 = 1; // For fib(2)
        if (n == 0)
            return f0;
        else if (n == 1)
            return f1;
        else if (n == 2)
            return f2;
        for (int i = 3; i <= n; i++) {
            f0 = f1;
            f1 = f2;
            f2 = f0 + f1;
        }
        return f2;

        Map<String, Integer> map = new HashMap<>();

        map.get
    }
}