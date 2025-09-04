package com.kibo.pgar.lib;

import java.util.List;
import java.util.StringJoiner;

/**
 * The <strong>Menu</strong> class creates a menu with multiple entry supposing that zero is always
 * the exit option. The class also contains some method that may result useful in visualizing the
 * menu.
 *
 * @author Alessandro Muscio (kibo)
 * @version 1.0
 */
public class Menu {
  private static final char NEW_LINE = '\n';
  private static final String EXIT_ENTRY = "0. Exit";
  private static final String INSERT_REQUEST = "> ";
  private static final String NEGATIVE_MILLIS_ERROR = "%sAttention!%s\nYou can't have negative time."
      .formatted(AnsiColors.RED, AnsiColors.RESET);

  /**
   * Represent the title of the menu.
   */
  private String title;

  /**
   * Contains all the menu entries.
   */
  private List<String> entries;

  /**
   * Represents the length of the frame.
   */
  private boolean useExitEntry;

  /**
   * Represents the title settings
   */
  private FrameSettings titleSettings;

  /**
   * Constructor that creates a <code>Menu</code> object specifying a title, the entries of the menu,
   * if you want the exit entry or not, if you want the title centred and if you also want the
   * vertical frame in the title. It will also automatically calculate the frame length.
   *
   * @param title            Represents the title of the menu.
   * @param entries          Represents the entries of the menu.
   * @param useExitEntry     If you want the exit entry or not.
   * @param titleAlignment   The alignment you want to title to be.
   * @param useVerticalFrame If you want to use the vertical frame or not.
   */
  public Menu(String title, List<String> entries, boolean useExitEntry, Alignment titleAlignment,
      boolean useVerticalFrame) {
    this.title = title;
    this.entries = entries;
    this.useExitEntry = useExitEntry;
    this.titleSettings = new FrameSettings(this.calculateFrameLength(title, entries), titleAlignment, useVerticalFrame);
  }

  /**
   * Prints the menu and lets the user choose an option from it.
   * 
   * @return An <code>int</code> representing the choice of the user.
   */
  public int choose() {
    this.printMenu();

    if (this.useExitEntry)
      return InputData.readIntegerBetween(Menu.INSERT_REQUEST, 0, this.entries.size());
    else
      return InputData.readIntegerBetween(Menu.INSERT_REQUEST, 1, this.entries.size());
  }

  /**
   * Clear any character from the console.
   */
  public static void clearConsole() {
    System.out.println(AnsiColors.CLEAR);
    System.out.flush();
  }

  public static void wait(int milliseconds) throws InterruptedException {
    try {
      Thread.sleep(milliseconds);
    } catch (IllegalArgumentException e) {
      System.out.println(Menu.NEGATIVE_MILLIS_ERROR);
    }
  }

  public static void loadingMessage(String message) throws InterruptedException {
    System.out.print("%s.".formatted(message));
    Menu.wait(500);
    System.out.print(".");
    Menu.wait(500);
    System.out.print(".");
    Menu.wait(500);
    System.out.println();
    Menu.clearConsole();
  }

  /**
   * Calculates the frame length by measuring the length of the title and of all the entries of the
   * menu accounting for their number and the ". " string before the actual entry.
   * 
   * @param title   The title of the menu.
   * @param entries The entries of the menu.
   * 
   * @return An <code>int</code> representing the length of the frame.
   */
  private int calculateFrameLength(String title, List<String> entries) {
    int frameLength = title.length();

    for (String entry : entries)
      frameLength = Math.max(entry.length(), frameLength);

    return frameLength + 10;
  }

  /**
   * Prints the menu: first the framed title and then all the entries.
   */
  private void printMenu() {
    StringJoiner stringedMenu = new StringJoiner(String.valueOf(Menu.NEW_LINE));

    stringedMenu.add(PrettyStrings.frame(this.title, this.titleSettings));

    for (int i = 0; i < this.entries.size(); i++)
      stringedMenu.add("%d. %s".formatted(i + 1, this.entries.get(i)));

    if (this.useExitEntry)
      stringedMenu.add(PrettyStrings.isolatedLine(Menu.EXIT_ENTRY));

    System.out.println(stringedMenu.toString());
  }
}
