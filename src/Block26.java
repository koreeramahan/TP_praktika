import java.util.Scanner;

public class Block26 {
    static void repeat(char[] chars,int k){
        for (int i = 0; i < chars.length; i++) {
            for (int j=0; j<k; j++) System.out.print(chars[i]);
        }
        System.out.println();
    }
    static void differenceMaxMin(int[] array){
        int min=array[0]; int max=array[0];
        for (int i=0;i<array.length;i++)
        {
            if (min>array[i]) min=array[i];
            if (max<array[i]) max=array[i];
        }
        System.out.println("Наименьшее значение: "+min);
        System.out.println("Наибольшее значение: "+max);
        System.out.println("Разница между max и min значениями: " + (max-min));
    }
    static void isAvgWhole(int[] array){
        boolean res; double sum=0;
        for (int i=0;i<array.length;i++)
            sum+=array[i];
        double avg=sum/array.length;
        System.out.println("Среднее значение: "+avg);
        if (avg==(int)avg) res=true;
        else res=false;
        System.out.println("Среднее значение чисел массива имеет целое значение: "+res);
    }
    static void cumulativeSum(int[] array) {
        int n=array.length;
        int[] array1 = new int[n];
        System.out.println("Новый массив по принципу элемент+сумма предыдущих цифр:");
        int sum=0;
        for (int i=0; i<array.length;i++)
        {
            sum+=array[i];
            array1[i]=sum;
            System.out.print(array1[i] + " ");
        }
        System.out.println();
    }
    static void getDecimalPlaces(String str) {
        double x=Double.valueOf(str);
        if (x%1==0)
            System.out.println("Количество символов после точки: 0");
        else
            System.out.println("Количество символов после точки: " + str.split("\\.")[1].length());
    }
    static void fibonacci(int n){
        int[] arr = new int[n];
        for (int i = 0; i <n; i++) {
            if (i==0) arr[0]=1;
            else if (i==1) arr[1]=2;
            else arr[i] = arr[i - 1] + arr[i - 2];
        }
        System.out.println("Соответствующее число Фибоначчи: "+arr[n-1]);
    }
    static void isValid(String str){
        char[] charm = str.toCharArray();
        boolean res=true;
        for (int i=0; i<charm.length; i++) {
            if (Character.isDigit(charm[i])==false)
            {
                res=false;
                break;
            }
        }
        if (charm.length!=5) res=false;
        System.out.println("Почтовый индекс " + res);
    }
    static void isStrangePair(String w1, String w2){
        if ((w1.charAt(0) == w2.charAt((w2.length()-1)))
            && (w2.charAt(0) == w1.charAt((w1.length()-1))))
                System.out.println("Данные слова образуют странную пару");
        else System.out.println("Данные слова НЕ образуют странную пару");
    }
    static void isPrefix(String word, String fix){
        boolean res = true;
        String sub_str = fix.substring(0,fix.length()-2);
        for (int i = 0; i < sub_str.length(); i++) {
            if (sub_str.charAt(i) != word.charAt(i)) {
                res = false;
                break;
            }
        }
        System.out.println("Префикс: " + res);
    }
    static void isSuffix(String word, String fix){
        boolean res = true;
        String sub_str = fix.substring(1,fix.length());
        int j = sub_str.length()-1;
        for (int i = word.length()-1; i > sub_str.length(); i--)
        {
            if (j < 0) res=true;
            if (sub_str.charAt(j) != word.charAt(i)) res = false;
            j--;
        }
        System.out.println("Суффикс: " + res);
    }
    static void boxSeq(int h){
        int sum=0;
        for (int i=0; i<=h; i++)
        {
            if (i==0) sum=0;
            else {
                if (i % 2 != 0) sum += 3;
                else sum -= 1;
            }
        }
        System.out.println("Количество полей: " + sum);
    }

    public static void main(String[] args) {
        System.out.println("Задание 1");
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку символов: ");
        String line = sc.next();
        char[] chars = line.toCharArray();
        System.out.println("Сколько раз повторить каждый символ? ");
        int k = sc.nextInt();
        repeat(chars,k);
        /////////////////////////////////////
        System.out.println("Задание 2");
        System.out.println("Введите количество чисел в массиве");
        int n = sc.nextInt();
        int[] array = new int [n];
        for (int i=0; i < n; i++) {
            System.out.println("Введите число "+(i+1));
            array[i]=sc.nextInt();
        }
        differenceMaxMin(array);
        /////////////////////////////////////
        System.out.println("Задание 3");
        System.out.println("Введите количество чисел в массиве");
        int n2 = sc.nextInt();
        int[] array2 = new int [n2];
        for (int i=0; i < n2; i++) {
            System.out.println("Введите число "+(i+1));
            array2[i]=sc.nextInt();
        }
        isAvgWhole(array2);
        /////////////////////////////////////
        System.out.println("Задание 4");
        System.out.println("Введите количество чисел в массиве");
        int n3 = sc.nextInt();
        int[] array3 = new int [n3];
        for (int i=0; i < n3; i++) {
            System.out.println("Введите число "+(i+1));
            array3[i]=sc.nextInt();
        }
        cumulativeSum(array3);
        /////////////////////////////////////
        System.out.println("Задание 5");
        System.out.println("Введите вещественное число, разделенное точкой");
        String str = sc.next();
        getDecimalPlaces(str);
        /////////////////////////////////////
        System.out.println("Задание 6");
        System.out.println("Числа Фибоначчи. Введите число: ");
        int n6 = sc.nextInt();
        fibonacci(n6);
        /////////////////////////////////////
        System.out.println("Задание 7");
        System.out.println("Введите почтовый индекс: ");
        String str1 = sc.next();
        isValid(str1);
        /////////////////////////////////////
        System.out.println("Задание 8. Образуют ли слова странную пару?");
        System.out.println("Введите первое слово: ");
        String w1 = sc.next();
        System.out.println("Введите второе слово: ");
        String w2 = sc.next();
        isStrangePair(w1,w2);
        /////////////////////////////////////
        System.out.println("Задание 9. Суффикс или префикс");
        System.out.println("Введите слово: ");
        String word = sc.next();
        System.out.println("Введите суффикс(начинается с -) или префикс(кончается -): ");
        String fix = sc.next();
        if (fix.charAt(0) == '-')
            isSuffix(word,fix);
        else if (fix.charAt(fix.length()-1) == '-')
            isPrefix(word,fix);
        else System.out.println("Суффикс или префикс не введены");
        /////////////////////////////////////
        System.out.println("Задание 10");
        System.out.println("Введите шаг: ");
        int h = sc.nextInt();
        boxSeq(h);
    }
}


