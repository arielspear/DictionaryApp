import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {

  @Test
  public void Definition_instanciatesCorrectly_true(){
    Definition myDefinition = new Definition("a wild dog");
    assertEquals(true, myDefinition instanceof Definition);
  }

  @Test
  public void word_getDefinition_true() {
      Definition testDef = new Definition("a cute fluffy animal");
      assertEquals("a cute fluffy animal", testDef.getDef());
  }

}
