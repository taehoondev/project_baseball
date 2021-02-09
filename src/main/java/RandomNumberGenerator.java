import java.util.Random;

public class RandomNumberGenerator {

    public static int generate() {
        Random random = new Random();
        int randomNumber = random.nextInt(864);
        randomNumber = randomNumber + 123;
        return randomNumber;
    }
}
