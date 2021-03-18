package com.company.cyclic;

import java.util.Date;

class GeneData<T>{

    private T x;

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public GeneData(T x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "GeneData{" +
                "x=" + x +
                '}';
    }
}

class GetGeneData{

    public void getTaskData(GeneData<? extends Number> geneData){
        System.out.println(geneData);
    }
}
public class Generics {



    public static void main(String[] args) {

        GeneData<Integer> geneData = new GeneData<Integer>(5);

        System.out.println(geneData.getX());
        GetGeneData getGeneData = new GetGeneData();
        getGeneData.getTaskData(new GeneData("hi"));

        //GeneData genEmployee = new GeneData(new EmployeeGene(2));

    }
}
