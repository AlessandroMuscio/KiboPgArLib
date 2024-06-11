package com.kibo.pgar.lib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandLineTable {
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

  public void addHeaders(String... headers) {
    List<String> listHeaders = Arrays.asList(headers);

    this.headers.addAll(listHeaders);

    List<String> holes = new ArrayList<>();
    for (int i = 0; i < headers.length; i++)
      holes.add("");

    for (List<String> row : this.rows)
      row.addAll(holes);
  }
}
