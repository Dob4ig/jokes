package consoleUI;

public enum UserCommands {
	EXIT("exit"), NEXT("next"), SHORT_NEXT("n");

	public final String command;

	private UserCommands(String str) {
		this.command = str;
	}
}
