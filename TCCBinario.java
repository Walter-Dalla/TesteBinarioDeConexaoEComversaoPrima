
package tccbinario;



/*
 * @author Walter Dalla Torre Neto <wwddttnn@hotmail.com>
 * Criaçao: 1/07/2018 21:35
 * Last update: 1/07/2018 21:35
 */
public class TCCBinario {


    public static void main(String[] args) {

        BinaryBool bin = new BinaryBool();
        Primo calc = new Primo();
        AcoesBD BD = new AcoesBD();
        
        int[] sla = calc.CalcNPrimos(6);
        
        for(int NumeroPrimo : sla){
            
            bin.DecimalToBinary(NumeroPrimo);// transforma o numero armazenado em "a" para binario
            
            System.out.printf("\nSLA : %d\nBin = ",NumeroPrimo);//printa o numero "a"
            
            for( Boolean bool: bin.GetBinary()){//faz um loop para printar o binario
                System.out.printf("%b | ",bool);
            }
            
            /*coloca no BD:
             *a = PK 
             *bin = boolean[]
             */
            BD.create(NumeroPrimo, bin.GetBinary());
        }
    }
        
}
