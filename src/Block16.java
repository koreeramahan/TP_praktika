import java.util.Scanner;

public class Block16 {

    static void remainder()
    {
        System.out.println("Задание 1");
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите делимое:");
        double a = sc.nextDouble();
        System.out.println("Введите делитель:");
        double b = sc.nextDouble();
        System.out.println("Остаток от деления "+a%b);
    }
    static void triArea()
    {
        System.out.println("Задание 2");
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите основание треугольника");
        double a = sc.nextDouble();
        System.out.println("Введите высоту треугольника");
        double b = sc.nextDouble();
        System.out.println("Площадь треугольника "+a*b/2);
    }
    static void animals()
    {
        System.out.println("Задание 3");
        Scanner sc = new Scanner(System.in);
        System.out.println("Сколько у фермера курочек?");
        int a = sc.nextInt();
        System.out.println("Сколько у фермера коровок?");
        int b = sc.nextInt();
        System.out.println("Сколько у фермера свинок?");
        int c = sc.nextInt();
        System.out.println("Всего ножек у животных "+(a*2+b*4+c*4));
    }
    static void profitableGamble()
    {
        System.out.println("Задание 4");
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите prob");
        double a = sc.nextDouble();
        System.out.println("Введите prize");
        double b = sc.nextDouble();
        System.out.println("Введите pay");
        double c = sc.nextDouble();
        if (a*b>c) System.out.println(true); else System.out.println(false);
    }
    static void operation()
    {
        System.out.println("Задание 5");
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число, которое нужно получить");
        double N = sc.nextDouble();
        System.out.println("Введите первое число");
        double a = sc.nextDouble();
        System.out.println("Введите второе число");
        double b = sc.nextDouble();
        if ((a+b)==N) System.out.println("Числа надо сложить");
        else if ((a-b)==N) System.out.println("Числа надо вычесть");
        else if (a*b==N) System.out.println("Числа надо умножить");
        else if (a/b==N) System.out.println("Числа надо разделить");
        else System.out.println("Запрашиваемое число получить нельзя");
    }
    static void ascii()
    {
        System.out.println("Задание 6");
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите символ для перевода его в числовое значение ASCII");
        char c = sc.next().charAt(0);
        System.out.println("Значение ASCII: "+(int)c);
    }
    static void addUpTo()
    {
        System.out.println("Задание 7");
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число, а я посчитаю сумму чисел от 1 до этого числа");
        int a = sc.nextInt();
        int res=0;
        for (int i=1;i<=a;i++) res+=i;
        System.out.println(res);
    }
    public static void main(String[] args) {
        remainder();
        triArea();
        animals();
        profitableGamble();
        operation();
        ascii();
        addUpTo();
    }
}


