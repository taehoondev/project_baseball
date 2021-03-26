# java-baseball test

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class baseballGame {

    public static int getNumber() {                     // 15번 중 1번 오류
        Random random = new Random();

        while (true) {
            String randomNumber = String.valueOf(random.nextInt((865) + 123));
            String arrayNumber[] = randomNumber.split("");
            if (!arrayNumber[0].equals(arrayNumber[1]) && !arrayNumber[0].equals(arrayNumber[2]) && !arrayNumber[1].equals(arrayNumber[2])
                    && !arrayNumber[0].equals("0") && !arrayNumber[1].equals("0") && !arrayNumber[2].equals("0")) {
                return Integer.parseInt(randomNumber);
            } else continue;
        }
    }

    public static int inputNumber() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int inputNumber = Integer.parseInt(bufferedReader.readLine());
            if (((int) Math.log10(inputNumber) + 1 == 3) && isNumber(String.valueOf(inputNumber))) {
                    return inputNumber;
            } else {
                System.out.println("세자리 숫자를 다시 입력하여 주십시오.");
                continue;
            }
        }
    }

    public static void printResult() throws IOException {
        String convertedLetter = String.valueOf(getNumber());
        String[] arr1 = convertedLetter.split("");


        while (true) {
            System.out.println("숫자를 입력해주세요 :" + " ");
            String convertedInputnumber = String.valueOf(inputNumber());
            String[] arr2 = convertedInputnumber.split("");

            int countStrike = 0;
            int countBall = 0;

            for (int i = 0; i < 3; i++) {
                if (arr1[i].equals(arr2[i]))
                    countStrike++;
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == j) continue;
                    else if (arr1[i].equals(arr2[j]))
                        countBall++;
                }
            }

            System.out.println(countStrike + " " + "스트라이크" + " " + countBall + "볼");

            if (countStrike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                Scanner scanner = new Scanner(System.in);
                int result = scanner.nextInt();
                if (result == 1) {
                    printResult();
                } else if (result == 2) {
                    System.out.println("게임 종료을 종료하였습니다.");
                    break;
                }
            }
        }
    }

    public static boolean isNumber(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        getNumber();
        printResult();
    }
}
