package com.kibo.pgar.lib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class CommandLineTable {
  private static final String RED_ERROR = PrettyStrings.prettify("Error!", AnsiColors.RED, AnsiWeights.BOLD, null);
  private static final String ADD_ROWS_EXCEPTION = "All the rows must be lists of the same length as of the headers.";

  private static final char HORIZONTAL_SEPARATOR = '-';
  private static final char VERTICAL_SEPARATOR = '|';
  private static final char[] JOIN_SEPARATOR = new char[] { ' ', '+' };

  private boolean showVLines;
  private Alignment cellsAlignment;
  private List<String> headers;
  private List<List<String>> rows;

  public CommandLineTable() {
    this.showVLines = false;
    this.cellsAlignment = Alignment.LEFT;
    this.headers = new ArrayList<>();
    this.rows = new ArrayList<>();
  }

  public boolean isShowVLines() {
    return showVLines;
  }

  public void setShowVLines(boolean showVLines) {
    this.showVLines = showVLines;
  }

  public Alignment getCellsAlignment() {
    return cellsAlignment;
  }

  public void setCellsAlignment(Alignment cellsAlignment) {
    this.cellsAlignment = cellsAlignment;
  }

  public List<String> getHeaders() {
    return headers;
  }

  public void setHeaders(List<String> headers) {
    this.headers = headers;
  }

  public List<List<String>> getRows() {
    return rows;
  }

  public void setRows(List<List<String>> rows) {
    this.rows = rows;
  }

  public void addHeaders(List<String> headers) {
    this.headers.addAll(headers);

    List<String> rowFillings = Collections.nCopies(headers.size(), "");
    for (List<String> row : this.rows)
      row.addAll(rowFillings);
  }

  public void addRows(List<List<String>> rows) throws IllegalArgumentException {
    for (List<String> row : rows) {
      if (row.size() != this.headers.size())
        throw new IllegalArgumentException(CommandLineTable.RED_ERROR + "\n" + CommandLineTable.ADD_ROWS_EXCEPTION);
    }

    this.rows.addAll(rows);
  }

  public void fillHoles(List<List<String>> fillings) {
    int fillI = 0;

    for (int i = 0; i < this.rows.size(); i++) {
      List<String> row = this.rows.get(i);
      int fillJ = 0;
      boolean filled = false;

      for (int j = 0; j < row.size(); j++) {
        String cell = row.get(j);

        if (fillI >= fillings.size() || fillJ >= fillings.get(fillI).size() || !cell.isEmpty())
          continue;

        this.rows.get(i).set(j, fillings.get(fillI).get(fillJ));
        filled = true;
        fillJ++;
      }

      fillI += filled ? 1 : 0;
    }
  }

  @Override
  public String toString() {
    StringJoiner tableStrJoiner = new StringJoiner("\n");

    List<List<String>> table = new ArrayList<>(this.rows);
    table.add(0, this.headers);

    List<Integer> widths = this.getMaxWidthsPerColumn(table);

    String hFrame = this.buildHFrame(widths);

    for (List<String> row : table) {
      tableStrJoiner.add(hFrame);

      StringJoiner rowStrJoiner = new StringJoiner(this.showVLines ? "" : " ");
      for (int i = 0; i < row.size(); i++) {
        String cell = row.get(i);

        if (i == 0 && this.showVLines)
          rowStrJoiner.add(Character.toString(CommandLineTable.VERTICAL_SEPARATOR));

        String formattedCell = "";
        if (this.cellsAlignment.equals(Alignment.CENTER)) {
          formattedCell = PrettyStrings.center(cell, widths.get(i));
        } else {
          boolean left = this.cellsAlignment.getIndex() < 0;
          formattedCell = PrettyStrings.column(cell, widths.get(i), left);
        }

        rowStrJoiner.add(formattedCell);

        if (this.showVLines)
          rowStrJoiner.add(Character.toString(CommandLineTable.VERTICAL_SEPARATOR));
      }

      tableStrJoiner.add(rowStrJoiner.toString());
    }

    tableStrJoiner.add(hFrame);

    return tableStrJoiner.toString();
  }

  private String buildHFrame(List<Integer> widths) {
    StringBuilder frame = new StringBuilder();

    for (int i = 0; i < widths.size(); i++) {
      int width = widths.get(i);
      StringBuilder framePiece = new StringBuilder();

      if (i == 0 && this.showVLines)
        framePiece.append(CommandLineTable.JOIN_SEPARATOR[1]);

      framePiece.append(PrettyStrings.repeatChar(CommandLineTable.HORIZONTAL_SEPARATOR, width));

      framePiece.append(CommandLineTable.JOIN_SEPARATOR[this.showVLines ? 1 : 0]);

      frame.append(framePiece.toString());
    }

    return frame.toString();
  }

  private List<Integer> getMaxWidthsPerColumn(List<List<String>> table) {
    List<Integer> widths = new ArrayList<>(Collections.nCopies(this.headers.size(), 0));

    for (List<String> row : table) {
      for (int i = 0; i < row.size(); i++) {
        String cell = row.get(i);
        widths.set(i, Math.max(widths.get(i), cell.length()));
      }
    }

    return widths.stream()
        .map(x -> x + (this.cellsAlignment == Alignment.CENTER ? 2 : 1))
        .collect(Collectors.toList());
  }
}