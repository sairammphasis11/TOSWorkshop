package Annotations;

//Creating custom annotations
@CustomAnnotations(name = "class",duration=1,version = {1,2})
public class AnnotationPrac {

    @CustomAnnotations(name = "variable",duration=1,version = {1,2})
    int level;

   // @CustomAnnotations(name = "constructor",duration=1,version = {1,2})
    public AnnotationPrac(){

    }

    @CustomAnnotations(name = "main",duration=1,version = {1,2})
    public  void test(int num){

    }

}
