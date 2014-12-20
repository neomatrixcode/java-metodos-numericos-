import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.math.*;

public class jausssei {

static int var=2;
static String sal="";
static float d;
static float p;
static float  matrix [][]= new float [var][var+1];
static float  solu[]= new float [var];
static float  er[]= new float [var];
static float  tem[]= new float [var];

public static void main(String args[]){

    matrixf();
    //matrixm();
    //cargarsolucionf();
    jordan();
   //jacobi();
    //seidel();
}

	public static void matrixm(){

	for(int i=0; i<var; i++){
		for(int j=0; j<var+1; j++){
		String ell=("INTRODUZCA EL ELEMENTO : "+i+" "+j);

		 matrix[i][j] = Float.parseFloat(JOptionPane.showInputDialog(ell));

		}
	}

	jordan();

}


	public static void matrixf(){



			matrix[0][0] = 7.0f;
    	matrix[0][1] = 5.0f;
    	matrix[0][2] = 22.12f;

    	matrix[1][0] = 5.0f;
    	matrix[1][1] = 5.91f;
    	matrix[1][2] = 16.28f;




	/*	matrix[0][0] = 6.0f;
    	matrix[0][1] = -1.0f;
    	matrix[0][2] = -1.0f;
    	matrix[0][3] = 3.0f;

    	matrix[1][0] = 6.0f;
    	matrix[1][1] = 9.0f;
    	matrix[1][2] = 1.0f;
    	matrix[1][3] = 40.0f;

		matrix[2][0] = -3.0f;
    	matrix[2][1] = 1.0f;
    	matrix[2][2] = 12.0f;
    	matrix[2][3] = 50.0f;

    	/*matrix[3][0] = 1.0f;
    	 matrix[3][1] = 2.0f;
    	 matrix[3][2] = -3.0f;
    	matrix[3][3] = 12.0f;
    	matrix[3][4] = 12.0f;

    	matrix[4][0] = 1.0f;
    	matrix[4][1] = 2.0f;
    	matrix[4][2] = -3.0f;
    	matrix[4][3] = 12.0f;
    	matrix[4][4] = 12.0f;
    	matrix[4][5] = 12.0f;
    	*/


}



    public static void muestramatriz(float matriz[][], int var) {
        for (int x = 0; x < var; x++) {
            for (int y = 0; y < (var + 1); y++) {
            	//sal+= " " + matriz[x][y] + " |";
            	if(matriz[x][y]==(-0)){
            	matriz[x][y]=0;
            	}
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


		 solu[0] = 0.0f;
		 solu[1] = 0.0f;
		solu[2] = 0.0f;
		//solu[3] = -1f;
		//solu[4] = -1f;
		}




//<<<<<<<<<---------------------------------------------------------------------------------------------------------------------------------------
 public static void seidel(){


	for (int k=0;k< var;k++){
	 er[k] = 1f;
	}


	int indice =1;

	 float error = Float.parseFloat(JOptionPane.showInputDialog("indice de error"));

	 if(var==3){

        while ((er[0]) >= error  || er[var-1] >= error){


            for(int i=0;i<var;i++){
      tem[i]=solu[i];
      	//System.out.print("\n"+tem[i]+" \n ");
      }

         	for (int h=0;h<var;h++){
         	System.out.print("\nel valor de tem["+h+"] es: "+tem[h]+" \n ");
         	}


      for(int e=0; e<var;e++){
      		solu[e] = (matrix[e][var]-((sumaecusei(e))-((matrix[e][e])*solu[e])))/(matrix[e][e]);
      }

     for ( int j=0; j<var; j++){
      er[j]  = Math.abs((solu[j]-tem[j])/solu[j]);
     }


            System.out.print("iteracion numero <--------------------------------------> " + indice +"\n");

            for (int i=0; i<var; i++){
            System.out.print("valor de solu["+i+"] = "+ solu[i]+"\n");
            }
            System.out.print("\n");
            for (int i=0;i<var;i++){
            System.out.print("el error de ["+(i)+"] es = " + er[i] +"\n");

            }

            System.out.print("------------------------------------\n\n");

            ++indice;
    }
	 }


}
 public static float sumaecusei(int e){
    	float resul=0;

    	for (int i=0;i<var; i++){
    		resul += (matrix[e][i])*(solu[i]);
    	}
    	return resul;
    	}

//<<<<<<<<<---------------------------------------------------------------------------------------------------------------------------------------
	 public static void jacobi(){


	for (int k=0;k< var;k++){
	 er[k] = 1f;
	}


	int indice =1;

	 float error = Float.parseFloat(JOptionPane.showInputDialog("indice de error"));

	 if(var==3){

        while ((er[0]) >= error  || er[var-1] >= error){


            for(int i=0;i<var;i++){
      tem[i]=solu[i];
      	//System.out.print("\n"+tem[i]+" \n ");
      }

         	for (int h=0;h<var;h++){
         	System.out.print("\nel valor de tem["+h+"] es: "+tem[h]+" \n ");
         	}


      for(int e=0; e<var;e++){
      		solu[e] = (matrix[e][var]-((sumaecu(e))-((matrix[e][e])*tem[e])))/(matrix[e][e]);
      }

     for ( int j=0; j<var; j++){
      er[j]  = Math.abs((solu[j]-tem[j])/solu[j]);
     }


            System.out.print("iteracion numero <--------------------------------------> " + indice +"\n");

            for (int i=0; i<var; i++){
            System.out.print("valor de solu["+i+"] = "+ solu[i]+"\n");
            }
            System.out.print("\n");
            for (int i=0;i<var;i++){
            System.out.print("el error de ["+(i)+"] es = " + er[i] +"\n");

            }

            System.out.print("------------------------------------\n\n");

            ++indice;
    }
	 }


}

 public static float sumaecu(int e){
    	float resul=0;

    	for (int i=0;i<var; i++){
    		resul += (matrix[e][i])*(tem[i]);
    	}
    	return resul;
    	}
//<<<<<<<<<---------------------------------------------------------------------------------------------------------------------------------------
	 public static void jordan(){
	int piv=0;

    for (int a = 0; a < var; a++) {
            pivote(piv, var);
            System.out.println("\tRenglon " + (a + 1) + " entre el pivote");
            muestramatriz(matrix, var);

            System.out.println("");

            System.out.println("\tHaciendo ceros");
            hacerceros(piv, var);

            muestramatriz(matrix, var);
            System.out.println("");
            piv++;
        }
   //     for (int x = 0; x < var; x++) {
           // System.out.println("La variable X" + (x + 1) + " es: " + matrix[x][var]);
  //        	sal+= "La variable X" + (x + 1) + " es: " + matrix[x][var]+"\n";
 //       }
  //     System.out.println("\n"+sal+"\n");
   // JOptionPane.showMessageDialog(null,sal,"GAUSS-JORDAN",JOptionPane.ERROR_MESSAGE);


}

	public  static void pivote( int piv, int var) {
        float temp = 0;
        temp = matrix[piv][piv];
        for (int y = 0; y < (var + 1); y++) {

            matrix[piv][y] = matrix[piv][y] / temp;
        }
    }

    public  static void hacerceros(int piv, int var) {
        for (int x = 0; x < var; x++) {

            if (x != piv) {
            //	System.out.println("x: "+x);
                float c = matrix[x][piv];
                //System.out.println("c: "+c);
                for (int z = 0; z < (var + 1); z++) {
                //	System.out.println("piv:"+piv+" z:"+z+"    matriz[piv][z]:"+matriz[piv][z]);

                    matrix[x][z] = ((-1 * c) * matrix[piv][z]) + matrix[x][z];

                  //  	System.out.println("  matrix[x][z]:"+matrix[x][z]+"  ");
                }
            }
        }
    }



}

