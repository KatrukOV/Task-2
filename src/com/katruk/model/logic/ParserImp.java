package com.katruk.model.logic;

import com.katruk.model.entity.*;
import com.katruk.model.entity.TypeData;

import java.util.*;

public class ParserImp implements Parser, KeyChar, KeyWord {

	@Override
	public Data parserAll(String string){
		checkNull(string);
		Data book = Factory.getInstance().create(TypeData.BOOK);
		book.setListData(makeBook(string));
		return book;
	}

	/**
	 * make list of abstract data
	 * @param string	text
	 * @return			list of data
	 */
	private List<Data> makeBook(String string){
		String[] strings = makeParagraph(string);

		List<Data> list = new ArrayList<>();

		for (int i = 0; i < strings.length; i++) {
			strings[i] = makeOneSpace(strings[i]);
			if (isCode(strings[i])) {
				Data code = Factory.getInstance().create(TypeData.CODE);
				code.setListData(stringToListSymbol(strings[i]));
				list.add(code);
			} else {
				Data text = Factory.getInstance().create(TypeData.TEXT);
				text.setListData(makeText(strings[i]));
				list.add(text);
			}
		}
		return list;
	}

	/**
	 * make one space in text
	 * @param string	input text
	 * @return			change text
	 */
	private String makeOneSpace(String string){
		return string.replaceAll(ALL_SPACE, ONE_SPACE);
	}

	/**
	 * make paragraph
	 * @param string	text
	 * @return			array of text
	 */
	private String[] makeParagraph (String string){
		String[] strings = string.split(LINE_BREAK);
		for (int i = 0; i < strings.length; i++) {
			strings[i] += ONE_SPACE;
		}
		return strings;
	}

	/**
	 * check text
	 * @param string	text
	 * @return			true if text is code
	 */
	private boolean isCode(String string){
		int firstChar = 0;
		if (string.charAt(firstChar) == CHAR_SPACE) firstChar++;
		return Character.isLowerCase(string.charAt(firstChar))
				|| string.charAt(firstChar) == CHAR_BRACE_BEGIN
				|| string.charAt(firstChar) == CHAR_BRACE_END;
	}

	/**
	 * make list of symbol
	 * @param string	text
	 * @return			list of symbol
	 */
	private List<Data> stringToListSymbol(String string){
		List<Data> symbolList = new ArrayList<>();

		for (int i = 0; i < string.length(); i++){
			Symbol symbol = FlyweightSymbol.Instance().create(string.charAt(i));
			symbolList.add(symbol);
		}
		return symbolList;
	}

	/**
	 * make text
	 * @param string	text
	 * @return			list of sentence
	 */
	private List<Data> makeText(String string){

		List<String> sentences = splitSentence(string);
		List<Data> text = new ArrayList<>();
		for (String aSentence : sentences) {
			Data sentence = Factory.getInstance().create(TypeData.SENTENCE);
			sentence.setListData(makeSentence(aSentence));
			text.add(sentence);
		}
		return text;
	}

	/**
	 * split text on sentence
	 * @param string	text
	 * @return			list of text
	 */
	private List<String> splitSentence(final String string){
		return new ArrayList<>(Arrays.asList(string.split(SENTENCE_END)));
	}

	/**
	 * make sentence
	 * @param string	text
	 * @return			list of words and marks
	 */
	private List<Data> makeSentence(String string){
		String[] words = string.split(WORD_END);
		String[] marks = string.split(FOR_WORD);

		List<Data> sentences = new ArrayList<>();
		for (int i = 0; i < words.length; i++) {
			Data word = FlyweightWordMark.getInstance().create(TypeData.WORD, words[i]);
			sentences.add(word);

			Data mark = FlyweightWordMark.getInstance().create(TypeData.MARK, marks[i]);
			sentences.add(mark);
		}
	return sentences;
	}

	/**
	 * check object
	 * @param object	input object
	 */
	private void checkNull(Object object) {
		if (object == null) { throw new IllegalArgumentException("input NULL");}
	}
}

