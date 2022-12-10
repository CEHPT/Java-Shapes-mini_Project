package ShapesManagerProject;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ShapesManager {

    ArrayList<Shapes> shapes = new ArrayList<Shapes>();
    String filePath = "./ShapesProject.txt";
    public enum Shapes_Types{Rectangle , Square , Cube , Circle};

    public ShapesManager(){

        File fileFound = new File(filePath);

        if(fileFound.isFile()){

            FileReader f = null;

            try{
                f = new FileReader(filePath);
                BufferedReader br = new BufferedReader(f);
                String str;

                while((str = br.readLine()) != null){

                    String[] str_array = str.split(",");
                    Shapes s = null;

                    switch (str_array[0]){

                        case "Square" :
                            s = new Square();
                            break;
                        case "Cube" :
                            s = new Cube();
                            break;
                        case "Circle" :
                            s = new Circle();
                            break;
                        case "Rectangle" :
                            s = new Rectangle();
                            break;
                    }

                    s.deSerialized(str);
                    shapes.add(s);
                }
                br = null;
                f.close();
            }

            catch (Exception e){

                e.printStackTrace();
            }
            finally {

                f = null;
            }
        }
    }

    public boolean addShape(Shapes_Types shapesTypes){

        Shapes s = null;

        switch(shapesTypes){

            case Square :
                s = new Square();
                break;
            case Rectangle :
                s = new Rectangle();
                break;
            case Cube :
                s = new Cube();
                break;
            case Circle :
                s = new Circle();
                break;
        }

        s.getInput();
        shapes.add(s);
        addShapeToFile(s);
        s = null;

        return true;
    }

    private void addShapeToFile(Shapes s){

        FileWriter f = null;

        try {

            f = new FileWriter(filePath, true);
            BufferedWriter bw = new BufferedWriter(f);
            bw.write(s.toCSVString());
            bw.newLine();
            bw.close();
            f .close();

        } catch (IOException e) {

            e.printStackTrace();
        }
        finally{

            f = null;
        }
    }

    public void listShapes(){

        System.out.println("List Of shapes");
        System.out.println("--------------");

        for(Shapes s : shapes)
            System.out.println(s.toString());
    }

    private Shapes getShape(String shapeId){

        Shapes s = null;

        for(Shapes str : shapes){

            String sid = str.shapeId.trim();

            if(sid.equals(shapeId))
                return str;
        }

        return s;
    }

    public void deleteShape(){

        System.out.println("Enter the shape ID :");
        Scanner in = new Scanner(System.in);
        String shapeId = in.next();

        Shapes s = getShape(shapeId);

        if(s == null){
            System.out.println("Invalid Shape ID!...");
            return;
        }

        System.out.println(s.toString());
        System.out.print("Are you sure to delete ? : ");
        String choice = in.next();

        if(choice.equalsIgnoreCase("y")){

            shapes.remove(s);

            FileWriter f = null;

            try{

                f = new FileWriter(filePath);
                BufferedWriter bw = new BufferedWriter(f);

                for(Shapes s2  : shapes){

                    bw.write(s2.toCSVString());
                    bw.newLine();
                }
                bw.close();
                f.close();
            }

            catch (Exception e){

                e.printStackTrace();
            }
            finally {

                f = null;
            }
        }




    }
}
