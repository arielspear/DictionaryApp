import java.util.ArrayList;

public class Definition {
  String mDefinition;
  private static ArrayList<Definition> mDefinitionsArray = new ArrayList<Definition>();
  int mId;

  public Definition (String definition){
    mDefinition = definition;
    mDefinitionsArray.add(this);
    mId = mDefinitionsArray.size();
  }

  public String getDef(){
    return mDefinition;
  }

  public int getId() {
    return mId;
  }

  public static ArrayList<Definition> getDefinitions (){
    return mDefinitionsArray;
  }

  public static Definition find(int id) {
    try {
        return mDefinitionsArray.get(id - 1);
    } catch (IndexOutOfBoundsException e) {
        return null;
    }
  }

  public static void clear() {
      mDefinitionsArray.clear();
  }
}
