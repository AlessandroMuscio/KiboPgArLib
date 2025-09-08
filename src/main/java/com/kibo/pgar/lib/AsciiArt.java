package com.kibo.pgar.lib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class AsciiArt {
  private static final String UNSUPPORTED_OP_ERR_MSG = String.format("%sThis class isn't instantiable!%s",
      AnsiColors.RED, AnsiColors.RESET);

  private static final String A = """
       █████╗\s
      ██╔══██╗
      ███████║
      ██╔══██║
      ██║  ██║
      ╚═╝  ╚═╝
       """;
  private static final String B = """
      ██████╗\s
      ██╔══██╗
      ██████╔╝
      ██╔══██╗
      ██████╔╝
      ╚═════╝\s
      """;
  private static final String C = """
       ██████╗
      ██╔════╝
      ██║    \s
      ██║    \s
      ╚██████╗
       ╚═════╝
      """;
  private static final String D = """
      ██████╗\s
      ██╔══██╗
      ██║  ██║
      ██║  ██║
      ██████╔╝
      ╚═════╝\s
      """;
  private static final String E = """
      ███████╗
      ██╔════╝
      █████╗ \s
      ██╔══╝ \s
      ███████╗
      ╚══════╝
      """;
  private static final String F = """
      ███████╗
      ██╔════╝
      █████╗ \s
      ██╔══╝ \s
      ██║    \s
      ╚═╝    \s
      """;
  private static final String G = """
       ██████╗\s
      ██╔════╝\s
      ██║  ███╗
      ██║   ██║
      ╚██████╔╝
       ╚═════╝\s
      """;
  private static final String H = """
      ██╗  ██╗
      ██║  ██║
      ███████║
      ██╔══██║
      ██║  ██║
      ╚═╝  ╚═╝
      """;
  private static final String I = """
      ██╗
      ██║
      ██║
      ██║
      ██║
      ╚═╝
      """;
  private static final String J = """
           ██╗
           ██║
           ██║
      ██   ██║
      ╚█████╔╝
       ╚════╝\s
      """;
  private static final String K = """
      ██╗  ██╗
      ██║ ██╔╝
      █████╔╝\s
      ██╔═██╗\s
      ██║  ██╗
      ╚═╝  ╚═╝
      """;
  private static final String L = """
      ██╗    \s
      ██║    \s
      ██║    \s
      ██║    \s
      ███████╗
      ╚══════╝
      """;
  private static final String M = """
      ███╗   ███╗
      ████╗ ████║
      ██╔████╔██║
      ██║╚██╔╝██║
      ██║ ╚═╝ ██║
      ╚═╝     ╚═╝
      """;
  private static final String N = """
      ███╗   ██╗
      ████╗  ██║
      ██╔██╗ ██║
      ██║╚██╗██║
      ██║ ╚████║
      ╚═╝  ╚═══╝
      """;
  private static final String O = """
       ██████╗\s
      ██╔═══██╗
      ██║   ██║
      ██║   ██║
      ╚██████╔╝
       ╚═════╝\s
      """;
  private static final String P = """
      ██████╗\s
      ██╔══██╗
      ██████╔╝
      ██╔═══╝\s
      ██║    \s
      ╚═╝    \s
      """;
  private static final String Q = """
       ██████╗\s
      ██╔═══██╗
      ██║   ██║
      ██║▄▄ ██║
      ╚██████╔╝
       ╚══▀▀═╝\s
      """;
  private static final String R = """
      ██████╗\s
      ██╔══██╗
      ██████╔╝
      ██╔══██╗
      ██║  ██║
      ╚═╝  ╚═╝
      """;
  private static final String S = """
      ███████╗
      ██╔════╝
      ███████╗
      ╚════██║
      ███████║
      ╚══════╝
      """;
  private static final String T = """
      ████████╗
      ╚══██╔══╝
         ██║  \s
         ██║  \s
         ██║  \s
         ╚═╝  \s
      """;
  private static final String U = """
      ██╗   ██╗
      ██║   ██║
      ██║   ██║
      ██║   ██║
      ╚██████╔╝
       ╚═════╝\s
      """;
  private static final String V = """
      ██╗   ██╗
      ██║   ██║
      ██║   ██║
      ╚██╗ ██╔╝
       ╚████╔╝\s
        ╚═══╝ \s
      """;
  private static final String W = """
      ██╗    ██╗
      ██║    ██║
      ██║ █╗ ██║
      ██║███╗██║
      ╚███╔███╔╝
       ╚══╝╚══╝\s
      """;
  private static final String X = """
      ██╗  ██╗
      ╚██╗██╔╝
       ╚███╔╝\s
       ██╔██╗\s
      ██╔╝ ██╗
      ╚═╝  ╚═╝
      """;
  private static final String Y = """
      ██╗   ██╗
      ╚██╗ ██╔╝
       ╚████╔╝\s
        ╚██╔╝ \s
         ██║  \s
         ╚═╝  \s
      """;
  private static final String Z = """
      ███████╗
      ╚══███╔╝
        ███╔╝\s
       ███╔╝ \s
      ███████╗
      ╚══════╝
      """;
  private static final List<String> ALPHABET = new ArrayList<>(
      Arrays.asList(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z));

  private static final String SPACE = """
      \s\s\s\s\s\s
      \s\s\s\s\s\s
      \s\s\s\s\s\s
      \s\s\s\s\s\s
      \s\s\s\s\s\s
      \s\s\s\s\s\s
      """;;

  private static final String ZERO = """
       ██████╗\s
      ██╔═████╗
      ██║██╔██║
      ████╔╝██║
      ╚██████╔╝
       ╚═════╝\s
      """;;
  private static final String ONE = """
       ██╗
      ███║
      ╚██║
       ██║
       ██║
       ╚═╝
      """;;
  private static final String TWO = """
      ██████╗\s
      ╚════██╗
       █████╔╝
      ██╔═══╝\s
      ███████╗
      ╚══════╝
      """;
  private static final String THREE = """
      ██████╗\s
      ╚════██╗
       █████╔╝
       ╚═══██╗
      ██████╔╝
      ╚═════╝\s
      """;
  private static final String FOUR = """
      ██╗  ██╗
      ██║  ██║
      ███████║
      ╚════██║
           ██║
           ╚═╝
      """;
  private static final String FIVE = """
      ███████╗
      ██╔════╝
      ███████╗
      ╚════██║
      ███████║
      ╚══════╝
      """;
  private static final String SIX = """
       ██████╗\s
      ██╔════╝\s
      ███████╗\s
      ██╔═══██╗
      ╚██████╔╝
       ╚═════╝\s
      """;
  private static final String SEVEN = """
      ███████╗
      ╚════██║
          ██╔╝
         ██╔╝\s
         ██║ \s
         ╚═╝ \s
      """;
  private static final String EIGHT = """
       █████╗\s
      ██╔══██╗
      ╚█████╔╝
      ██╔══██╗
      ╚█████╔╝
       ╚════╝\s
      """;
  private static final String NINE = """
       █████╗\s
      ██╔══██╗
      ╚██████║
       ╚═══██║
       █████╔╝
       ╚════╝\s
      """;
  private static final List<String> NUMBERS = new ArrayList<>(
      Arrays.asList(ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE));

  private static final int LINE_HEIGHT = 6;
  private static final char HORIZONTAL_FRAME = '~';
  private static final char VERTICAL_FRAME = '|';

  private AsciiArt() throws UnsupportedOperationException {
    throw new UnsupportedOperationException(AsciiArt.UNSUPPORTED_OP_ERR_MSG);
  }

  public static String createTitle(String toAscii, boolean useFrame) throws Exception {
    StringBuilder title = new StringBuilder();
    char[] toAsciiChars = toAscii.trim().toUpperCase().toCharArray();

    for (int i = 0; i < AsciiArt.LINE_HEIGHT; i++) {
      for (int j = 0; j < toAsciiChars.length; j++) {
        char character = toAsciiChars[j];

        String charAsciiArt;
        if (character == ' ')
          charAsciiArt = AsciiArt.SPACE;
        else if (character >= 'A' && character <= 'Z')
          charAsciiArt = AsciiArt.ALPHABET.get(character - 'A');
        else if (character >= '0' && character <= '9')
          charAsciiArt = AsciiArt.NUMBERS.get(character - '0');
        else
          throw new Exception(); // TODO: handle error

        /*
         * Let's explain the logic here. Our characters span on multiple rows, what we do with the first
         * while loop is simply got to the first position of the char array that has the first position of
         * the line we currently need to print. The second while will loop that line and add every character
         * form it.
         * 
         * In the and if the character isn't a space, it isn't the last one and the character after it isn't
         * a space we ad a space on this line to correctly have some space between characters in order to
         * not have all of them glued together.
         */
        int newLineCounter = 0;
        int position = 0;

        char[] charAsciiArtArray = charAsciiArt.toCharArray();
        while (newLineCounter < i) {
          if (charAsciiArtArray[position] == '\n')
            newLineCounter++;

          position++;
        }

        while (charAsciiArtArray[position] != '\n') {
          title.append(charAsciiArtArray[position]);
          position++;
        }

        if (character != ' ' && j != toAsciiChars.length - 1 && toAsciiChars[j + 1] != ' ')
          title.append(' ');
      }

      if (i != AsciiArt.LINE_HEIGHT - 1)
        title.append('\n');
    }

    if (useFrame) {
      int frameLength = (title.length() / AsciiArt.LINE_HEIGHT) + AsciiArt.LINE_HEIGHT;
      String hFrame = PrettyStrings.repeatChar(AsciiArt.HORIZONTAL_FRAME, frameLength);
      hFrame = "%s\n".formatted(hFrame);

      title.insert(0, hFrame);

      for (int i = 0; i < AsciiArt.LINE_HEIGHT; i++) {
        /*
         * It needs to be at the beginning of the line. So we have at least one `frameLength` for the
         * `hFrame` and then one for each line we have. After that we need to account for every new line
         * character. And then we add 1, because we want the vFrame to be placed after.
         */
        int startOffset = (frameLength * (i + 1)) + i + 1;
        int endOffset = (frameLength * (i + 2)) + i - 2;

        title.insert(startOffset, "%s  ".formatted(AsciiArt.VERTICAL_FRAME));
        title.insert(endOffset, "  %s".formatted(AsciiArt.VERTICAL_FRAME));
      }

      title.append('\n').append(hFrame);
    }

    return title.toString();
  }
}
