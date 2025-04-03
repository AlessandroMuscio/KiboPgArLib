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
    private static final int MIN_FRAME_WIDTH = 30; // Minimum frame width to ensure uniformity
    private static final int PADDING = 4; // Padding around menu items

    private final String title;
    private final String[] entries;
    private final boolean useExitOption;
    private final boolean centerTitle;
    private final int frameWidth;

    /**
     * Constructs a <code>Menu</code> with a specified title, entries, and formatting options.
     */
    public Menu(String title, String[] entries, boolean useExitOption) {
        this.title = title;
        this.entries = entries;
        this.useExitOption = useExitOption;
        this.centerTitle = false;
        this.frameWidth = calculateFrameWidth(title, entries);
    }

    private int calculateFrameWidth(String title, String[] entries) {
        int frameLength = title.length();

        for (int i = 0; i < entries.length; i++) {
            frameLength = Math.max(frameLength, entries[i].length() + KnownProblems.countIntegerDigits(i + 1) + 2);
        }

        return Math.max(frameLength + PADDING * 2, MIN_FRAME_WIDTH);
    }

    /**
     * Generates a horizontal line of specified length and character.
     */
    private String generateHorizontalLine(int length, char lineChar) {
        return new String(new char[length]).replace('\0', lineChar);
    }

    private void printMenu() {
        StringBuilder menuBuilder = new StringBuilder();
        menuBuilder.append("\n");

        // Top border
        menuBuilder.append(generateHorizontalLine(frameWidth, '=')).append("\n");

        menuBuilder.append(title).append("\n");

        // Title separator
        menuBuilder.append(generateHorizontalLine(frameWidth, '-')).append("\n\n");

        // Menu items
        for (int i = 0; i < entries.length; i++) {
            String menuItem = String.format("%d. %s", (i + 1), entries[i]);
            // Center each menu item if centerTitle is true
            if (centerTitle) {
                menuItem = String.format("%" + ((frameWidth + menuItem.length()) / 2) + "s", menuItem);
            }
            menuBuilder.append(menuItem).append("\n");
        }

        if (useExitOption) {
            menuBuilder.append("\n").append(generateHorizontalLine(frameWidth, '-')).append("\n");
            String exitLine = EXIT_OPTION;
            if (centerTitle) {
                exitLine = String.format("%" + ((frameWidth + exitLine.length()) / 2) + "s", exitLine);
            }
            menuBuilder.append(exitLine).append("\n");
        }

        // Bottom border
        menuBuilder.append(generateHorizontalLine(frameWidth, '=')).append("\n");

        System.out.println(menuBuilder);
    }

    public int choose() {
        printMenu();
        return useExitOption ? InputData.readIntegerBetween(INPUT_PROMPT, 0, entries.length)
                : InputData.readIntegerBetween(INPUT_PROMPT, 1, entries.length);
    }

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
}