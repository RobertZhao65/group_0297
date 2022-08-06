import MusicUtil.Song;
import org.junit.Test;

public class test {
    @Test
    public void testSometing() {
        Song s = new Song("something");
        assert s.getName().equals("something");

    }


}
