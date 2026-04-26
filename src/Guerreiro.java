import java.util.Random;

/**
 *
 * @author alunolab10
 */

public class Guerreiro {

    Random random = new Random();
    
   private String nome;
   private int qntdVidas, vidaInicial, vidasPerdidas = 0;
   private Bolsa myBolsa; 
   private boolean pedidoMisericordia = false;

    public Guerreiro(String nome, Bolsa myBolsa) {
        this.nome = nome;
        this.myBolsa = myBolsa;
        this.qntdVidas = this.sortearVidas();        //Sorteia a vida do guerreiro automaticamente assim que ele é instanciado
        this.vidaInicial = this.qntdVidas;
    }
    
    //tratamento de erro nome oraculo
    /**
     * 
     * @param name 
     */
    public void atribuirNome (String name){
        this.nome = name; 
    }
    
    /**
     * 
     * @return 
     */
    //tratamento de erro nome oraculo
    public boolean verificarNome (){
        if(this.nome.isBlank() || this.nome.isEmpty()){
            return false;
        }
        else{
            return true;
        }
    }
    
    /**
     * 
     * @return 
     */
   //Sorteia a vida do guerreiro gerando um aleatório entre 0 e 3 e somando 9, gerando entre 9 a 12 vidas.
   public int sortearVidas(){
       return ((random.nextInt(3))+9);              
   }                                                
 
   /**
    * 
    * @return 
    */
    public String getNome() {
        return nome;
    }

    /**
     * 
     * @return 
     */
    public int getQntdVidas() {
        return qntdVidas;
    }

    /**
     * 
     * @return 
     */
    public boolean isPedidoMisericordia() {
        return pedidoMisericordia;
    }

    public void setPedidoMisericordia(boolean pedidoMisericordia) {
        this.pedidoMisericordia = pedidoMisericordia;
    }
    
    

    /**
     * 
     * @return 
     */
    public int getVidaInicial() {
        return vidaInicial;
    }
    
    /**
     * 
     * @return 
     */
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
    
    /**
     * 
     * @param itemId 
     */
    public void equiparItem (int itemId)
    {
        myBolsa.equiparItem(itemId);
    }
    
    public void desequiparItem (int itemId)
    {
        myBolsa.desequiparItem(itemId);
    }
    
    /**
     * 
     * @param itemId
     * @return 
     */
    public boolean itemEquipado (int itemId)
    {
        return myBolsa.itemEquipado(itemId);
    }
    
    public String vidaExtra(){
        InOut.iconeOraculo("Oráculo", "Suas vidas acabaram, você deseja misericórdia?");
        this.pedidoMisericordia = true;
        return InOut.leStringOraculo("Apresente teu pedido de misericórdia e que ele revele humildade e seja digno de aceitação.");
    }
   
}
