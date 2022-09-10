package consoleUI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

public class ConsoleDisplay implements Displaying {
	private static final Logger log = Logger.getLogger(ConsoleDisplay.class);
	private static final int breaksFrequency = 8;

	@Override
	public void displayContent(String content) {
		log.debug("Запуск метода DisplayContent(String)");
		log.trace(String.format("Поступившие аргументы: %s", content));
		content = addBreaks(content);
		System.out.printf("\n%s\n\n", content);
		log.trace(String.format("Вывод пользователю:\n%s\n\n", content));
	}

	private String addBreaks(String baseString) {
		log.debug("Запуск метода addBreaks(String)");
		log.trace(
				String.format("Поступившие аргументы: %s\n Частота переносов строки %d", baseString, breaksFrequency));
		List<String> words = new ArrayList<>(Arrays.asList(baseString.split(" ")));
		log.trace(String.format("Список слов в строке: %s", words.toString()));
		if (words.size() <= breaksFrequency) {
			log.debug(String.format("Кол-во слов меньше %d, метод успешно завершился,\n вернув: %s", breaksFrequency,
					baseString));
			return baseString;
		}
		words = words.stream().map(n -> n + " ").collect(Collectors.toList());
		log.trace(String.format("Добавлены пробелы ко всем словам\nРезультат: %s", words.toString()));
		for (int i = breaksFrequency; i < words.size(); i += breaksFrequency)
			words.add(i, "\n");
		log.trace(String.format("Добавлены переносы строк каждые %d элементов\nРезультат:%s", breaksFrequency,
				words.toString()));
		var strBuf = new StringBuffer();
		words.forEach(strBuf::append);
		log.trace(String.format("Функция вернула: %s", strBuf.toString()));
		return strBuf.toString();
		
	}

}
