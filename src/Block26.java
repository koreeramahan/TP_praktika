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
    //static void getDecimalPlaces(String str) {
        //String[] num = str.split(".");
        //System.out.println("Количество символов после точки: ");
    //}
    static void fibonacci(int n){
        int[] arr = new int[n];
        for (int i = 0; i <n; i++) {
            if (i==0) arr[0]=1;
            else if (i==1) arr[1]=2;
            else arr[i] = arr[i - 1] + arr[i - 2];
        }
        System.out.println("Соответствующее число Фибоначчи: "+arr[n-1]);
    }
    static void isValid(){}
    static void isStrangePair(){}
    static void isPrefix(){}
    static void isSuffix(){}
    static void boxSeq(){}

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
        //System.out.println("Задание 5");
        //System.out.println("Введите вещественное число, разделенное точкой");
        //String str = sc.next();
        //getDecimalPlaces(str);
        /////////////////////////////////////
        System.out.println("Задание 6");
        System.out.println("Числа Фибоначчи. Введите число: ");
        int n6 = sc.nextInt();
        fibonacci(n6);
    }
}


