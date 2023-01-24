using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace day2 {
  public enum Choice {
    ROCK = 1,
    PAPER,
    SCISSORS
  }
  public static class Extensions {
    private static readonly int values = Enum.GetNames(typeof(Choice)).Length;
    public static int versus(this Choice choice, Choice opponent) {
      // 1 if this wins, 2 if opponent wins, 0 if tie
      return (values + (int)choice - (int)opponent) % values;
    }
  }
}