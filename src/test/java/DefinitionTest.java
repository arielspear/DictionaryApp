import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {

  @Test
  public void Definition_instanciatesCorrectly_true(){
    Definition myDefinition = new Definition("a wild dog");
    assertEquals(true, myDefinition instanceof Definition);
  }

  @Test
  public void word_getsDefinition_true() {
      Definition testDef = new Definition("a cute fluffy animal");
      assertEquals("a cute fluffy animal", testDef.getDef());
  }

  @Test
  public void all_returnsAllDefinitions_true() {
      Definition firstDef = new Definition("a container");
      Definition secondDef = new Definition("to suddenly be shaken");
      assertTrue(Definition.getDefinitions().contains(firstDef));
      assertTrue(Definition.getDefinitions().contains(secondDef));
  }

}
