package com.luke.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleUtil{
    public static BufferedReader br;

    public ConsoleUtil(){
        if(br==null){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
    }

    public static void output(String output){
        System.out.println(output);
    }

    public static void input() throws IOException {
        String line;
        while((line=br.readLine())!=null){
            System.out.println(line);
        }
    }

    public void destroy(){
        if(br!=null){
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
