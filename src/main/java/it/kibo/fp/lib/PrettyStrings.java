package it.kibo.fp.lib;

/**
 * The class <strong>PrettyStrings</strong> has various methods to better print
 * strings to the terminal.
 */
public final class PrettyStrings {
  /**
   * The character used to represent the space.
   */
  private final static char SPACE = ' ';
  /**
   * The character used to represent the horizontal frame.
   */
  private final static char HORIZONTAL_FRAME = '-';
  /**
   * The character used to represent the vertical frame.
   */
  private final static char VERTICAL_FRAME = '|';
  /**
   * The character used to represent a new line.
   */
  private final static char NEW_LINE = '\n';

  private PrettyStrings() {
    throw new UnsupportedOperationException();
  }

  /**
   * Puts the given string in the center or in the beginning of the line
   * surrounded by the horizontal frame above and below and, if needed, also the
   * vertical frame before and after. It's required to specify a frame length for
   * the horizontal frame.
   * 
   * @param toFrame       The <code>String</code> to put in the frame.
   * @param frameLength   The length of the horizontal frame.
   * @param centred       If the <code>String</code> needs to be centred or not.
   * @param verticalFrame If the vertical frame is needed or not.
   * 
   * @return A <code>String</code> containing the framed original string.
   */
  public static String frame(String toFrame, int frameLength, boolean centred, boolean verticalFrame) {
    StringBuffer framed = new StringBuffer(frameLength * 3);

    framed.append(repeatChar(HORIZONTAL_FRAME, frameLength) + NEW_LINE);

    if (verticalFrame)
      framed.append(VERTICAL_FRAME);

    if (centred)
      framed.append(verticalFrame ? center(toFrame, frameLength - 2) : (center(toFrame, frameLength) + NEW_LINE));
    else
      framed.append(verticalFrame ? column(toFrame, frameLength - 2) : column(toFrame, frameLength) + NEW_LINE);

    if (verticalFrame) {
      framed.append(VERTICAL_FRAME);
      framed.append(NEW_LINE);
    }

    framed.append(repeatChar(HORIZONTAL_FRAME, frameLength) + NEW_LINE);

    return framed.toString();
  }

  /**
   * Puts the given string at the beginning of the line and ads spaces until the
   * end of the line. If the string is too long for the width of the line it will
   * be cut.
   * 
   * @param toColumnise The string to put in column.
   * @param width       The length of the line.
   * 
   * @return A <code>String</code> containing the columnated string.
   */
  public static String column(String toColumnise, int width) {
    StringBuffer columnated = new StringBuffer(width);
    int charToPrint = Math.min(width, toColumnise.length());

    columnated.append(toColumnise.substring(0, charToPrint));

    columnated.append(repeatChar(SPACE, Math.max(0, width - toColumnise.length())));

    return columnated.toString();
  }

  /**
   * Puts the given string in the center of the line of the given length. If the
   * string is too long it will be cut.
   * 
   * @param toCenter The string to center.
   * @param width    The length of the line where to center the string.
   * 
   * @return A <code>String</code> containing the centred string.
   */
  public static String center(String toCenter, int width) {
    int toCenterLength = toCenter.length();
    StringBuffer centred = new StringBuffer(width);

    if (width < toCenterLength) {
      centred.append(toCenter.substring(width));
    } else if (width == toCenterLength) {
      centred.append(toCenter);
    } else {
      int whiteSpace = width - toCenterLength;
      int spacesBefore = Math.floorDiv(whiteSpace, 2);
      int spacesAfter = whiteSpace - spacesBefore;

      centred.append(repeatChar(SPACE, spacesBefore));

      centred.append(toCenter);

      centred.append(repeatChar(SPACE, spacesAfter));
    }

    return centred.toString();
  }

  /**
   * Repeats a given character a given number of times.
   * 
   * @param character The <code>char</code> to repeat.
   * @param times     The number of times to repeat the character.
   * 
   * @return A <code>String</code> containing the character repeated.
   */
  public static String repeatChar(char character, int times) {
    StringBuffer result = new StringBuffer(times);

    result.append(String.valueOf(character).repeat(Math.max(0, times)));

    return result.toString();
  }

  /**
   * Isolates a given string by adding an empty line before and after it.
   * 
   * @param toIsolate The string to isolate
   * 
   * @return A <code>String</code> containing the isolated string.
   */
  public static String isolatedLine(String toIsolate) {
    StringBuffer result = new StringBuffer();

    result.append(NEW_LINE);
    result.append(toIsolate);
    result.append(NEW_LINE);

    return result.toString();
  }
}