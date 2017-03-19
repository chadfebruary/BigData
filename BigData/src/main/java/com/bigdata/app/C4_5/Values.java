package com.bigdata.app.C4_5;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by cfebruary on 2017/03/19.
 */
public class Values {
    public String        valueName    = new String();
    public List<String> classes      = new ArrayList<String>();
    public List<Integer> classesCount = new ArrayList<Integer>();
    public double        gain         = 0.0;

    public Values(String valName, String newClass){
        this.valueName = valName;
        this.classes.add(newClass);
        this.classesCount.add(1);
    }

    public void setGain(){
        double temp = 0.0;

        int totalNumClasses = 0;
        for(int i : this.classesCount) {
            totalNumClasses += i;
        }

        for(double d : classesCount){
            temp = (-1 * (d/totalNumClasses)) * (Math.log((d/totalNumClasses)) / Math.log(2));
            this.gain += temp;
        }
    }

    public void update(Val inVal) {
        if(this.classes.contains(inVal.inClass)){
            this.classesCount.set(this.classes.indexOf(inVal.inClass),
                    this.classesCount.get(this.classes.indexOf(inVal.inClass)) + 1);
        }
        else{
            this.classes.add(inVal.inClass);
            this.classesCount.add(this.classes.indexOf(inVal.inClass), 1);
        }
    }
}
