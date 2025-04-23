package com.kibo.pgar.lib;

import java.util.Arrays;
import java.util.Map;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * The class <strong>InputData</strong> can read a specific data type inserted in input by the
 * user.It also allows the possibility to make controls on the data inserted.
 *
 * @author Alessandro Muscio
 * @version 1.0
 */
public final class InputData {
  private static final Scanner reader = createScanner();
  // @formatter:off
  private static final Map<String, String> ERRORS = Map.ofEntries(
      Map.entry("red", PrettyStrings.prettify("Error!", AnsiColors.RED, AnsiWeights.BOLD, null)),
      Map.entry("constructor", "This class is not instantiable!"),
      Map.entry(
          "alphanumeric_characters",
          "Only " + PrettyStrings.prettify("characters", null, AnsiWeights.BOLD, null) + " characters are allowed.\n"
      ),
      Map.entry(
          "empty_string",
          "No " + PrettyStrings.prettify("whitespaces", null, AnsiWeights.BOLD, null) + " or only "
              + PrettyStrings.prettify("alphanumeric", null, AnsiWeights.BOLD, null) + " were inserted.\n"
      ),
      Map.entry("allowed_characters", "The only allowed characters are: %s\n"),
      Map.entry(
          "integer_format",
          "The inserted data is in an " + PrettyStrings.prettify("incorrect", null, AnsiWeights.BOLD, null)
              + " format. An " + PrettyStrings.prettify("integer", null, null, AnsiDecorations.UNDERLINE)
              + " is required.\n"
      ),
      Map.entry(
          "double_format",
          "The inserted data is in an " + PrettyStrings.prettify("incorrect", null, AnsiWeights.BOLD, null)
              + " format. A " + PrettyStrings.prettify("double", null, null, AnsiDecorations.UNDERLINE)
              + " is required.\n"
      ),
      Map.entry("minimum", "A value greater than or equal to %.2f is required.\n"),
      Map.entry("maximum", "A value less than or equal to %.2f is required.\n")
  );
  // @formatter:on

  private static final String ALPHANUMERIC_CHARACTERS = "abcdefghijklmnopqrstuvwxyzZ0123456789 ";
  private static final char YES_ANSWER = 'y';
  private static final char NO_ANSWER = 'n';

  private static final double EPSILON = 1E-5;

  private InputData() {
    throw new UnsupportedOperationException(InputData.ERRORS.get("constructor"));
  }

  /**
   * Methods that creates a <code>Scanner</code> object.
   *
   * @return A <code>Scanner</code> object.
   */
  private static Scanner createScanner() {
    return new Scanner(System.in).useDelimiter("\n");
  }

  /**
   * Verifies if the given message has only alphanumeric characters.
   *
   * @param message The message to verify.
   * 
   * @return A <code>boolean</code> representing if the message is alphanumeric or not.
   */
  private static boolean hasAlphanumericCharacters(String message) {
    for (char currentChar : message.toCharArray()) {
      if (ALPHANUMERIC_CHARACTERS.indexOf(currentChar) == -1)
        return false;
    }

    return true;
  }

  /**
   * Flushes the scanner, emptying the input buffer.
   */
  private static void flushReader() {
    reader.nextLine();
  }

  /**
   * Prints <code>message</code> in the terminal and reads the text inserted by the user. If it isn't
   * a <code>String</code> an error message is printed. It's also possible to select if the inserted
   * text needs to be alphanumeric or not.
   *
   * @param message      The message to print.
   * @param alphanumeric If the input needs to be alphanumeric or not.
   * 
   * @return A <code>String</code> representing the user input.
   */
  public static String readString(String message, boolean alphanumeric) {
    boolean isAlphanumeric = true;
    String read = "";

    do {
      System.out.println(message);

      read = reader.next().trim();

      isAlphanumeric = alphanumeric ? InputData.hasAlphanumericCharacters(read) : isAlphanumeric;
      if (!isAlphanumeric)
        System.out.println(InputData.ERRORS.get("red") + InputData.ERRORS.get("alphanumeric_characters"));
    } while (!isAlphanumeric);

    return read;
  }

  /**
   * Prints <code>message</code> in the terminal and reads the text inserted by the user, given that
   * it isn't empty. If it isn't a <code>String</code> an error message is printed. It's also possible
   * to select if the inserted text needs to be alphanumeric or not.
   *
   * @param message      The message to print.
   * @param alphanumeric If the input needs to be alphanumeric or not.
   * 
   * @return A <code>String</code> representing the user input.
   */
  public static String readNonEmptyString(String message, boolean alphanumeric) {
    boolean isEmpty = true;
    String read = "";

    do {
      read = InputData.readString(message, alphanumeric);

      isEmpty = read.isBlank();
      if (isEmpty)
        System.out.println(InputData.ERRORS.get("red") + InputData.ERRORS.get("empty_string"));
    } while (isEmpty);

    return read;
  }

  /**
   * Prints <code>message</code> in the terminal and reads the text inserted by the user. It will take
   * the first <code>char</code> in it and verify if it is in the <code>allowed</code> characters, if
   * not, an error message will be printed.
   *
   * @param message The message to print.
   * @param allowed All the allowed characters.
   * 
   * @return A <code>char</code> representing the character tha was read.
   */
  public static char readChar(String message, String allowed) {
    boolean isAllowed = true;
    String read = "";
    char readChar = '\0';

    do {
      read = InputData.readNonEmptyString(message, false);
      readChar = read.charAt(0);

      isAllowed = allowed.indexOf(readChar) != -1;
      if (!isAllowed)
        // @formatter:off
        System.out.println(
          InputData.ERRORS.get("red") + 
          InputData.ERRORS.get("allowed_characters").formatted(Arrays.toString(allowed.toCharArray()))
        );
        // @formatter:on
    } while (!isAllowed);

    return readChar;
  }

  /**
   * Prints <code>message</code> in the terminal and reads the text inserted by the user. It will take
   * the first <code>char</code> in it or return empty if the user inserted nothing.
   *
   * @param message The message to print.
   * 
   * @return A <code>char</code> representing the character tha was read or empty.
   */
  public static char readChar(String message) {
    String read = InputData.readString(message, false);

    return read.isBlank() ? '\0' : read.charAt(0);
  }

  /**
   * Prints <code>question</code> in the terminal with the string "? [Y/n] " added. If the user
   * answers with 'y' or 'Y' the method will return <code>true</code>, <code>false</code> otherwise.
   *
   * @param question The question to print.
   * 
   * @return A <code>boolean</code> representing the affirmative or negative answer of the user.
   */
  public static boolean readYesOrNo(String question) {
    question = "%s? [%c/%c] ".formatted(question, Character.toUpperCase(InputData.YES_ANSWER), InputData.NO_ANSWER);

    char readChar = InputData.readChar(question);

    char[] trueAnswers = new char[] {
        InputData.YES_ANSWER, Character.toUpperCase(InputData.YES_ANSWER), '\0'
    };

    return IntStream.range(0, trueAnswers.length).anyMatch(i -> trueAnswers[i] == readChar);
  }

  /**
   * Prints <code>message</code> in the terminal and reads the text inserted by the user. It will
   * print an error message if the text inserted isn't an integer.
   *
   * @return An <code>int</code> representing the integer that was read.
   */
  public static int readInteger(String message) {
    boolean isInteger = true;
    int read = 0;

    do {
      try {
        System.out.println(message);

        read = reader.nextInt();

        isInteger = true;
      } catch (InputMismatchException e) {
        System.out.println(InputData.ERRORS.get("red") + InputData.ERRORS.get("integer_format"));

        isInteger = false;
      } finally {
        InputData.flushReader();
      }
    } while (!isInteger);

    return read;
  }

  /**
   * Prints <code>message</code> in the terminal and reads the text inserted by the user. It will
   * print an error message if the text inserted isn't an integer or if the integer inserted is less
   * than <code>min</code>.
   *
   * @param message The message to print.
   * @param min     The minimum value to read.
   * 
   * @return An <code>int</code> representing the integer that was read.
   */
  public static int readIntegerWithMinimum(String message, int min) {
    boolean isBelowMin = true;
    int read = Integer.MIN_VALUE;

    do {
      read = InputData.readInteger(message);

      isBelowMin = read < min;
      if (isBelowMin)
        // @formatter:off
        System.out.println(
          InputData.ERRORS.get("red") + 
          InputData.ERRORS.get("minimum").formatted(min)
        );
        // @formatter:on
    } while (isBelowMin);

    return read;
  }

  /**
   * Prints <code>message</code> in the terminal and reads the text inserted by the user. It will
   * print an error message if the text inserted isn't an integer or if the integer inserted is
   * greater than <code>max</code>.
   *
   * @param message The message to print.
   * @param max     The maximum value to read.
   * 
   * @return An <code>int</code> representing the integer that was read.
   */
  public static int readIntegerWithMaximum(String message, int max) {
    boolean isAboveMax = true;
    int read = Integer.MIN_VALUE;

    do {
      read = InputData.readInteger(message);

      isAboveMax = read > max;
      if (isAboveMax)
        // @formatter:off
        System.out.println(
          InputData.ERRORS.get("red") + 
          InputData.ERRORS.get("maximum").formatted(max)
        );
        // @formatter:on
    } while (isAboveMax);

    return read;
  }

  /**
   * Prints <code>message</code> in the terminal and reads the text inserted by the user. It will
   * print an error message if the text inserted isn't an integer or if the integer inserted isn't
   * between or equal than <code>min</code> and <code>max</code>.
   *
   * @param message The message to print.
   * @param min     The minimum value to read.
   * @param max     The maximum value to read.
   * @return An <code>int</code> representing the integer that was read.
   */
  public static int readIntegerBetween(String message, int min, int max) {
    boolean isBelowMin = true;
    boolean isAboveMax = true;
    int read = Integer.MIN_VALUE;

    do {
      read = InputData.readInteger(message);

      isBelowMin = read < min;
      if (isBelowMin)
        // @formatter:off
        System.out.println(
          InputData.ERRORS.get("red") + 
          InputData.ERRORS.get("minimum").formatted(min)
        );
        // @formatter:on

      isAboveMax = read > max;
      if (isAboveMax)
        // @formatter:off
        System.out.println(
          InputData.ERRORS.get("red") + 
          InputData.ERRORS.get("maximum").formatted(max)
        );
        // @formatter:on
    } while (isBelowMin || isAboveMax);

    return read;
  }

  /**
   * Prints <code>message</code> in the terminal and reads the text inserted by the user. It will
   * print an error message if the text inserted isn't a double.
   *
   * @param message The message to print.
   * @return A <code>double</code> representing the double that was read.
   */
  public static double readDouble(String message) {
    boolean isDouble = true;
    double read = Double.NaN;

    do {
      try {
        System.out.println(message);

        read = reader.nextDouble();

        isDouble = true;
      } catch (InputMismatchException e) {
        System.out.println(InputData.ERRORS.get("red") + InputData.ERRORS.get("double_format"));

        isDouble = false;
      } finally {
        InputData.flushReader();
      }
    } while (!isDouble);

    return read;
  }

  /**
   * Prints <code>message</code> in the terminal and reads the text inserted by the user. It will
   * print an error message if the text inserted isn't a double or if the double inserted isn't
   * greater equal than <code>min</code>.
   *
   * @param message The message to print.
   * @param min     The minimum value to read.
   * @return A <code>double</code> representing the double that was read.
   */
  public static double readDoubleWithMinimum(String message, double min) {
    boolean isBelowMin = true;
    double read = Double.NaN;

    do {
      read = InputData.readDouble(message);

      isBelowMin = (min - read) > InputData.EPSILON;
      if (isBelowMin)
        // @formatter:off
        System.out.println(
          InputData.ERRORS.get("red") + 
          InputData.ERRORS.get("minimum").formatted(min)
        );
        // @formatter:on
    } while (isBelowMin);

    return read;
  }

  /**
   * Prints <code>message</code> in the terminal and reads the text inserted by the user. It will
   * print an error message if the text inserted isn't a double or if the double inserted isn't less
   * equal than <code>max</code>.
   *
   * @param message The message to print.
   * @param max     The maximum value to read.
   * @return An <code>double</code> representing the double that was read.
   */
  public static double readDoubleWithMaximum(String message, double max) {
    boolean isAboveMax = true;
    double read = Double.NaN;

    do {
      read = InputData.readDouble(message);

      isAboveMax = (read - max) > InputData.EPSILON;
      if (isAboveMax)
        // @formatter:off
        System.out.println(
          InputData.ERRORS.get("red") + 
          InputData.ERRORS.get("maximum").formatted(max)
        );
        // @formatter:on
    } while (isAboveMax);

    return read;
  }

  /**
   * Prints <code>message</code> in the terminal and reads the text inserted by the user. It will
   * print an error message if the text inserted isn't an double or if the double inserted isn't
   * between or equal than <code>min</code> and <code>max</code>.
   *
   * @param message The message to print.
   * @param min     The minimum value to read.
   * @param max     The maximum value to read.
   * @return An <code>double</code> representing the double that was read.
   */
  public static double readDoubleBetween(String message, double min, double max) {
    boolean isBelowMin = true;
    boolean isAboveMax = true;
    double read = Double.NaN;

    do {
      read = InputData.readDouble(message);

      isBelowMin = (min - read) > InputData.EPSILON;
      if (isBelowMin)
        // @formatter:off
        System.out.println(
          InputData.ERRORS.get("red") + 
          InputData.ERRORS.get("minimum").formatted(min)
        );
        // @formatter:on

      isAboveMax = (read - max) > InputData.EPSILON;
      if (isAboveMax)
        // @formatter:off
        System.out.println(
          InputData.ERRORS.get("red") + 
          InputData.ERRORS.get("maximum").formatted(max)
        );
        // @formatter:on
    } while (isBelowMin);

    return read;
  }
}