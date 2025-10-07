import java.io.*;
import java.util.Stack;

public class revert {

    public static void main(String[] args) throws IOException {
        Stack<Character> pila = new Stack<>();

        File inputFile = new File("input.txt");
        File outputFile = new File("output.txt");

        if (inputFile.exists()) {
            FileReader lector = new FileReader(inputFile);
            int caracter = lector.read();

            // Leer caracter por caracter usando if dentro de un bucle simple
            while (caracter != -1) {
                pila.push((char) caracter);
                caracter = lector.read();
            }
            lector.close();

            // Si hay algo en la pila, escribirlo en orden inverso
            if (!pila.isEmpty()) {
                FileWriter escritor = new FileWriter(outputFile);

                while (!pila.isEmpty()) {
                    escritor.write(pila.pop());
                }
                escritor.close();
                System.out.println("El contenido se ha invertido correctamente en 'output.txt'.");
            } else {
                System.out.println("El archivo está vacío, no hay nada que invertir.");
            }
        } else {
            System.out.println("El archivo 'input.txt' no existe.");
        }
    }
}
