package day1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
  public static void main(String[] args) {
    task1();
    task2();
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

  public static void task2() {
    class Elf implements Comparable<Elf> {
      private int calories;
      Elf(int calories) {
        this.calories = calories;
      }

      int getCalories() {
        return calories;
      }

      @Override
      public int compareTo(Elf o) {
        return this.calories - o.calories;
      }

      @Override
      public boolean equals(Object o) {
        if(o == null || !(this.getClass().equals(o.getClass()))) return false;
        return this.calories == ((Elf) o).calories;
      }

      @Override
      public int hashCode() {
        return this.calories;
      }
    }

    ArrayList<Elf> elves = new ArrayList<Elf>();
    try(BufferedReader reader = new BufferedReader(new FileReader("src/day1/input.txt"))) {
      int currentElf = 0;
      String food = reader.readLine();

      while(food != null) {
        if(food.equals("")) {
          elves.add(new Elf(currentElf));
          currentElf = 0;
        }
        else {
          currentElf += Integer.parseInt(food);
        }
        food = reader.readLine();
      }
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    Collections.sort(elves, Collections.reverseOrder());
    int total = 0;
    for(int i = 0; i < 3; i++) {
      total += elves.get(i).calories;
    }
    System.out.println(total);
  }
}
