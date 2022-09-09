package consoleUI;

import java.util.ArrayList;
import java.util.Arrays;

public class ConsoleDisplay implements Displaying {
	private static final int breaksFrequency = 8;

	@Override
	public void DisplayContent(String content) {
		content = addBreaks(content);
		System.out.printf("\n%s\n\n", content);

	}

	

	private String addBreaks(String baseString) {
		ArrayList<String> words = new ArrayList<>(Arrays.asList(baseString.split(" ")));
		if (words.size() <= breaksFrequency)
			return baseString;

		for (int i = 0; i < words.size(); i++)
			words.set(i, words.get(i).concat(" "));

		for (int i = breaksFrequency; i < words.size(); i += breaksFrequency)
			words.add(i, "\n");

		var strBuf = new StringBuffer();
		words.forEach(strBuf::append);

		return strBuf.toString();
	}
	
}	
