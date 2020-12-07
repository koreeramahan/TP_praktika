import java.util.Scanner;

public class Block66 {
    public static void bell(int n) {

    }

    public static void translateWord(String str) {

    }

    public static void translateSentence(String sent) {

    }

    public static void validColor(String col) {

    }

    public static void stripUrlParams(String url) {

    }

    public static void getHashTags(String tag) {

    }

    public static void ulam(int u) {

    }

    public static void longestNonrepeatingSubstring(String repeat){

    }

    public static void convertToRoman(int arab) {

    }

    public static void formula(String f) {

    }

    public static void palindromeDescendant(int p) {

    }

    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Задание 1. Число Белла. Введите число:");
        int n = sc1.nextInt();
        bell(n);
        ///////////////////////////////////////
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Задание 2. Свинский латинский. Введите слово: ");
        String str = sc2.next();
        translateWord(str);
        System.out.println("Введите предложение: ");
        String sent = sc2.nextLine();
        translateSentence(sent);
        ///////////////////////////////////////
        Scanner sc3 = new Scanner(System.in);
        System.out.println("Задание 3. RGB. Введите строку:");
        String col = sc3.next();
        validColor(col);
        ///////////////////////////////////////
        Scanner sc4 = new Scanner(System.in);
        System.out.println("Задание 4. Введите URL:");
        String url = sc4.next();
        stripUrlParams(url);
        ////////////////////////////////////////
        Scanner sc5 = new Scanner(System.in);
        System.out.println("Задание 5. Хештеги. Введите предложение:");
        String tag = sc5.nextLine();
        getHashTags(tag);
        ////////////////////////////////////////
        Scanner sc6 = new Scanner(System.in);
        System.out.println("Задание 6. Последовательность Улама. Введите число:");
        int u = sc6.nextInt();
        ulam(u);
        ////////////////////////////////////////
        Scanner sc7 = new Scanner(System.in);
        System.out.println("Задание 7. Самая длинная неповторяящаяся подстрока строки:");
        String repeat = sc7.next();
        longestNonrepeatingSubstring(repeat);
        ////////////////////////////////////////
        Scanner sc8 = new Scanner(System.in);
        System.out.println("Задание 8. Преобразование в римское число. Введите арабское число::");
        int arab = sc8.nextInt();
        convertToRoman(arab);
        ////////////////////////////////////////
        Scanner sc9 = new Scanner(System.in);
        System.out.println("Задание 9. Правильная ли формула. Введите формулу: ");
        String f = sc9.nextLine();
        formula(f);
        ////////////////////////////////////////
        Scanner sc10 = new Scanner(System.in);
        System.out.println("Задание 10. Число и его потомк - палиндромы. Введите число: ");
        int p = sc10.nextInt();
        palindromeDescendant(p);
    }
}
