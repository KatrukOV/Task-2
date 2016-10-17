package com.katruk.model.logic;

import com.katruk.model.entity.Symbol;
import com.katruk.model.entity.TypeData;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is using pattern FLYWEIGHT for the creating words and marks
 */
class FlyweightSymbol {

  /**
   * private instance of class
   */
  private static FlyweightSymbol flyweight;

  /**
   * Map of unique symbol
   */
  private Map<Character, Symbol> cacheSymbol;

  /**
   * default private constructor
   */
  private FlyweightSymbol() {
    this.cacheSymbol = new HashMap<>();
  }

  /**
   * get instance
   *
   * @return factory
   */
  public static FlyweightSymbol Instance() {
    if (flyweight != null) {
      return flyweight;
    } else {
      return new FlyweightSymbol();
    }
  }

  /**
   * creates or return from list of cache symbol
   *
   * @param input input string
   * @return data
   */
  public Symbol create(char input) {
    if (cacheSymbol.containsKey(input)) {
      return cacheSymbol.get(input);
    } else {
      Symbol symbol = (Symbol) Factory.getInstance().create(TypeData.SYMBOL);
      symbol.setSymbol(input);
      cacheSymbol.put(input, symbol);
      return symbol;
    }
  }
}
