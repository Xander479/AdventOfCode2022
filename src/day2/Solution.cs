﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace day2 {
  public class Solution {
    public static void Main(string[] args) {
      task1();
      task2();
    }

    public static void task1() {
      using StreamReader reader = File.OpenText("input.txt"); // May have to move input.txt to whichever directory you're running from
      int score = 0;
      string? line = String.Empty;
      while((line = reader.ReadLine()) != null) {
        Choice opponent = line.Split(' ')[0] switch {
          "A" => Choice.ROCK,
          "B" => Choice.PAPER,
          "C" => Choice.SCISSORS,
          _ => throw new Exception("Unexpected input")
        };
        Choice me = line.Split(' ')[1] switch {
          "X" => Choice.ROCK,
          "Y" => Choice.PAPER,
          "Z" => Choice.SCISSORS,
          _ => throw new Exception("Unexpected input")
        };
        switch(me.versus(opponent)) {
          case 0: // draw
            score += (int)me + 3;
            break;
          case 1: // win
            score += (int)me + 6;
            break;
          case 2: // loss
            score += (int)me;
            break;
          default:
            throw new Exception("value = " + me.versus(opponent));
        }
      }

      Console.WriteLine(score);
    }

    public static void task2() { }
  }
}
