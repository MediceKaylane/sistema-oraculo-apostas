/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Classe que representa um item do jogo.
 * Pode ser equipado e possui efeitos especiais.
 * 
 * @author alunolab10
 */
public class Item {
    
    private int idItem;
    private String tipoItem;
    private boolean equipado;
    
    /**
     * Construtor da classe Item.
     * 
     * @param idItem identificador do item
     * @param tipoItem tipo do item
     * @param equipado estado inicial (equipado ou não)
     */

    public Item(int idItem, String tipoItem, boolean equipado) {
        this.idItem = idItem;
        this.tipoItem = tipoItem;
        this.equipado = equipado;
    }
    
    /**
     * Exibe os dados do item em uma janela.
     */
    public void imprimirDados(){
        InOut.MsgDeInformacao("Dados do Item",  tipoItem + "\n" + equipado);    //Imprime os dados do item em uma janela com o InOut
    }
    
    
    /**
     * Marca o item como equipado.
     */
    public void equipar(){      //Equipa o item
        this.equipado = true;
        System.out.println("item e se esta equipado:" + tipoItem + equipado);
    }
    
    /**
     * Marca o item como não equipado.
     */
    public void desequipar(){      //Desequipa o item
        this.equipado = false;
        System.out.println("item e se esta equipado:" + tipoItem + equipado);
    }
    
    /**
     * Retorna se o item está equipado.
     * 
     * @return true se equipado
     */
    public boolean itemEquipado(){
        return this.equipado;
    }
    
    /**
     * Efeito: adiciona uma vida ao guerreiro.
     * 
     * @param oraculo objeto que contém o guerreiro
     */
        public void efeitoAdcVida(Oraculo oraculo){
            oraculo.getWarrior().aumentarVida();
        }
        
        /**
        * Efeito: retorna a primeira letra da resposta da charada.
        * 
        * @param oraculo acesso às charadas
        * @param idCharada índice da charada
        * @return primeira letra da resposta
        */
        public char efeitoDicaPrimeiraLetra(Oraculo oraculo, int idCharada){
            return oraculo.getCharadas().get(idCharada).resposta.charAt(0);
        }
        
        /**
        * Efeito: retorna a quantidade de letras da resposta da charada.
        * 
        * @param oraculo acesso às charadas
        * @param idCharada índice da charada
        * @return quantidade de letras
        */
        public int efeitoDicaQntdLetras(Oraculo oraculo, int idCharada){
            return oraculo.getCharadas().get(idCharada).resposta.length();
        }
        
        /**
        * Efeito: retorna uma dica sobre a resposta da charada.
        * 
        * @param oraculo acesso ao contexto
        * @param idCharada índice da charada
        * @return dica correspondente
        */
        public String efeitoDicaResposta(Oraculo oraculo, int idCharada){
            switch(idCharada){
                case 0:
                    return "é redondo";
                case 1:
                    return "é molhado";
                case 2:
                    return "é um alimento";
                case 3:
                    return "é usado para escrever";
                default:
                    return "id da charada não existente";
            }
        }
        
        
}
