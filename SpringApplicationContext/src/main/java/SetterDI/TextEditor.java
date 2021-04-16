package SetterDI;

public class TextEditor {

    public SpellChecker spellChecker;

    /*TextEditor(SpellChecker spellChecker){
        this.spellChecker=spellChecker;
    }*/
    public TextEditor(){
        System.out.println("Insdie TextEditor no args");
    }

    public SpellChecker getSpellChecker() {
        return spellChecker;
    }

    public void setSpellChecker(SpellChecker spellChecker) {
        System.out.println("inside setter method of SpeelChecker");
        this.spellChecker = spellChecker;
    }

    public void checkSpell(){

        spellChecker.checkSpell();

    }

}
