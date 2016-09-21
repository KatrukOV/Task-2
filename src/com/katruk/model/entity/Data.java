package com.katruk.model.entity;

import java.util.List;

public class Data {

	/**
	 * list of abstract data
	 */
	protected List<Data> listData;

	/**
	 * type of data
	 */
	protected TypeData typeData;

	public List<Data> getListData() {
		return listData;
	}

	public void setListData(List<Data> listData) {
		this.listData = listData;
	}

	public TypeData getTypeData() {
		return typeData;
	}

	public void setTypeData(TypeData typeData) {
		this.typeData = typeData;
	}

	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		for (Data abstractData: listData) {
			string.append(abstractData);
		}
		return String.valueOf(string);
	}
}
