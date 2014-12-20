import java.util.ArrayList; 
import javax.swing.JOptionPane;
import java.math.*;


public class gauss { 

static int var=3;
static String sal="";
static double d;
static double p;
static float  matrix [][]= new float [var][var+1];

	public static void main(String args[]){ 
  
    matrixf();
    //matrixm();
    jordan();
    
} 

public static void matrixm(){
	
	for(int i=0; i<var; i++){
		for(int j=0; j<var+1; j++){
		String ell="INTRODUZCA EL ELEMENTO : "+i+" "+j;	
			
		 matrix[i][j] = Float.parseFloat(JOptionPane.showInputDialog(ell));	
			
		}
	}
	
}


public static void matrixf(){
		
		matrix[0][0] = 3.0f;
    	matrix[0][1] = 6.0f;
    	matrix[0][2] = 9.0f;
    	matrix[0][3] = 8.0f;
    
    	matrix[1][0] = 5.0f;
    	matrix[1][1] = 8.0f;
    	matrix[1][2] = 13.0f;
    	matrix[1][3] = 6.0f;
    	
    	matrix[2][0] = 1.0f;
    	matrix[2][1] = 2.0f;
    	matrix[2][2] = -3.0f;
    	matrix[2][3] = 12.0f;
    	
	
}

 static void pivote(float matriz[][], int piv, int var) {
        float temp = 0;
        temp = matriz[piv][piv];
        for (int y = 0; y < (var + 1); y++) {

            matriz[piv][y] = matriz[piv][y] / temp;
        }
    }
    
    static void hacerceros(float matriz[][], int piv, int var) {
        for (int x = 0; x < var; x++) {
            if (x != piv) {
                float c = matriz[x][piv];
                for (int z = 0; z < (var + 1); z++) {
                    matriz[x][z] = ((-1 * c) * matriz[piv][z]) + matriz[x][z];
                }
            }
        }
    }
    
    static void muestramatriz(float matriz[][], int var) {
        for (int x = 0; x < var; x++) {
            for (int y = 0; y < (var + 1); y++) {
            	//sal+= " " + matriz[x][y] + " |";
                System.out.print(" " + matriz[x][y] + " |");
            }
           
            System.out.println("");
           // JOptionPane.showMessageDialog(null,sal,"GAUSS-JORDAN",JOptionPane.ERROR_MESSAGE);
        }

    }
    

public static void jordan(){
	int piv=0;
    
    for (int a = 0; a < var; a++) {
            pivote(matrix, piv, var);

            System.out.println("\tRenglon " + (a + 1) + " entre el pivote");
            muestramatriz(matrix, var);

            System.out.println("");

            System.out.println("\tHaciendo ceros");
            hacerceros(matrix, piv, var);

            muestramatriz(matrix, var);
            System.out.println("");
            piv++;
        }
        for (int x = 0; x < var; x++) {
           // System.out.println("La variable X" + (x + 1) + " es: " + matrix[x][var]);
          	sal+= "La variable X" + (x + 1) + " es: " + matrix[x][var]+"\n";	
        }
        
    JOptionPane.showMessageDialog(null,sal,"GAUSS-JORDAN",JOptionPane.ERROR_MESSAGE);
    
 
}

}

