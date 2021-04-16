package p2;

public class TextEditor {

    public SpellChecker spellChecker;

    TextEditor(SpellChecker spellChecker){
        this.spellChecker=spellChecker;
    }

    public void checkSpell(){

        spellChecker.checkSpell();

    }

}
