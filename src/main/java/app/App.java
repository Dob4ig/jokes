package app;

import java.io.IOException;
import java.util.Scanner;

import consoleUI.ConsoleDisplay;
import consoleUI.UserCommands;
import jokes.RzhunemoguGetJoke;

public class App {
	private static final ConsoleDisplay consoleDisplay = new ConsoleDisplay();

	public static void main(String[] args) {
		var rzhuNeMoguJoke = new RzhunemoguGetJoke();

		try (var scanner = new Scanner(System.in)) {
			consoleDisplay.DisplayContent(rzhuNeMoguJoke.getJoke());

			while (scanner.hasNext()) {
				var input = scanner.next();

				if (input.equals(UserCommands.EXIT.command))
					break;
				if (input.equals(UserCommands.NEXT.command) || input.equals(UserCommands.SHORT_NEXT.command))
					consoleDisplay.DisplayContent(rzhuNeMoguJoke.getJoke());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
