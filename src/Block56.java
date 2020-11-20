import java.util.Scanner;

public class Block56 {

    public static void canComplete(String not, String full)
    {
        int j = 0;
        for (int i = 0; i < full.length(); i++)
        {
            if (j >= not.length()) System.out.println("true");
            char ch = full.charAt(i);
            if (ch == not.charAt(j)) j++;
        }
        if (j == not.length()) System.out.println("true");
        else System.out.println("false");
    }

    public static void main(String[] args) {

        Scanner sc3 = new Scanner(System.in);
        System.out.println("Задание 3. Последнее слово содержит одни и те же гласные, значит строки рифмуются.");
        System.out.println("Введите две строки:");
        String not = sc3.next();
        String full = sc3.next();
        canComplete(not, full);

    }

}
