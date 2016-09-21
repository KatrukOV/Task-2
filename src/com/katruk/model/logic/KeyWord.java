package com.katruk.model.logic;

public interface KeyWord {
//	String LINE_BREAK = System.getProperty("line.separator");
	String LINE_BREAK = "\n";    //   "\r\n"
	String ALL_SPACE = "\\s+";
	String ONE_SPACE = " ";
	String SENTENCE_END = "[.!?]+?[\\s]";
	String WORD_END = "([.,:!?]?\\s)";
	String FOR_WORD = "([+-]?(([0-9]?[\\.,][0-9]+)|([0-9]+([\\.,][0-9]*)?)))|\\p{javaLetterOrDigit}+(-(?:\\n)?\\p{javaLetterOrDigit}+)?";

}
