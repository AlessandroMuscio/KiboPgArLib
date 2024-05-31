package com.kibo.pgar.lib;

/**
 * <code>Enum</code> that collects some ansi weights in order to prettify
 * strings in the terminal. It can change the font weight of strings.
 * 
 * @author Alessandro Muscio (Kibo)
 */
public enum AnsiWeights {
  /** Resets the formatting of the terminal. */
  RESET("\u001B[0m"),
  /** Formats the words in a <i>bold</i> weight. */
  BOLD("\u001B[1m"),
  /** Formats the words in a <i>light</i> weight. */
  LIGHT("\u001B[2m"),
  /** Formats the words in a <i>italic</i> weight. */
  ITALIC("\u001B[3m");

  private final String ansiCode;

  private AnsiWeights(String ansiCode) {
    this.ansiCode = ansiCode;
  }

  @Override
  public String toString() {
    return ansiCode;
  }
}
