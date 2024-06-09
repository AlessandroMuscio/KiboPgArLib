package com.kibo.pgar.lib;

public class FrameSettings {
  private static final char HORIZONTAL_FRAME = '-';
  private static final char VERTICAL_FRAME = '|';

  private int width;
  private Alignment alignment;
  private char horizontalFrame;
  private boolean verticalFrameEnabled;
  private char verticalFrame;

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
