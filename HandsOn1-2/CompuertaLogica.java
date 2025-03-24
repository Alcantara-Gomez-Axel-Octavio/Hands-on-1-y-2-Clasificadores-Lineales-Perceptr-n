import java.util.ArrayList;


public class CompuertaLogica {

    public int X1;
    public int X2;
    public int Resultado;
    
    public static ArrayList<CompuertaLogica> DatosReales = new ArrayList<>();


    public  CompuertaLogica(int X1, int X2, int Resultado ){
        this.X1=X1;
        this.X2=X2;
        this.Resultado=Resultado;

    }


    public static ArrayList<CompuertaLogica> DatosRealesAND() {
        DatosReales.clear();
        DatosReales.add(new CompuertaLogica(0, 0, 0));
        DatosReales.add(new CompuertaLogica(1, 0, 0));
        DatosReales.add(new CompuertaLogica(0, 1, 0));
        DatosReales.add(new CompuertaLogica(1, 1, 1));
     
        return DatosReales;
    }

    public static ArrayList<CompuertaLogica> DatosRealesOR() {
        DatosReales.clear();
        DatosReales.add(new CompuertaLogica(0, 0, 0));
        DatosReales.add(new CompuertaLogica(1, 0, 1));
        DatosReales.add(new CompuertaLogica(0, 1, 1));
        DatosReales.add(new CompuertaLogica(1, 1, 1));
     
        return DatosReales;
    }


    /*

    public double[][] DatosRealesAND(){
            

        double[][] DatosRealesAND = {
            {0, 0, 0},
            {1, 0, 0},
            {1, 1, 1},
            {0, 1, 0}
        };
        return DatosRealesAND;
    }


    public double[][] DatosRealesOR(){
        double[][] DatosRealesOR = {
            {0, 0, 0},
            {1, 0, 0},
            {1, 1, 1},
            {0, 1, 0}
        };
        return DatosRealesOR;
    }
     * 
     */

    
}
