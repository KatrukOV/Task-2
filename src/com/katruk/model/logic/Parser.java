package com.katruk.model.logic;

import com.katruk.model.entity.Data;


public interface Parser {

  /**
   * made book
   *
   * @param string input text
   * @return book
   */
  public Data parserAll(String string);
}
