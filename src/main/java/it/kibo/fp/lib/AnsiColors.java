package it.kibo.fp.lib;

/**
 * The enumeration <strong>AnsiColors</strong> has a collection of some ansi
 * code to better visualize strings in the terminal.
 */
public enum AnsiColors {
  /**
   * The ansi code for resetting the colors.
   */
  RESET("\u001B[0m"),
  /**
   * The ansi code for the <i>black</i> color.
   */
  BLACK("\u001B[30m"),
  /**
   * The ansi code for the <i>red</i> color.
   */
  RED("\u001B[31m"),
  /**
   * The ansi code for the <i>green</i> color.
   */
  GREEN("\u001B[32m"),
  /**
   * The ansi code for the <i>yellow</i> color.
   */
  YELLOW("\u001B[33m"),
  /**
   * The ansi code for the <i>blue</i> color.
   */
  BLUE("\u001B[34m"),
  /**
   * The ansi code for the <i>purple</i> color.
   */
  PURPLE("\u001B[35m"),
  /**
   * The ansi code for the <i>cyan</i> color.
   */
  CYAN("\u001B[36m"),
  /**
   * The ansi code for the <i>white</i> color.
   */
  WHITE("\u001B[37m"),
  /**
   * The ansi code for the <i>black background</i> of the text.
   */
  BLACK_BACKGROUND("\u001B[40m"),
  /**
   * The ansi code for the <i>red background</i> of the text.
   */
  RED_BACKGROUND("\u001B[41m"),
  /**
   * The ansi code for the <i>green background</i> of the text.
   */
  GREEN_BACKGROUND("\u001B[42m"),
  /**
   * The ansi code for the <i>yellow background</i> of the text.
   */
  YELLOW_BACKGROUND("\u001B[43m"),
  /**
   * The ansi code for the <i>blue background</i> of the text.
   */
  BLUE_BACKGROUND("\u001B[44m"),
  /**
   * The ansi code for the <i>purple background</i> of the text.
   */
  PURPLE_BACKGROUND("\u001B[45m"),
  /**
   * The ansi code for the <i>cyan background</i> of the text.
   */
  CYAN_BACKGROUND("\u001B[46m"),
  /**
   * The ansi code for the <i>white background</i> of the text.
   */
  WHITE_BACKGROUND("\u001B[47m"),
  /**
   * The ansi code for clearing the terminal.
   */
  CLEAR("\033[H\033[2J");

  private String ansiCode;

  private AnsiColors(String ansiCode) {
    this.ansiCode = ansiCode;
  }

  @Override
  public String toString() {
    return ansiCode;
  }
}
