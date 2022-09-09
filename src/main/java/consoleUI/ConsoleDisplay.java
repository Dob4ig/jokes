package consoleUI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConsoleDisplay implements Displaying {
	private static final int breaksFrequency = 8;

	@Override
	public void DisplayContent(String content) {
		content = addBreaks(content);
		System.out.printf("\n%s\n\n", content);

	}

	private String addBreaks(String baseString) {
		List<String> words = new ArrayList<>(Arrays.asList(baseString.split(" ")));
		if (words.size() <= breaksFrequency)
			return baseString;

		words = words.stream().map(n -> n + " ").collect(Collectors.toList());

		for (int i = breaksFrequency; i < words.size(); i += breaksFrequency)
			words.add(i, "\n");

		var strBuf = new StringBuffer();
		words.forEach(strBuf::append);

		return strBuf.toString();
	}

}
