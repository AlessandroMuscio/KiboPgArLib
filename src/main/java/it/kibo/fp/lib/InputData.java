package it.kibo.fp.lib;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The class <strong>InputData</strong> can read a specific data type inserted
 * in input by the user.It also allows the possibility to make controls on the
 * data inserted.
 *
 * @author Alessandro Muscio
 * @version 1.0
 */
public final class InputData {
  private InputData() {
    throw new UnsupportedOperationException();
  }

  private static final Scanner reader = createScanner();

  private static final String RED_ATTENTION = AnsiColors.RED + "Attention!" + AnsiColors.RESET;
  private static final String ALPHANUMERIC_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 ";
  private static final String ALPHANUMERIC_CHARACTERS_ERROR = RED_ATTENTION
      + "\nOnly alphanumeric characters are allowed.";
  private static final String EMPTY_STRING_ERROR = RED_ATTENTION + "\nNo characters were inserted.";
  private static final String ALLOWED_CHARACTERS_ERROR = RED_ATTENTION + "\nThe only allowed characters are: %s";
  private static final String INTEGER_FORMAT_ERROR = RED_ATTENTION
      + "\nThe inserted data is in a incorrect format. An integer is required.";
  private static final String DOUBLE_FORMAT_ERROR = RED_ATTENTION
      + "\nThe inserted data is in a incorrect format. A double is required.";
  private static final String MINIMUM_ERROR = RED_ATTENTION + "\nA value greater equal than %.2f is required.";
  private static final String MAXIMUM_ERROR = RED_ATTENTION + "\nA value less equal than %.2f is required.";
  private static final String YES_ANSWERS = "yY";
  private static final String NO_ANSWERS = "nN";

  /**
   * Methods that creates a <code>Scanner</code> object.
   *
   * @return A <code>Scanner</code> object.
   */
  private static Scanner createScanner() {
    return new Scanner(System.in);
  }

  /**
   * Verifies if the given message has only alphanumeric characters.
   *
   * @param message The message to verify.
   * 
   * @return A <code>boolean</code> representing if the message is alphanumeric or
   *         not.
   */
  private static boolean hasAlphanumericCharacters(String message) {
    char currentChar;

    for (int i = 0; i < message.length(); i++) {
      currentChar = message.charAt(i);

      if (ALPHANUMERIC_CHARACTERS.indexOf(currentChar) == -1)
        return false;
    }

    return true;
  }

  /**
   * Prints <code>message</code> in the terminal and reads the text inserted by
   * the user. If it isn't a <code>String</code> an error message is printed. It's
   * also possible to select if the inserted text needs to be alphanumeric or not.
   *
   * @param message      The message to print.
   * @param alphanumeric If the input needs to be alphanumeric or not.
   * 
   * @return A <code>String</code> representing the user input.
   */
  public static String readString(String message, boolean alphanumeric) {
    boolean isAlphanumeric;
    String read;

    if (alphanumeric) {
      do {
        System.out.print(message);

        read = reader.next();
        read = read.trim();

        isAlphanumeric = hasAlphanumericCharacters(read);

        if (!isAlphanumeric)
          System.out.println(ALPHANUMERIC_CHARACTERS_ERROR);
      } while (!isAlphanumeric);
    } else {
      System.out.print(message);

      read = reader.next();
      read = read.trim();
    }

    return read;
  }

  /**
   * Prints <code>message</code> in the terminal and reads the text inserted by
   * the user, given that it isn't empty. If it isn't a <code>String</code> an
   * error message is printed. It's also possible to select if the inserted text
   * needs to be alphanumeric or not.
   *
   * @param message      The message to print.
   * @param alphanumeric If the input needs to be alphanumeric or not.
   * 
   * @return A <code>String</code> representing the user input.
   */
  public static String readNonEmptyString(String message, boolean alphanumeric) {
    boolean isStringEmpty = true;
    String read;

    do {
      read = readString(message, alphanumeric);

      if (read.length() > 0)
        isStringEmpty = false;
      else
        System.out.println(EMPTY_STRING_ERROR);
    } while (isStringEmpty);

    return read;
  }

  /**
   * Prints <code>message</code> in the terminal and reads the text inserted by
   * the user. It will take the first <code>char</code> in it and verify if it is
   * in the <code>allowed</code> characters, if not, an error message will be
   * printed.
   *
   * @param message The message to print.
   * @param allowed All the allowed characters.
   * 
   * @return A <code>char</code> representing the character tha was read.
   */
  public static char readChar(String message, String allowed) {
    boolean isAllowed = false;
    String read;
    char readChar;

    do {
      read = readNonEmptyString(message, false);

      readChar = read.charAt(0);

      if (allowed.indexOf(readChar) != -1)
        isAllowed = true;
      else
        System.out.println(String.format(ALLOWED_CHARACTERS_ERROR, Arrays.toString(allowed.toCharArray())));
    } while (!isAllowed);

    return readChar;
  }

  /**
   * Prints <code>message</code> in the terminal and reads the text inserted by
   * the user, it will take the first <code>char</code> in it.
   *
   * @param message The message to print.
   * 
   * @return A <code>char</code> representing the character tha was read.
   */
  public static char readChar(String message) {
    String read;

    read = readNonEmptyString(message, false);

    return read.charAt(0);
  }

  /**
   * Prints <code>message</code> in the terminal and reads the text inserted by
   * the user. It will print an error message if the text inserted isn't an
   * integer.
   *
   * @param message The message to print.
   * 
   * @return An <code>int</code> representing the integer that was read.
   */
  public static int readInteger(String message) {
    boolean isInteger;
    int read = 0;

    do {
      try {
        System.out.print(message);

        read = reader.nextInt();

        isInteger = true;
      } catch (InputMismatchException e) {
        System.out.println(INTEGER_FORMAT_ERROR);

        // Clean the input buffer
        while (reader.hasNext())
          reader.next();

        isInteger = false;
      }
    } while (!isInteger);

    return read;
  }

  /**
   * Prints <code>message</code> in the terminal and reads the text inserted by
   * the user. It will print an error message if the text inserted isn't an
   * integer or if the integer inserted isn't greater equal than <code>min</code>.
   *
   * @param message The message to print.
   * @param min     The minimum value to read.
   * 
   * @return An <code>int</code> representing the integer that was read.
   */
  public static int readIntegerWithMinimum(String message, int min) {
    boolean isAboveMin = false;
    int read;

    do {
      read = readInteger(message);

      if (read >= min)
        isAboveMin = true;
      else
        System.out.println(String.format(MINIMUM_ERROR, min));
    } while (!isAboveMin);

    return read;
  }

  /**
   * Prints <code>message</code> in the terminal and reads the text inserted by
   * the user. It will print an error message if the text inserted isn't an
   * integer or if the integer inserted isn't less equal than <code>max</code>.
   *
   * @param message The message to print.
   * @param max     The maximum value to read.
   * 
   * @return An <code>int</code> representing the integer that was read.
   */
  public static int readIntegerWithMaximum(String message, int max) {
    boolean isBelowMax = false;
    int read;

    do {
      read = readInteger(message);

      if (read <= max)
        isBelowMax = true;
      else
        System.out.println(String.format(MAXIMUM_ERROR, max));
    } while (!isBelowMax);

    return read;
  }

  /**
   * Prints <code>message</code> in the terminal and reads the text inserted by
   * the user. It will print an error message if the text inserted isn't an
   * integer or if the integer inserted isn't between or equal than
   * <code>min</code> and <code>max</code>.
   *
   * @param message The message to print.
   * @param min     The minimum value to read.
   * @param max     The maximum value to read.
   * 
   * @return An <code>int</code> representing the integer that was read.
   */
  public static int readIntegerBetween(String message, int min, int max) {
    boolean isBetweenMinMax = false;
    int read;

    do {
      read = readInteger(message);

      if (read < min)
        System.out.println(String.format(MINIMUM_ERROR, min));
      else if (read > max)
        System.out.println(String.format(MAXIMUM_ERROR, max));
      else
        isBetweenMinMax = true;
    } while (!isBetweenMinMax);

    return read;
  }

  /**
   * Prints <code>message</code> in the terminal and reads the text inserted by
   * the user. It will print an error message if the text inserted isn't a double.
   *
   * @param message The message to print.
   * 
   * @return A <code>double</code> representing the double that was read.
   */
  public static double readDouble(String message) {
    boolean isDouble;
    double read = Double.NaN;

    do {
      System.out.print(message);

      try {
        read = reader.nextDouble();
        isDouble = true;
      } catch (InputMismatchException e) {
        System.out.println(DOUBLE_FORMAT_ERROR);

        // Clean the input buffer
        while (reader.hasNext())
          reader.next();

        isDouble = false;
      }
    } while (!isDouble);

    return read;
  }

  /**
   * Prints <code>message</code> in the terminal and reads the text inserted by
   * the user. It will print an error message if the text inserted isn't a double
   * or if the double inserted isn't greater equal than <code>min</code>.
   *
   * @param message The message to print.
   * @param min     The minimum value to read.
   * 
   * @return A <code>double</code> representing the double that was read.
   */
  public static double readDoubleWithMinimum(String message, double min) {
    boolean isAboveMin = false;
    double read;

    do {
      read = readDouble(message);

      if (read >= min)
        isAboveMin = true;
      else
        System.out.println(String.format(MINIMUM_ERROR, min));
    } while (!isAboveMin);

    return read;
  }

  /**
   * Prints <code>message</code> in the terminal and reads the text inserted by
   * the user. It will print an error message if the text inserted isn't a double
   * or if the double inserted isn't less equal than <code>max</code>.
   *
   * @param message The message to print.
   * @param max     The maximum value to read.
   * 
   * @return An <code>double</code> representing the double that was read.
   */
  public static double readDoubleWithMaximum(String message, double max) {
    boolean isBelowMax = false;
    double read;

    do {
      read = readDouble(message);

      if (read <= max)
        isBelowMax = true;
      else
        System.out.println(String.format(MAXIMUM_ERROR, max));
    } while (!isBelowMax);

    return read;
  }

  /**
   * Prints <code>message</code> in the terminal and reads the text inserted by
   * the user. It will print an error message if the text inserted isn't an double
   * or if the double inserted isn't between or equal than <code>min</code> and
   * <code>max</code>.
   *
   * @param message The message to print.
   * @param min     The minimum value to read.
   * @param max     The maximum value to read.
   * 
   * @return An <code>double</code> representing the double that was read.
   */
  public static double readDoubleBetween(String message, double min, double max) {
    boolean isBetweenMinMax = false;
    double read;

    do {
      read = readDouble(message);

      if (read < min)
        System.out.println(String.format(MINIMUM_ERROR, min));
      else if (read > max)
        System.out.println(String.format(MAXIMUM_ERROR, max));
      else
        isBetweenMinMax = true;
    } while (!isBetweenMinMax);

    return read;
  }

  /**
   * Prints <code>question</code> in the terminal with the string "? [Y/n] "
   * added. If the user answers with 'y' or 'Y' the method will return
   * <code>true</code>, <code>false</code> otherwise.
   *
   * @param question The question to print.
   * 
   * @return A <code>boolean</code> representing the affirmative or negative
   *         answer of the user.
   */
  public static boolean readYesOrNo(String question) {
    char valoreLetto;

    question = question + "? [" + YES_ANSWERS.charAt(1) + "/" + NO_ANSWERS.charAt(0) + "] ";

    valoreLetto = readChar(question);

    return YES_ANSWERS.indexOf(valoreLetto) != -1;
  }
}