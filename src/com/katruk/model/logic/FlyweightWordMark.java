package com.katruk.model.logic;

import com.katruk.model.entity.Data;
import com.katruk.model.entity.Symbol;
import com.katruk.model.entity.TypeData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is using pattern FLYWEIGHT for the creating words
 */
class FlyweightWordMark {

  /**
   * private instance of class
   */
  private static FlyweightWordMark flyweight = new FlyweightWordMark();

  /**
   * Map of unique words
   */
  private Map<String, Data> cacheWordMark;

  /**
   * Default private constructor
   */
  private FlyweightWordMark() {
    this.cacheWordMark = new HashMap<>();
  }

  /**
   * get instance
   *
   * @return factory
   */
  public static FlyweightWordMark getInstance() {
    return flyweight;
  }

  /**
   * creates or return from list of cache Word or Mark
   *
   * @param type  type of Text
   * @param input input string
   * @return data
   */
  public Data create(TypeData type, String input) {

    if (cacheWordMark.containsKey(input)) {
      return cacheWordMark.get(input);
    } else {
      Data data = Factory.getInstance().create(type);
      data.setListData(stringToListSymbol(input));
      cacheWordMark.put(input, data);
      return data;
    }
  }

  //todo: in this place?

  /**
   * conversion string to list of data
   *
   * @param string input string
   * @return list of data
   */
  private List<Data> stringToListSymbol(String string) {
    List<Data> symbolList = new ArrayList<>();

    for (int i = 0; i < string.length(); i++) {
      Symbol symbol = FlyweightSymbol.Instance().create(string.charAt(i));
      symbolList.add(symbol);
    }
    return symbolList;
  }
}
