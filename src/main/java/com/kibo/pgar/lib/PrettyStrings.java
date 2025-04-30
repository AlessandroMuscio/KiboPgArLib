package com.kibo.pgar.lib;

/**
 * <code>Class</code> that let's you prettify the strings to output in the terminal.
 * 
 * @author Alessandro Muscio (Kibo)
 */
public class PrettyStrings {
  private static final String UNSUPPORTED_OP_ERR_MSG = String.format("%sThis class isn't instantiable!%s",
      AnsiColors.RED, AnsiColors.RESET);
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
      framed.append(PrettyStrings.column(toFrame, settings.getWidth(), settings.getAlignment().equals(Alignment.LEFT)));

    framed.append(settings.isVerticalFrameEnabled() ? settings.getVerticalFrame() : "");

    framed.append(PrettyStrings.isolatedLine(horizontalFrame));

    return framed.toString();
  }

  /**
   * Columnize the given <code>String</code>, to the left or to the right.
   * 
   * @param toColumnize The <code>String</code> to columnize.
   * @param width       The width where to columnize the <code>String</code>.
   * @param left        If columnize it to the left or to the right.
   * 
   * @return A <code>String</code> representing the given one columnized.
   */
  public static String column(String toColumnize, int width, boolean left) {
    int toColumnizeLength = toColumnize.length();
    int charsToPrint = Math.min(width, toColumnizeLength);

    String columned = toColumnizeLength > charsToPrint ? toColumnize.substring(0, charsToPrint) : toColumnize;
    String spaces = PrettyStrings.repeatChar(PrettyStrings.SPACE, width - toColumnizeLength);

    return left ? columned.concat(spaces) : spaces.concat(columned);
  }

  /**
   * Centers the given <code>String</code> in the given space.
   * 
   * @param toCenter The <code>String</code> to center.
   * @param width    The width where to center the <code>String</code>.
   * 
   * @return A <code>String</code> representing the given one centered.
   */
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

  /**
   * Repeats a given <code>char</code> for a given number of times.
   * 
   * @param character The <code>char</code> to repeat.
   * @param times     The number of times to repeat the <code>char</code>.
   * 
   * @return A <code>String</code> representing the given <code>char</code> repeated the given number
   *         of times.
   */
  public static String repeatChar(char character, int times) {
    return String.valueOf(character).repeat(Math.max(0, times));
  }

  /**
   * Isolates the given <code>String</code>.
   * 
   * @param toIsolate The <code>String</code> to isolate.
   * 
   * @return A <code>String</code> isolated in it's own line.
   */
  public static String isolatedLine(String toIsolate) {
    StringBuilder builder = new StringBuilder();

    builder.append(PrettyStrings.NEW_LINE);
    builder.append(toIsolate);
    builder.append(PrettyStrings.NEW_LINE);

    return builder.toString();
  }

  /**
   * Prettifies the given <code>String</code> by adding a <i>color</i>, <i>weight</i> and
   * <i>decoration</i>, if given.
   * 
   * @param toPrettify The <code>String</code> to be prettified.
   * @param color      The color given to the <code>String</code>, <code>null</code> for default
   *                   color.
   * @param weight     The weight given to the <code>String</code>, <code>null</code> for default
   *                   weight.
   * @param decoration The decoration given to the <code>String</code>, <code>null</code> for no
   *                   decoration.
   * 
   * @return A <code>String</code> representing the given one prettified.
   */
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

/**
 * <code>Class</code> that let's you specify the settings for framing a <code>String</code>.
 * 
 * @author Alessandro Muscio (Kibo)
 */
class FrameSettings {
  private static final char HORIZONTAL_FRAME = '-';
  private static final char VERTICAL_FRAME = '|';

  private int width;
  private Alignment alignment;
  private char horizontalFrame;
  private boolean verticalFrameEnabled;
  private char verticalFrame;

  /**
   * Creates a new <i>settings</i> instance specifying the width of the frame, its alignment and if
   * the vertical frame is enabled or not. The constructor will automatically set the default vertical
   * and horizontal frame, change it with the appropriate setters.
   *
   * @param width                The width of the frame.
   * @param alignment            The alignment of the frame.
   * @param verticalFrameEnabled If teh vertical frame is enabled or not.
   */
  public FrameSettings(int width, Alignment alignment, boolean verticalFrameEnabled) {
    this.width = width;
    this.alignment = alignment;
    this.horizontalFrame = FrameSettings.HORIZONTAL_FRAME;
    this.verticalFrameEnabled = verticalFrameEnabled;
    this.verticalFrame = FrameSettings.VERTICAL_FRAME;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public Alignment getAlignment() {
    return alignment;
  }

  public void setAlignment(Alignment alignment) {
    this.alignment = alignment;
  }

  public char getHorizontalFrame() {
    return horizontalFrame;
  }

  public void setHorizontalFrame(char horizontalFrame) {
    this.horizontalFrame = horizontalFrame;
  }

  public boolean isVerticalFrameEnabled() {
    return verticalFrameEnabled;
  }

  public void setVerticalFrameEnabled(boolean useVerticalFrame) {
    this.verticalFrameEnabled = useVerticalFrame;
  }

  public char getVerticalFrame() {
    return verticalFrame;
  }

  public void setVerticalFrame(char verticalFrame) {
    this.verticalFrame = verticalFrame;
  }
}
