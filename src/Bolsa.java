import java.util.ArrayList;
import java.util.List;


/**
 *Classe que representa a bolsa (inventário) de itens.
 * Armazena e gerencia os itens do jogador.
 * @author alunolab10
 */
public class Bolsa {
    
   public List<Item> item = new ArrayList<>();
   
   /**
     * Construtor da classe Bolsa.
     * Inicializa a lista de itens.
     */

    public Bolsa() {
        
    }

    /**
     * Equipa um item da bolsa com base no índice informado.
     * 
     * @param itemId índice do item na lista
     */
    public void equiparItem (int itemId) {
        item.get(itemId).equipar();  // chama o método equipar do item
    }
    
    
    /**
     * Desequipa um item da bolsa com base no índice informado.
     * 
     * @param itemId índice do item na lista
     */
    public void desequiparItem (int itemId) {
        item.get(itemId).desequipar(); // chama o método desequipar do item
    }
    
    /**
     * Verifica se um item está equipado.
     * 
     * @param itemId índice do item na lista
     * @return true se estiver equipado, false caso contrário
     */
    public boolean itemEquipado (int itemId) {
        return item.get(itemId).itemEquipado(); // retorna o estado do item
    }
    
    
}
