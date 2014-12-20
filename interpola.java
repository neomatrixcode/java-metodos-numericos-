import java.util.ArrayList; 
import javax.swing.JOptionPane;
import java.math.*;


public class interpola { 


static int grado=4;
static int maxd=8;



static String sal="";

static double h,suma=0.0f;
//esto es de euler creo.
static int pi=0,maxc=(4*grado),var=(grado+1),eld=-1; 
static double  parcial=1;
static double matrix [][]= new double [var][var+1],p=0.0;
static double sumas []= new double [maxc];
static double tab [][]= new double [maxd][maxc];



public static void main(String args[]){ 
   dattabla();
  
   //euler();
    gregory(6.7);
   // double vectordato[]={0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0};
   //Lagrange(vectordato);
      
     
   
} 
		/*	public static void dattabla(){
		tab[0][0]=0.5;
		tab[1][0]=0.75;
		tab[2][0]=1.0;
		tab[3][0]=1.25;
		tab[4][0]=1.5;
		tab[5][0]=1.75;
		tab[6][0]=2.0;
		tab[7][0]=2.25;
		tab[8][0]=2.5;
		tab[9][0]=2.75;
		tab[10][0]=3.0;
		tab[11][0]=3.25;
		tab[12][0]=3.5;
	
		
		
		tab[0][1]=1.97;
		tab[1][1]=2.16;
		tab[2][1]=2.54;
		tab[3][1]=3.11;
		tab[4][1]=3.79;
		tab[5][1]=4.49;
		tab[6][1]=5.04;
		tab[7][1]=5.26;
		tab[8][1]=4.99;
		tab[9][1]=4.06;
		tab[10][1]=2.37;
		tab[11][1]=-0.12;
		tab[12][1]=-3.35;
	
		
	
	}*/
	
	public static void dattabla(){
		tab[0][0]=0.0;
		tab[1][0]=1.0;
		tab[2][0]=2.0;
		tab[3][0]=3.0;
		tab[4][0]=4.0;
		tab[5][0]=5.0;
		tab[6][0]=6.0;
		tab[7][0]=7.0;
		
		
		tab[0][1]=2.0;
		tab[1][1]=4.0;
		tab[2][1]=6.0;
		tab[3][1]=8.0;
		tab[4][1]=10.0;
		tab[5][1]=6.0;
		tab[6][1]=5.0;
		tab[7][1]=3.0;
		
	
	}
	
	/*public static void dattabla(){
		tab[0][0]=1.0f;
		tab[1][0]=2.0f;
		tab[2][0]=3.0f;
		tab[3][0]=4.0f;
		tab[4][0]=5.0f;
		
		
		tab[0][1]=4.0f;
		tab[1][1]=6.0f;
		tab[2][1]=8.0f;
		tab[3][1]=10.0f;
		tab[4][1]=6.0f;
		
		
	}*/
	
		/*public static void dattabla(){
		tab[0][0]= 3.0;
		tab[1][0]= 4.0;
		tab[2][0]= 7.0;
		tab[3][0]= 8.0;
		tab[4][0]= 15.0;
		tab[5][0]= 17.0;
		tab[6][0]= 18.0;
		
		tab[0][1]=-31.0;
		tab[1][1]=6.0;
		tab[2][1]=10.0;
		tab[3][1]=5.0;
		tab[4][1]=3.0;
		tab[5][1]=6.0;
		tab[6][1]=20.0;
	
	}*/


		public static void Lagrange(double vd []){
  		System.out.print("\n     Metodo de Lagrange\n"); 
  	    
  	    int posision[]=new int[vd.length];
  	    double F[]=new double [vd.length];
  	   double  dp=1.0;
  	    double vectorentrada[]= new double [vd.length-1];
   	
   		//mostrartabla();
   		
          
          int gradola=vd.length-1;
        
          double matrixsolucion[][]=new double [vd.length][vd.length+1];
          
          	System.out.print("\n     funcion de "+gradola+"° grado\n\n");
   		       
   		  for(int i=0;i<vd.length;i++){
   		  	for(int j=0;j<maxd;j++){
			
			if (tab[j][0]==vd[i]){
				posision[i]=j;
				j=maxd;
			}
			}
   		  }     
   		   
   		   	for(int j=0;j<posision.length;j++){
  		   		F[j]= tab[posision[j]][1];
   		   	}
   		   
   		   for(int j=0;j<vd.length-1;j++){
   		   	dp=1.0;
   		   	int e=0;
   		  	for(int i=0;i<vd.length;i++){
			if(j==i){
			i++;	
			}
		     vectorentrada[e]=vd[i];    
			dp=dp*(vd[j]-vd[i]);
			e++;
			}
			 for(int i=0;i<vectorentrada.length;i++){
	     	vectorentrada[i]*=-1.0;
	        }
				Multipli a1 = new Multipli (vectorentrada);
			double vectortran[]= a1.fvector();
		
			
			for(int l=0;l<vectortran.length;l++){
				vectortran[l]=((F[j])/dp)*vectortran[l];
			}
			for(int h=0;h<vectortran.length;h++){
				matrixsolucion[j][h]=vectortran[h];
			}
			
   		  }
   		  
   		  dp=1;
   	
   		  	for(int k=0;k<vd.length-1;k++){
		      
		     vectorentrada[k]=vd[k];
		     
			dp=dp*(vd[vd.length-1]-vd[k]);
		    
			}
			
			for(int i=0;i<vectorentrada.length;i++){
	     	vectorentrada[i]*=-1.0;
	        }
				Multipli a2 = new Multipli (vectorentrada);
			double vectortran[]= a2.fvector();
			
			for(int l=0;l<vectortran.length;l++){
				vectortran[l]=((F[F.length-1])/dp)*vectortran[l];
			}
			
			for(int h=0;h<vectortran.length;h++){
				matrixsolucion[vd.length-1][h]=vectortran[h];
			}
			
		
  		double vectortaylor[] =new double [vectortran.length];
  		
  		for(int i=0;i<vectortran.length;i++){
   		  for(int h=0;h<vd.length;h++){
			vectortaylor[i] +=	matrixsolucion[h][i];
			}
   		  }
   		  
   		  
   		  sal="";
   		  for(int i=0;i<vectortaylor.length;i++){
   		  		if(i>0){
				sal+="+ ";	
				}
   		  	    if(gradola==1){
   		  	    sal+=vectortaylor[i]+" x " ;	
   		  	    }
   		  	    if(gradola==0){
   		  	    sal+=vectortaylor[i]+"" ;	
   		  	    }
   		  	    if(gradola>=2){
   		  	    sal+=vectortaylor[i]+" x^"+gradola+" " ;	
   		  	    }
				gradola--;
			}
  		System.out.print(sal);	
  			
          
        }
   
	
//------------------------------------------------------------------------------------------------------------------------------------
		
	
	public static void gregory(double dat){
  System.out.print("\n     Metodo de Newton-Gregory\n\n"); 
 
  difieretabla();
   //mostrartabla();
   
   caltabla(dat);
   
	}
   
   
   	public static void difieretabla(){
	
	for(int col=2; col<maxc; col++){
	for(int i=0; i<maxd; i++){
	
	tab[i][col] = 0.0;

	}

	}
	
  	for(int col=2; col<maxc; col++){
	for(int i=(pi+1); i<maxd; i++){
	
	tab[i][col] = (tab[i][col-1])-(tab[i-1][col-1]);

	}
	pi++;
	}
	
	}
	
	public static void caltabla(double  x){
		h = (tab[1][0])-(tab[0][0]);	
	  
	  System.out.print("\n   f("+x+")=");
	  
	  	for(int j=0;j<maxd;j++){
			
			if (tab[j][0]<=x){
				eld=j;
			}
			}
	  
	  	if( (tab[maxd-1][0])< x  ){
				System.out.print("  NO EXISE INFORMACION SUFICIENTE PARA CALCULAR ESE DATO\n\n");
				System.exit(1);
			}
			
			if( (tab[0][0])> x  ){
				System.out.print("  NO EXISE INFORMACION SUFICIENTE PARA CALCULAR ESE DATO\n\n");
				System.exit(1);
			}
		
	  
	  double s = (x-(tab[eld][0]))/h;
     
	  
	   
	   p+= tab[eld][1];
			//System.out.print(p+"\n");
		for(int i=2; i<maxc; i++){
			parcial=1;
			for(int j=0;j<=(i-2);j++){
				parcial*=(s-j);
				//System.out.print("\n parcial (s-"+j+"): "+(s-j)+"  \n");
			}
			//System.out.print("\n");
			
			p+=((parcial/fac(i-1))*(tab[eld][i]));
			
			
			
		//	System.out.print("\n(("+parcial+"/"+fac(i-1)+")*("+tab[eld][i]+")) :"+((parcial/fac(i-1))*(tab[eld][i]))+"\n");
			
		}
		
		System.out.print(p+"\n\n");
		
		
		}
		
	public static double fac(int num){
	double  res=1;			
	for(double  i=num; i>=1; i--){
		res*=i;
	}
	return res;			
	}
		
		
		
//------------------------------------------------------------------------------------------------------------------------------------		
	
	public static void euler(){
		
    calculatabla();
   // mostrartabla();
   // tabladesumas();
    calculasistema();
  
    muestraecuacioneuler();
	
	}
	
		public static void calculatabla(){			
	for(int col=2;col<maxc;col=col+2){	
	for(int i=0; i<maxd; i++){	
	tab[i][col] = Math.pow((tab[i][0]),(col/2)+1);
	}
	}
	for(int col=3;col<maxc;col=col+2){
	for(int i=0; i<maxd; i++){
	tab[i][col] = (tab[i][(col-3)])*(tab[i][1]);
	}
	}
	for(int pos=0;pos<maxc;pos++){
	for(int i=0; i<maxd; i++){
    suma+=tab[i][pos];
	}
	 sumas[pos]=suma;
	 suma=0.0f;
	}
	
}
	
		public static void tabladesumas(){
			System.out.printf("          ");
		for(int j=0;j<maxc;j++){
			
				System.out.printf("  |%3.3f|  ",(sumas[j]) );
			}
		}
		
		public static void calculasistema(){
			
			for(int i=0;i<=grado;i++){
					matrix[i][var]= sumas[(2*i)+1];
					
				for(int j=0;j<=grado;j++){
					
					int calculo =((2*j)-2)+(i*2);
					
					if(calculo<0){	
					calculo=0;
					}
				
					matrix[i][j]= sumas[calculo];
					
					if(j==0 && i==0){	
					matrix[i][j]=(double)maxd;
					}
				}
			}
		
		}
		
		public static void muestraecuacioneuler(){
		sal="";
		sal+="la ecuacion es:\n";
		
		 sisecu a = new sisecu(matrix);
		double  resultado[]=a.solucionv();
		
		
			for (int i=0;i<=grado;i++){
				if(i>0){
				sal+="+ ";	
				}
			    
			    if (i==0){
			    sal+=(resultado[i]+" ");	
			    }
			    
			    if (i==1){
			    sal+=(resultado[i]+" x ");	
			    }
			    if(i>=2){
				sal+=(resultado[i]+" x^"+i+" ");
			    	
			    }
									
			}
		    	
		  	sal+=("\n");
		  	System.out.print(sal);
			
	} 
//------------------------------------------------------------------------------------------------------------------------------------

 
 
   		public static void mostrartabla(){
		System.out.printf("          ");
		for(int i=0;i<maxd;i++){
			for(int j=0;j<maxc;j++){
			
				System.out.printf("  |%3.3f|  ",(tab[i][j]) );
			}
			System.out.print("\n          ");
			
		}
			
		System.out.print("\n");
		
	}
	
	

}

