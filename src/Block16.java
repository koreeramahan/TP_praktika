import java.util.Scanner;

public class Block16 {

    static void remainder(double a,double b)
    {
        System.out.println("Остаток от деления "+a%b);
    }
    static void triArea(double a,double b)
    {
        System.out.println("Площадь треугольника "+a*b/2);
    }
    static void animals(int a,int b,int c)
    {
        System.out.println("Всего ножек у животных "+(a*2+b*4+c*4));
    }
    static void profitableGamble(double a,double b,double c)
    {
        if (a*b>c) System.out.println(true); else System.out.println(false);
    }
    static void operation(double N, double a, double b)
    {
        if ((a+b)==N) System.out.println("Числа надо сложить");
        else if ((a-b)==N) System.out.println("Числа надо вычесть");
        else if (a*b==N) System.out.println("Числа надо умножить");
        else if (a/b==N) System.out.println("Числа надо разделить");
        else System.out.println("Запрашиваемое число получить нельзя");
    }
    static void ascii(char c)
    {
        System.out.println("Значение ASCII: "+(int)c);
    }
    static void addUpTo(int a)
    {
        int res=0;
        for (int i=1;i<=a;i++) res+=i;
        System.out.println(res);
    }
    static void nextEdge(int a,int b)
    {
        System.out.println("Максимальное значение третьего ребра треугольника: "+(a+b-1));
    }
    static void sumOfCubes(int[] array,int n) {
        int res=0;
        for (int i=0; i < n; i++)
            res+=Math.pow(array[i],3);
        System.out.println("Сумма кубов элементов массива "+res);
    }
    static void numbers(int a, int b, int c)
    {
        int d=a;
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
        System.out.println("Задание 1");
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите делимое:");
        double a = sc.nextDouble();
        System.out.println("Введите делитель:");
        double b = sc.nextDouble();
        remainder(a,b);
        /////////////////////////////////////
        System.out.println("Задание 2");
        System.out.println("Введите основание треугольника");
        double a2 = sc.nextDouble();
        System.out.println("Введите высоту треугольника");
        double b2 = sc.nextDouble();
        triArea(a2,b2);
        /////////////////////////////////////
        System.out.println("Задание 3");
        System.out.println("Сколько у фермера курочек?");
        int a3 = sc.nextInt();
        System.out.println("Сколько у фермера коровок?");
        int b3 = sc.nextInt();
        System.out.println("Сколько у фермера свинок?");
        int c3 = sc.nextInt();
        animals(a3,b3,c3);
        /////////////////////////////////////
        System.out.println("Задание 4");
        System.out.println("Введите prob");
        double a4 = sc.nextDouble();
        System.out.println("Введите prize");
        double b4 = sc.nextDouble();
        System.out.println("Введите pay");
        double c4 = sc.nextDouble();
        profitableGamble(a4,b4,c4);
        /////////////////////////////////////
        System.out.println("Задание 5");
        System.out.println("Введите число, которое нужно получить");
        double N = sc.nextDouble();
        System.out.println("Введите первое число");
        double a5 = sc.nextDouble();
        System.out.println("Введите второе число");
        double b5 = sc.nextDouble();
        operation(N,a5,b5);
        /////////////////////////////////////
        System.out.println("Задание 6");
        System.out.println("Введите символ для перевода его в числовое значение ASCII");
        char c6 = sc.next().charAt(0);
        ascii(c6);
        /////////////////////////////////////
        System.out.println("Задание 7");
        System.out.println("Введите число, а я посчитаю сумму чисел от 1 до этого числа");
        int a7 = sc.nextInt();
        addUpTo(a7);
        /////////////////////////////////////
        System.out.println("Задание 8");
        System.out.println("Введите одну сторону треугольника");
        int a8 = sc.nextInt();
        System.out.println("Введите другую сторону треугольника");
        int b8 = sc.nextInt();
        nextEdge(a8,b8);
        /////////////////////////////////////
        System.out.println("Задание 9");
        System.out.println("Введите количество чисел в массиве");
        int n = sc.nextInt();
        int[] array = new int [n];
        for (int i=0; i < n; i++) {
            System.out.println("Введите число "+(i+1));
            array[i]=sc.nextInt();
        }
        sumOfCubes(array,n);
        /////////////////////////////////////
        System.out.println("Задание 10");
        System.out.println("Какое число будем прибавлять само к себе?");
        int a10 = sc.nextInt();
        System.out.println("Сколько раз?");
        int b10 = sc.nextInt();
        System.out.println("Получившееся число делим на");
        int c10 = sc.nextInt();
        numbers(a10,b10,c10);
    }
}


