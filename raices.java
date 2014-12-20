
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JOptionPane;

public class raices {
	static private String func,sal="",df;
	static private double sol;
		
		raices(String funcio,double lin,double ls){
		
		func=funcio;
		
		bis(lin,ls);
		
		}
		
		raices(String funcio,double lin,double ls,String metodo){
		
		func=funcio;
		
		if((metodo.compareTo("biseccion"))==0){
		bis(lin,ls);
		}
		
		if((metodo.compareTo("falsa posision"))==0){
			falsa(lin,ls);
		}
		
		}
		
		raices(String funcion,String derif,double val){
			func=funcion;
			df=derif;
			newton(val);
		}
		
		
		raices(String metodo){
		 func=JOptionPane.showInputDialog("Escribe una funcion de x");
		 
		if((metodo.compareTo("biseccion"))==0){
	double  a = Float.parseFloat(JOptionPane.showInputDialog("Introduzca el limite inferior"));
    double  c = Float.parseFloat(JOptionPane.showInputDialog("Introduzca el limite superior"));
   	
   		bis(a,c);
			
		}
	   
	   if ((metodo.compareTo("falsa posision"))==0){
	   	double  a = Float.parseFloat(JOptionPane.showInputDialog("Introduzca el limite inferior"));
        double  c = Float.parseFloat(JOptionPane.showInputDialog("Introduzca el limite superior"));
   		falsa(a,c);	
	   }
	  
	  if((metodo.compareTo("newton"))==0){
	 df = JOptionPane.showInputDialog("Introduzca la derivada de "+func);
	 double  x = Float.parseFloat(JOptionPane.showInputDialog("Introduzca el valor de x a evaluar"));
		newton(x);
	  }
			
		}
		
		
		public String solucion(){
			return sal;
		}
        
        public double resultado(){
        	return sol;
        }
		
		
		
		
private  void falsa(double lin,double lsup){
	sol=0.0;
	sal="";
	double  a = lin;
    double  c = lsup;
    int il = 100;
   	double ep = 0.5;
    	int it=0;
    	int kr=0;
    	int kl=0;
    	
    double b=a+10;	
    double ya = f(a);
    double yc = f(c);

     
    if((ya*yc)<=0){
    	
    	while((it<il)||((b-a)>ep)){
    	b= a-(((c-a)/((f(c))-(f(a))))*(f(a)));	
    		
    	double yb= f(b);
    	if(((ya)*(yb))<=0){
    	a=a;
    	c=b;
    	ya=ya;
    	yc=yb;
    	kr=0;
    	kl=kl+1;
    
    	if (kl>1){
    		ya=(ya/2);
    	}
    	}
    	if(((ya)*(yb))>0){
    	a=b;
    	c=c;
    	ya=yb;
    	yc=yc;
    	kr++;
    	kl=0;
    	if (kr>1){
    		yc=(yc/2);
    	}
    	}
    	
    	it++;
    	
    	}
    
    	sal+=("la raiz esta en: "+b);	
    	
    	sol=b;
    }
    if((ya*yc)>0){
    		sal+=("En el intervalo de: "+a+"a "+b+"no existen raices o existe un par de raices");
    }
    
}


private  void bis(double linf,double lsup){
	sol=0.0;
	sal="";
	double  a = linf;
    double  c = lsup;
   	double er = 0.5;
   	a=a+0.000000000000001;
   	double ya= f(a);
   	double yc= f(c);
   	double xm=0.0;
   	int nt;
   	int n=0;
   	

   	 nt=(int)((Math.log((((c-a)/er))))/(Math.log(2)))+1;
   	
   	if((ya*yc)<=0){
	while (n<nt){
   	 xm=((a+c)/2);
   	if(((f(a))*(f(xm)))<=0){
    c=xm;
    yc=f(c);
   	}
  	if(((f(a))*(f(xm)))>0){
    a=xm;
    ya=f(a);
   	}	
   	
   	n++;
	
   	}
    	sal+=("La raiz esta en: "+xm);
    	sol=xm;
   
}
	if((ya*yc)>0){
		if(n>1){
		sal+=("La raiz esta en: "+xm);
		sol=xm;
		}
	sal+=("No existe una raiz en este intervalo");	
	}



}


private  void newton(double va){
	sol=0.0;
	sal="";
	double  x = va;
    double  tol = 0.5;
    double e=1;
    
    while (e>= tol){
    	
    	double tm=x;
    	x=x-((f(x))/(fd(x)));
    	
    	e= Math.abs((x-tm)/x);
    }
	
	sal+=("La raiz esta en: "+x);
	sol=x;
}
		
		

private  double fd(double x){
	 Object o =0;
	
	ScriptEngineManager manager = new ScriptEngineManager();
    ScriptEngine engine = manager.getEngineByName("javascript");
	 try {
      engine.eval("function myFunction(x){var output = '';"
          + "{output = "+df+";"
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
	

	 
	 //double s=3*(Math.exp(3*x));
	 //double s=((85*(((75*x)/(Math.pow((x+1),76)))+(Math.pow((x+1),-75))-1))/(x*x));
	 	
}



private  double  f(double x){
	 Object o =0;
	
	ScriptEngineManager manager = new ScriptEngineManager();
    ScriptEngine engine = manager.getEngineByName("javascript");
	 try {
      engine.eval("function myFunction(x){var output = '';"
          + "{output = "+func+";"
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
	

    
}
		
		
		
}