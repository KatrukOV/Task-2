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
public class FlyweightWordMark {

	/**
	 * private instance of class
	 */
	private static FlyweightWordMark flyweight;

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
	 * @return	factory
	 */
	public static FlyweightWordMark Instance(){
		if (flyweight != null) return flyweight;
		else return new FlyweightWordMark();
	}

	/**
	 * creates or return from list of cache Word or Mark
	 * @param type		type of Text
	 * @param input		input string
	 * @return			data
	 */
	public Data create(TypeData type, String input) {

		if(cacheWordMark.containsKey(input)){
			return cacheWordMark.get(input);
		} else {
			Data data = Factory.Instance().create(type);
			data.setListData(stringToListSymbol(input));
			cacheWordMark.put(input, data);
			return data;
		}
	}

	/**
	 * conversion string to list of data
	 * @param string		input string
	 * @return				list of data
	 */
	private List<Data> stringToListSymbol(String string){
		List<Data> symbolList = new ArrayList<Data>();

		for (int i = 0; i < string.length(); i++) {
			Symbol symbol = FlyweightSymbol.Instance().create(string.charAt(i));
			symbolList.add(symbol);
		}
		return symbolList;
	}
}
