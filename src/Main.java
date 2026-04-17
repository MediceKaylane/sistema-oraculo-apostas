/**
 *
 * @author alunolab10
 */

void main() {
    
     //Objeto Bolsa criado
     Bolsa bolsaGuerreiro = new Bolsa();  
     
     
    
     //Objetos itens
    Item item0 = new Item (0, "Capacete de Ferro", false);
    Item item1 = new Item(1, "Espada de Ferro", false);
    Item item2 = new Item(2, "Escudo de Madeira", false);
    Item item3 = new Item(3, "Botas de Couro", false);
    Item item4 = new Item(4, "Peitoral de Malha", false);
    Item item5 = new Item(5, "Amuleto Antigo", false);
    Item item6 = new Item(6, "Pedra Supreme", false);
    
    //Adicionando os objetos na bolsa 
    bolsaGuerreiro.item.add(item0);
    bolsaGuerreiro.item.add(item1);
    bolsaGuerreiro.item.add(item2);
    bolsaGuerreiro.item.add(item3);
    bolsaGuerreiro.item.add(item4);
    bolsaGuerreiro.item.add(item5);
    bolsaGuerreiro.item.add(item6);
    
    
    Musica.tocar("src/musica/Musica Background.wav");
    
    //Objeto guerreiro: Já atribuindo o seu nome pelo o usuario e atribuindo o objeto bolsa a ele
    Guerreiro guerreiro = new Guerreiro (InOut.leStringGuerreiro("Insira o nome do Guerreiro:"), bolsaGuerreiro);
    do{
        if(guerreiro.verificarNome() == false){
        
        guerreiro.getName(InOut.leStringOraculo("Insira o nome do Guerreiro novamente:")); //tratamento de erro nome guerreiro
        }
    }
    while(guerreiro.verificarNome() == false);
    
    
    //Objeto oraculo
    Oraculo oraculo = new Oraculo (InOut.leStringOraculo("Insira o nome do Oraculo:"), guerreiro); 
    do{
        if(oraculo.verificarNome() == false){
        
        oraculo.getName(InOut.leStringOraculo("Insira o nome do Oraculo novamente:")); //tratamento de erro nome oraculo
        }
    }
    while(oraculo.verificarNome() == false);
    
    oraculo.loadLevel01();
    oraculo.loadLevel02();
    oraculo.loadLevel03();
    
    
}