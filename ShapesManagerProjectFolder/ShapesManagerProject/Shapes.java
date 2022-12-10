package ShapesManagerProject;

import java.io.PrintStream;
import java.util.Scanner;

public abstract class Shapes {

    protected PrintStream p = new PrintStream(System.out);
    protected Scanner in = new Scanner(System.in);

    protected String shapeType , shapeId;
    protected double surfaceArea;

    abstract public void getInput();
    abstract public void CalculateArea();
    abstract public String toString();
    abstract public String toCSVString();

    Shapes(){

        shapeId = "Undefined";
    }

    Shapes(String shapeType , String shapeId){

        this.shapeId = shapeId;
        this.shapeType = shapeType;
    }

    protected void getShapeId(){

        p.println("Enter the shape ID : ");
        shapeId = in.nextLine();
    }

    protected void deSerialized(String str_csv){

        String[] str_array = str_csv.split(",");
        shapeType = str_array[0];
        shapeId = str_array[1];
        surfaceArea = Double.parseDouble(str_array[2]);
        str_array = null;
    }

}
