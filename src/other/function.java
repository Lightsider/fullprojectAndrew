package other;

/**
 * Created by andrey.popov on 10.07.2017.
 */
public class function {
    public static String randomString()
    {
        String symbols = "qwertyuiopasdfghjklzxcvbnm1234567890";
        StringBuilder randString = new StringBuilder();
        int count = (int) (Math.random() * 25);
        for (int i = 0; i < count; i++)
            randString.append(symbols.charAt((int) (Math.random() * symbols.length())));
        return randString.toString();
    }
}
