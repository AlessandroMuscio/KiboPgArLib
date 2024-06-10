package com.kibo.pgar.lib;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tests {
  private static final Logger LOGGER = LoggerFactory.getLogger(Tests.class);
  private static final String TEST_START = "Test Started - %s";
  private static final String TEST_END = "Test Ended - %s";
  private static final String[] TESTS_NAMES = new String[] { "AnsiClasses", "KnownProblems", "PrettyStrings" };

  @Test
  @Order(1)
  public void testAnsiClasses() {
    LOGGER.info(String.format(Tests.TEST_START, Tests.TESTS_NAMES[0]));

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

    assertTrue(true);

    LOGGER.info(String.format(Tests.TEST_END, Tests.TESTS_NAMES[0]));
  }

  @Test
  public void testKnownProblems() {
    LOGGER.info(String.format(Tests.TEST_START, Tests.TESTS_NAMES[1]));

    List<GCD_LCMTestCase> testCasesGCD_LCM = new ArrayList<>();
    testCasesGCD_LCM.add(new GCD_LCMTestCase(48, 18, 6, 144));
    testCasesGCD_LCM.add(new GCD_LCMTestCase(101, 103, 1, 10403));
    testCasesGCD_LCM.add(new GCD_LCMTestCase(56, 98, 14, 392));
    testCasesGCD_LCM.add(new GCD_LCMTestCase(144, 89, 1, 12816));
    testCasesGCD_LCM.add(new GCD_LCMTestCase(252, 105, 21, 1260));

    List<Map.Entry<Long, Long>> testCasesCountDigits = new ArrayList<>();
    testCasesCountDigits.add(new SimpleEntry<>(12345L, 5L));
    testCasesCountDigits.add(new SimpleEntry<>(0L, 1L));
    testCasesCountDigits.add(new SimpleEntry<>(-987L, 3L));
    testCasesCountDigits.add(new SimpleEntry<>(4567890123L, 10L));
    testCasesCountDigits.add(new SimpleEntry<>(1001L, 4L));

    List<Map.Entry<Double, Integer>> testCasesCountDecimalDigits = new ArrayList<>();
    testCasesCountDecimalDigits.add(new SimpleEntry<>(123.456, 3));
    testCasesCountDecimalDigits.add(new SimpleEntry<>(0.00789, 5));
    testCasesCountDecimalDigits.add(new SimpleEntry<>(-3.14, 2));
    testCasesCountDecimalDigits.add(new SimpleEntry<>(456.0, 1));
    testCasesCountDecimalDigits.add(new SimpleEntry<>(123.5, 1));

    for (GCD_LCMTestCase testCase : testCasesGCD_LCM) {
      assertEquals(testCase.getGCD(), KnownProblems.gcd(testCase.getA(), testCase.getB()));

      assertEquals(testCase.getLCM(), KnownProblems.lcm(testCase.getA(), testCase.getB()));
    }

    for (Map.Entry<Long, Long> testCase : testCasesCountDigits)
      assertEquals(testCase.getValue(), KnownProblems.countIntegerDigits(testCase.getKey()));

    for (Map.Entry<Double, Integer> testCase : testCasesCountDecimalDigits)
      assertEquals(testCase.getValue(), KnownProblems.countDecimalDigits(testCase.getKey()));

    LOGGER.info(String.format(Tests.TEST_END, Tests.TESTS_NAMES[1]));
  }

  @Test
  public void testPrettyStrings() {
    LOGGER.info(String.format(Tests.TEST_START, Tests.TESTS_NAMES[2]));

    final String NEW_LINE = "\n";
    final String SEPARATOR = NEW_LINE + "~~~~~~~~~~~~~~~~~~~~" + NEW_LINE;
    final String TEST_IL = "Isolated Line";
    final char TEST_RC = 'a';
    final String TEST_CL = "Column Left";
    final String TEST_CR = "Column Right";
    final String TEST_C = "Centered";
    final String TEST_FC = "Framed Centered, no VFrame";
    final String TEST_FCV = "Framed Centered, VFrame";
    final String TEST_FL = "Framed Left, no VFrame";
    final String TEST_FLV = "Framed Left, VFrame";
    final String TEST_FR = "Framed Right, no VFrame";
    final String TEST_FRV = "Framed Right, VFrame";

    final FrameSettings SETTINGS_FC = new FrameSettings(30, Alignment.CENTER, false);
    final FrameSettings SETTINGS_FCV = new FrameSettings(27, Alignment.CENTER, true);
    final FrameSettings SETTINGS_FL = new FrameSettings(26, Alignment.LEFT, false);
    final FrameSettings SETTINGS_FLV = new FrameSettings(23, Alignment.LEFT, true);
    final FrameSettings SETTINGS_FR = new FrameSettings(27, Alignment.RIGHT, false);
    final FrameSettings SETTINGS_FRV = new FrameSettings(24, Alignment.RIGHT, true);

    StringBuilder builder = new StringBuilder();

    builder.append(PrettyStrings.isolatedLine(TEST_IL));

    builder.append(SEPARATOR);

    builder.append(PrettyStrings.repeatChar(TEST_RC, 10));

    builder.append(SEPARATOR);

    builder.append(PrettyStrings.column(TEST_CL, 16, true));
    builder.append(NEW_LINE);
    builder.append(PrettyStrings.column(TEST_CR, 16, false));

    builder.append(SEPARATOR);

    builder.append(PrettyStrings.center(TEST_C, 18));

    builder.append(SEPARATOR);

    builder.append(PrettyStrings.frame(TEST_FC, SETTINGS_FC));
    builder.append(NEW_LINE);
    builder.append(PrettyStrings.frame(TEST_FCV, SETTINGS_FCV));
    builder.append(NEW_LINE);
    builder.append(PrettyStrings.frame(TEST_FL, SETTINGS_FL));
    builder.append(NEW_LINE);
    builder.append(PrettyStrings.frame(TEST_FLV, SETTINGS_FLV));
    builder.append(NEW_LINE);
    builder.append(PrettyStrings.frame(TEST_FR, SETTINGS_FR));
    builder.append(NEW_LINE);
    builder.append(PrettyStrings.frame(TEST_FRV, SETTINGS_FRV));
    builder.append(NEW_LINE);

    LOGGER.info(builder.toString());

    assertTrue(true);

    LOGGER.info(String.format(Tests.TEST_END, Tests.TESTS_NAMES[2]));
  }
}
