import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Application {
    public static void main(String[] args) throws IOException {
        Random generator = new Random();
        int randomNumber = generator.nextInt(865) + 123; //   123~987 숫자 뽑기

        //String으로 변환 후, split 사용해서 배열로 쪼개자.
        String convertedNumber = Integer.toString(randomNumber);
        String[] arr = convertedNumber.split("");

        //중복 되면 다시 뽑기.
        int i = 1;
        while (i > 0) {
            if (!arr[0].equals(arr[1]) && !arr[0].equals(arr[2]) && !arr[1].equals(arr[2])
                    && Integer.parseInt(arr[0]) != 0 &&
                    Integer.parseInt(arr[1]) != 0 && Integer.parseInt(arr[2]) != 0) {
                System.out.println(convertedNumber);
                break;
            } else {
                randomNumber = generator.nextInt(865) + 123;
                convertedNumber = Integer.toString(randomNumber);
                arr = convertedNumber.split("");
            }
        }
        // 2단계

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputNumber; //  --> 이거반복해서 다시 뽑기

        //3단계     --   컴퓨터숫자는 스트링임.
        // 먼저 입력받은거 쪼개자

        int sum = 0;          // 스트라이크 개수
        int sum2 = 0;

        while (true) {
            System.out.println("숫자를 입력해주세요" + " " + ":" + " ");
            inputNumber = br.readLine();
            String[] inputNumberArr = inputNumber.split("");
            for (int j = 0; j < 3; j++) {
                if (arr[j].equals(inputNumberArr[j])) {
                    sum++;
                }
            }
            if (arr[0].equals(inputNumberArr[1]) || arr[0].equals(inputNumberArr[2])) {
                sum2++;
            }
            if (arr[1].equals(inputNumberArr[0]) || arr[1].equals(inputNumberArr[2]))
                sum2++;
            if (arr[2].equals(inputNumberArr[1]) || arr[2].equals(inputNumberArr[0]))
                sum2++;
            System.out.println(sum + " " + "스트라이크" + " " + sum2 + " " + "볼");
            sum = 0;
            sum2 = 0;

            if (convertedNumber.equals(inputNumber)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
        //last stage
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int oneTwo = Integer.parseInt(br.readLine());
        if (oneTwo == 1) {
            while (true) {
                System.out.println("숫자를 입력해주세요" + " " + ":" + " ");
                inputNumber = br.readLine();
                String[] inputNumberArr = inputNumber.split("");
                for (int j = 0; j < 3; j++) {
                    if (arr[j].equals(inputNumberArr[j])) {
                        sum++;
                    }
                }
                if (arr[0].equals(inputNumberArr[1]) || arr[0].equals(inputNumberArr[2])) {
                    sum2++;
                }
                if (arr[1].equals(inputNumberArr[0]) || arr[1].equals(inputNumberArr[2]))
                    sum2++;
                if (arr[2].equals(inputNumberArr[1]) || arr[2].equals(inputNumberArr[0]))
                    sum2++;
                System.out.println(sum + " " + "스트라이크" + " " + sum2 + " " + "볼");
                sum = 0;
                sum2 = 0;

                if (convertedNumber.equals(inputNumber)) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }
        }
        //last stage
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}

