
package tccbinario;

/*
 * @author Walter Dalla Torre Neto <wwddttnn@hotmail.com>
 */
public class Primo {

    
    
    public int[] CalcNPrimos(int Quantidade){
        int[] primos = new int[Quantidade];
        primos[0] = 2;
        for(int cont1 = 3,  i = 1; i < Quantidade ; cont1++){
            if(!Par(cont1)){
                boolean div = false;
                for(int cont2 = 2; (cont2 < cont1); cont2++){
                    div = ((cont1 % cont2 == 0)||(div))? true:false;
                }
                if(!div){
                    primos[i] = cont1;
                    i++;
                }
            }
        }
        return primos;
    }
    
    private boolean Par(int num){
        boolean bool = false;
        
        if(num % 2 == 0)
            bool = true;
        
        return bool;
    }
}
