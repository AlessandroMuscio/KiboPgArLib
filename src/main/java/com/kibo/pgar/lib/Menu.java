package com.kibo.pgar.lib;

/**
 * <code>Class</code> that represents a generic text menu with multiple options.
 * <p>
 * It is assumed that the exit option is always associated with choice 0 and is presented at the bottom of the menu (when it must be shown).
 *
 * @author Minini Luca
 */

public class Menu {
    final private static String FRAME = "--------------------------------";
    final private static String EXIT_OPTION = "0.\tExit";
    final private static String INPUT_REQUEST = "Enter the number of the desired option";
    final private static boolean SHOW_EXIT_OPTION_DEFAULT = true;


    private String title;
    private String[] options;
    private boolean showExitOption;

    /**
     * Constructs a <code>MyMenu</code> with the given title and options, showing the exit option by default.
     *
     * @param title   The title of the menu.
     * @param options The array of menu options.
     */
    
    public Menu(String title, String[] options) {
        this(title, options, Menu.SHOW_EXIT_OPTION_DEFAULT);
    }

    /**
     * Constructs a <code>MyMenu</code> with the given title, options, and whether to show the exit option.
     *
     * @param title          The title of the menu.
     * @param options        The array of menu options.
     * @param showExitOption Whether the exit option is to be shown.
     */
    
    public Menu(String title, String[] options, boolean showExitOption) {
        this.title = title;
        this.options = options;
        this.showExitOption = showExitOption;
    }

    /**
     * Displays the menu and returns the user's choice.
     *PrettyStrings
     * @return The user's choice.
     */
    public int choose() {
        int minOptionChoiceValue = (this.showExitOption) ? 0 : 1;

        displayMenu();

        return InputData.readIntegerBetween(Menu.INPUT_REQUEST, minOptionChoiceValue, this.options.length);
    }

    /**
     * Displays the menu to the console.
     */
    
    public void displayMenu() {
        String prettifiedTitle = PrettyStrings.prettify(this.title, AnsiColors.GREEN, AnsiWeights.BOLD, null);
        System.out.println(Menu.FRAME);
        System.out.println(PrettyStrings.center(prettifiedTitle, Menu.FRAME.length()));
        System.out.println(Menu.FRAME);

        for (int i = 0; i < this.options.length; i++) {
            System.out.printf("%d.\t%s%n\n", i + 1, this.options[i]);
        }
        if (this.showExitOption) {
            System.out.printf("\n%s\n", Menu.EXIT_OPTION);
        }
        System.out.println();
    }
}