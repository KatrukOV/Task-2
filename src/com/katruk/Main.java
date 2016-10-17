package com.katruk;

import com.katruk.controller.EncodingText;
import com.katruk.controller.Controller;
import com.katruk.model.entity.Data;
import com.katruk.model.logic.Operation;
import com.katruk.model.logic.OperationImp;
import com.katruk.model.logic.Parser;
import com.katruk.model.logic.ParserImp;
import com.katruk.veiw.Renderer;
import java.io.IOException;
import java.util.List;

public class Main {
	public static final String PATH_INPUT = "Input.txt";
	public static final String PATH_OUTPUT = "Output.txt";

	public static void main(String[] args) throws IOException {

		Controller controller = new Controller();
		Renderer renderer = new Renderer();
		Parser parser = new ParserImp();
		Operation operation = new OperationImp();

		String string = controller.readFile(PATH_INPUT, EncodingText.CP1251);

		renderer.showLn(string);

		renderer.showLn("		1_________________");

		Data book = parser.parserAll(string);
		renderer.showLn(book.toString());

		renderer.showLn("		2________________");

		List<String> words = operation.getAllWord(book);
		for (String word : words) {
			renderer.showLn(word);
		}

		renderer.showLn("		3_________________");
		String sortWord = operation.sortWord(words);

		renderer.showLn(sortWord);
		string = words.toString();

		controller.writeFile(PATH_OUTPUT, EncodingText.Utf8, string);

	}
}
