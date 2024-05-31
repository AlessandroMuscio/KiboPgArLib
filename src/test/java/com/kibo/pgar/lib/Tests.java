package com.kibo.pgar.lib;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tests {
  private static final Logger LOGGER = LoggerFactory.getLogger(Tests.class);

  @Test
  public void testAnsiClasses() {
    LOGGER.info("Test Started!");

    final String NEW_LINE = "\n";
    final String SEPARATOR = "~~~~~~~~~~~~~~~~~~~~" + NEW_LINE;

    List<AnsiColors> colors = new ArrayList<>(Arrays.asList(AnsiColors.values()));
    List<AnsiWeights> weights = new ArrayList<>(Arrays.asList(AnsiWeights.values()));
    List<AnsiDecorations> decorations = new ArrayList<>(Arrays.asList(AnsiDecorations.values()));
    AnsiColors reset = colors.remove(0);
    StringBuilder builder = new StringBuilder();

    weights.remove(0);
    decorations.remove(0);

    builder.append(NEW_LINE);
    for (AnsiColors color : colors) {
      builder.append(color.toString());
      builder.append(color.name().toLowerCase());
      builder.append(reset.toString());

      builder.append(NEW_LINE);
    }

    builder.append(SEPARATOR);

    for (AnsiWeights weight : weights) {
      builder.append(weight.toString());
      builder.append(weight.name().toLowerCase());
      builder.append(reset.toString());

      builder.append(NEW_LINE);
    }

    builder.append(SEPARATOR);

    for (AnsiDecorations decoration : decorations) {
      String name = decoration.name().toLowerCase();
      String current_new_line = name.equals("double_underline") ? NEW_LINE + NEW_LINE : NEW_LINE;

      builder.append(decoration.toString());
      builder.append(name);
      builder.append(reset.toString());

      builder.append(current_new_line);
    }

    LOGGER.info(builder.toString());

    LOGGER.info("Test Ended!");
    assertTrue(true);
  }
}
