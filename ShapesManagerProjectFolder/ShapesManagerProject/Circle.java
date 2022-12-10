package ShapesManagerProject;

public class Circle extends Shapes {

    private double radius;

    public Circle(){

        shapeType = "Circle";
    }

    public Circle(String shapeId){

        super("Circle" , shapeId);
    }

    @Override
    public void getInput() {

        getShapeId();

        p.println("Enter the Radius of Circle : ");
        radius = in.nextDouble();

        CalculateArea();
    }

    @Override
    public void CalculateArea() {

        surfaceArea = (22.0/7) * radius * radius;
    }

    @Override
    public String toString() {

        return String.format("%-10s %-10s %.2f %.2f" , shapeType , shapeId , surfaceArea , radius);
    }

    @Override
    public String toCSVString() {

        return String.format("%s,%s,%f,%f" ,shapeType , shapeId , surfaceArea , radius);
    }

    @Override
    protected void deSerialized(String str_csv){
        super.deSerialized(str_csv);
        String array[] = str_csv.split(",");
        radius = Double.parseDouble(array[3]);
        array = null;
    }
}
