package com.kibo.pgar.lib;

/**
 * <code>Enum</code> that collects the alignment a string can have.
 * 
 * @author Alessandro Muscio (Kibo)
 */
public enum Alignment {
  /** Represents the <i>left</i> alignment. */
  LEFT(-1),
  /** Represents the <i>center</i> alignment. */
  CENTER(0),
  /** Represents the <i>right</i> alignment. */
  RIGHT(1);

  private int index;

  private Alignment(int index) {
    this.index = index;
  }

  public int getIndex() {
    return index;
  }
}
