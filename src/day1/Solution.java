package day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
  public static void main(String[] args) {
    task1();
  }
  public static void task1() {
    try(BufferedReader reader = new BufferedReader(new FileReader("src/day1/input.txt"))) {
      int mostCalories = 0;
      int currentElf = 0;
      String food = reader.readLine();

      while(food != null) {
        if(food.equals("")) {
          if(currentElf > mostCalories) {
            mostCalories = currentElf;
          }
          currentElf = 0;
        }
        else {
          currentElf += Integer.parseInt(food);
        }
        food = reader.readLine();
      }

      System.out.println(mostCalories);
    }
    catch(IOException e) {
      e.printStackTrace();
    }
  }
}
