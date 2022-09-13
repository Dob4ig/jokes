package jokes;

import java.io.IOException;

public abstract class JokesGetter {
	public abstract Joke getJoke() throws IOException;

	public class Joke {
		private String content;

		public Joke(String content) {
			this.content = content;
		}

		public Joke() {

		}

		public String getContent() {
			return content;
		}
	}
}
