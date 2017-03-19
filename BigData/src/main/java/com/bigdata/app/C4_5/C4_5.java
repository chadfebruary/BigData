package com.bigdata.app.C4_5;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C4_5
{
    public static void main( String[] args ) throws IOException
    {
        //.csv data sets
        String files[] = {"data sets/tic_tac_toe.csv"};
        Scanner scanner;

        //Start loop for all files
        scanner = new Scanner(new File(files[0]));
        String headerLine = scanner.nextLine();
        String headers[] = headerLine.split(",");

        int classIndex = headers.length - 1;
        int numAttributes = headers.length - 1;

        //Store data set attributes
        Attribute attributes[] = new Attribute[numAttributes];
        for (int x = 0; x < numAttributes; x++)
        {
            attributes[x] = new Attribute(headers[x]);
        }

        //Storing classes and class count
        List<String> classes = new ArrayList<String>();
        List<Integer> classesCount = new ArrayList<Integer>();

        //Store values into respective attributes along with classes
        while (scanner.hasNextLine())
        {
            Val data = null;
            String inLine = scanner.nextLine();
            String lineData[] = inLine.split(",");

            //Insert class into classes List
            if(classes.isEmpty())
            {
                classes.add(lineData[classIndex]);
                classesCount.add(classes.indexOf(lineData[classIndex]), 1);
            }
            else
            {
                if(!classes.contains(lineData[classIndex]))
                {
                    classes.add(lineData[classIndex]);
                    classesCount.add(classes.indexOf(lineData[classIndex]), 1);
                }
                else
                {
                    classesCount.set(classes.indexOf(lineData[classIndex]),
                            classesCount.get(classes.indexOf(lineData[classIndex])) + 1);
                }
            }

            //Insert data into attributes
            for(int x = 0; x < numAttributes; x++)
            {
                data = new Val(lineData[x], lineData[classIndex]);
                attributes[x].insertVal(data);
            }
        }

        int totalNumClasses = 0;

        for(int i : classesCount)
        {
            totalNumClasses = totalNumClasses + i;
        }

        double IofD = calcIofD(classesCount);

        //Testing
        Attribute age = new Attribute("age");

        Val inV = new Val("30","yes");
        age.insertVal(inV);
        inV = new Val("30","yes");
        age.insertVal(inV);
        inV = new Val("30","no");
        age.insertVal(inV);
        inV = new Val("30","no");
        age.insertVal(inV);
        inV = new Val("30","no");
        age.insertVal(inV);
        inV = new Val("35","yes");
        age.insertVal(inV);
        inV = new Val("35","yes");
        age.insertVal(inV);
        inV = new Val("35","yes");
        age.insertVal(inV);
        inV = new Val("35","yes");
        age.insertVal(inV);
        inV = new Val("40","yes");
        age.insertVal(inV);
        inV = new Val("40","yes");
        age.insertVal(inV);
        inV = new Val("40","yes");
        age.insertVal(inV);
        inV = new Val("40","no");
        age.insertVal(inV);
        inV = new Val("40","no");
        age.insertVal(inV);

        System.out.println(age.toString());

        List<Integer> testCount = new ArrayList<Integer>();
        testCount.add(9);
        testCount.add(5);

        double testIofD = calcIofD(testCount);
        age.setGain(testIofD, 14);

        System.out.println("I of D: " + testIofD);
        System.out.println("age: " + age.gain);
    }

    public static double calcIofD(List<Integer> classesCount)
    {
        double IofD = 0.0;
        double temp = 0.0;

        int totalNumClasses = 0;

        for(int i : classesCount)
        {
            totalNumClasses = totalNumClasses + i;
        }

        for(double d : classesCount)
        {
            temp = (-1 * (d / totalNumClasses)) * (Math.log((d / totalNumClasses) / Math.log(2)));
            IofD += temp;
        }

        return IofD;
    }
}
