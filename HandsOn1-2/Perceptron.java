import java.util.ArrayList;
import java.util.Random;

// Clase Perceptron que contiene los métodos de entrenamiento sin sesgo y con sesgo
public class Perceptron {

    // Función sigmoide
    public static double sigmoid(double x) {
        return 1 / (1 + Math.exp(-x));
    }

    public static int  EscalonDeHeaviside(double valor) {
        return valor >= 0 ? 1 : 0;
    }

    // Función para redondear la salida a 0 o 1
    public static int activar(double valor) {
        return valor >= 0.5 ? 1 : 0;
    }

    // Entrenamiento del perceptrón SIN SESGO para la compuerta AND
    public static void PerceptronSinSesgo() {
        System.out.println("=== Entrenamiento del Perceptrón SIN SESGO (Compuerta AND) ===");
        
        Random rand = new Random();
        double w1 = rand.nextDouble();
        double w2 = rand.nextDouble();
        double eta = 0.01; // Tasa de aprendizaje
        int maxepocas = 100;
        int epoca = 0;
        boolean errorPresente;
        
        ArrayList<CompuertaLogica> trainingSet = CompuertaLogica.DatosRealesAND();
        
        do {
            errorPresente = false;
            System.out.println("Epoca: " + epoca);
            
            for (CompuertaLogica ejemplo : trainingSet) {
                double Y = (ejemplo.X1 * w1) + (ejemplo.X2 * w2);
                double salida = sigmoid(Y);
                int salidaRedondeada = activar(salida);
                
                System.out.printf("Entrada: [%d, %d], Salida esperada: %d, Salida calculada: %d\n", 
                        ejemplo.X1, ejemplo.X2, ejemplo.Resultado, salidaRedondeada);
                
                if (salidaRedondeada != ejemplo.Resultado) {
                    double error = ejemplo.Resultado - salida;
                    w1 += eta * error * ejemplo.X1;
                    w2 += eta * error * ejemplo.X2;
                    errorPresente = true;
                    
                    System.out.printf("   Actualización de pesos: w1 = %.4f, w2 = %.4f\n", w1, w2);
                }
            }
            epoca++;
            System.out.println("-----------------------------------------");
        } while (errorPresente && epoca < maxepocas);
        
        System.out.println("Entrenamiento completado en " + epoca + " epocas.");
        System.out.printf("Pesos finales: w1 = %.4f, w2 = %.4f\n", w1, w2);
    }

    // Entrenamiento del perceptrón CON SESGO para la compuerta OR
    public static void PerceptronConSesgo() {
        System.out.println("=== Entrenamiento del Perceptrón CON SESGO (Compuerta OR) ===");
        
        Random rand = new Random();
        double w1 = rand.nextDouble();
        double w2 = rand.nextDouble();
        double b = rand.nextDouble(); // Sesgo
        double eta = 0.1; // Tasa de aprendizaje
        int maxepocas = 100;
        int epoca = 0;
        boolean errorPresente;
        
        ArrayList<CompuertaLogica> trainingSet = CompuertaLogica.DatosRealesOR();
        
        do {
            errorPresente = false;
            System.out.println("Epoca: " + epoca);
            
            for (CompuertaLogica ejemplo : trainingSet) {
                double Y = (ejemplo.X1 * w1) + (ejemplo.X2 * w2) + b;
                double salida = sigmoid(Y);
                int salidaRedondeada = activar(salida);
                
                System.out.printf("Entrada: [%d, %d], Salida esperada: %d, Salida calculada: %d\n", 
                        ejemplo.X1, ejemplo.X2, ejemplo.Resultado, salidaRedondeada);
                
                if (salidaRedondeada != ejemplo.Resultado) {
                    double error = ejemplo.Resultado - salida;
                    w1 += eta * error * ejemplo.X1;
                    w2 += eta * error * ejemplo.X2;
                    b += eta * error;
                    errorPresente = true;
                    
                    System.out.printf("   Actualización de pesos y sesgo: w1 = %.4f, w2 = %.4f, b = %.4f\n", w1, w2, b);
                }
            }
            epoca++;
            System.out.println("-----------------------------------------");
        } while (errorPresente && epoca < maxepocas);
        
        System.out.println("Entrenamiento completado en " + epoca + " epocas.");
        System.out.printf("Pesos finales: w1 = %.4f, w2 = %.4f, Sesgo (b) = %.4f\n", w1, w2, b);
    }
}
