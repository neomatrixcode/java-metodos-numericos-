import java.util.ArrayList; 
import javax.swing.JOptionPane;
import java.math.*;


public class integrate { 

static String sal="";
static int seg=3000;
static double paso =0.05;
static double li,ls,h,resultado=0;
static int maxd=7;
static double [][]tab = new double [maxd][2];

public static void main(String args[]){ 
  
  /* metodos
   *trapecio="tra"
   *simpson 1/3 = "sim"
   *simpson 3/8= "sim38"
   *todos = ""
 */

   //integra(0.5,1.5,"");
   //integra(0.5,2.0,"tra");
   //integra("sim38");
   
   
  integra(1.0,3.0,0.5,2.0,"x");
   
   //integra(0.0,2.0,0.0,2.0,"x"); 
  //integra(0.0,2.0,0.0,2.0); 
  
  //dattabla();
    
 // integratablatra();
 // integratablasim();
 // integratablasim38();
} 

	
	public static void integra(String met){
	li= Float.parseFloat(JOptionPane.showInputDialog("limite inferior"));

	ls= Float.parseFloat(JOptionPane.showInputDialog("limite superior"));
	
	seg= Integer.parseInt(JOptionPane.showInputDialog("numero de intervalos"));;
	
	//seg=1000;
	
	String metodo = met;
	
		if((metodo.compareTo("tra"))==0){
	integraciontrapecio();
	}
	
	if((metodo.compareTo("sim"))==0){
	integracionsimpson();
	}
	
	if((metodo.compareTo("sim38"))==0){
	integracionsimpson38();
	}
	
	if((metodo.compareTo(""))==0){
	integraciontrapecio();
	integracionsimpson();
	}
	
}

	public static void integra(double lii, double  lis,String met){
	li=lii;
	ls=lis;
	String metodo = met;
	
	
	
	if((metodo.compareTo("tra"))==0){
	integraciontrapecio();
	}
	
	if((metodo.compareTo("sim"))==0){
	integracionsimpson();
	}
	
	if((metodo.compareTo("sim38"))==0){
	integracionsimpson38();
	}
	
	if((metodo.compareTo(""))==0){
	integraciontrapecio();
	integracionsimpson();
	integracionsimpson38();
	}
	
}

		public static void integra(double liix,double lisx,double liiy,double lisy){
		}



	public static void integra(double liix,double lisx,double liiy,double lisy,String var){
		double lix=liix;
		double lsx=lisx;
		double liy=liiy;
		double lsy=lisy;
		double hx = paso;
		double hy = paso;
		
		
		if((var.compareTo("x"))==0){
			
		for(double i=liy;i<=lsy;i+=paso){
		
		resultado += intrax(lix,lsx,i)*hx;
		
		}
		JOptionPane.showMessageDialog(null,"La integral doble de f(x,y) en el intervalo de:  "+lix+"x  a  "+lsx+"x  y de:  "+liy+"y  a  "+lsy+"y  es igual a: \n"+ resultado,"INTEGRAL DOBLE X ",JOptionPane.ERROR_MESSAGE);
	 System.out.print("\nINTEGRAL DOBLE X:\nLa integral DOBLE de f(x,y) en el intervalo de:  "+lix+"x  a  "+lsx+"x  y de:  "+liy+"y  a  "+lsy+"y  es igual a: \n"+ resultado); 
	
		}
		
	 
		
		if(var.compareTo("y")==0){
		for(double i=lix;i<=lsx;i+=paso){
		resultado += intray(liy,lsy,i)*hy;
		}
		JOptionPane.showMessageDialog(null,"La integral doble de f(x,y) en el intervalo de:  "+lix+"x  a  "+lsx+"x  y de:  "+liy+"y  a  "+lsy+"y  es igual a: \n"+ resultado,"INTEGRAL DOBLE Y",JOptionPane.ERROR_MESSAGE);
	 System.out.print("\nINTEGRAL DOBLE Y:\nLa integral DOBLE de f(x,y) en el intervalo de:  "+lix+"x  a  "+lsx+"x  y de:  "+liy+"y  a  "+lsy+"y  es igual a: \n"+ resultado); 
	
		}	
		
		 
		
		}

	public static double  intrax(double li, double ls, double cnt){
		
	h = (ls-li)/(seg);	
	
	resultado=0;
	double resultadopar=0;
	
	resultado += f(li,cnt)+f(ls,cnt);
	//System.out.print("\n"+ls+"  "+cnt+"  f(ls,cnt) :"+f(ls,cnt)+"\n");
	for(int i=1; i<=(seg-1); i++){
	
	resultadopar += f((li+(i*h)),cnt);
	
	}
	resultado+=(2*resultadopar);
	resultado=resultado*(h/2); 
	
	// JOptionPane.showMessageDialog(null,"La integral de f(x) en el intervalo de:  "+li+"  a  "+ls+"  es igual a: \n"+ resultado,"INTEGRAL  TRAPECIO",JOptionPane.ERROR_MESSAGE);
	 System.out.print("\nTRAPECIO:\nLa integral de f(x) en el intervalo de:  "+li+"  a  "+ls+" con cto: "+cnt+"  es igual a: \n"+ resultado); 
	 
	 return resultado;

}

	
	public static double  intray(double li, double ls, double cnt){
		
	h = (ls-li)/(seg);	
	
	resultado=0;
	double resultadopar=0;
	
	resultado += f(cnt,li)+f(cnt,ls);
	//System.out.print("\n"+ls+"  "+cnt+"  f(ls,cnt) :"+f(ls,cnt)+"\n");
	for(int i=1; i<=(seg-1); i++){
	
	resultadopar += f(cnt,(li+(i*h)));
	
	}
	resultado+=(2*resultadopar);
	resultado=resultado*(h/2); 
	
	// JOptionPane.showMessageDialog(null,"La integral de f(y) en el intervalo de:  "+li+"  a  "+ls+"  es igual a: \n"+ resultado,"INTEGRAL  TRAPECIO",JOptionPane.ERROR_MESSAGE);
	 System.out.print("\nTRAPECIO:\nLa integral de f(y) en el intervalo de:  "+li+"  a  "+ls+" con cto: "+cnt+"  es igual a: \n"+ resultado); 
	 
	 return resultado;

}



		public static void integracionsimpson38(){
	if((seg % 3)!=0){
		JOptionPane.showMessageDialog(null,"ERROR: \n EL VALOR ES PAR","INTEGRAL",JOptionPane.ERROR_MESSAGE);
    System.exit(0);
	}
		
	h = (ls-li)/(seg);	
	
	resultado=0;
	double rp1=0;
	double rp2=0;
	
	resultado += f(li)+f(ls);
	
	//NO MLTIPLOS
	for(int i=1; i<=(seg); i++){
//		System.out.print();
	if((i % 3)!=0){
	rp1 += f(li+((i*h)));
	}
	}
	
	
	resultado+=(3*rp1);
	
	for(int i=1; i<=(seg/2); i++){
	
	rp2 += f(li+(((2*i)-1)*h));
	
	}
	
	resultado+=(2*rp2);
	
	resultado=resultado*h*(3.0/8.0); 
	
	 JOptionPane.showMessageDialog(null,"La integral de f(x) en el intervalo de:  "+li+"  a  "+ls+"  es igual a: \n"+ resultado,"INTEGRAL SIMPSON 3/8",JOptionPane.ERROR_MESSAGE);
	 System.out.print("\nSIMPSON 3/8:\nLa integral de f(x) en el intervalo de:  "+li+"  a  "+ls+"  es igual a: \n"+ resultado); 

}
	
	public static void integracionsimpson(){
	if((seg % 2)!=0){
		JOptionPane.showMessageDialog(null,"ERROR: \n EL VALOR ES IMPAR","INTEGRAL",JOptionPane.ERROR_MESSAGE);
    System.exit(0);
	}
		
	h = (ls-li)/(seg);	
	
	resultado=0;
	double rp1=0;
	double rp2=0;
	
	resultado += f(li)+f(ls);
	
	for(int i=2; i<=(seg/2); i++){
	
	rp1 += f(li+(((2*i)-2)*h));
	
	}
	resultado+=(2*rp1);
	
	for(int i=1; i<=(seg/2); i++){
	
	rp2 += f(li+(((2*i)-1)*h));
	
	}
	
	resultado+=(4*rp2); 
	
	resultado=resultado*(h/3); 
	
	 JOptionPane.showMessageDialog(null,"La integral de f(x) en el intervalo de:  "+li+"  a  "+ls+"  es igual a: \n"+ resultado,"INTEGRAL SIMPSON",JOptionPane.ERROR_MESSAGE);
	 System.out.print("\nSIMPSON:\nLa integral de f(x) en el intervalo de:  "+li+"  a  "+ls+"  es igual a: \n"+ resultado); 

}

	public static void integraciontrapecio(){
		
	h = (ls-li)/(seg);	
	
	resultado=0;
	double resultadopar=0;
	
	resultado += f(li)+f(ls);
	
	for(int i=1; i<=(seg-1); i++){
	
	resultadopar += f(li+(i*h));
	
	}
	resultado+=(2*resultadopar);
	resultado=resultado*(h/2); 
	
	 JOptionPane.showMessageDialog(null,"La integral de f(x) en el intervalo de:  "+li+"  a  "+ls+"  es igual a: \n"+ resultado,"INTEGRAL  TRAPECIO",JOptionPane.ERROR_MESSAGE);
	 System.out.print("\nTRAPECIO:\nLa integral de f(x) en el intervalo de:  "+li+"  a  "+ls+"  es igual a: \n"+ resultado); 

}

	public static void dattabla(){
		tab[0][0]=0.5;
		tab[1][0]=1.0;
		tab[2][0]=1.5;
		tab[3][0]=2.0;
		tab[4][0]=2.5;
		tab[5][0]=3.0;
		tab[6][0]=3.5;
		
		tab[0][1]=0.165;
		tab[1][1]=0.271;
		tab[2][1]=0.447;
		tab[3][1]=0.738;
		tab[4][1]=1.216;
		tab[5][1]=2.005;
		tab[6][1]=3.306;
		
	
	}
	
	public static void integratablatra(){
	
	dattabla();
			
	h = (tab[1][0])-(tab[0][0]);	
	
	resultado=0;
	double resultadopar=0;
	
	resultado += tab[0][1]+tab[maxd-1][1];
	
	for(int i=1; i<=maxd-2; i++){
	
	resultadopar += tab[i][1];
	
	}
	resultado+=(2*resultadopar);
	resultado=resultado*(h/2); 
	
	 JOptionPane.showMessageDialog(null,"La integral de la tabla de valores es igual a: \n"+ resultado,"INTEGRAL TABLA  TRAPECIO",JOptionPane.ERROR_MESSAGE);
	 System.out.print("\nDE TABLA: TRAPECIO:\nLa integral de los valores de la tabla es igual a: \n"+ resultado); 

}
	
	
	public static void integratablasim38(){
		
	h = (tab[1][0])-(tab[0][0]);	
	
	resultado=0;
	double rp1=0;
	double rp2=0;
	
	resultado += tab[0][1]+tab[maxd-1][1];
	
	//NO MLTIPLOS
	for(int i=1; i<=(maxd-2); i++){
//		System.out.print();
	if((i % 3)!=0){
	rp1 += tab[i][1];
	}
	}
	
	
	resultado+=(3*rp1);
	
	for(int i=1; i<=(maxd/2); i++){
	
	rp2 += tab[(2*i)-1][1];
	
	}
	
	resultado+=(2*rp2);
	
	resultado=resultado*h*(3.0/8.0); 
	
	JOptionPane.showMessageDialog(null,"La integral de la tabla de valores es igual a: \n"+ resultado,"INTEGRAL TABLA SIMPSON 3/8",JOptionPane.ERROR_MESSAGE);
	 System.out.print("\nDE TABLA: SIMPSON 3/8:\nLa integral de los valores de la tabla es igual a: \n"+ resultado);
}
	
	public static void integratablasim(){

		
	h = (tab[1][0])-(tab[0][0]);
	
	resultado=0;
	double rp1=0;
	double rp2=0;
	
	resultado += tab[0][1]+tab[maxd-1][1];
	
	for(int i=2; i<=(maxd/2); i++){
	
	rp1 += tab[(2*i)-2][1];
	
	}
	resultado+=(2*rp1);
	
	for(int i=1; i<=(maxd/2); i++){
	
	rp2 += tab[(2*i)-1][1];
	
	}
	
	resultado+=(4*rp2); 
	
	resultado=resultado*(h/3); 
	
	 JOptionPane.showMessageDialog(null,"La integral de la tabla de valores es igual a: \n"+ resultado,"INTEGRAL TABLA SIMPSON 1/3",JOptionPane.ERROR_MESSAGE);
	 System.out.print("\nDE TABLA: SIMPSON:\nLa integral de los valores de la tabla es igual a: \n"+ resultado);  

}



	public static double  f(double x){
		
	//return  (((Math.exp(x))*(Math.cos(x)))-(Math.pow(x,3.0)));
	return  (Math.pow(x,2.0));
	//return  6.0;
}

	public static double  f(double x,double y){

  //  return 2;
//	return ((Math.pow(x,2.0))*(Math.cos(y)))+(Math.exp(x*y));
	return ((Math.sin(x))*(Math.sin(y)))/(x*y);
    
//	return 16-(Math.pow(x,2.0))-(2*(Math.pow(y,2.0))); //48
//	return (x)-(3*(Math.pow(y,2.0)));//-11.87
}


}

