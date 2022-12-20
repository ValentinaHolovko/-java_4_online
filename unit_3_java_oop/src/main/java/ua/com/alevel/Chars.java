package ua.com.alevel;

import java.util.*;


public class Chars {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while ( true ) {
            System.out.print("String: ");
            String str = scanner.nextLine();
            if ( "".equals(str) )
                break;

            Map<Character, Integer> map = new TreeMap<>();
            for ( char c : str.toCharArray() )
                map.put(c, ( map.containsKey(c) ) ? map.get(c) + 1 : 1);

            StringBuilder sb = new StringBuilder();
            for ( char c : map.keySet() )
                sb.append(c);
            System.out.println("Unique characters: \"" + sb.toString() + "\"");
            for ( char c : map.keySet() )
                System.out.printf("'%c'\t%d\n", c, map.get(c));

            System.out.println();
        }
    }

}