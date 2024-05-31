package com.kibo.pgar.lib;

/**
 * <code>Enum</code> that collects some ansi decorations in order to prettify
 * strings in the terminal. It can add decorations to the strings.
 * 
 * @author Alessandro Muscio (Kibo)
 */
public enum AnsiDecorations {
  /** Resets the formatting of the terminal. */
  RESET("\u001B[0m"),
  /** Formats the words with an <i>underline</i> decoration. */
  UNDERLINE("\u001B[4m"),
  /** <i>Hides</i> the words. */
  HIDE("\u001B[8m"),
  /** Formats the words with an <i>strikethrough</i> decoration. */
  STRIKETHROUGH("\u001B[9m"),
  /** Formats the words with an <i>double underline</i> decoration. */
  DOUBLE_UNDERLINE("\u001B[21m"),
  /** Formats the words with an <i>overline</i> decoration. */
  OVERLINE("\u001B[53m");

  private final String ansiCode;

  private AnsiDecorations(String ansiCode) {
    this.ansiCode = ansiCode;
  }

  @Override
  public String toString() {
    return ansiCode;
  }
}
