package ua.com.alevel;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Chars {

    public static void main(String[] args) throws IOException {
        BufferedReader isolate = new BufferedReader(new InputStreamReader(System.in));
        DataInputStream in = new DataInputStream(System.in);
        while ( true ) {
            System.out.print("String: ");
            String str = in.readLine();
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