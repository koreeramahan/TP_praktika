import java.util.Scanner;

public class Block36 {

    static void solutions (int a, int b, int c)
    {
        double D=b*b-4*a*c;
        if (D>0) System.out.println("2 Два решения");
        else if (D==0) System.out.println("1 Одно решение");
        else System.out.println("0 Нет решений");
    }
    static void findZip (String str)
    {
        int index = str.indexOf("zip");
        if (index == -1 || index == str.length() - 1) System.out.println("-1");
        System.out.println(str.indexOf("zip", index + 1));
    }
    public static void main(String[] args) {
        System.out.println("Задание 1");
        Scanner sc = new Scanner(System.in);
        System.out.println("Количество решений квадратного уравнения. Введите a,b,затем c: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        solutions(a,b,c);
        /////////////////////////////////////
        System.out.println("Задание 2");
        System.out.println("Позиция второго вхождения zip в строку. Введите строку:");
        String str = sc.next();
        findZip(str);
    }
}
