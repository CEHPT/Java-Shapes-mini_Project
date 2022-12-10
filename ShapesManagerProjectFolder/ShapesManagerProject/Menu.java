package ShapesManagerProject;

import java.io.PrintStream;
import java.util.Scanner;

public class Menu {

    PrintStream p = new PrintStream(System.out);
    Scanner in = new Scanner(System.in);
    ShapesManager sm = new ShapesManager();

    private void displayHeader(){

        p.println("\nSHAPES MANAGER");
        p.println("--------------\n");
    }

    public void displayMainMenu(){

        int choice;

        while(true){

            displayHeader();

            p.println("1.Add a shape");
            p.println("2.Delete a shape");
            p.println("3.List a shape");
            p.println("9.Exit");

            p.println("\nEnter your choice (1-9) : ");
            choice = in.nextInt();

            switch(choice){

                case 1 :
                    ShapesMenu();
                    break;
                case 2 :
                    sm.deleteShape();
                    break;
                case 3 :
                    sm.listShapes();
                    break;
                case 9 :
                    return;
                default :
                    p.println("Invalid Choice! Pls Try Again.....");
                    break;
            }
        }
    }

    private void ShapesMenu(){

        int choice;

        while(true){

            displayHeader();

            p.println("1.Square");
            p.println("2.Rectangle");
            p.println("3.Cube");
            p.println("4.Circle");
            p.println("9.Exit");

            p.println("\nEnter your choice (1-9) : ");
            choice = in.nextInt();

            switch(choice){

                case 1 :
                    sm.addShape(ShapesManager.Shapes_Types.Square);
                    break;
                case 2 :
                    sm.addShape(ShapesManager.Shapes_Types.Rectangle);
                    break;
                case 3 :
                    sm.addShape(ShapesManager.Shapes_Types.Cube);
                    break;
                case 4 :
                    sm.addShape(ShapesManager.Shapes_Types.Circle);
                    break;
                case 9 :
                    return;
                default :
                    p.println("Invalid Choice! Pls Try Again.....");
                    break;
            }
        }
    }
}
