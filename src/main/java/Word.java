import java.util.ArrayList;

public class Word {
  private String mWord;
  private int mId;

  public Word (String word) {
    mWord = word;
    mWordArray.add(this);
    mId = mWordArray.size();
  }

  public String getWord() {
    return mWord;
  }

  public int getId() {
    return mId;
  }

  public ArrayList<Definition> getDefinitions() {
    return mDefinitionsArray;
  }

  public void addDefinition(Definition definition) {
    mDefinitionsArray.add(definition);
  }

  public static ArrayList<Word> getAllWords() {
    return mWordArray;
}

  public static Word find(int id) {
    try {
        return mWordArray.get(id - 1);
    } catch (IndexOutOfBoundsException exception) {
        return null;
    }
  }

  public static void clear() {
    mWordArray.clear();
  }
}
