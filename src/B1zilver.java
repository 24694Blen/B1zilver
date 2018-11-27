import java.util.Scanner;

public class B1zilver {

    private static String[] words = {"walvis", "kip", "paard", "varken", "duif", "zeehond" };
    private static String word = words[(int) (Math.random() * words.length)];
    private static String asterisk = new String(new char[word.length()]).replace("\0", "*");
    private static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (count < 7 && asterisk.contains("*")) {
            System.out.println("Raad een letter uit het word");
            System.out.println(asterisk);
            String guess = sc.next();
            hang(guess);
        }
        sc.close();
    }

    public static void hang(String guess) {
        String newasterisk = "";
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess.charAt(0)) {
                newasterisk += guess.charAt(0);
            } else if (asterisk.charAt(i) != '*') {
                newasterisk += word.charAt(i);
            } else {
                newasterisk += "*";
            }
        }

        if (asterisk.equals(newasterisk)) {
            count++;
            hangmanImage();
        } else {
            asterisk = newasterisk;
        }
        if (asterisk.equals(word)) {
            System.out.println("Correct! jij wint! het woord was " + word);
        }
    }

    public static void hangmanImage() {
        if (count == 1) {
            System.out.println("Fout probeer opnieuw");
            System.out.println("Je hebt nog 6 levens!");

        }
        if (count == 2) {
            System.out.println("Fout probeer opnieuw");
            System.out.println("Je hebt nog 5 levens!");

        }
        if (count == 3) {
            System.out.println("Fout probeer opnieuw");
            System.out.println("Je hebt nog 4 levens!");

        }
        if (count == 4) {
            System.out.println("Fout probeer opnieuw");
            System.out.println("Je hebt nog 3 levens!");

        }
        if (count == 5) {
            System.out.println("Fout probeer opnieuw");
            System.out.println("   Je hebt nog 2 levens!");}

        if (count == 6) {
            System.out.println("Fout probeer opnieuw");
            System.out.println("   Je hebt nog 1 levens!");}

        if (count == 7) {
            System.out.println("GAME OVER!");
            System.out.println("Je hebt  0 levens!");

            System.out.println("GAME OVER! het woord was " + word);
        }
    }
}