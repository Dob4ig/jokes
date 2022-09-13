package jokes;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class RzhunemoguGetJoke extends JokesGetter {
	private final String APIURL = "http://rzhunemogu.ru/RandJSON.aspx?CType=1";

	@Override
	public Joke getJoke() throws IOException {
		var gson = new Gson();
		try {
			var joke = gson.fromJson(getResponse(), Joke.class);
			return joke;
		} catch (JsonSyntaxException e) {

			return getJoke();
		}

	}

	private final String getResponse() throws IOException {
		var url = new URL(APIURL);
		var connection = (HttpURLConnection) url.openConnection();
		try (var scanner = new Scanner(connection.getInputStream(), "cp1251")) {
			var strBuf = new StringBuffer();
			while (scanner.hasNextLine()) {
				strBuf.append(scanner.nextLine());
			}
			return strBuf.toString();
		}
	}

	/*public class Joke {
		private String content;
		
		public String getContent() {
			return content;
		}

	}*/
}
