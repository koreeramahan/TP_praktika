import java.util.Scanner;

public class Block26 {
    static void repeat(){}
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
    static void cumulativeSum() {}
    static void getDecimalPlaces() {}
    static void fibonacci(){}
    static void isValid(){}
    static void isStrangePair(){}
    static void isPrefix(){}
    static void isSuffix(){}
    static void boxSeq(){}

    public static void main(String[] args) {
        System.out.println("Задание 1");
        Scanner sc = new Scanner(System.in);
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
    }
}


