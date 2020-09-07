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
    static void nextEdge()
    {
        System.out.println("Задание 8");
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите одну сторону треугольника");
        int a = sc.nextInt();
        System.out.println("Введите другую сторону треугольника");
        int b = sc.nextInt();
        System.out.println("Максимальное значение третьего ребра треугольника: "+(a+b-1));
    }
    static void sumOfCubes() {
        System.out.println("Задание 9");
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество чисел в массиве");
        int n = sc.nextInt();
        int[] array = new int [n];
        int res=0;
        for (int i=0; i < n; i++) {
            System.out.println("Введите число "+(i+1));
            array[i]=sc.nextInt();
            res+=Math.pow(array[i],3);
        }
        System.out.println("Сумма кубов элементов массива "+res);
    }
    static void numbers()
    {
        System.out.println("Задание 10");
        Scanner sc = new Scanner(System.in);
        System.out.println("Какое число будем прибавлять само к себе?");
        int a = sc.nextInt();
        System.out.println("Сколько раз?");
        int b = sc.nextInt();
        System.out.println("Получившееся число делим на");
        int c = sc.nextInt(); int d=a;
        for (int i=1;i<=b;i++)
        {
            d+=a;
            a=d;
            System.out.println("Промежуточный результат "+i+" = "+d);
        }
        if (d%c==0) System.out.println("Полученное число делится на "+c);
        else System.out.println("Полученное число не делится на "+c);
    }
    public static void main(String[] args) {
        remainder();
        triArea();
        animals();
        profitableGamble();
        operation();
        ascii();
        addUpTo();
        nextEdge();
        sumOfCubes();
        numbers();
    }
}


