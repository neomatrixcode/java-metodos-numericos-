import java.util.ArrayList; 
import javax.swing.JOptionPane;
import java.math.*;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JOptionPane;


public class integracion{
	
	static private String fun,fund;
	static String sal="";
	static int seg=3000;
	static double paso =0.05;
	static double li,ls,h,resultado=0;
	static int maxd;
	static double [][]tab;
	
		integracion(String func,double limi,double lims,String metodo){
		fun=func;
		
		if((metodo.compareTo("trapecio"))==0){
		integra(limi,lims,"tra");
		}
		if((metodo.compareTo("simpsom"))==0){
			integra(limi,lims,"sim");
		}
		if((metodo.compareTo("simpsom 3/8"))==0){
			integra(limi,lims,"sim38");
		}
			
		}
		
		integracion(String metodo){
		
		if((metodo.compareTo("trapecio"))==0){
		integra("tra");
		}
		if((metodo.compareTo("simpsom"))==0){
			integra("sim");
		}
		if((metodo.compareTo("simpsom 3/8"))==0){
			integra("sim38");
		}
		}
		
		integracion(String fun,double lixx,double lsxx,double liyy,double lsyy){
			fund=fun;
			
			integra(lixx,lsxx,liyy,lsyy,"x");
			
		}
		
		integracion(String fun,double lixx,double lsxx,double liyy,double lsyy,String variable){
			fund=fun;
			
			integra(lixx,lsxx,liyy,lsyy,variable);
		}
		
		integracion(double tabla[][],String metodo){
		maxd=tabla.length;	
		tab = new double [maxd][2];	
		
		for(int c=0;c<2;c++){
			for(int f=0;f<maxd;f++){
				tab[f][c]=tabla[f][c];
			}
		}
		
		if((metodo.compareTo("trapecio"))==0){
			integratablatra();
		}
		if((metodo.compareTo("simpsom"))==0){
			integratablasim();
		}
		if((metodo.compareTo("simpsom 3/8"))==0){
			integratablasim38();
		}
		}

  
  /* metodos
   *trapecio="tra"
   *simpson 1/3 = "sim"
   *simpson 3/8= "sim38"
   *todos = ""
 */
		
	public String solucion(){
		return sal;
	}

   
  
	
	private  void integra(String met){
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

	private  void integra(double lii, double  lis,String met){
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

	private  void integra(double liix,double lisx,double liiy,double lisy){
		}



	private  void integra(double liix,double lisx,double liiy,double lisy,String var){
		sal="";
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
	
		 sal+=("\nINTEGRAL DOBLE X:\nLa integral DOBLE de f(x,y) en el intervalo de:  "+lix+"x  a  "+lsx+"x  y de:  "+liy+"y  a  "+lsy+"y  es igual a: \n"+ resultado); 
	
		}
		
	 
		
		if(var.compareTo("y")==0){
		for(double i=lix;i<=lsx;i+=paso){
		resultado += intray(liy,lsy,i)*hy;
		}
		
		 sal+=("\nINTEGRAL DOBLE Y:\nLa integral DOBLE de f(x,y) en el intervalo de:  "+lix+"x  a  "+lsx+"x  y de:  "+liy+"y  a  "+lsy+"y  es igual a: \n"+ resultado); 
	
		}	
		
		 
		
		}

	private  double  intrax(double li, double ls, double cnt){
		
	h = (ls-li)/(seg);	
	
	resultado=0;
	double resultadopar=0;
	
	resultado += f(li,cnt)+f(ls,cnt);
	
	for(int i=1; i<=(seg-1); i++){
	
	resultadopar += f((li+(i*h)),cnt);
	
	}
	resultado+=(2*resultadopar);
	resultado=resultado*(h/2); 
	
	 return resultado;

}

	
	private  double  intray(double li, double ls, double cnt){
		
	h = (ls-li)/(seg);	
	
	resultado=0;
	double resultadopar=0;
	
	resultado += f(cnt,li)+f(cnt,ls);

	for(int i=1; i<=(seg-1); i++){
	
	resultadopar += f(cnt,(li+(i*h)));
	
	}
	resultado+=(2*resultadopar);
	resultado=resultado*(h/2); 
	
	 return resultado;

}



	private  void integracionsimpson38(){
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
	
	 
	 sal+=("\nSIMPSON 3/8:\nLa integral de f(x) en el intervalo de:  "+li+"  a  "+ls+"  es igual a: \n"+ resultado); 

}
	
	private  void integracionsimpson(){
	sal="";
	if((seg % 2)!=0){
		sal+=("ERROR: \n EL VALOR ES IMPAR");
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
	
	 
	 sal+=("\nSIMPSON:\nLa integral de f(x) en el intervalo de:  "+li+"  a  "+ls+"  es igual a: \n"+ resultado); 

}

	private  void integraciontrapecio(){
		sal="";
	h = (ls-li)/(seg);	
	
	resultado=0;
	double resultadopar=0;
	
	resultado += f(li)+f(ls);
	
	for(int i=1; i<=(seg-1); i++){
	
	resultadopar += f(li+(i*h));
	
	}
	resultado+=(2*resultadopar);
	resultado=resultado*(h/2); 
	
	 
	 sal+=("\nTRAPECIO:\nLa integral de f(x) en el intervalo de:  "+li+"  a  "+ls+"  es igual a: \n"+ resultado); 

}


	
	private void integratablatra(){
		sal="";
	h = (tab[1][0])-(tab[0][0]);	
	
	resultado=0;
	double resultadopar=0;
	
	resultado += tab[0][1]+tab[maxd-1][1];
	
	for(int i=1; i<=maxd-2; i++){
	
	resultadopar += tab[i][1];
	
	}
	resultado+=(2*resultadopar);
	resultado=resultado*(h/2); 
	
	 
	sal+=("\nDE TABLA: TRAPECIO:\nLa integral de los valores de la tabla es igual a: \n"+ resultado); 

}
	
	
	private  void integratablasim38(){
		sal="";
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
	
	
	 sal+=("\nDE TABLA: SIMPSON 3/8:\nLa integral de los valores de la tabla es igual a: \n"+ resultado);
}
	
	private  void integratablasim(){

		sal="";
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
	
	 
	 sal+=("\nDE TABLA: SIMPSON:\nLa integral de los valores de la tabla es igual a: \n"+ resultado);  

}



	private  double  f(double x){
	
	Object o =0;
	
	ScriptEngineManager manager = new ScriptEngineManager();
    ScriptEngine engine = manager.getEngineByName("javascript");
	 try {
      engine.eval("function myFunction(x){var output = '';"
          + "{output = "+fun+";"
          + "  } return output;}");
      Invocable invokeEngine = (Invocable) engine;
      o = invokeEngine.invokeFunction("myFunction", x);
      //System.out.println(o);
     

    } catch (NoSuchMethodException e) {
      System.err.println(e);
    } catch (ScriptException e) {
      System.err.println(e);
    }
	 return (double)o;
	
		
	//return  (((Math.exp(x))*(Math.cos(x)))-(Math.pow(x,3.0)));
	//return  (Math.pow(x,2.0));
	//return  6.0;
}

	private  double  f(double x,double y){
	
	Object o =0;
	
	ScriptEngineManager manager = new ScriptEngineManager();
    ScriptEngine engine = manager.getEngineByName("javascript");
	 try {
      engine.eval("function myFunction(x,y){var output = '';"
          + "{output = "+fund+";"
          + "  } return output;}");
      Invocable invokeEngine = (Invocable) engine;
      o = invokeEngine.invokeFunction("myFunction", x, y);
      //System.out.println(o);
     

    } catch (NoSuchMethodException e) {
      System.err.println(e);
    } catch (ScriptException e) {
      System.err.println(e);
    }
	 return (double)o;


//    return 2;
//	return ((Math.pow(x,2.0))*(Math.cos(y)))+(Math.exp(x*y));
//	return ((Math.sin(x))*(Math.sin(y)))/(x*y);
    
//	return 16-(Math.pow(x,2.0))-(2*(Math.pow(y,2.0))); //48
//	return (x)-(3*(Math.pow(y,2.0)));//-11.87
}







	
}


