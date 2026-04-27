import java.util.Random;

/**
 * Classe que representa o Guerreiro (jogador).
 * Controla suas vidas, itens e estado durante o jogo.
 * 
 * @author alunolab10
 */

public class Guerreiro {

   Random random = new Random();
    
   private String nome;
   private int qntdVidas, vidaInicial, vidasPerdidas = 0;
   private Bolsa myBolsa; 
   private boolean pedidoMisericordia = false;
   
    /**
     * Construtor da classe Guerreiro.
     * Inicializa o nome, a bolsa e sorteia as vidas iniciais.
     * 
     * @param nome nome do guerreiro
     * @param myBolsa bolsa de itens do guerreiro
     */

    public Guerreiro(String nome, Bolsa myBolsa) {
        this.nome = nome;
        this.myBolsa = myBolsa;
        this.qntdVidas = this.sortearVidas();        //Sorteia a vida do guerreiro automaticamente assim que ele é instanciado
        this.vidaInicial = this.qntdVidas;
    }
    
    //tratamento de erro nome oraculo
    /**
     * Atribui um nome ao guerreiro.
     * 
     * @param name novo nome
     */
    public void atribuirNome (String name){
        this.nome = name; 
    }
    
    /**
     * Verifica se o nome do guerreiro é válido.
     * 
     * @return true se não estiver vazio
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
     * Verifica se o nome do guerreiro é válido.
     * 
     * @return true se não estiver vazio
     */
   //Sorteia a vida do guerreiro gerando um aleatório entre 0 e 3 e somando 9, gerando entre 9 a 12 vidas.
   public int sortearVidas(){
       return ((random.nextInt(3))+9);              
   }                                                
 
    /**
     * Retorna o nome do guerreiro.
     * 
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna a quantidade atual de vidas.
     * 
     * @return vidas atuais
     */
    public int getQntdVidas() {
        return qntdVidas;
    }

    /**
     * Verifica se o guerreiro já pediu misericórdia.
     * 
     * @return true se já pediu
     */
    public boolean isPedidoMisericordia() {
        return pedidoMisericordia;
    }

    /**
     * Define se o guerreiro já pediu misericórdia.
     * 
     * @param pedidoMisericordia estado do pedido
     */
    public void setPedidoMisericordia(boolean pedidoMisericordia) {
        this.pedidoMisericordia = pedidoMisericordia;
    }
    
    

    /**
     * Retorna a quantidade inicial de vidas.
     * 
     * @return vidas iniciais
     */
    public int getVidaInicial() {
        return vidaInicial;
    }
    
    /**
     * Retorna o total de vidas perdidas.
     * 
     * @return vidas perdidas
     */
    public int getVidasPerdidas() {
        return vidasPerdidas;
    }
    
   
    /**
     * Retorna o total de vidas perdidas.
     * 
     * @return vidas perdidas
     */ 
    public void diminuirVida(){
        this.qntdVidas--;
        vidasPerdidas++;
    }
    
    
    /**
     * Aumenta uma vida do guerreiro.
     */
    public void aumentarVida(){
        this.qntdVidas++;
    }
    
    /**
     * Equipa um item da bolsa.
     * 
     * @param itemId índice do item
     */
    public void equiparItem (int itemId)
    {
        myBolsa.equiparItem(itemId);
    }
    
    /**
     * Desequipa um item da bolsa.
     * 
     * @param itemId índice do item
     */
    public void desequiparItem (int itemId)
    {
        myBolsa.desequiparItem(itemId);
    }
    
    /**
     * Verifica se um item está equipado.
     * 
     * @param itemId índice do item
     * @return true se equipado
     */
    public boolean itemEquipado (int itemId)
    {
        return myBolsa.itemEquipado(itemId);
    }
    
    /**
     * Verifica se um item está equipado.
     * 
     * @param itemId índice do item
     * @return true se equipado
     */
    
    public String vidaExtra(){
        InOut.iconeOraculo("Oráculo", "Suas vidas acabaram, você deseja misericórdia?");
        this.pedidoMisericordia = true;
        return InOut.leStringOraculo("Apresente teu pedido de misericórdia e que ele revele humildade e seja digno de aceitação.");
    }


}
