package com.company;
interface FunctInterface{
    public void Print(Empl empl);
}
class Empl{
   int empid;

    @Override
    public String toString() {
        return "Empl{" +
                "empid=" + empid +
                '}';
    }

    public Empl(int empid) {
        this.empid = empid;
    }
}

class PeformClass {

    public void perform(FunctInterface functInterface) {
    //functInterface.Print(25633);
    }


}
public class LambdaCl{
    public static void main(String[] args) {
        Empl empl = new Empl(245);
       // FunctInterface functInterface = (employee)-> { System.out.println("In Function interface"+employee.empid);
        PeformClass peformClass = new PeformClass();
      //  peformClass.perform((emp)-> System.out.println("In Function interface"+employee.empid));
//        employee.empid = 255;};
//        functInterface.Print(empl);
//        System.out.println(empl);


    }


}
