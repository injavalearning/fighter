package Java.basic_grammar;

import java.util.Scanner;

public class tt {
    public static void main(String[] args) {
        StringBuffer s = null;
        StringBuilder ss = null;
        String sss = "";
        Object o = null;
        String str = "0,1 0,2";
        String[] line = str.split("\\s+");
        String[] s1 = line[0].split(",");
        String[] s2 = line[1].split(",");
        System.out.println(s1[0]+"sss"+s1[1]+"sss"+s2[1]);
        Scanner sc = new Scanner(System.in);
        int a = Integer.parseInt(sc.nextLine());
    }
}
