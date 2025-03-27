package com.kibo.pgar.lib;

import java.io.Serializable;

/**
 * The <strong>Menu</strong> class creates a menu with multiple entries, assuming
 * that zero is always the exit option. It also provides methods for displaying
 * the menu in a visually appealing manner.
 *
 * @author Alessandro Muscio
 * @version 1.1
 */
public class Menu implements Serializable {
    private static final String EXIT_OPTION = "0. Exit";
    private static final String INPUT_PROMPT = "> ";
    private static final String NEGATIVE_MILLIS_ERROR = AnsiColors.RED + "Error: Negative time is not allowed." + AnsiColors.RESET;

    private final String title;
    private final String[] entries;
    private final boolean useExitOption;
    private final boolean centerTitle;
    private final boolean useVerticalFrame;
    private final int frameWidth;

    /**
     * Constructs a <code>Menu</code> with a specified title, entries, and formatting options.
     *
     * @param title          The title of the menu.
     * @param entries        The menu entries.
     * @param useExitOption  Whether to include an exit option.
     * @param centerTitle    Whether to center the title.
     * @param useVerticalFrame Whether to include a vertical frame around the title.
     */
    public Menu(String title, String[] entries, boolean useExitOption, boolean centerTitle, boolean useVerticalFrame) {
        this.title = title;
        this.entries = entries;
        this.useExitOption = useExitOption;
        this.centerTitle = centerTitle;
        this.useVerticalFrame = useVerticalFrame;
        this.frameWidth = calculateFrameWidth(title, entries);
    }

    /**
     * Determines the frame width based on the title and the longest menu entry.
     *
     * @param title   The menu title.
     * @param entries The menu entries.
     * @return The calculated frame width.
     */
    private int calculateFrameWidth(String title, String[] entries) {
        int maxWidth = title.length();
        for (int i = 0; i < entries.length; i++) {
            int entryWidth = entries[i].length() + KnownProblems.countIntegerDigits(i + 1) + 2;
            maxWidth = Math.max(maxWidth, entryWidth);
        }
        return maxWidth + 10;
    }

    /**
     * Displays the menu with appropriate formatting.
     */
    private void printMenu() {
        StringBuilder menuBuilder = new StringBuilder();
        FrameSettings frameSettings = new FrameSettings(frameWidth, centerTitle ? Alignment.CENTER : Alignment.LEFT, useVerticalFrame);

        menuBuilder.append(PrettyStrings.frame(title, frameSettings)).append("\n");

        for (int i = 0; i < entries.length; i++) {
            menuBuilder.append(String.format("%d. %s\n", (i + 1), entries[i]));
        }

        if (useExitOption) {
            menuBuilder.append(PrettyStrings.isolatedLine(EXIT_OPTION));
        }

        System.out.println(menuBuilder);
    }

    /**
     * Displays the menu and allows the user to choose an option.
     *
     * @return The user's menu selection.
     */
    public int choose() {
        printMenu();
        return useExitOption ? InputData.readIntegerBetween(INPUT_PROMPT, 0, entries.length)
                : InputData.readIntegerBetween(INPUT_PROMPT, 1, entries.length);
    }

    /**
     * Pauses execution for a given number of milliseconds.
     *
     * @param milliseconds The pause duration.
     */
    public static void wait(int milliseconds) {
        if (milliseconds < 0) {
            System.out.println(NEGATIVE_MILLIS_ERROR);
            return;
        }
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Displays a loading message with animated dots.
     *
     * @param message The message to display.
     */
    public static void loadingMessage(String message) {
        System.out.print(message);
        for (int i = 0; i < 3; i++) {
            wait(1000);
            System.out.print(".");
        }
        System.out.println();
    }
}
