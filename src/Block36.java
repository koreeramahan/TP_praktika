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
    static void checkPerfect (int perfect){
        int sum = 0;
        for (int i = 1; i < perfect; i++)
        {
            if (perfect%i==0) sum+=i;
        }
        if (sum==perfect) System.out.println("true");
        else System.out.println("false");
    }
    static void flipEndChars(String line)
    {
        if (line.length() < 2) System.out.println("Низя");
        if (line.charAt(0) == line.charAt(line.length()-1)) System.out.println("Первый и последний символы совпадают");
        System.out.println(line.charAt(line.length()-1) + line.substring(1, line.length()-1) + line.charAt(0));
    }
    static void isValidHexCode(String line)
    {
        if (line.length()!= 7 || line.charAt(0) != '#') System.out.println("false");
        for (int i = 1; i < line.length(); i++)
        {
            if (!( Character.isDigit(line.charAt(i))
                    || "ABCDEFabcdef".contains(Character.toString((line.charAt(i))))))
                System.out.println("false");
        }
        System.out.println("true");
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
        /////////////////////////////////////
        System.out.println("Задание 3");
        System.out.println("Совершенное ли число. Введите число:");
        int perfect = sc.nextInt();
        checkPerfect(perfect);
        /////////////////////////////////////
        System.out.println("Задание 4");
        System.out.println("Замена первого и последнего символа. Введите строку:");
        String line = sc.next();
        flipEndChars(line);
        /////////////////////////////////////
        System.out.println("Задание 5");
        System.out.println("Является ли строка допустимым 16ным кодом. Введите строку:");
        String line2 = sc.next();
        isValidHexCode(line2);
    }
}
