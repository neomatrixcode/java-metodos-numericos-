import java.util.ArrayList; 
import javax.swing.JOptionPane;
import java.math.*;


public class derivacion{
	static String sal="";
	static double sol=0.0;
static double h,resultado=0,evalu=0;
static int pi=0,maxcolum=10;
static double recor=0.2;
static int maxd;
static double [][]tab;


	derivacion(double tabla[][],double evalu,String metodo){
		maxd=tabla.length;
	   	tab = new double [maxd][maxcolum];
	   	 iniciartabla();
		 
		 for(int c=0;c<2;c++){
		 	for(int f=0;f<maxd;f++){
		 	tab[f][c]=tabla[f][c];	
		 	}
		 }
	   	
		 diferenciar(evalu,metodo);
	}
	
	derivacion(double tabla[][],double evalu,int derivada){
		maxd=tabla.length;
	   	tab = new double [maxd][maxcolum];
		 iniciartabla();
		 
		 for(int c=0;c<2;c++){
		 	for(int f=0;f<maxd;f++){
		 	tab[f][c]=tabla[f][c];	
		 	}
		 }
		 
		 if(derivada==1){
		 d1(evalu);	
		 }
		 
		 if(derivada==2){
		 d2(evalu);	
		 }
		 
		 if(derivada==3){
		 d3(evalu);	
		 }
		  
	}
	
	
	public String solucion(){
		return sal;
	}
	
	public double resultado(){
		return sol;
	}
	
		private  void diferenciar(double eval, String metodo){
	
 		//mostrartabla();
		
		if((metodo.compareTo("tabla de diferencias"))==0){
		derivatabla();
 	
 	    d(eval);
		}
		
		if((metodo.compareTo("diferencias centrales"))==0){
		
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
	
	public  void mostrartabla(){
		System.out.printf("          ");
		for(int i=0;i<maxd;i++){
			for(int j=0;j<10;j++){
			
				System.out.printf("  |%3.3f|  ",(tab[i][j]) );
			}
			System.out.print("\n          ");
		}
		
		System.out.print("\n");
	}
	
	
		public static void dN(double dato,double da,double dd){
			sal="";
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
		
		
			
			double a2p2=(tab[fda][1]-tab[fd][1])/(tab[fda][0]-tab[fd][0]);
		

			
			double a2= ((a2p1)-(a2p2))/(tab[fdd][0]-tab[fd][0]);
			
				
			
		    
			
		    resultado=a1+(a2*(tab[fd][0]-tab[fda][0]));
			
		
			}
			
			
			sal+=("\nEl valor de la primera derivada por interpolacion de NEWTON de f(x) en el punto "+dato+" es igual a: \n"+resultado+"\n\n");
		
			sol=resultado;
		
					
		}

	
	
	
		public static void d1(double dato){
			sal="";
			int filacond=0;
			
			h = (tab[1][0])-(tab[0][0]);	
	
				
			for(int j=0;j<maxd;j++){
			
			if (tab[j][0]==dato){
				filacond=j;
			}
			}
			
		      resultado=((tab[filacond+1][1])-(tab[filacond-1][1]));
						
		
			resultado *= (1/(2*h));
			
			
			sal+=("El valor de la PRIMERA derivada de f(x)por derivadas CENTRALES en el punto "+dato+" es igual a: \n"+resultado+"\n\n");
		sol=resultado;
					
		}

	
		public static void d2(double dato){
			sal="";
			int filacond=0;
			
			h = (tab[1][0])-(tab[0][0]);	
	
				
			for(int j=0;j<maxd;j++){
			
			if (tab[j][0]==dato){
				filacond=j;
			}
			}
			
		      resultado=((tab[filacond+1][1])-(2*(tab[filacond][1]))+(tab[filacond-1][1]));
						
		
			resultado *= (1/(Math.pow(h,2.0)));
			
		
			sal+=("El valor de la SEGUNDA derivada de f(x) por derivadas CENTRALES en el punto "+dato+" es igual a: \n"+resultado+"\n\n");
		    sol=resultado;
					
		}

		
		public static void d3(double dato){
			sal="";
			int filacond=0;
			
			h = (tab[1][0])-(tab[0][0]);	
	
				
			for(int j=0;j<maxd;j++){
			
			if (tab[j][0]==dato){
				filacond=j;
			}
			}
			
		      resultado=((tab[filacond+2][1])-(2*(tab[filacond+1][1]))+(2*(tab[filacond-1][1]))-(tab[filacond-2][1]));
						
		
			resultado *= (1/(2*(Math.pow(h,3.0))));
			
			
			sal+=("El valor de la TERCERA derivada de f(x) por derivadas CENTRALES en el punto "+dato+" es igual a: \n"+resultado+"\n\n");
			sol=resultado;
		}

	
	
		public static void d(double dato){
			sal="";
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
			sal+=("El valor de la derivada de f(x) por TABLA DE DIFERENCIAS en el punto "+dato+" es igual a: \n"+resultado+"\n\n\n");
			sol=resultado;
			}
			
			if(resultado==0){
			sal+=("El valor de la derivada de f(x) por TABLA DE DIFERENCIAS en el punto "+dato+" se desconoce \n\n\n");
			}
				
		}
		
	public static void determinagrado(){
	
	int coincidencia=0,ldc=0;
	System.out.print("\n");
	for(int coo=2;coo<maxcolum;coo++){
	
	for(int j=1;j<maxd;j++){
		
			if (((tab[j-1][coo])!=0)&&((tab[j][coo])!=0)){	
			if ((tab[j-1][coo])==(tab[j][coo])){
				
			
				
				coincidencia++;
			
				ldc=coo-1;
				  
				
			}
			}
			}
	}
	
	if(coincidencia>1){
		sal+=("la funcion f(x) es de grado: "+ldc);
	}
	if(coincidencia==0){
		sal+=("Se desconoce el grado de la funcion \n");
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
	
	

}
	
	
}