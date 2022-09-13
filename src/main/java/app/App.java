package app;

import java.io.IOException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import consoleUI.ConsoleDisplay;
import consoleUI.UserCommands;
import jokes.RzhunemoguGetJoke;

public class App {
	private static final Logger log = Logger.getLogger(App.class);
	private static final ConsoleDisplay consoleDisplay = new ConsoleDisplay();

	public static void main(String[] args) {

		log.info("Программа запущена");
		var rzhuNeMoguJoke = new RzhunemoguGetJoke();
		try (var scanner = new Scanner(System.in)) {
			consoleDisplay.displayContent(rzhuNeMoguJoke.getJoke().getContent());
			log.info("Первый вывод программы");
			var joke = rzhuNeMoguJoke.getJoke();
			while (scanner.hasNext()) {
				var input = scanner.next();
				log.info(String.format("Получен пользовательский ввод input=%s", input));
				if (input.equals(UserCommands.EXIT.command))
					break;
				if (input.equals(UserCommands.NEXT.command) || input.equals(UserCommands.SHORT_NEXT.command)) {
					consoleDisplay.displayContent(joke.getContent());
					joke = rzhuNeMoguJoke.getJoke();
					log.info("Вывод в консоль");
				}
			}
			log.info("Успешное завершение программы");
		} catch (IOException e) {
			log.error(e.getStackTrace());

		}
	}

}
