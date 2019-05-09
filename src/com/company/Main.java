package com.company;
import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args){

        try {

            int number_of_used_posters = 0;
            Stack<Integer> stack = new Stack<>();
            File file = new File("src/pla.in");
            BufferedReader br = new BufferedReader(new FileReader((file)));
            String linia = br.readLine();
            StringTokenizer st = new StringTokenizer(linia);
            int number_of_buildings = Integer.parseInt(st.nextToken());

            for (int i = 0; i < number_of_buildings; i++) {
                linia = br.readLine();
                st = new StringTokenizer(linia);
                st.nextToken();
                int w = Integer.parseInt(st.nextToken());

                while (stack.empty() != true && stack.peek() > w)
                    stack.pop();

                if (stack.empty() == true || stack.peek() < w) {
                    stack.push(w);
                    number_of_used_posters++;
                }


            }

            FileWriter writer = new FileWriter("src/pla.out");
            writer.write(Integer.toString(number_of_used_posters));
            writer.close();

        } catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
