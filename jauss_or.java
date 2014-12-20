import java.util.ArrayList; 
import javax.swing.JOptionPane;
import java.math.*;

public class jausei { 

static int var=3;
static String sal="";
static double d;
static double p;
static float  matrix [][]= new float [var][var+1];
static float  solu[]= new float [var];
static float  tem[]= new float [var];

public static void main(String args[]){ 
  
    matrixf();
    //matrixm();
    cargarsolucionf();
    //jordan();
    jacobi();
    
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
		
		matrix[2][0] = 1.0f;
    	matrix[2][1] = 2.0f;
    	matrix[2][2] = -3.0f;
    	matrix[2][3] = 12.0f;
    	
		matrix[0][0] = 3.0f;
    	matrix[0][1] = 6.0f;
    	matrix[0][2] = 9.0f;
    	matrix[0][3] = 8.0f;
    
    	matrix[1][0] = 5.0f;
    	matrix[1][1] = 8.0f;
    	matrix[1][2] = 13.0f;
    	matrix[1][3] = 6.0f;
    	
    	
    	
	
}

 	public  static void pivote(float matriz[][], int piv, int var) {
        float temp = 0;
        temp = matriz[piv][piv];
        for (int y = 0; y < (var + 1); y++) {

            matriz[piv][y] = matriz[piv][y] / temp;
        }
    }
    
    public  static void hacerceros(float matriz[][], int piv, int var) {
        for (int x = 0; x < var; x++) {
            if (x != piv) {
                float c = matriz[x][piv];
                for (int z = 0; z < (var + 1); z++) {
                    matriz[x][z] = ((-1 * c) * matriz[piv][z]) + matriz[x][z];
                }
            }
        }
    }
    
    public static void muestramatriz(float matriz[][], int var) {
        for (int x = 0; x < var; x++) {
            for (int y = 0; y < (var + 1); y++) {
            	//sal+= " " + matriz[x][y] + " |";
                System.out.print(" " + matriz[x][y] + " |");
            }
           
            System.out.println("");
           // JOptionPane.showMessageDialog(null,sal,"GAUSS-JORDAN",JOptionPane.ERROR_MESSAGE);
        }

    }
    
     public static void cargarsolucionm(){
    	for(int j=0; j<var; j++){
		String ell="INTRODUZCA EL ELEMENTO x"+j;	
			
		 solu[j] = Float.parseFloat(JOptionPane.showInputDialog(ell));	
			
		}
    }
    
    
     public  static void cargarsolucionf(){
    	
		 solu[0] = -1f;
		 solu[1] = 1f;
		solu[2] = -1f;
		}
		
	 
	 public static void seidel(){
	 	float errorX =1f;
	float errorY =1f;
	float errorZ =1f;
	int indice =1;

	 float error = Float.parseFloat(JOptionPane.showInputDialog("indice de error"));	 
     
        while (errorX > error || errorY > error || errorZ > error){
         
            for(int i=0;i<var;i++){
      tem[i]=solu[i]; 	
      	//System.out.print("\n"+tem[i]+" \n ");
      }
         	System.out.print("\nx:"+tem[0]+" \n ");  
         	System.out.print("y:"+tem[1]+" \n ");
         	System.out.print("z:"+tem[2]+" \n ");
            
	solu[0] = ( matrix[0][var]-((matrix[0][1]*tem[1])+(matrix[0][var-1]*tem[2])))/(matrix[0][0]);
	System.out.print("\n"+matrix[0][var]+"-(("+matrix[0][1]+"*"+tem[1]+")+("+matrix[0][var-1]+"*"+tem[2]+")))/("+matrix[0][0]+")\n");
	
	
	solu[1] = ( matrix[1][var]-((matrix[1][0]*tem[0])+(matrix[1][var-1]*tem[2])))/(matrix[1][1]);
	System.out.print("\n"+matrix[1][var]+"-(("+matrix[1][0]+"*"+tem[0]+")+("+matrix[1][var-1]+"*"+tem[2]+")))/("+matrix[1][1]+")\n");
  
	solu[2] = ( matrix[2][var]-((matrix[2][0]*tem[0])+(matrix[2][1]*tem[1])))/(matrix[2][var-1]);
	System.out.print("\n"+matrix[2][var]+"-(("+matrix[2][0]+"*"+tem[0]+")+("+matrix[2][1]+"*"+tem[1]+")))/("+matrix[2][var-1]+")\n");

 errorX  = Math.abs((solu[0]-tem[0])/solu[0]);  
 errorY  = Math.abs((solu[1]-tem[1])/solu[1]);  
 errorZ  = Math.abs((solu[2]-tem[2])/solu[2]);  
                        
 
            System.out.print("iteracion numero <--------------------------------------> " + indice +"\n");
            System.out.print("valor de 'x' = "+ solu[0]+"\n");
            System.out.print("valor de 'y' = "+ solu[1]+"\n");
            System.out.print("valor de 'z' = "+ solu[2]+"\n\n");
            System.out.print("el error de x es = " + errorX  +"\n");         
            System.out.print("el error de y es = " + errorY  +"\n");         
            System.out.print("el error de z es = " + errorZ  +"\n");            
            System.out.print("------------------------------------\n\n");            
            
            ++indice;	
	 }
	 }

	 public static void jacobi(){
		
	float errorX =1f;
	float errorY =1f;
	float errorZ =1f;
	int indice =1;

	 float error = Float.parseFloat(JOptionPane.showInputDialog("indice de error"));	 
     
        while (errorX > error || errorY > error || errorZ > error){
         
            for(int i=0;i<var;i++){
      tem[i]=solu[i]; 	
      	//System.out.print("\n"+tem[i]+" \n ");
      }
         	System.out.print("\nx:"+tem[0]+" \n ");  
         	System.out.print("y:"+tem[1]+" \n ");
         	System.out.print("z:"+tem[2]+" \n ");
            
	solu[0] = ( matrix[0][var]-((matrix[0][1]*tem[1])+(matrix[0][var-1]*tem[2])))/(matrix[0][0]);
	System.out.print("\n"+matrix[0][var]+"-(("+matrix[0][1]+"*"+tem[1]+")+("+matrix[0][var-1]+"*"+tem[2]+")))/("+matrix[0][0]+")\n");
	
	
	
	solu[1] = ( matrix[1][var]-((matrix[1][0]*tem[0])+(matrix[1][var-1]*tem[2])))/(matrix[1][1]);
	System.out.print("\n"+matrix[1][var]+"-(("+matrix[1][0]+"*"+tem[0]+")+("+matrix[1][var-1]+"*"+tem[2]+")))/("+matrix[1][1]+")\n");
  
	solu[2] = ( matrix[2][var]-((matrix[2][0]*tem[0])+(matrix[2][1]*tem[1])))/(matrix[2][var-1]);
	System.out.print("\n"+matrix[2][var]+"-(("+matrix[2][0]+"*"+tem[0]+")+("+matrix[2][1]+"*"+tem[1]+")))/("+matrix[2][var-1]+")\n");
       
           //calculamos los errorres de cada variables  
 errorX  = Math.abs((solu[0]-tem[0])/solu[0]);  
 errorY  = Math.abs((solu[1]-tem[1])/solu[1]);  
 errorZ  = Math.abs((solu[2]-tem[2])/solu[2]);  
                        
  //aqui solo se manda a imprimir en TextArea los resultado de esta iteracion
  
            System.out.print("iteracion numero <--------------------------------------> " + indice +"\n");
            System.out.print("valor de 'x' = "+ solu[0]+"\n");
            System.out.print("valor de 'y' = "+ solu[1]+"\n");
            System.out.print("valor de 'z' = "+ solu[2]+"\n\n");
            System.out.print("el error de x es = " + errorX  +"\n");         
            System.out.print("el error de y es = " + errorY  +"\n");         
            System.out.print("el error de z es = " + errorZ  +"\n");            
            System.out.print("------------------------------------\n\n");            
            
            ++indice;
    }//fin del ciclo mientras
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

