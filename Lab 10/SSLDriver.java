/**
 * Drive I used for testing.
 */

public class SSLDriver {
    public static void main(String[] args) {
        SmartStringList test = new SmartStringList(1);
        test.add("Hi");
        test.add("You");
        test.add("Cutie");

        System.out.println(test.indexOf("You"));
        test.sort();
        System.out.println(test.indexOf("You"));
    }
}
