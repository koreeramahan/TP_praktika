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
        else System.out.println(str.indexOf("zip", index + 1));
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
        boolean res=true;
        if (line.length()!= 7 || line.charAt(0) != '#') {
            res = false;
            System.out.println("false");
        }
        else {
            for (int i = 1; i < line.length(); i++) {
                if (!(Character.isDigit(line.charAt(i))
                        || "ABCDEFabcdef".contains(Character.toString((line.charAt(i)))))) {
                    res = false;
                    System.out.println("false");
                    break;
                }
            }
            if (res) System.out.println("true");
        }
    }
    static void uniquesInArray(int[]array,int[]array2){
        int u=0; int p=0;
        for (int i=0; i<array.length-1; i++)
            if (array[i]!=array[i+1]) u++;
        for (int i=0; i<array2.length-1; i++)
            if (array2[i]!=array2[i+1]) p++;
        if (u==p) System.out.println("true");
        else System.out.println("false");
    }
    static void isKaprekar(int kap){
        int sqr=kap*kap;
        String sqr1=Integer.toString(sqr);
        String first="";
        String last="";
        first=sqr1.substring(0, sqr1.length()/2);
        last=sqr1.substring(sqr1.length()/2, sqr1.length());
        int a=first.equals("")?0:Integer.parseInt(first);
        int b=last.equals("")?0:Integer.parseInt(last);
        if (a+b==kap) System.out.println("true");
        else System.out.println("false");
    }
    static void longestZero(String line)
    {
        int zero1=0;
        int zero2=0;
        int k=1;
        if (line.charAt(0)=='0') zero1++;
        for (int i=1; i<line.length(); i++)
        {
            if (line.charAt(i)=='0') zero1++;
            else {
                if (zero1>zero2) {
                    zero2=zero1;
                    zero1=0;
                }
                k++;
            }
        }
        if (k==1) zero2=zero1;
        String res="";
        for (int i=0; i<zero2; i++)
            res+="0";
        System.out.println(res);
    }
    static void nextPrime (int n){
        boolean res=true;
        for (int i=2; i<Math.sqrt(n)+1; i++)
            if (n%i == 0) res=false;
        if (res) System.out.println(n);
        else {
            while (true) {
                n++;
                for (int i=2; i<Math.sqrt(n)+1; i++)
                    if (n%i == 0) res=false;
                if (res)
                {
                    System.out.println(n);
                    break;
                }
            }
        }
    }
    static void rightTriangle(int x,int y,int z){
        if ((x*x+y*y==z*z)||(x*x+z*z==y*y)||(y*y+z*z==x*x))
            System.out.println("true");
        else System.out.println("false");
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
        /////////////////////////////////////
        System.out.println("Задание 6");
        System.out.println("Введите количество чисел в первом массиве");
        int n = sc.nextInt();
        int[] array = new int [n];
        for (int i=0; i < n; i++) {
            System.out.println("Введите число "+(i+1));
            array[i]=sc.nextInt();
        }
        System.out.println("Введите количество чисел во втором массиве");
        int n1 = sc.nextInt();
        int[] array1 = new int [n1];
        for (int j=0; j < n1; j++) {
            System.out.println("Введите число "+(j+1));
            array1[j]=sc.nextInt();
        }
        uniquesInArray(array,array1);
        /////////////////////////////////////
        System.out.println("Задание 7");
        System.out.println("Число Капрекара. Введите число:");
        int kap = sc.nextInt();
        isKaprekar(kap);
        /////////////////////////////////////
        System.out.println("Задание 8");
        System.out.println("Самая длинная последовательность нулей. Введите двоичную строку:");
        String line3 = sc.next();
        longestZero(line3);
        /////////////////////////////////////
        System.out.println("Задание 9");
        System.out.println("Следующее простое число. Введите число:");
        int ch = sc.nextInt();
        nextPrime(ch);
        /////////////////////////////////////
        System.out.println("Задание 10");
        System.out.println("Являются ли x,y,z ребрами прямоугольного треугольника. Введите x,y,затем z:");
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        rightTriangle(x,y,z);
    }
}
