import  javax.swing.JOptionPane;
public class interpol {
	
	
	static int grado;
	static int maxd;
	
	static String sal="";
	static int be=0,bl=0,bg=0;
	static double h,suma=0.0f;
	//esto es de euler creo.
	static int pi=0,maxc,var,eld=-1; 
	static double  parcial=1;
	static double matrix [][],p=0.0;
	static double sumas [];
	static double tab [][];
	static 	double vectoreuler[];
    static double vectorgre[]=new double[2];
    static double vectorl[];
	
	
	interpol(double en[][],int gr){
	be=1;
	grado=gr;
	maxd= en.length; //Determina el número de las filas
	maxc=(4*grado);
	var=(grado+1);	
		
	matrix = new double [var][var+1];
	sumas = new double [maxc];
	tab = new double [maxd][maxc];
	
	for(int i=0;i<2;i++){
		for(int j=0;j<maxd;j++){
			tab[j][i]=en[j][i];
		}
	}
	
	calculatabla();
    
    calculasistema();
	muestraecuacioneuler();
	}



	interpol(double en[][],double vec[]){
		bl=1;
	maxd= en.length; //Determina el número de las filas
	tab = new double [maxd][2];
	for(int i=0;i<2;i++){
		for(int j=0;j<maxd;j++){
			tab[j][i]=en[j][i];
		}
	}
	
	Lagrange(vec);	
	}
	
	interpol(double ent[][],double d){
		bg=1;
		grado=10;
	maxd= ent.length; //Determina el número de las filas
	maxc=(grado);
	
	tab = new double [maxd][maxc];
	
	for(int i=0;i<2;i++){
		for(int j=0;j<maxd;j++){
			tab[j][i]=ent[j][i];
		}
	}
	
	difieretabla();
	caltabla(d);
	}
   
   
    public String funcion(){
    	return sal;
    }
    public String dato(){
    	return  sal;
    }
   		
   	public double[] funcionv(){
   		if(be==1){
   	    return vectorl;
   		}
   		if(bl==1){
   		return vectoreuler;	
   		}
   		if(bg==1){
   		return vectorgre;	
   		}
   		double def[]=new double [1];
   		return def;
   	}	
   		
   		
   	private void difieretabla(){
	
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
	
	private   void caltabla(double  x){
		h = (tab[1][0])-(tab[0][0]);	
	  sal="";
	  sal+=("\n   f("+x+")=");
	  
	  	for(int j=0;j<maxd;j++){
			
			if (tab[j][0]<=x){
				eld=j;
			}
			}
	  
	  	if( (tab[maxd-1][0])< x  ){
				sal+=("  NO EXISE INFORMACION SUFICIENTE PARA CALCULAR ESE DATO\n\n");
				System.exit(1);
			}
			
			if( (tab[0][0])> x  ){
				sal+=("  NO EXISE INFORMACION SUFICIENTE PARA CALCULAR ESE DATO\n\n");
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
		
		vectorgre[0]=x;
		vectorgre[1]=p;
		sal+=(p+"\n\n");
		
		
		}
		
	private   double fac(int num){
	double  res=1;			
	for(double  i=num; i>=1; i--){
		res*=i;
	}
	return res;			
	}
		
   		
		private   void Lagrange(double vd []){
  	
  	    sal="";
  	    int posision[]=new int[vd.length];
  	    double F[]=new double [vd.length];
  	   double  dp=1.0;
  	    double vectorentrada[]= new double [vd.length-1];
   	
   		//mostrartabla();
   		
          
          int gradola=vd.length-1;
        
          double matrixsolucion[][]=new double [vd.length][vd.length+1];
          
          	sal+=("\n     funcion de "+gradola+"° grado\n\n");
   		       
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
			
		
  		vectoreuler=new double [vectortran.length];
  		
  		for(int i=0;i<vectortran.length;i++){
   		  for(int h=0;h<vd.length;h++){
			vectoreuler[i] +=	matrixsolucion[h][i];
			}
   		  }
   		  
   		  
   		  //sal="";
   		  for(int i=0;i<vectoreuler.length;i++){
   		  		if(i>0){
				sal+="+ ";	
				}
   		  	    if(gradola==1){
   		  	    sal+=vectoreuler[i]+" x " ;	
   		  	    }
   		  	    if(gradola==0){
   		  	    sal+=vectoreuler[i]+"" ;	
   		  	    }
   		  	    if(gradola>=2){
   		  	    sal+=vectoreuler[i]+" x^"+gradola+" " ;	
   		  	    }
				gradola--;
			}
  		
  			sal+=("\n");
          
        }
	
	
	
		private   void calculatabla(){			
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
	
		private   void tabladesumas(){
			System.out.printf("          ");
		for(int j=0;j<maxc;j++){
			
				System.out.printf("  |%3.3f|  ",(sumas[j]) );
			}
		}
		
		public  void calculasistema(){
			
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
		
		private   void muestraecuacioneuler(){
		sal="";
		sal+="la ecuacion es:\n";
		
		 sisecu a = new sisecu(matrix);
	
		double  resultado[]=a.solucionv();
		
		vectorl=resultado;
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
		  	
			
	} 
//------------------------------------------------------------------------------------------------------------------------------------

 
 
   		private  void mostrartabla(){
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