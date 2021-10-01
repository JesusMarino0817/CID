package examples.behaviours;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

public class OneShotAgentH3 extends Agent {

  protected void setup() {
    System.out.println("Agent "+getLocalName()+" started.");
    addBehaviour(new MyOneShotBehaviour());
  } 

  private class MyOneShotBehaviour extends OneShotBehaviour {
    float valorXi = 0;
    float valorYi = 0;
    float valorXxY = 0;
    float valorX2 = 0;
    float b1 = 0;
    float b0 = 0;
    int num;
    float predic;
    
    Valores val[] = {new Valores(23,651)
            ,new Valores(26,762)
            ,new Valores(30,856)
            ,new Valores(34,1063)
            ,new Valores(43,1190)
            ,new Valores(48,1298)
            ,new Valores(52,1421)
            ,new Valores(57,1440)
            ,new Valores(58,1518)}; 
   
    public void action() {
        for(int i=0; i<=8; i++){
       //sumatoria de xi
       valorXi += val[i].getX();
        
       //sumatoria de yi
       valorYi += val[i].getY();
       
       //sumatoria de X x Y
       valorXxY += val[i].getX()*val[i].getY();
       
       //sumatoria x2
       valorX2 += val[i].getX()*val[i].getX();
            }    
    
    //valores de b1 y b0
    b1 = ((9 * valorXxY) - (valorXi * valorYi))/ ((9 * valorX2) - (valorXi * valorXi));
    
    b0 = (valorYi - (b1 * valorXi))/9;
    
    //predecir valor del usuario 
    predic = b0 + (b1*60);
    
    System.out.println("La prediccion de inversion de 60 es: " + predic);
        
        } 
    public int onEnd() {
      myAgent.doDelete();   
      return super.onEnd();
        } 
    }
    class Valores{
    
    private float x = 0;
    private float y = 0;
    
    
    Valores(){}
    
        Valores(float xi, float yi){
            x = xi;
            y = yi;   
        }

        public float getX() {
            return x;
        }

        public float getY() {
            return y;
        }

        public void setX(float x) {
            this.x = x;
        }

        public void setY(float y) {
            this.y = y;
        }
    }
}    // END of inner class ...Behaviour

    