

// Clase Main para ejecutar los entrenamientos
public class Main {
    public static void main(String[] args) {
        // Entrena el perceptrón sin sesgo para la compuerta AND
        Perceptron.PerceptronSinSesgo();
        System.out.println("\n============================\n");
        // Entrena el perceptrón con sesgo para la compuerta OR
        Perceptron.PerceptronConSesgo();
    }
}
