package jokes;

import java.io.IOException;
import org.junit.Test;
import org.junit.Assert;

public class JokeTest extends JokesGetter {

	@Test
	public void testDefaultConstructor() {
		var joke = new Joke();
		Assert.assertNull(joke.getContent());
	}
	@Test
	public void testGetContent(){
		var joke = new Joke("@!1testCase1!@");
		Assert.assertEquals("@!1testCase1!@",joke.getContent());
	}
	@Override
	public Joke getJoke() throws IOException {
		return null;
	}

}
