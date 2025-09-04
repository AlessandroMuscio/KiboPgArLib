package com.kibo.pgar.lib;

/**
 * <code>Enum</code> that collects some ansi colors in order to prettify strings
 * in the terminal. It
 * can color both the words and the background of strings.
 * 
 * @author Alessandro Muscio (Kibo)
 */
public enum AnsiColors {
  /** Ansi code for clearing the terminal */
  CLEAR("\033[H\033[2J"),
  /** Resets the colors of the terminal. */
  RESET("\u001B[0m"),
  /** Inverts <i>background</i> with foreground. */
  INVERT("\u001B[7m"),
  /** Colors the words <i>black</i>. */
  BLACK("\u001B[30m"),
  /** Colors the words <i>red</i>. */
  RED("\u001B[31m"),
  /** Colors the words <i>green</i>. */
  GREEN("\u001B[32m"),
  /** Colors the words <i>yellow</i>. */
  YELLOW("\u001B[33m"),
  /** Colors the words <i>blue</i>. */
  BLUE("\u001B[34m"),
  /** Colors the words <i>purple</i>. */
  PURPLE("\u001B[35m"),
  /** Colors the words <i>cyan</i>. */
  CYAN("\u001B[36m"),
  /** Colors the words <i>white</i>. */
  WHITE("\u001B[37m"),
  /** Colors the background <i>black</i>. */
  BLACK_BACKGROUND("\u001B[40m"),
  /** Colors the background <i>red</i>. */
  RED_BACKGROUND("\u001B[41m"),
  /** Colors the background <i>green</i>. */
  GREEN_BACKGROUND("\u001B[42m"),
  /** Colors the background <i>yellow</i>. */
  YELLOW_BACKGROUND("\u001B[43m"),
  /** Colors the background <i>blue</i>. */
  BLUE_BACKGROUND("\u001B[44m"),
  /** Colors the background <i>purple</i>. */
  PURPLE_BACKGROUND("\u001B[45m"),
  /** Colors the background <i>cyan</i>. */
  CYAN_BACKGROUND("\u001B[46m"),
  /** Colors the background <i>white</i>. */
  WHITE_BACKGROUND("\u001B[47m");

  private final String ansiCode;

  private AnsiColors(String ansiCode) {
    this.ansiCode = ansiCode;
  }

  @Override
  public String toString() {
    return ansiCode;
  }
}
