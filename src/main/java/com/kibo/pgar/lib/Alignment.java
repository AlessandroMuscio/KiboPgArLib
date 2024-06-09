package com.kibo.pgar.lib;

public enum Alignment {
  LEFT(-1),
  CENTER(0),
  RIGHT(1);

  private int index;

  private Alignment(int index) {
    this.index = index;
  }

  public int getIndex() {
    return index;
  }
}
