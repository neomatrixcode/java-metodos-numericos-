import java.util.ArrayList; 
import javax.swing.JOptionPane;
import java.math.*;


public class derivate { 

static String sal="";

static double h,resultado=0,evalu=0;
static int pi=0,maxcolum=10;
static double recor=0.2;
static int maxd=16;
static double [][]tab = new double [maxd][maxcolum];


public static void main(String args[]){ 
  
     
     
     evalu = 1.3;
    
   
    diferenciar(evalu,"");
    
    
   
    
    
} 
 	public static void diferenciar(double eval, String metodo){
		
		dattabla4();
 		mostrartabla();
		
		if((metodo.compareTo("tabla"))==0){
		derivatabla();
 		mostrartabla();	
 	    d(eval);
		}
		
		if((metodo.compareTo("diferencias"))==0){
		
		d1(eval);
			
		}
		
		if((metodo.compareTo("newton"))==0){
		
		dN(eval,eval-recor,eval+recor);
			
		}
		
		if((metodo.compareTo(""))==0){
		derivatabla();
 		mostrartabla();	
 	    d(eval);
		d1(eval);
		dN(eval,eval-recor,eval+recor);
			
		}
		
	}

	public static void iniciartabla(){
		for(int i=0;i<maxd;i++){
			for(int j=0;j<10;j++){
			tab[i][j]=0.0;
			}
		
		}
	}
	
	public static void mostrartabla(){
		System.out.printf("          ");
		for(int i=0;i<maxd;i++){
			for(int j=0;j<10;j++){
			
				System.out.printf("  |%3.3f|  ",(tab[i][j]) );
			}
			System.out.print("\n          ");
		}
		
		System.out.print("\n");
	}

	public static void dattabla1(){
		tab[0][0]=0.5;
		tab[1][0]=1.0;
		tab[2][0]=1.5;
		tab[3][0]=2.0;
		tab[4][0]=2.5;
		tab[5][0]=3.0;
		
		
		tab[0][1]=2.75;
		tab[1][1]=2.0;
		tab[2][1]=0.75;
		tab[3][1]=-1.0;
		tab[4][1]=-3.25;
		tab[5][1]=-6.0;
		
	
	}
	
		public static void dattabla2(){
		tab[0][0]=1.3;
		tab[1][0]=1.5;
		tab[2][0]=1.7;
		tab[3][0]=1.9;
		tab[4][0]=2.1;
		tab[5][0]=2.3;
		tab[6][0]=2.5;
		
		tab[0][1]=3.669;
		tab[1][1]=4.482;
		tab[2][1]=5.474;
		tab[3][1]=6.686;
		tab[4][1]=8.166;
		tab[5][1]=9.974;
		tab[6][1]=12.182;
		
	
	}
	public static void dattabla3(){
		tab[0][0]=0.1;
		tab[1][0]=0.5;
		tab[2][0]=1.1;
		tab[3][0]=1.8;
		tab[4][0]=2.5;
		tab[5][0]=2.6;
		
		
		tab[0][1]=2.809;
		tab[1][1]=2.219;
		tab[2][1]=1.348;
		tab[3][1]=-1.336;
		tab[4][1]=-7.007;
		tab[5][1]=-7.992;
		
		
	
	}
       	public static void dattabla4(){
		tab[0][0]=0.1;
		tab[1][0]=0.3;
		tab[2][0]=0.5;
		tab[3][0]=0.7;
		tab[4][0]=0.9;
		tab[5][0]=1.1;
		tab[6][0]=1.3;
		tab[7][0]=1.5;
		tab[8][0]=1.7;
		tab[9][0]=1.9;
		tab[10][0]=2.1;
		tab[11][0]=2.3;
		tab[12][0]=2.5;
		tab[13][0]=2.7;
		tab[14][0]=2.9;
		tab[15][0]=3.1;
	
		
		tab[0][1]=-2.52;
		tab[1][1]=-2.01;
		tab[2][1]=-1.4;
		tab[3][1]=-0.75;
		tab[4][1]=-0.08;
		tab[5][1]=0.556;
		tab[6][1]=1.112;
		tab[7][1]=1.547;
		tab[8][1]=1.818;
		tab[9][1]=1.881;
		tab[10][1]=1.695;
		tab[11][1]=1.215;
		tab[12][1]=0.397;
		tab[13][1]=-0.8;
		tab[14][1]=-2.42;
		tab[15][1]=-4.51;
		
		
	
	}
	
	
		public static void dN(double dato,double da,double dd){
			
			int fd=0,fda=0,fdd=0,e=0;
			
			h = (tab[1][0])-(tab[0][0]);	
	
				
			for(int j=0;j<maxd;j++){
			if (tab[j][0]==dato){
				fd=j;
				
			}
			
			}
			
			for(int j=0;j<maxd;j++){
			if (tab[j][0]==da){
				fda=j;
				
			}
			
			}
			
			for(int j=0;j<maxd;j++){
			if (tab[j][0]==dd){
				fdd=j;
			
			}
			
			}
			
			if(e==0){
			
			
		    double a1=(tab[fda][1]-tab[fd][1])/(tab[fda][0]-tab[fd][0]);
		   
			double a2p1=(tab[fdd][1]-tab[fda][1])/(tab[fdd][0]-tab[fda][0]);
		
			//System.out.print(" \n"+a2p1+" \n");
			
			double a2p2=(tab[fda][1]-tab[fd][1])/(tab[fda][0]-tab[fd][0]);
		
			//System.out.print(a2p2+" \n");
			
			double a2= ((a2p1)-(a2p2))/(tab[fdd][0]-tab[fd][0]);
			
				
			
		    
			
		    resultado=a1+(a2*(tab[fd][0]-tab[fda][0]));
		//	System.out.print(" \n"+resultado+" \n");			
		
			}
			
			
			System.out.print("\nEl valor de la primera derivada por interpolacion de NEWTON de f(x) en el punto "+dato+" es igual a: \n"+resultado+"\n\n");
		
			
		
					
		}

	
	
		public static void d1(double dato){
			
			int filacond=0;
			
			h = (tab[1][0])-(tab[0][0]);	
	
				
			for(int j=0;j<maxd;j++){
			
			if (tab[j][0]==dato){
				filacond=j;
			}
			}
			
		      resultado=((tab[filacond+1][1])-(tab[filacond-1][1]));
						
		
			resultado *= (1/(2*h));
			
			
			System.out.print("El valor de la PRIMERA derivada de f(x)por derivadas CENTRALES en el punto "+dato+" es igual a: \n"+resultado+"\n\n");
		
					
		}

	
		public static void d2(double dato){
			
			int filacond=0;
			
			h = (tab[1][0])-(tab[0][0]);	
	
				
			for(int j=0;j<maxd;j++){
			
			if (tab[j][0]==dato){
				filacond=j;
			}
			}
			
		      resultado=((tab[filacond+1][1])-(2*(tab[filacond][1]))+(tab[filacond-1][1]));
						
		
			resultado *= (1/(Math.pow(h,2.0)));
			
		
			System.out.print("El valor de la SEGUNDA derivada de f(x) por derivadas CENTRALES en el punto "+dato+" es igual a: \n"+resultado+"\n\n");
		
					
		}

		
		public static void d3(double dato){
			
			int filacond=0;
			
			h = (tab[1][0])-(tab[0][0]);	
	
				
			for(int j=0;j<maxd;j++){
			
			if (tab[j][0]==dato){
				filacond=j;
			}
			}
			
		      resultado=((tab[filacond+2][1])-(2*(tab[filacond+1][1]))+(2*(tab[filacond-1][1]))-(tab[filacond-2][1]));
						
		
			resultado *= (1/(2*(Math.pow(h,3.0))));
			
			
			System.out.print("El valor de la TERCERA derivada de f(x) por derivadas CENTRALES en el punto "+dato+" es igual a: \n"+resultado+"\n\n");
			
		}

	
	
		public static void d(double dato){
			
			int filacond=0;
				
			for(int j=0;j<maxd;j++){
			
			if (tab[j][0]==dato){
				filacond=j;
			}
			}
			
			
			for(int c=1;c<=8;c++){
				int a=1;
				if((c%2)==0){
					a=-1;
				}
				else{
				a=1;	
				}
				
				
				resultado+=(1/c)*(tab[filacond][c+1])*(a);
			}
		
			resultado *= (1/h);
			
			if(resultado!=0){
			System.out.print("El valor de la derivada de f(x) por TABLA DE DIFERENCIAS en el punto "+dato+" es igual a: \n"+resultado+"\n\n\n");
			}
			
			if(resultado==0){
			System.out.print("El valor de la derivada de f(x) por TABLA DE DIFERENCIAS en el punto "+dato+" se desconoce \n\n\n");
			}
					
		}
		
	public static void determinagrado(){
	
	int coincidencia=0,ldc=0;
	System.out.print("\n");
	for(int coo=2;coo<maxcolum;coo++){
	
	for(int j=1;j<maxd;j++){
		
			if (((tab[j-1][coo])!=0)&&((tab[j][coo])!=0)){	
			if ((tab[j-1][coo])==(tab[j][coo])){
				
				//System.out.print((tab[j-1][coo])+"   "+(tab[j][coo]));
				
				coincidencia++;
				//	System.out.print("coincidencia :"+coincidencia+"\n");
				ldc=coo-1;
				  // System.out.print("columna de coincidencia"+ldc+"\n");
				
			}
			}
			}
	}
	
	if(coincidencia>1){
		System.out.print("la funcion f(x) es de grado: "+ldc);
	}
	if(coincidencia==0){
		System.out.print("Se desconoce el grado de la funcion \n");
	}
	
	}
		
	
	public static void derivatabla(){
			
	h = (tab[1][0])-(tab[0][0]);	
	
	resultado=0;
	
  	for(int col=2; col<maxcolum; col++){
	for(int i=(pi+1); i<maxd; i++){
	
	tab[i][col] = (tab[i][col-1])-(tab[i-1][col-1]);

	}
	pi++;
	}
	
	
	
//	resultado=resultado*(1/h); 
	
	 //JOptionPane.showMessageDialog(null,"La integral de la tabla de valores es igual a: \n"+ resultado,"INTEGRAL TABLA  TRAPECIO",JOptionPane.ERROR_MESSAGE);
	 System.out.print("\n\nLos valores de la tabla es igual a: \n"); 

}




	


}

