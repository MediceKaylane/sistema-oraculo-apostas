import java.util.Random;

/**
 *
 * @author alunolab10
 */

public class Guerreiro {

    Random random = new Random();
    
   private String nome;
   private int qntdVidas;
   private int vidaInicial;
   private Bolsa myBolsa; 

    public Guerreiro(String nome, Bolsa myBolsa) {
        this.nome = nome;
        this.myBolsa = myBolsa;
        this.qntdVidas = this.sortearVidas();        //Sorteia a vida do guerreiro automaticamente assim que ele é instanciado
        this.vidaInicial = this.qntdVidas;
    }
    
    //tratamento de erro nome oraculo
    public void getName (String name){
        this.nome = name; 
    }
    
    //tratamento de erro nome oraculo
    public boolean verificarNome (){
        if(this.nome.isBlank() || this.nome.isEmpty()){
            InOut.MsgDeAviso("Nome Inválido!", "Dê um nome para o coitado");
            return false;
        }
        else{
            return true;
        }
    }

   public int sortearVidas(){
       return ((random.nextInt(3))+9);                //Sorteia a vida do guerreiro gerando um aleatório entre 0 e 3 e somando 9, gerando entre
   }                                                  //9 a 12 vidas. To ligado que vc fez diferente la usando o math.random eu acho Kaylane mas
                                                      //não sei fazer assim :)
    


    public String getNome() {
        return nome;
    }

    public int getQntdVidas() {
        return qntdVidas;
    }

    public int getVidaInicial() {
        return vidaInicial;
    }
   
    public void diminuirVida(){
        this.qntdVidas--;
    }
    
    public void aumentarVida(){
        this.qntdVidas++;
    }
    
    public void getbolsa (int itemId)
    {
        myBolsa.equiparItem(itemId);
    }
    

   
}
