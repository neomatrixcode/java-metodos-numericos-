import java.util.ArrayList; 
import javax.swing.JOptionPane;
import java.math.*;
public class sisecu {
	
static int var;
static String sal="";
static String metodod="";
static double d;
static double p;
static double  matrix [][];
static double  solu[];
static double  er[];
static double  tem[];
static double  error =0.5;
	
sisecu(double  matrixf[][]){
	
	matrix=matrixf;
	metodod="por el metodo de gauss-jordan";
	int piv=0;
    var = matrixf.length; //determina el número de las columnas

    for (int a = 0; a < var; a++) {
            pivote(matrix,piv, var);         
            hacerceros(matrix,piv, var);
            piv++;
        }
 
}



sisecu( double  matrixf[][],double  sol[],String  metodo){
	var = matrixf.length;
	solu=sol;

	if((metodo.compareTo("jacobi"))==0){
		
	metodod="por el metodo de jacobi";	
		jacobi(matrixf,solu,var);
	}
	if((metodo.compareTo("seidel"))==0){
			metodod="por el metodo de seidel";
		seidel(matrixf,solu,var);
	}
	if(((metodo.compareTo("jacobi"))!=0)||((metodo.compareTo("seidel"))!=0)){
	//	System.out.print("\nEliga un metodo: jacobi o seidel\n");
	}
}
	
sisecu(int va){
	var=va;
		metodod="por el metodo de gauss-jordan";
		matrix = new double  [var][var+1];
	for(int i=0; i<var; i++){
		for(int j=0; j<var+1; j++){
		String ell="INTRODUZCA EL ELEMENTO : "+i+" "+j;	
			
		 matrix[i][j] = Float.parseFloat(JOptionPane.showInputDialog(ell));	
			
		}
	}	
		
		
	int piv=0;
    
    for (int a = 0; a < var; a++) {
            pivote(matrix,piv, var);         
            System.out.println("\tRenglon " + (a + 1) + " entre el pivote");
            muestramatriz(matrix, var);

            System.out.println("");

            System.out.println("\tHaciendo ceros");
            hacerceros(matrix,piv, var);

            muestramatriz(matrix, var);
            System.out.println("");
            piv++;
        }
       
       
       
      //System.out.println("\n"+sal+"\n");  
   // JOptionPane.showMessageDialog(null,sal,"GAUSS-JORDAN",JOptionPane.ERROR_MESSAGE);
	
}	

sisecu(int v,String metodo){
	var=v;
 	 matrix = new double  [var][var+1];
	  solu = new double  [var];
	for(int i=0; i<var; i++){
		for(int j=0; j<var+1; j++){
		String ell="INTRODUZCA EL ELEMENTO : "+i+" "+j;	
			
		 matrix[i][j] = Float.parseFloat(JOptionPane.showInputDialog(ell));	
			
		}
	}	
		
		
			for(int j=0; j<var; j++){
		String ell="INTRODUZCA EL ELEMENTO "+j+"de la solucion";	
			
		 solu[j] = Float.parseFloat(JOptionPane.showInputDialog(ell));	
			
		}
		
	if(metodo.compareTo("jacobi")==0){
			metodod="por el metodo de jacobi";
		jacobi(matrix,solu,var);
	}
	if(metodo.compareTo("seidel")==0){
			metodod="por el metodo de seidel";
		seidel(matrix,solu,var);
	}

	
}	
	
	
	



	public void solucion(){
    	sal="";
		sal+="la solucion del sistema de ecuaciones "+metodod+" es:\n";
	
				if((metodod.compareTo("por el metodo de gauss-jordan"))==0){
				for(int i=0;i<var;i++){  
			    sal+=("x"+(i+1)+": "+matrix[i][var]+" \n");  
			    }	
				}
			    
			    if(((metodod.compareTo("por el metodo de jacobi"))==0)||((metodod.compareTo("por el metodo de seidel"))==0)){
			    for(int i=0;i<this.var;i++){
			    sal+=("x"+(i+1)+": "+solu[i]+" \n");
			    }
			    }
		
		  	sal+=("\n");
		  	
		  	System.out.print(sal);
      }
      
      	
      
      public double [] solucionv(){
    double  salida[]=new double [this.var];
    
            	if((metodod.compareTo("por el metodo de gauss-jordan"))==0){
				for(int i=0;i<var;i++){  
			    salida[i]=(matrix[i][this.var]);  
			    }	
				}
			    
			    if(((metodod.compareTo("por el metodo de jacobi"))==0)||((metodod.compareTo("por el metodo de seidel"))==0)){
			    for(int i=0;i<var;i++){
			    salida[i]=(solu[i]);
			    }
			    }
		
		  return salida;
      }
      

	
    
    public static void muestramatriz(double  matriz[][], int var) {
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
    
  
    
		
   
   

//<<<<<<<<<---------------------------------------------------------------------------------------------------------------------------------------
 public static void seidel(double  matrix[][],double  solu[],int var){
		
	er= new double  [var];
	tem= new double  [var];

		
	for (int k=0;k< var;k++){
	 er[k] = 1f;	
	}
	
	
	int indice =1;
    
	// float error = Float.parseFloat(JOptionPane.showInputDialog("indice de error"));
	 
	// if(var==3){
       
        while ((er[0]) >= error  || er[var-1] >= error){
            
    
            for(int i=0;i<var;i++){
      tem[i]=solu[i]; 	
      	//System.out.print("\n"+tem[i]+" \n ");
      }
         	
         
      
      for(int e=0; e<var;e++){
      		solu[e] = (matrix[e][var]-((sumaecusei(e,matrix,solu))-((matrix[e][e])*solu[e])))/(matrix[e][e]);
      }
       
     for ( int j=0; j<var; j++){
      er[j]  = Math.abs((solu[j]-tem[j])/solu[j]);  
     }      

  
          /*  System.out.print("iteracion numero <--------------------------------------> " + indice +"\n");
            
            for (int i=0; i<var; i++){
            System.out.print("valor de solu["+i+"] = "+ solu[i]+"\n");
            }
            System.out.print("\n");
            for (int i=0;i<var;i++){
            System.out.print("el error de ["+(i)+"] es = " + er[i] +"\n");         
                     	
            }
                      
            System.out.print("------------------------------------\n\n");     */       
            
            ++indice;
    }
//	 }
	
	 	 
}
 public static double  sumaecusei(int e,double  matrix[][],double  solu[]){
    	double  resul=0;
    	
    	for (int i=0;i<var; i++){
    		resul += (matrix[e][i])*(solu[i]);
    	}
    	return resul;
    	}
    	
//<<<<<<<<<---------------------------------------------------------------------------------------------------------------------------------------
	 public static void jacobi(double  matrix[][],double  solu[],int var){
	
	er= new double  [var];
	tem= new double  [var];

	
	for (int k=0;k< var;k++){
	 er[k] = 1f;	
	}
	

	int indice =1;
	
	 //float error = Float.parseFloat(JOptionPane.showInputDialog("indice de error"));
  
	// if(var==3){
   
        while ((er[0]) >= error  || er[var-1] >= error){
            
    
            for(int i=0;i<var;i++){
      tem[i]=solu[i]; 	
      	//System.out.print("\n"+tem[i]+" \n ");
      }
         	
         
      
      
      for(int e=0; e<var;e++){
     
      		solu[e] = (matrix[e][var]-((sumaecu(e,matrix,tem))-((matrix[e][e])*tem[e])))/(matrix[e][e]);
      }
       
     for ( int j=0; j<var; j++){
      er[j]  = Math.abs((solu[j]-tem[j])/solu[j]);  
     }      

  
          /*  System.out.print("iteracion numero <--------------------------------------> " + indice +"\n");
            
            for (int i=0; i<var; i++){
            System.out.print("valor de solu["+i+"] = "+ solu[i]+"\n");
            }
            System.out.print("\n");
            for (int i=0;i<var;i++){
            System.out.print("el error de ["+(i)+"] es = " + er[i] +"\n");               	
            }
                      
            System.out.print("------------------------------------\n\n");    */        
            
            ++indice;
    }
	 //}
		
	 	
	 	 
}

 public static double  sumaecu(int e,double  matrix[][],double  tem[]){
    	double  resul=0;
    	
    	for (int i=0;i<var; i++){
    		resul += (matrix[e][i])*(tem[i]);
    	}
    	return resul;
    	}
//<<<<<<<<<---------------------------------------------------------------------------------------------------------------------------------------
//jordan

	public  static void pivote(double  matrix[][] ,int piv, int var) {
        double temp = 0;
       
       temp = matrix[piv][piv];
        for (int y = 0; y < (var + 1); y++) {

            matrix[piv][y] = matrix[piv][y] / temp;
        }
    }
    
    public  static void hacerceros(double matrix[][] ,int piv, int var) {
        for (int x = 0; x < var; x++) {
            
            if (x != piv) {
            //	System.out.println("x: "+x);
                double  c = matrix[x][piv];
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