import javax.swing.JOptionPane;

public class aplica {
	
	public static void main( String args[] ){
		
	/*	double v[]={2.0,2.0,2.0,2.0};
		
		Multipli a1 = new Multipli (v);
	
	a1.funciong();	
		
	double res[]=a1.fvector();
	
	for(int i=0;i<res.length;i++){
		System.out.print(res[i]+" ");
	}*/
	
	
	/*double  matrix[][]=new double  [3][4];
		matrix[0][0] = 6.0;
    	matrix[0][1] = -1.0;
    	matrix[0][2] = -1.0;
    	matrix[0][3] = 3.0;
    
    	matrix[1][0] = 6.0;
    	matrix[1][1] = 9.0;
    	matrix[1][2] = 1.0;
    	matrix[1][3] = 40.0;
    	
		matrix[2][0] = -3.0;
    	matrix[2][1] = 1.0;
    	matrix[2][2] = 12.0;
    	matrix[2][3] = 50.0;
    	
    	
    	double  vs[]={0.0,0.0,0.0};
	

   sisecu a = new sisecu(matrix);
    	a.solucion();
    	
	double  res[]=a.solucionv();
	    
	    
	    	for(int i=0;i<res.length;i++){
		System.out.print(res[i]+" ");
	}*/
/*
double  tab[][]=new double  [8][2];
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
		
		int grado=4;
		
   //interpol a1 = new interpol(tab,grado);
	
	
	 double vectordato[]={0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0};
   
   
      interpol a1 =new interpol(tab,5.7);
      System.out.print(a1.dato());
    //  interpol a1 =new interpol(tab,6.7);
       
       double res[]=a1.funcionv();
	    
	    
	    	for(int i=0;i<res.length;i++){
		System.out.print(res[i]+" ");

}
*/
	//String s=((108*((1-(Math.pow((1+x),(-48))))/x))-3799);
	//String s=((85*((1-(Math.pow((1+x),(-75))))/x))-3939);
	// String s=(Math.exp(3*x))-10;
	// String s=((216*((1-(Math.pow((1+x),(-24))))/x))-3799);
	//String s=(Math.sin(x/2))-(Math.sin(2*x));	
	

//raices aa = new raices("(Math.exp(3*x))-10","3*(Math.exp(3*x))",1.0);
//raices aa = new raices("(Math.sin(x/2))-(Math.sin(2*x))",-0.5,0.5);
/*raices aa= new raices("newton");
System.out.print(aa.solucion());
System.out.println("\n"+aa.resultado());*/

double [][]tab = new double [7][2];
	 /*   tab[0][0]=0.0;
		tab[1][0]=0.05;
		tab[2][0]=0.1;
		tab[3][0]=0.15;
		tab[4][0]=0.2;
		tab[5][0]=0.25;
		tab[6][0]=0.3;*/

//ediferencial p = new ediferencial(tab,1,"x+y(y)","1+ypd(x,y)","ysd(x,y)");

 
   //integracion a2=new integracion("(Math.pow(x,2.0))",0.5,2.0,"trapecio");
   //integra("sim38");
   
   
  //integracion a2= new integracion ("((Math.sin(x))*(Math.sin(y)))/(x*y)",1.0,3.0,0.5,2.0,"x");
  // System.out.print(a2.solucion());
   //integra(0.0,2.0,0.0,2.0,"x"); 
  //integra(0.0,2.0,0.0,2.0); 
  
 // dattabla();
    
  //integratablatra();
  //integratablasim();
  //integratablasim38();

//tabla de diferencias
//diferencias centrales
//newton
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
		
    derivacion a3 = new derivacion(tab,2.3,2);
//System.out.print(a3.solucion());
        a3.determinagrado();
        System.out.print(a3.solucion());


}

}