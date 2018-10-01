package tccbinario;

/*
 * @author Walter Dalla Torre Neto <wwddttnn@hotmail.com>
 * Criaçao: 1/07/2018 21:35
 * Last update: 1/07/2018 21:35
 */
public class BinaryDec {
   
    private int[] binary;
    
    //Comverte um numro decimal para binario
    public int[] DecimalToBinary(int numDec){
        
        //cria o tamanho do array binary(boolean)
        this.binary = new int[TamanhoDoBinario(numDec)];
        
        //preenche o arrey
        for(int cont = this.binary.length -1 ; cont > -1; cont--){
            this.binary[cont] = ((numDec % 2) != 0)? 1:0;
            numDec /= 2; 
        }   
        return this.binary;
    }
    
    //comverte um binario para Decimal
    public int BinaryToDecimal(){
        int dec = 0;
        
        for(int i = 0; i < this.binary.length; i++){
            dec += (int) (Math.pow(2,i) * this.binary[this.binary.length -i -1]);
        }
        return dec;
    }
    
    //Define o tamanho do binario em Bytes
    int TamanhoDoBinario(int numDec ){
        int tamanho = 0;
        
        for(int i = 0; i < numDec +1; ){
            tamanho += 8;
            i = (int) Math.pow(2,tamanho);
        }
        return tamanho;
    }
    
    //Metodo GET para binary
    public int[] GetBinary(){
        return this.binary;
    }
    
    
    //Metodo Set para binary
    void SetBinary(int[] value){
        binary = new int[value.length];
        for(int i = 0; i < value.length-1; i++){
            binary[i] = (value[i] == 1)? 1:0;
        }
    }
}