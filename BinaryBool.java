package tccbinario;

/*
 * @author Walter Dalla Torre Neto <wwddttnn@hotmail.com>
 */
public class BinaryBool{
    private boolean[] binary;
    
    //Comverte um numro decimal para binario
    public boolean[] DecimalToBinary(int numDec){
        
        //cria o tamanho do array binary(boolean)
        this.binary = new boolean[TamanhoDoBinario(numDec)];
        
        //preenche o arrey
        for(int cont = this.binary.length -1 ; cont > -1; cont--){
            this.binary[cont] = ((numDec % 2) != 0)? true:false;
            numDec /= 2; 
        }   
        return this.binary;
    }
    
    //comverte um binario para Decimal
    public int BinaryToDecimal(){
        int dec = 0;
       
        for(int i = 0; i < this.binary.length; i++){
            int aux = (this.binary[this.binary.length -i -1])? 1:0;
            dec += (int) (Math.pow(2,i) * aux);
        }
        return dec;
    }
    
    //Define o tamanho do binario em Bytes
    private int TamanhoDoBinario(int numDec ){
        int tamanho = 0;
        
        for(int i = 0; i < numDec +1; ){
            tamanho += 8;
            i = (int) Math.pow(2,tamanho);
        }
        return tamanho;
    }
    
    //Metodo GET para binary
    public boolean[] GetBinary(){
        return this.binary;
    }
    
    
    //Metodo Set para binary
    void SetBinary(int[] value){
        this.binary = new boolean[value.length];
        for(int i = 0; i < value.length-1; i++){
            this.binary[i] = (value[i] == 1);
        }
    }
}