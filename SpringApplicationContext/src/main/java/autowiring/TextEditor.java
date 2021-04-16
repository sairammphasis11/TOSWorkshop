package autowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class TextEditor {

    @Autowired
    @Qualifier("SpellCheck1")
    private SpellChecker spellChecker;


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
    @PostConstruct
    public void init(){
        System.out.println("Bean is going through init.");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Bean will destroy now.");
    }

}
