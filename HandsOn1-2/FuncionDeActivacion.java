
// Clase para la función de activación (Sigmoid)
public class FuncionDeActivacion {
    public static double sigmoid(double x) {
        return 1.0 / (1.0 + Math.exp(-x));
    }
}