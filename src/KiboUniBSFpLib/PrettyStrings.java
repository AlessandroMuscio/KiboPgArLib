package KiboUniBSFpLib;

public class PrettyStrings {
  private final static char SPACE = ' ';
  private final static char FRAME = '-';
  private final static char NEW_LINE = '\n';

  public static String frame(String toFrame, int frameLength) {
    StringBuffer framed = new StringBuffer(frameLength * 3);

    framed.append(repeatChar(FRAME, frameLength) + NEW_LINE);

    framed.append(center(toFrame, frameLength) + NEW_LINE);

    framed.append(repeatChar(FRAME, frameLength) + NEW_LINE);

    return framed.toString();
  }

  public static String column(String toColumnise, int width) {
    StringBuffer columnated = new StringBuffer(width);
    int charToPrint = Math.min(width, toColumnise.length());

    columnated.append(toColumnise.substring(0, charToPrint));

    columnated.append(repeatChar(SPACE, Math.max(0, width - toColumnise.length())));

    return columnated.toString();
  }

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

  public static String repeatChar(char character, int times) {
    StringBuffer result = new StringBuffer(times);

    result.append(String.valueOf(character).repeat(Math.max(0, times)));

    return result.toString();
  }

  public static String isolatedLine(String toIsolate) {
    StringBuffer result = new StringBuffer();

    result.append(NEW_LINE);
    result.append(toIsolate);
    result.append(NEW_LINE);

    return result.toString();
  }
}
