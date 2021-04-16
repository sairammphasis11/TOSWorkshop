package aopAnnotation;

import org.aspectj.lang.annotation.*;

@Aspect
public class Logging {

    @Pointcut("execution(* aopAnnotation.*.readMessage(..))")
    public void doSomething(){

    }
    /**
     * This is the method which I would like to execute
     * before a selected method execution.
     */
    @Before("doSomething()")
    public void beforeAdvice() {
        System.out.println("Message Service has been called");
    }

    /**
     * This is the method which I would like to execute
     * after a selected method execution.
     */
    @After("doSomething()")
    public void afterAdvice() {
        System.out.println("Message Service call ended");
    }

    /**
     * This is the method which I would like to execute
     * when any method returns.
     */
    @AfterReturning(value = "doSomething()",returning = "retVal")
    public void afterReturningAdvice(Object retVal){
        System.out.println("Returning:" + retVal.toString() );
    }

    /**
     * This is the method which I would like to execute
     * if there is an exception raised.
     */
    @AfterThrowing(pointcut = "doSomething()", throwing = "ex")
    public void afterThrowingAdvice(IllegalArgumentException ex) {
        System.out.println("There has been an exception: " + ex.toString());
    }
}
