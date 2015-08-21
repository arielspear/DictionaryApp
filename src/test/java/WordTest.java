import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {

  @Test
  public void Word_instanciatesCorrectly_true(){
    Word myWord = new Word("wolf");
    assertEquals(true, myWord instanceof Word);
  }

  @Test
  public void Word_instanciatesWord_true(){
    Word myWord = new Word("Unicorn");
    assertEquals("Unicorn", myWord.getWord());
  }
}
