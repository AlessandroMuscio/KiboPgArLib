package com.kibo.pgar.lib;

public class PrettyStrings {
  private static final String UNSUPPORTED_OP_ERR_MSG = String
      .format("%sThis class isn't instantiable!%s", AnsiColors.RED, AnsiColors.RESET);
  private static final char SPACE = ' ';
  private static final char NEW_LINE = '\n';

  public PrettyStrings() throws UnsupportedOperationException {
    throw new UnsupportedOperationException(PrettyStrings.UNSUPPORTED_OP_ERR_MSG);
  }

  public static String frame(String toFrame, FrameSettings settings) {
    StringBuilder framed = new StringBuilder();
    String horizontalFrame = PrettyStrings.repeatChar(settings.getHorizontalFrame(), settings.getWidth());

    framed.append(horizontalFrame);
    framed.append(PrettyStrings.NEW_LINE);

    if (settings.isVerticalFrameEnabled()) {
      settings.setWidth(settings.getWidth() - 2);

      framed.append(settings.getVerticalFrame());
    }

    if (settings.getAlignment().equals(Alignment.CENTER))
      framed.append(PrettyStrings.center(toFrame, settings.getWidth()));
    else
      framed.append(PrettyStrings.column(
          toFrame,
          settings.getWidth(),
          settings.getAlignment().equals(Alignment.LEFT)));

    framed.append(settings.isVerticalFrameEnabled() ? settings.getVerticalFrame() : "");

    framed.append(PrettyStrings.isolatedLine(horizontalFrame));

    return framed.toString();
  }

  public static String column(String toColumnize, int width, boolean left) {
    int toColumnizeLength = toColumnize.length();
    int charsToPrint = Math.min(width, toColumnizeLength);

    String columned = toColumnizeLength > charsToPrint ? toColumnize.substring(0, charsToPrint) : toColumnize;
    String spaces = PrettyStrings.repeatChar(PrettyStrings.SPACE, width - toColumnizeLength);

    return left ? columned.concat(spaces) : spaces.concat(columned);
  }

  public static String center(String toCenter, int width) {
    int toCenterLength = toCenter.length();

    if (toCenterLength > width)
      return toCenter.substring(0, width);

    if (toCenterLength == width)
      return toCenter;

    StringBuilder builder = new StringBuilder(width);
    int whitespaces = width - toCenterLength;
    int whitespacesBefore = Math.floorDiv(whitespaces, 2);
    int whitespacesAfter = whitespaces - whitespacesBefore;

    builder.append(PrettyStrings.repeatChar(PrettyStrings.SPACE, whitespacesBefore));
    builder.append(toCenter);
    builder.append(PrettyStrings.repeatChar(PrettyStrings.SPACE, whitespacesAfter));

    return builder.toString();
  }

  public static String repeatChar(char character, int times) {
    return String.valueOf(character).repeat(Math.max(0, times));
  }

  public static String isolatedLine(String toIsolate) {
    StringBuilder builder = new StringBuilder();

    builder.append(PrettyStrings.NEW_LINE);
    builder.append(toIsolate);
    builder.append(PrettyStrings.NEW_LINE);

    return builder.toString();
  }

  public static String prettify(String toPrettify, AnsiColors color, AnsiWeights weight, AnsiDecorations decoration) {
    StringBuilder builder = new StringBuilder();
    boolean reset = false;

    if (color != null) {
      reset = true;
      builder.append(color);
    }

    if (weight != null) {
      reset = true;
      builder.append(weight);
    }

    if (decoration != null) {
      reset = true;
      builder.append(decoration);
    }

    builder.append(toPrettify);

    if (reset)
      builder.append(AnsiColors.RESET);

    return builder.toString();
  }
}
