package com.katruk.model.logic;

import com.katruk.model.entity.*;
import com.katruk.model.entity.TypeData;

public class Factory {
	/**
	 * private instance of class
	 */
	private static Factory factory;

	/**
	 * default private constructor
	 */
	private Factory(){}

	/**
	 * get instance
	 * @return	factory
	 */
	public static Factory Instance(){
		if (factory != null) return factory;
		else return new Factory();
	}

	/**
	 * create element of data
	 * @param type	type of data
	 * @return		data
	 */
	public Data create(TypeData type){
		Data data;

		switch (type) {
			case SYMBOL:{
				data = new Symbol(); break;
			}
			default:
				data = new Data();
		}
		data.setTypeData(type);
		return data;

	}
}
