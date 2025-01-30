public class Main {
    // 싱기한 네자리 숫자 - https://www.acmicpc.net/problem/6679

    public static void main(String[] args) {
        for (int num = 1000; num <= 9999; num++) {
            if (getDigitSum(num, 10) == getDigitSum(num, 12) &&
                    getDigitSum(num, 12) == getDigitSum(num, 16)) {
                System.out.println(num);
            }
        }
    }

    private static int getDigitSum(int num, int base) {
        int sum = 0;
        while (num > 0) {
            sum += num % base;
            num /= base;
        }
        return sum;
    }
}
