package com.company.Collections;

import java.lang.reflect.Array;
import java.util.*;

public class CollectionFramework {

    public static void main(String[] args) {
        CollectionTask task = new CollectionTask();
        LinkedHashSet<CEmployee> set = task.getResult();
        Iterator<CEmployee> iterator = set.iterator();
        /*while(iterator.hasNext()){
            System.out.println(iterator.next());
        }*/
        for (CEmployee emp:
                set) {
            System.out.println(emp);

        }
    }
}

class CollectionTask{

   public LinkedHashSet<CEmployee> getResult(){

       LinkedHashSet<CEmployee> linkedHashSet= new LinkedHashSet<CEmployee>();
       linkedHashSet.add(new CEmployee(241,"Sairam"));
       linkedHashSet.add(new CEmployee(242,"Vaddepally"));
       linkedHashSet.add(new CEmployee(242,"Vaddepally"));
       linkedHashSet.add(new CEmployee(243,"Sairam"));
      /* ArrayList<String> list = new ArrayList<String>();
       list.add("S");
       list.add("a");
       list.add("i");
       list.add("r");
       list.add("a");
       list.add("m");*/
       return linkedHashSet;
    }
}
class CEmployee{

    private int empId;

    public CEmployee(int empId, String empName) {
        this.empId = empId;
        this.empName = empName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CEmployee cEmployee = (CEmployee) o;
        return empId == cEmployee.empId && Objects.equals(empName, cEmployee.empName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId, empName);
    }

    @Override
    public String toString() {
        return "CEmployee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                '}';
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    private String empName;

        }
