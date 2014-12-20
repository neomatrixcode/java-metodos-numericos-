
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JOptionPane;

public class ediferencial {
	static private String sal="",pd,sd,td;
	static double h,resultado=0,evalu=0;
	static int pi=0,maxcolum=4;
	static double recor=0.2;
	static int maxd;
	static int bt=0,be=0,bem=0;
	static double [][]tab ;
	static String []tmet;
	static int vini;
		
		
		ediferencial(double tabla[][],int vi,String prid,String segd,String terd){
		pd=prid;
		sd=segd;
		td=terd;
		maxd=tabla.length;
		tab = new double [maxd][maxcolum];
		tmet = new String [maxcolum];
		vini=vi;
		iniciartabla();
		
		for(int i=0;i<maxd;i++){
	    	for(int j=0;j<1;j++){
				tab[i][j]=tabla[i][j];
			}
		}
		
		taylor();
		   mostrartabla();
		}
		
		
				private  void iniciartabla(){
			for(int i=0;i<maxd;i++){
				for(int j=0;j<maxcolum;j++){
				tab[i][j]=0.0;
				}
			}
			tmet[0]="     x    ";
		}
		
				private void mostrartabla(){
					
		
	
			System.out.printf("            ");
			for(int j=0;j<(be+bem+bt+1);j++){
				System.out.printf("|%s|    ",(tmet[j]) );
			}
			
			System.out.printf("\n");
			
			System.out.printf("          ");
			for(int i=0;i<maxd;i++){
				for(int j=0;j<(be+bem+bt+1);j++){
				
					System.out.printf("  |%3.8f|  ",(tab[i][j]) );
				}
				System.out.print("\n          ");
			}
			
			System.out.print("\n");
		}
	
	
				private  void euler(){
				int col =1;
				be=1;
				
				if(bt==1){
			    	col++;
			    }
			    if(bem==1){
			    	col++;
			    }
				
				tmet[col]=" y (euler)";
				h = (tab[1][0])-(tab[0][0]);	
		
				tab[0][col]= 1;
			
				for(int i=1; i<maxd; i++){
				tab[i][col]= eulers(tab[i-1][0],tab[i-1][col]);
				
				}
				
				
				}
				
				private   void eulerm(){
				int col =1;
				bem=1;
				
				if(bt==1){
			    	col++;
			    }
			    if(be==1){
			    	col++;
			    }
				
				tmet[col]="y (eulerm)";
				h = (tab[1][0])-(tab[0][0]);	
		
				tab[0][col]= 1;
			
				for(int i=1; i<maxd; i++){
				tab[i][col]= eulerm(tab[i-1][0],tab[i-1][col]);
				
	
				}
				
				}
				
			
					
				private  double eulerm(double x,double y ){
					
					
				//	System.out.print("x: "+x+"\n"+"y: "+y+"\n\n"+y(y)+" +(((("+ypd(x,y)+")+("+(x+h)+" + "+(eulers(x,y))+"))/2)*"+h+")\n\n");
			
					return y(y)+((((ypd(x,y))+((x+h)+(eulers(x,y))))/2)*h);
					
				
				}
					
				private  double eulers(double x,double y ){
			
					return y(y)+(ypd(x,y)*h);
				
				}
				
			
			private  void taylor(){
				int col=1;
				bt=1;
				
			    if(be==1){
			    	col++;
			    }
			    if(bem==1){
			    	col++;
			    }
			    
			    tmet[col]="y (Taylor)";
			    
				h = (tab[1][0])-(tab[0][0]);	
		
				tab[0][col]= vini;
			
			for(int i=1; i<maxd; i++){
				tab[i][col]= yx(tab[i-1][0],tab[i-1][col]);
				}
				
			    
			
			}
			
			
			
				private  double yx(double x,double y ){
					
					
					return y(y)+(ypd(x,y)*h)+(((ysd(x,y))/2)*(Math.pow(h,2)))+(((ytd(x,y))/6)*(Math.pow(h,3)));
					
					
				}
		
			private  double y(double n){
					
					if(n==0.0){
						return vini;	
					}
					else{
						return n;	
					}
					
					
				}
				
					private  double ypd(double x,double y){
					 Object o =0;
	
						ScriptEngineManager manager = new ScriptEngineManager();
					    ScriptEngine engine = manager.getEngineByName("javascript");
						 try {
					      engine.eval("function ypd(x,y){"
					          + "return "+pd+";"
					          + " }");
					      Invocable invokeEngine = (Invocable) engine;
					      o = invokeEngine.invokeFunction("ypd", x,y);
					      //System.out.println(o);
					     
					
					    } catch (NoSuchMethodException e) {
					      System.err.println(e);
					    } catch (ScriptException e) {
					      System.err.println(e);
					    }
						 return (double)o;
								//	return x+y(y);
				}
				
					private  double ysd(double x,double y){
						
						 Object o =0;
	
						ScriptEngineManager manager = new ScriptEngineManager();
					    ScriptEngine engine = manager.getEngineByName("javascript");
						 try {
					       engine.eval("function ysd(x,y){"
					          + "return "+pd+";"
					          + " }");
					      Invocable invokeEngine = (Invocable) engine;
					      o = invokeEngine.invokeFunction("ysd", x,y);
					      //System.out.println(o);
					     
					
					    } catch (NoSuchMethodException e) {
					      System.err.println(e);
					    } catch (ScriptException e) {
					      System.err.println(e);
					    }
						 return (double)o;
									
					//return 1+ypd(x,y);
				}
				
				private  double ytd(double x,double y){
				
				 Object o =0;
	
				ScriptEngineManager manager = new ScriptEngineManager();
			    ScriptEngine engine = manager.getEngineByName("javascript");
				 try {
			       engine.eval("function ytd(x,y){"
					          + "return "+pd+";"
					          + " }");
			      Invocable invokeEngine = (Invocable) engine;
			      o = invokeEngine.invokeFunction("ytd", x,y);
			      //System.out.println(o);
			     
			
			    } catch (NoSuchMethodException e) {
			      System.err.println(e);
			    } catch (ScriptException e) {
			      System.err.println(e);
			    }
				 return (double)o;
						
					
				//	return ysd(x,y);
				}

	
		
		
		
}