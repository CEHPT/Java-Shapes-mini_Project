package ShapesManagerProject;

public class Cube extends Shapes{

    private double length , breadth , height;

    public Cube(){

        shapeType = "Cube";
    }

    @Override
    public void getInput() {

        getShapeId();

        p.println("Enter the Length of Cube : ");
        length = in.nextDouble();

        p.println("Enter the Breadth of Cube : ");
        breadth = in.nextDouble();

        p.println("Enter the height of Cube : ");
        height = in.nextDouble();

        CalculateArea();
    }

    @Override
    public void CalculateArea() {

        surfaceArea = 2 *(breadth * length + length * height + height * breadth);
    }

    @Override
    public String toString() {

        return String.format("%-10s %-10s %.2f %.2f %.2f %.2f" , shapeType , shapeId , surfaceArea , length , breadth , height);
    }

    @Override
    public String toCSVString() {

        return String.format("%s,%s,%f,%f,%f,%f", shapeType , shapeId , surfaceArea , length , breadth , height);
    }

    @Override
    protected void deSerialized(String str_csv){
        super.deSerialized(str_csv);
        String array[] = str_csv.split(",");
        length = Double.parseDouble(array[3]);
        breadth = Double.parseDouble(array[4]);
        height = Double.parseDouble(array[5]);
        array = null;
    }
}
