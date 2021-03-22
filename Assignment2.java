import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Assignment2 {


    public static int[] generateGrades(){
        int []grades = new int[5];
        Random rand = new Random();
        for(int i = 0; i<5; i++){
            grades[i] = rand.nextInt(21)+80;
        }
        return grades;
    }

    public static String writeToFile(int[]array) throws IOException {
        String filename = "grades.txt";
        FileWriter myWriter = new FileWriter(filename);
        for (int value : array) {
            myWriter.append(value + "\n");
        }
        myWriter.close();
        return filename;
    }


    public static ArrayList<Integer> readNumbers(String filename) throws FileNotFoundException {
        ArrayList<Integer> numbers = new ArrayList<>();
        File myObj = new File(filename);
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            numbers.add(Integer.parseInt(data));
        }
        myReader.close();
        return numbers;
    }


    public static void main(String[] args) {
        try
        {
            int[] arrayGradesData = generateGrades();
            String fileName = writeToFile(arrayGradesData);
            readNumbers(fileName);
        }
        catch(Exception e)
        {
            String errorMsg = e.getMessage();
            System.out.println(errorMsg);
        }
    }
}
