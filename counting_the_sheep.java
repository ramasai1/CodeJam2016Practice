import java.util.*;
public class question1 {
    private static int[] num_to_array(int num) {
        int length = String.valueOf(num).length();
        int[] num_array = new int[length];
        for(int i = 0; i < length; i++) {
            int digit = num % 10;
            num_array[i] = digit;
            num /= 10;
        }
        for (int i = 0; i < num_array.length / 2; i++) {
            int temp = num_array[i];
            num_array[i] = num_array[num_array.length - 1 - i];
            num_array[num_array.length - 1 - i] = temp;
        }
        return num_array;
    }

    private static boolean are_nums_there(Set<Integer> num_set) {
        if (num_set.contains(0)) if (num_set.contains(1)) if (num_set.contains(2)) if (num_set.contains(3))
            if (num_set.contains(4)) if (num_set.contains(5)) if (num_set.contains(6))
                if (num_set.contains(7)) if (num_set.contains(8)) if (num_set.contains(9)) return true;
        return false;
    }

    public static void main(String[] args) {
        int track = 1;
        Set<Integer> num_set = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        int num_test_cases = scanner.nextInt();
        int[] test_cases = new int[num_test_cases];
        for(int i = 0; i < num_test_cases; i++)
            test_cases[i] = scanner.nextInt();

        for(int test_case : test_cases) {
            if (test_case == 0)
                System.out.println("Case #" + track + ": INSOMNIA");
            else {
                for (int i = 1; ; i++) {
                    int to_check = i * test_case;
                    int[] array_num = num_to_array(to_check);
                    for (int j = 0; j < array_num.length; j++)
                        num_set.add(array_num[j]);

                    if (are_nums_there(num_set)) {
                        System.out.println("Case #" + track + ": " + to_check);
                        num_set.clear();
                        break;
                    }
                }
            }
            track++;
        }
    }
}
