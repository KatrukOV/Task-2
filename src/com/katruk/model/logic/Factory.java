package com.katruk.model.logic;

import com.katruk.model.entity.*;
import com.katruk.model.entity.TypeData;

class Factory {

	/**
	 * private instance of class
	 */
	private static Factory factory = new Factory();

	/**
	 * default private constructor
	 */
	private Factory(){}

	/**
	 * get instance
	 * @return	factory
	 */
	public static Factory getInstance(){
		 return factory;
	}

	/**
	 * create element of data
	 * @param type	type of data
	 * @return		data
	 */
	public Data create(TypeData type){
		Data data;

		switch (type) {
			case SYMBOL:{ data = new Symbol(); break;}
			default:      data = new Data();
		}

		data.setTypeData(type);
		return data;
	}
}
