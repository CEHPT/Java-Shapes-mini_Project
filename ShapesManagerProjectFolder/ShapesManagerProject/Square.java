package ShapesManagerProject;

public class Square extends Shapes{

    private double side;

    Square(){

        shapeType = "Square";
    }

    @Override
    public void getInput() {

        getShapeId();

        p.println("Enter the side of Square : ");
        side = in.nextDouble();

        CalculateArea();
    }

    @Override
    public void CalculateArea() {

        surfaceArea = side * side;
    }

    @Override
    public String toString() {

        return String.format("%-10s %-10s %.2f %.2f" , shapeType , shapeId ,surfaceArea , side);
    }

    @Override
    public String toCSVString() {

        return String.format("%s,%s,%f,%f" , shapeType , shapeId ,surfaceArea , side);
    }

    @Override
    protected void deSerialized(String str_csv){
        super.deSerialized(str_csv);
        String array[] = str_csv.split(",");
        side = Double.parseDouble(array[3]);
        array = null;
    }
}
