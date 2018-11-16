import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Parser {

    static double[][] parse(String filename){
        Scanner sc = null;
        try {
            sc = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int numVertices = Integer.parseInt(sc.nextLine());
        double[][] arr = new double[numVertices][numVertices];

        for(int i = 0; i < numVertices; i++){
            for(int j = 0; j < numVertices; j++){
                arr[i][j] = sc.nextDouble();
            }
        }

        return arr;
    }
}
