import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class Block46 {

    static void essay(int k, ArrayList<String> strArr){
        StringBuilder res = new StringBuilder();
        int count = k;
        Iterator<String> iter = strArr.iterator();
        String val = iter.next();
        res.append(val).append(" ");
        count -= val.length();
        while (iter.hasNext())
        {
            val = iter.next();
            if (count < val.length())
            {
                res.append('\n');
                count = k;
            }
            res.append(val).append(" ");
            count -= val.length();
        }
        System.out.println(res);
    }

    public static void split(String str)
    {
        StringBuilder res = new StringBuilder();
        int count = 0;
        for (int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
            res.append(ch);
            if (ch == '(') count++;
            else count--;
            if (count == 0) res.append(' ');
        }
        System.out.println(res);
    }

    public static void toCamelCase(String str)
    {
        StringBuilder res = new StringBuilder();
        boolean n = false;
        for (int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
            if (ch == '_') n = true;
            else if (n)
            {
                n = false;
                res.append((char)(ch-32));
            }
            else res.append(ch);
        }
        System.out.println(res);
    }

    public static void toSnakeCase(String str)
    {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
            if (ch>='A' && ch<='Z')
            {
                res.append('_');
                res.append((char)(ch+32));
            }
            else res.append(ch);
        }
        System.out.println(res);
    }

    public static void overTime(double start, double finish, double rate, double m)
    {
        double reg = 0;
        double over = 0;

        if (start<9 && finish<9) over = finish - start;
        else if (start<9 && finish>=9 && finish<=17)
        {
            over = 9-start;
            reg = finish-9;
        }
        else if (start<9 && finish>17)
        {
            over = 9-start+finish-17;
            reg = 9+17;
        }
        else if (start>=9 && start<=17 && finish>=9 && finish<=17)
        {
            reg = finish - start;
        }
        else if (start>=9 && start<=17 && finish>17)
        {
            reg = 17-start;
            over = finish-17;
        }
        else
        {
            over = finish-start;
        }
        System.out.println("$" + String.format("%.2f", reg*rate + over*rate*m));

    }

    public static void BMI(String height, String weight)
    {
        double w = Double.parseDouble(weight.split(" ")[0]);
        if (weight.endsWith("pounds"))
            w *= 0.45359237;
        double h = Double.parseDouble(height.split(" ")[0]);
        if (height.endsWith("inches"))
            h *= 0.0254;
        double index = w/(h*h);
        index = Math.round(index * 10)/10.0;
        String category;
        if (index < 18.5)
            category = "Underweight";
        else if (index < 25)
            category = "Normal weight";
        else category = "Overweight";
        System.out.println(index+" "+category);

    }

    public static void bugger(int n)
    {
        int count = 0;
        String str = Integer.toString(n);
        while (str.length()>1)
        {
            count++;
            int val = 1;
            for (int i = 0; i < str.length(); i++)
                val *= Integer.parseInt((str.substring(i, i+1)));
            str = Integer.toString(val);
        }
        System.out.println(count);
    }

    public static void toStarShorthand(String str)
    {
        StringBuilder res = new StringBuilder();
        int count = 1;
        char ch = '\0';
        for (int i = 0; i < str.length(); i++)
        {
            char newCh = str.charAt(i);
            if (newCh == ch) count++;
            else
            {
                if (count != 1)
                {
                    res.append('*');
                    res.append(count);
                    count = 1;
                }
                res.append(newCh);
                ch = newCh;
            }
        }
        if (count != 1)
        {
            res.append('*');
            res.append(count);
        }
        System.out.println(res);
    }

    public static void doesRhyme(String a, String b)
    {
        String lastA = a.substring(a.lastIndexOf(" ") + 1).toUpperCase();
        String lastB = b.substring(b.lastIndexOf(" ") + 1).toUpperCase();

        StringBuilder vowelsA = new StringBuilder();
        StringBuilder vowelsB = new StringBuilder();
        for (int i = 0; i < lastA.length(); i++)
            if ("AEIOUY".contains(lastA.substring(i, i+1)))
                vowelsA.append(lastA.charAt(i));
        for (int i = 0; i < lastB.length(); i++)
            if ("AEIOUY".contains(lastB.substring(i, i+1)))
                vowelsB.append(lastB.charAt(i));
        System.out.println (vowelsA.toString().equals(vowelsB.toString()));

    }

    public static void trouble(int a, int b)
    {
        String strA = Long.toString(a);
        String strB = Long.toString(b);
        boolean res=false;
        int[] repeatsA = new int[10];
        int[] repeatsB = new int[10];
        for (int i = 0; i < strA.length(); i++)
            repeatsA[Integer.parseInt(strA.substring(i, i+1))]++;
        for (int i = 0; i < strB.length(); i++)
            repeatsB[Integer.parseInt(strB.substring(i, i+1))]++;
        for (int i = 0; i < 10; i++)
                if (repeatsA[i] == 3 && repeatsB[i] == 2) res = true;
        System.out.println (res);
    }

    public static void countUniqueBooks(String str, char c)
    {
        boolean bookOpen = false;
        StringBuilder uniqueChars = new StringBuilder();
        String currentBook = "";
        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i) == c)
            {
                if (bookOpen) uniqueChars.append(currentBook);
                bookOpen = !bookOpen;
            }
            else
            {
                if (bookOpen)
                    if (!uniqueChars.toString().contains(str.substring(i, i+1))
                            && !currentBook.contains(str.substring(i, i+1)))
                        uniqueChars.append(str.charAt(i));
            }
        }
        System.out.println(uniqueChars.length());
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Задание 1. Сколько слов, размер строки, текст.");
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество слов и размер строки:");
        int n = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<String> strArr = new ArrayList<>(n);
        System.out.println("Введите текст:");
        for (int i = 0; i < n; i++) strArr.add(sc.next());
        essay(k, strArr);
        /////////////////////////////////////
        System.out.println("Задание 2. Группируем строку в кластер скобок.");
        System.out.println("Введите строку:");
        String str = sc.next();
        split(str);
        /////////////////////////////////////
        System.out.println("Задание 3. Преобразование в camel или snake case.");
        System.out.println("Введите строку:");
        String str1 = sc.next();
        if (str1.indexOf('_') != -1) toCamelCase(str1);
        else toSnakeCase(str1);
        /////////////////////////////////////
        System.out.println("Задание 4. Оплата сверхурочной работы.");
        System.out.println("Введите 4 значения:");
        double start = sc.nextDouble();
        double finish = sc.nextDouble();
        double rate = sc.nextDouble();
        double m = sc.nextDouble();
        overTime(start, finish, rate, m);
        /////////////////////////////////////
        System.out.println("Задание 5. Считаем ИМТ.");
        System.out.println("Введите рост и вес:");
        String h = sc.next();
        String w = sc.next();
        BMI(h, w);
        /////////////////////////////////////
        System.out.println("Задание 6. Перемножать цифры числа, пока не останется одна цифра.");
        System.out.println("Введите число:");
        int x = sc.nextInt();
        bugger(x);
        /////////////////////////////////////
        System.out.println("Задание 7. Звездная стенография, символ повторяется *n раз.");
        System.out.println("Введите строку:");
        String str3 = sc.next();
        toStarShorthand(str3);
        sc.close();
        /////////////////////////////////////
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Задание 8. Последнее слово содержит одни и те же гласные, значит строки рифмуются.");
        System.out.println("Введите две строки:");
        String str4 = sc1.next();
        String str5 = sc1.next();
        doesRhyme(str4, str5);
        sc1.close();
        /////////////////////////////////////
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Задание 9. В первом числе надо 3 повтора, во втором 2 повтора.");
        System.out.println("Введите два числа:");
        int y = sc2.nextInt();
        int z = sc2.nextInt();
        trouble(y,z);
        sc2.close();
        /////////////////////////////////////
        Scanner sc3 = new Scanner(System.in);
        System.out.println("Задание 10. Число уникальных книг.");
        System.out.println("Введите последовательность символов и символ, обозначающий начало/конец книги:");
        String str6 = sc3.next();
        char c = (char) System.in.read();
        countUniqueBooks(str6, c);
        sc3.close();
    }

}
