package com.campusdual.classroom;

import com.campusdual.Utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

class Route{
    public static final String PATH_NAME = "src/main/resources/data.txt";
}
public class Exercise {

    public static void main(String[] args) {
        String texToSave = generateStringToSave(null);
        printToFile(texToSave);
        System.out.println("Texto guardado");

    }

    public static String generateStringToSave(String string) {
        if (string == null || string.isEmpty()){
            return generateUserInputToSave();
        }else{
            return string;
        }

    }

    private static String generateUserInputToSave(){
        StringBuilder sb = new StringBuilder();
        System.out.println("Escribe debajo el texto que quieras. Pulsa \"ENTER\" 2 veces seguidas para finalizar:");
        String string;
        while(!(string = Utils.string()).isEmpty()){
            sb.append(string).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static void printToFile(String string) {
        Path filePath = Paths.get(Route.PATH_NAME);
        try (PrintWriter pw = new PrintWriter(new FileWriter(filePath.toFile()))){
            pw.print(string);
        }catch (IOException e){
            e.printStackTrace();
        }

    }


}
