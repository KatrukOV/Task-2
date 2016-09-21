package com.katruk.model.logic;

import com.katruk.model.entity.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OperationImp implements Operation, KeyChar {



    @Override
    public List<String> getAllWord(Data book){
        checkNull(book);
        List<String> strings = new ArrayList<String>();

        List<Data> texts = book.getListData();
        for (Data text : texts) {
            if (text.getTypeData() == TypeData.TEXT) {
                List<Data> sentences = text.getListData();
                for (Data sentence : sentences) {
                    if (sentence.getTypeData() == TypeData.SENTENCE) {
                        List<Data> words = sentence.getListData();
                        for (Data word : words) {
                            if (word.getTypeData() == TypeData.WORD) {
                                strings.add(word.toString());
                            }
                        }
                    }
                }
            }
        }
        return strings;
    }

    @Override
    public String sortWord(List<String> strings){
        if (strings == null || strings.size() == 0) throw new IllegalArgumentException("Input wrong string");

        Collections.sort(strings, new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return Character.compare(Character.toUpperCase(o1.charAt(0)),
                                                 Character.toUpperCase(o2.charAt(0)));
                    }
                }
        );

        Character firstChar = Character.toUpperCase(strings.get(0).charAt(0));
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : strings) {
            if (firstChar != Character.toUpperCase(string.charAt(0))) {
                firstChar = Character.toUpperCase(string.charAt(0));
                stringBuilder.append(CHAR_LINE_BREAK);
            }
            stringBuilder.append(string);
            stringBuilder.append(CHAR_SPACE);
        }
        return stringBuilder.toString();
    }

    /**
     * check for null
     * @param object    input object
     */
    private void checkNull(Object object) {
        if (object == null) { throw new IllegalArgumentException("input NULL");}
    }

}
