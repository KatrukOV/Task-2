package com.katruk.model.logic;

import com.katruk.model.entity.Data;

import java.util.List;

public interface Operation {

  /**
   * get all word from data
   *
   * @param data input data
   * @return list of text
   */
  public List<String> getAllWord(Data data);

  /**
   * sort input list of text
   *
   * @param strings list of text
   * @return text
   */
  public String sortWord(List<String> strings);
}
