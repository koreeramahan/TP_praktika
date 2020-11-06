import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashSet;

public class Block46 {

    static void essay(int k, ArrayList<String> strArr){
        String res = "";
        int count = k;
        Iterator<String> it = strArr.iterator();
        String val = it.next();
        res += val + " ";
        count -= val.length();
        while (it.hasNext())
        {
            val = it.next();
            if (count < val.length())
            {
                res += '\n';
                count = k;
            }
            res += val + " ";
            count -= val.length();
        }
        System.out.println(res);
    }

    public static void split(String str)
    {
        String res = "";
        int count = 0;
        for (int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
            res += ch;
            if (ch == '(') count++;
            else count--;
            if (count == 0) res += ' ';
        }
        System.out.println(res);
    }

    public static void toCamelCase(String str)
    {
        String res = "";
        boolean newWord = false;
        for (int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
            if (ch == '_') newWord = true;
            else if (newWord)
            {
                newWord = false;
                res += (char)(ch-32);
            }
            else res += ch;
        }
        System.out.println(res);
    }

    public static void toSnakeCase(String str)
    {
        String res = "";
        for (int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
            if (ch >= 'A' && ch <= 'Z')
            {
                res += '_';
                res += (char)(ch+32);
            }
            else res += ch;
        }
        System.out.println(res);
    }

    public static void overTime(double start, double finish, double rate, double mult)
    {
        double reg = 0;
        double over = 0;
        final int G_START = 9;
        final int G_FINISH = 17;
        if (start < G_START && finish < G_START) over = finish - start;
        else if (start < G_START && finish >= G_START && finish <= G_FINISH)
        {
            over = G_START - start;
            reg = finish - G_START;
        }
        else if (start < G_START && finish > G_FINISH)
        {
            over = G_START - start + finish - G_FINISH;
            reg = G_START + G_FINISH;
        }
        else if (start >= G_START && start <= G_FINISH && finish >= G_START && finish <= G_FINISH)
        reg = finish - start;
        else if (start >= G_START && start <= G_FINISH && finish > G_FINISH)
        {
            reg = G_FINISH - start;
            over = finish - G_FINISH;
        }
        else over = finish - start;
        System.out.println("$" + String.format("%.2f", reg*rate + over*rate*mult));
    }

    public static void BMI(double w, double h)
    {
        double val = w / (h*h);
        String res = String.format("%.1f", val);
        if (val < 18.5) res += " Underweight";
        else if (val >= 18.5 && val < 25) res += " Normal weight";
        else res += " Overweight";
        System.out.println(res);
    }

    public static void bugger(int n)
    {
        int count = 0;
        String str = Integer.toString(n);
        while (str.length() > 1)
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
        String res = "";
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
                    res += '*';
                    res += Integer.toString(count);
                    count = 1;
                }
                res += newCh;
                ch = newCh;
            }
        }
        if (count != 1)
        {
            res += '*';
            res += Integer.toString(count);
        }
        System.out.println(res);
    }

    public static void doesRhyme(String str1, String str2)
    {
        int index;
        index = str1.lastIndexOf(' ');
        if (index == -1) index = 0;
        String word1 = str1.substring(index+1).toUpperCase();
        index = str2.lastIndexOf(' ');
        if (index == -1) index = 0;
        String word2 = str2.substring(index+1).toUpperCase();
        String check = "";
        for (int i = 0; i < word1.length(); i++)
        {
            char ch = word1.charAt(i);
            if (ch == 'E' || ch == 'Y' || ch == 'U' || ch == 'O' || ch == 'A' || ch == 'I')
            check += ch;
        }
        int count = 0;
        for (int i = 0; i < word2.length(); i++)
        {
            char ch = word2.charAt(i);
            if (ch == 'E' || ch == 'Y' || ch == 'U' || ch == 'O' || ch == 'A' || ch == 'I')
            {
                if (count >= check.length()) System.out.println("false");
                else if (ch != check.charAt(count)) System.out.println("false");
                count++;
            }
        }
        System.out.println("true");
    }

    public static void trouble(int a, int b)
    {
        String str1 = Integer.toString(a);
        String str2 = Integer.toString(b);
        char number = '\0';
        int count = 0;
        for (int i = 0; i < str1.length(); i++)
        {
            char ch = str1.charAt(i);
            if (ch == number) count++;
            else
            {
                number = ch;
                count = 0;
            }
            if (count == 2)
            {
                if (str2.indexOf(String.copyValueOf(new char[] {number, number})) != -1)
                    System.out.println("true");
                else count = 0;
            }
        }
        System.out.println("false");
    }

    public static void countUniqueBooks(String str, String endChar)
    {
        int count = 0;
        boolean open = false;
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
            if (!open && ch == endChar.charAt(0)) open = true;
            else if (open)
            {
                if (ch != endChar.charAt(0))
                {
                    if (!set.contains(ch))
                    {
                        set.add(ch);
                        count++;
                    }
                }
                else
                {
                    open = false;
                    set.clear();
                }
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        System.out.println("Задание 1");
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество слов и размер строки:");
        int n = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<String> strArr = new ArrayList<>(n);
        System.out.println("Введите текст:");
        for (int i = 0; i < n; i++) strArr.add(sc.next());
        essay(k, strArr);
        /////////////////////////////////////
        System.out.println("Задание 2");
        System.out.println("Введите строку:");
        String str = sc.next();
        split(str);
        /////////////////////////////////////
        System.out.println("Задание 3");
        System.out.println("Введите строку:");
        String str1 = sc.next();
        if (str1.indexOf('_') != -1) toCamelCase(str1);
        else toSnakeCase(str1);
        /////////////////////////////////////
        System.out.println("Задание 4");
        System.out.println("Введите 4 значения:");
        double start = sc.nextDouble();
        double finish = sc.nextDouble();
        double rate = sc.nextDouble();
        double mult = sc.nextDouble();
        overTime(start, finish, rate, mult);
        /////////////////////////////////////
        System.out.println("Задание 5");
        System.out.println("Введите рост и вес:");
        double h = sc.nextDouble();
        double w = sc.nextDouble();
        BMI(h, w);
        /////////////////////////////////////
        System.out.println("Задание 6");
        System.out.println("Введите число:");
        int x = sc.nextInt();
        bugger(x);
        /////////////////////////////////////
        System.out.println("Задание 7");
        System.out.println("Введите строку:");
        String str3 = sc.next();
        toStarShorthand(str3);
        /////////////////////////////////////
        System.out.println("Задание 8");
        System.out.println("Введите две строки:");
        String str4 = sc.nextLine();
        String str5 = sc.nextLine();
        doesRhyme(str4, str5);
        /////////////////////////////////////
        System.out.println("Задание 9");
        System.out.println("Введите два числа:");
        int y = sc.nextInt();
        int z = sc.nextInt();
        trouble(y,z);
        /////////////////////////////////////
        System.out.println("Задание 10");
        System.out.println("Введите последовательность символов и символ, обозначающий начало/конец книги:");
        String str6 = sc.next();
        String endChar = sc.next();
        countUniqueBooks(str6, endChar);
    }

}
