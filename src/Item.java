/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alunolab10
 */
public class Item {
    
    private int idItem;
    private String tipoItem;
    private boolean equipado;

    public Item(int idItem, String tipoItem, boolean equipado) {
        this.idItem = idItem;
        this.tipoItem = tipoItem;
        this.equipado = equipado;
    }
    

    public void imprimirDados(){
        InOut.MsgDeInformacao("Dados do Item",  tipoItem + "\n" + equipado);    //Imprime os dados do item em uma janela com o InOut
    }
    
    public void equipar(){      //Equipa o item
        this.equipado = true;
        System.out.println("item e se esta equipado:" + tipoItem + equipado);
    }
    
    public boolean itemEquipado(){
        return this.equipado;
    }
    
        public void efeitoAdcVida(Oraculo oraculo){
            oraculo.getWarrior().aumentarVida();
        }
        
        /**
         * 
         * @param oraculo
         * @param idCharada
         * @return 
         */
        public char efeitoDicaPrimeiraLetra(Oraculo oraculo, int idCharada){
            return oraculo.getCharadas().get(idCharada).resposta.charAt(0);
        }
        
        /**
         * 
         * @param oraculo
         * @param idCharada
         * @return 
         */
        public int efeitoDicaQntdLetras(Oraculo oraculo, int idCharada){
            return oraculo.getCharadas().get(idCharada).resposta.length();
        }
        
        /**
         * 
         * @param oraculo
         * @param idCharada
         * @return 
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
