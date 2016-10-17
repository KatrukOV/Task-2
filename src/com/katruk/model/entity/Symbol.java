package com.katruk.model.entity;

public class Symbol extends Data {

  /**
   * one char
   */
  private char symbol;

  public void setSymbol(char symbol) {
    this.symbol = symbol;
  }

  public char getSymbol() {
    return symbol;
  }

  @Override
  public String toString() {
    return String.format("%c", symbol);
  }
}
