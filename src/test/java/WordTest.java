import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {

  @Test
  public void Word_instantiatesCorrectly_true(){
    Word myWord = new Word("wolf");
    assertEquals(true, myWord instanceof Word);
  }

  @Test
  public void Word_instantiatesWord_true(){
    Word myWord = new Word("Unicorn");
    assertEquals("Unicorn", myWord.getWord());
  }

  //had get definition
}
