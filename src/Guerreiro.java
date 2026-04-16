import java.util.Random;

/**
 *
 * @author alunolab10
 */

public class Guerreiro {

    Random random = new Random();
    
   private String nome;
   private int qntdVidas, vidaInicial, vidasPerdidas;
   private Bolsa myBolsa; 
   private boolean pedidoMisericordia = false;

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

   //Sorteia a vida do guerreiro gerando um aleatório entre 0 e 3 e somando 9, gerando entre 9 a 12 vidas.
   public int sortearVidas(){
       return ((random.nextInt(3))+9);              
   }                                                
 
   
    public String getNome() {
        return nome;
    }

    
    public int getQntdVidas() {
        return qntdVidas;
    }

    public boolean isPedidoMisericordia() {
        return pedidoMisericordia;
    }
    

    
    public int getVidaInicial() {
        return vidaInicial;
    }

    public int getVidasPerdidas() {
        return vidasPerdidas;
    }
    
   
    
    public void diminuirVida(){
        this.qntdVidas--;
        vidasPerdidas++;
    }
    
    
    public void aumentarVida(){
        this.qntdVidas++;
    }
    

    public void equiparItem (int itemId)
    {
        myBolsa.equiparItem(itemId);
    }
    

    public boolean itemEquipado (int itemId)
    {
        return myBolsa.itemEquipado(itemId);
    }
    
    public String vidaExtra(){
        InOut.MsgSemIcone("Oráculo", "Suas vidas acabaram, você deseja misericórdia?");
        this.pedidoMisericordia = true;
        return InOut.leString("Faça seu pedido de misericórdia");
    }
   
}
