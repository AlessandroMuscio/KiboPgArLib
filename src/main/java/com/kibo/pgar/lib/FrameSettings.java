package com.kibo.pgar.lib;

/**
 * <code>Class</code> that let's you specify the settings for framing a
 * <code>String</code>.
 * 
 * @author Alessandro Muscio (Kibo)
 */
public class FrameSettings {
  private static final char HORIZONTAL_FRAME = '-';
  private static final char VERTICAL_FRAME = '|';

  private int width;
  private Alignment alignment;
  private char horizontalFrame;
  private boolean verticalFrameEnabled;
  private char verticalFrame;

  /**
   * Creates a new <i>settings</i> instance specifying the width of the frame, its
   * alignment and if the vertical frame is enabled or not. The constructor will
   * automatically set the default vertical and horizontal frame, change it with
   * the appropriate setters.
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
