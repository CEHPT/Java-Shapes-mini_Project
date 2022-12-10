package ShapesManagerProject;

public class Rectangle extends Shapes{

    private double length , breadth;

    Rectangle(){

        shapeType = "Rectangle";
    }

    @Override
    public void getInput() {

        getShapeId();

        p.println("Enter the Length of Rectangle : ");
        length = in.nextDouble();

        p.println("Enter the Breadth of Rectangle : ");
        breadth = in.nextDouble();

        CalculateArea();
    }

    @Override
    public void CalculateArea() {

        surfaceArea = length * breadth;
    }

    @Override
    public String toString() {

        return String.format("%-10s %-10s %.2f %.2f %.2f", shapeType , shapeId , surfaceArea , length , breadth);
    }

    @Override
    public String toCSVString() {

        return String.format("%s,%s,%f,%f,%f", shapeType , shapeId , surfaceArea , length , breadth);
    }

    @Override
    protected void deSerialized(String str_csv){
        super.deSerialized(str_csv);
        String array[] = str_csv.split(",");
        length = Double.parseDouble(array[3]);
        breadth = Double.parseDouble(array[4]);
        array = null;
   }
}
