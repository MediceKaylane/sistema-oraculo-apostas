/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alunolab10
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.io.File;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class Oraculo {
    Random random = new Random();
    
    public int tentativasLevel01 = 0;
    private String nome;
    private Guerreiro warrior;
    private List<Charada> charadas = new ArrayList<>();
    private List<Integer> palpites = new ArrayList<>();

    public Oraculo(String nome, Guerreiro warrior) {
        this.nome = nome;
        this.warrior = warrior;
    }
    
    //inner class pra criar as charadas da segunda fase
    class Charada{
        String pergunta, resposta;
        
        public Charada(String pergunta, String resposta){
            this.pergunta = pergunta;
            this.resposta = resposta;
        }
    }
    
    //tratamento de erro nome oraculo
    public void getName (String name){
        this.nome = name; 
    }

    public Guerreiro getWarrior() {
        return warrior;
    }

    public List<Charada> getCharadas() {
        return charadas;
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
    
    public boolean decidirVidaExtra(String pedidoMisericordia){
        boolean vidaExtra = false;
        
        if(pedidoMisericordia.length() > 5){
            warrior.aumentarVida();
            vidaExtra = true;
        }
        
        return vidaExtra;
    }
    

    
    public boolean loadLevel01 (){
        boolean level01Completo = false;
        int resposta = random.nextInt(99) + 1;
        System.out.println("numero sorteado:" + resposta);
        
        //explicar para o usuario o jogo 
            InOut.iconeOraculo(this.nome, "Neste nível você deve acertar qual número foi sorteado de 1 a 100");
        
        
        for(int i = 0; i < warrior.getVidaInicial() + 1; i++){
            
            if(warrior.getQntdVidas() == 0){                                            //Avisa que o jogador perdeu e encerra o programa caso as vidas
                if(warrior.isPedidoMisericordia() == false){
                    this.decidirVidaExtra(warrior.vidaExtra());
                }
                
                InOut.iconeOraculo(this.nome, "Suas vidas acabaram! Você perdeu!");        //tenham acabado
                System.exit(0);
            }
            
            //qtnd vidas do usuario
            InOut.iconeOraculo(this.nome, "Sua quantidade de vidas atual: " + warrior.getQntdVidas() + " vidas.");
            
            
            
            int respostaJogador = InOut.leIntGuerreiro(warrior.getNome() + ", " + "qual o seu palpite?");         //Recebe o palpite do jogador
            palpites.add(respostaJogador);
                
                if(respostaJogador == resposta){                                                    //Se o jogador acertar, a Oráculo avisa o acerto
                    InOut.iconeOraculo(this.nome, "Parabéns!\n Você completou o primeiro nível");
                    level01Completo = true;
                    
                    if(tentativasLevel01 < 4){              //Caso o jogador acerte na primeira tentativa, equipa o item definido
                        warrior.equiparItem(6); //id item supremo
                    }
                    
                    break;
                    
                } else{
                    
                    if(respostaJogador > resposta){                                                                 //Caso o jogador erre, da as dicas de
                        InOut.iconeOraculo(this.nome, "Uma dica: o número secreto é menor que o seu palpite");       //maior ou menor do que o palpite
                    } 
                    else if(respostaJogador < resposta){
                        InOut.iconeOraculo(this.nome, "Uma dica: o número secreto é maior que o seu palpite");
                    }
                    
                  warrior.diminuirVida();                     //Guerreiro perde uma vida e tentativas do nível 1 aumenta
                  InOut.MsgSemIcone(this.nome, "Sua quantidade de vidas atual: " + warrior.getQntdVidas() + " vidas.");
                  tentativasLevel01++;
                }
        }
        
        for (int i = 0; i < 5; i++) {
            warrior.aumentarVida();
        }
        return level01Completo;
    }
    
    public boolean loadLevel02(){
        boolean levelCompleto = false, dePrimeira;
        String respostaCharada, respostaJogador;
        int tentativas = 0;
        
        //Adiciona cada charada e suas respostas na lista de charadas
        charadas.add(new Charada("O que é, o que é:\nQuanto mais você tira, maior ele fica?", "buraco"));
        charadas.add(new Charada("O que é, o que é:\nSempre corre, mas nunca anda?", "rio"));
        charadas.add(new Charada("O que é, o que é:\nTem cabeça e tem dente, mas não é gente?", "alho"));
        charadas.add(new Charada("O que é, o que é:\nQuanto mais você usa, mais fino ele fica?", "lapis"));
        
        //Explicação da segunda fase
        InOut.iconeOraculo(this.nome, "Parabéns você chegou no nível 2!");
        InOut.iconeOraculo(this.nome, "Sua quantidade de vidas atual: " + warrior.getQntdVidas() + " vidas.");
        InOut.iconeOraculo(this.nome, "Deixa eu te explicar as regras:");
        InOut.iconeOraculo(this.nome, "Eu vou te dar 4 charadas, a sua tarefa é acertar as respostas de cada uma.\nSe você não acertar...\nPerde uma vida.");
        InOut.iconeOraculo(this.nome, "As charadas são simples, qualquer um acertaria...\nVamos testar suas capacidades:");
        
        //Começa as charadas
        //Rodas o loop 4 vezes, cada vez setando a charada e resposta como a charada em sua respectiva posição dentro da lista
        for(int i=0; i<4; i++){
            
            
            //No início de cada charada define que o jogador ainda não acertou de primeira
            dePrimeira = false;
            InOut.iconeOraculo(this.nome, charadas.get(i).pergunta);
            respostaCharada = charadas.get(i).resposta;
            
            switch(i){
                case 0:
                    if(warrior.itemEquipado(6)){
                        InOut.iconeOraculo("Pedra Supreme", "Uma dica:\nA resposta é buraco :)");
                    }
                case 1:
                    if(warrior.itemEquipado(0)){
                        InOut.iconeOraculo("Capacete de Ferro", "Uma dica:\nÉ algo molhado");
                    }
                case 2:
                    if(warrior.itemEquipado(2)){
                        InOut.iconeOraculo("Escudo de Madeira", "Uma dica:\nComeça com a");
                    }
                case 3:
                    if(warrior.itemEquipado(3)){
                        InOut.iconeOraculo("Botas de Couro", "Uma dica:\nTem 5 letras");
                    }
            }
                
            //Enquanto o jogador não acertar, a oráculo vai continuar pedindo a resposta até que ele não tenha mais vidas
            while(true){
                if(warrior.getQntdVidas() == 0){
                    if(warrior.isPedidoMisericordia() == false){
                    this.decidirVidaExtra(warrior.vidaExtra());
                }
                    
                    InOut.iconeOraculo(this.nome, "Suas vidas acabaram! Você perdeu!");        
                    System.exit(0);
                }
                
                //Recebe a resposta do jogador em letrar minúsculas e sem espaços. Ex: buraco, um buraco, o buraco, etc
                respostaJogador = InOut.leStringGuerreiro("Insira sua resposta (sem acentos :)):").toLowerCase().replace(" ", "");

                if(respostaJogador.contains(respostaCharada)){
                    //Caso o jogador acerte de primeira define a variavel dePrimeira como true
                    if(tentativas == 0){
                        dePrimeira = true;
                    }
                        
                    InOut.iconeOraculo(this.nome, "Parabéns!\nVocê acertou a " + (i+1) + "° charada");
                    break;
                }
                else{
                    //Caso o jogador erre, aumenta o numero de tentativas e diminui uma vida
                    InOut.iconeOraculo(this.nome, "Errado, tenta de novo:");
                    tentativas++;
                    warrior.diminuirVida();
                }
            }
                
            //Caso o jogador tenha acertado de primeira, ele recebe um item de acordo com a charada
            if(dePrimeira == true){
                switch(i){
                    case 0:
                        warrior.equiparItem(0);
                        break;
                    case 1:
                        warrior.equiparItem(2);
                        break;
                    case 2:
                        warrior.equiparItem(3);
                        break;
                    case 3:
                        warrior.equiparItem(4);
                        warrior.aumentarVida();
                        InOut.MsgSemIcone("Peitoral de Malha", "Pode deixar que eu sou resistente.\nvocê ganhou mais uma vida.");
                        break;
                    }

                }
        
        }
        
        //Se o jogador passou por todas as charadas, define levelCompleto como true
        levelCompleto = true;
        
        InOut.iconeOraculo(this.nome, "Você acertou todas?\nMeus parabéns, essas não estavam tão faceis assim");
        return levelCompleto;
    }
    
    
    public boolean loadLevel03 () {
        
        boolean level03Completo = false;
        
        //hashset p/ armazenar dicionario e a leitura ser instatanea
        Set<String> dicionario = new HashSet<>(); 
        
        //abrindo br-sem-acentos.txt e passando para o hash dicionario
        
        try  //try: tenta isso e se der errado joga no exception erro
        {
            File arq = new File("src/br-sem-acentos.txt"); //obj aponta para o arquivo txt
            Scanner leitorArq = new Scanner (arq); //fopen(arq, "r");
            
            while (leitorArq.hasNextLine()) //nextline "ainda tem linha para ler?"
            {
                String palavraDicio = leitorArq.nextLine().trim(); //le ate a prox line e remove espaços antes/depois da palavra
                
                if(!palavraDicio.isEmpty())
                {
                    dicionario.add(palavraDicio);
                }
                
            }
            leitorArq.close(); //fecha o arquivo
        }
        catch(Exception erro)
        {
            InOut.iconeOraculo("opss, deu red", erro.getMessage());
        }
        
        // Criando a tabela de pontuação
        Map<Character, Integer> tabelaPontuacao = new HashMap<>();

        // Adicionando as pontuações
        tabelaPontuacao.put('a', 10);
        tabelaPontuacao.put('b', 30);
        tabelaPontuacao.put('c', 30);
        tabelaPontuacao.put('d', 20);
        tabelaPontuacao.put('e', 10);
        tabelaPontuacao.put('f', 40);
        tabelaPontuacao.put('g', 20);
        tabelaPontuacao.put('h', 20);
        tabelaPontuacao.put('i', 40);
        tabelaPontuacao.put('j', 10);
        tabelaPontuacao.put('k', 80);
        tabelaPontuacao.put('l', 50);
        tabelaPontuacao.put('m', 10);
        tabelaPontuacao.put('n', 30);
        tabelaPontuacao.put('o', 10);
        tabelaPontuacao.put('p', 10);
        tabelaPontuacao.put('q', 90);
        tabelaPontuacao.put('r', 10);
        tabelaPontuacao.put('s', 10);
        tabelaPontuacao.put('t', 10);
        tabelaPontuacao.put('u', 10);
        tabelaPontuacao.put('v', 80);
        tabelaPontuacao.put('w', 100);
        tabelaPontuacao.put('x', 70);
        tabelaPontuacao.put('y', 100);
        tabelaPontuacao.put('z', 50);
        
        //Entrada do usuario 
        int soma = 0;
            //introducao level03
            InOut.iconeOraculo(this.nome, "Uau, você chegou no último nível!");
            InOut.iconeOraculo(this.nome, "Sua quantidade de vidas atual: " + warrior.getQntdVidas() + " vidas.");
            
            
            //explicacao do game com um obs palavras sem potuacao 
            InOut.iconeOraculo(this.nome, "Agora vamos entender como o jogo funciona, ok?");
            InOut.iconeOraculo(this.nome, "Entendendo o Nível..\nNeste nível você digita uma palavra sem pontuação.\nCada letra tem uma pontuação diferente.\nA soma do ponto de cada letra determina sua pontuação final!");
            InOut.iconeOraculo("DICA", "Tem letras que valem muitos pontos\nEstas compõem palavra mais difíceis no vocabulário.");
            
            
        //1 fase, escreve o tanto que quiser até chegar a 100 pontos
        InOut.iconeOraculo(this.nome, "Sua palavra deve ter uma pontuação total de 100 pontos\nEu sei, você não sabe os pontos de cada letra...\nEntão tente deduzir!");
        do
        {
             String palavra = InOut.leStringGuerreiro("Insira sua palavra:").toLowerCase();
             
             if(dicionario.contains(palavra))
             {
                 for(char letra : palavra.toCharArray()){
                    if (tabelaPontuacao.containsKey(letra)){
                        Integer valor = tabelaPontuacao.get(letra);
                        soma += valor;
                    }
                }
                 
             }
             else{
                 InOut.iconeOraculo("Palavra inválida!", "Estávamos preparados para isso...\nDigite uma palavra válida");
                 warrior.diminuirVida();
                 InOut.iconeOraculo(this.nome, "Sua quantidade de vidas atual: " + warrior.getQntdVidas() + " vidas.");
             }
             if(warrior.getQntdVidas() == 0){
                InOut.iconeOraculo(this.nome, "Suas vidas acabaram! Você perdeu!");        
                System.exit(0);
             }
             //falta inserir a logica das vidas
             if(soma >= 100){
                 InOut.iconeOraculo("Parabéns!", "Você passou dessa fase com " + soma + " pontos");
             }
             else if (soma != 0){
                 InOut.iconeOraculo("Quase lá..", "Sua pontuação atual: " + soma + " pontos");
             }
        }
        while(soma < 100);
        
        //2 fase tem 3 chances se as palavras nao somarem 600 pontos perde uma vida
        
        InOut.iconeOraculo(this.nome, "Esta fase contém 3 rodadas.\nAo total sua pontuação deve ser maior ou igual a 600");
        do
        {
            if(warrior.getQntdVidas() == 0){
                if(warrior.isPedidoMisericordia() == false){
                    this.decidirVidaExtra(warrior.vidaExtra());
                }
                
                InOut.iconeOraculo(this.nome, "Suas vidas acabaram! Você perdeu!");        
                System.exit(0);
            }
            
            soma = 0;
            for(int i = 0; i < 3; i++){
                String palavra = InOut.leStringGuerreiro("Insira sua palavra:").toLowerCase();
                if(dicionario.contains(palavra))
                {
                    for(char letra : palavra.toCharArray()){
                        if (tabelaPontuacao.containsKey(letra)){
                            Integer valor = tabelaPontuacao.get(letra);
                            soma += valor;
                        }
                    }  
                }
                else{
                    InOut.iconeOraculo("Palavra inválida!", "Estávamos preparados para isso...\nDigite uma palavra válida.");  
                }
                
                if(soma >= 600){
                 InOut.iconeOraculo("Parabéns!", "Você passou dessa fase com " + soma + " pontos");
                }
                else if(soma < 300){
                    InOut.iconeOraculo("Não desista!", "Sua pontuação atual: " + soma + " pontos");
                }
                else{
                    InOut.iconeOraculo("Quase lá..", "Sua pontuação atual: " + soma + " pontos");
                }
            }
            
            if(soma < 600){
               
                warrior.diminuirVida();
                if(warrior.getQntdVidas() != 0){
                    InOut.iconeOraculo(this.nome, "Tente essa fase novamente, você vai conseguir!");
                    InOut.iconeOraculo(this.nome, "Sua quantidade de vidas atual: " + warrior.getQntdVidas() + " vidas.");
                }
            }
             
             
        }
        while(soma < 600);
        
        //fase precisao: digitar duas palavras acima de 300 pontos mas a palavra tem que ter no maximo 6 letras
       
        InOut.iconeOraculo(this.nome, "Esta fase contém 2 rodadas.\nAo total sua pontuação deve ser maior ou igual a 300");
        InOut.iconeOraculo(this.nome, "Achou fácil?\nNão se empolgue..");
        InOut.iconeOraculo(this.nome, "Sua palavra pode ter no máximo 6 letras hahaha");
        do
        {
            if(warrior.getQntdVidas() == 0){
                if(warrior.isPedidoMisericordia() == false){
                    this.decidirVidaExtra(warrior.vidaExtra());
                }
                
                InOut.iconeOraculo(this.nome, "Suas vidas acabaram! Você perdeu!");        
                System.exit(0);
            }
            
            soma = 0;
            for(int i = 0; i < 2; i++){
                String palavra = InOut.leStringGuerreiro("Insira sua palavra:").toLowerCase();
                
                if(palavra.length() <= 6){
                    if(dicionario.contains(palavra))
                    {
                        for(char letra : palavra.toCharArray()){
                            if (tabelaPontuacao.containsKey(letra)){
                                Integer valor = tabelaPontuacao.get(letra);
                                soma += valor;
                            }
                        }  
                    }
                    else{
                        InOut.iconeOraculo("Palavra inválida!", "Estávamos preparados para isso...\nDigite uma palavra válida.");  
                    } 
                    
                    if(soma >= 300){
                        InOut.iconeOraculo("Parabéns!", "Você passou dessa fase com " + soma + " pontos");
                    }
                    else if(soma < 150){
                        InOut.iconeOraculo("Não desista!", "Sua pontuação atual: " + soma + " pontos");
                    }
                    else{
                        InOut.iconeOraculo("Quase lá..", "Sua pontuação atual: " + soma + " pontos");
                    }

                }
                else{
                    InOut.iconeOraculo("Palavra inválida!", "Sua palavra deve conter no máximo 6 letras!");
                }
                
            }
            
            if(soma < 300){
                warrior.diminuirVida();
                if(warrior.getQntdVidas() != 0){
                    InOut.iconeOraculo(this.nome, "Tente essa fase novamente, você vai conseguir!");
                    InOut.iconeOraculo(this.nome, "Sua quantidade de vidas atual: " + warrior.getQntdVidas() + " vidas.");
                }
                
            }
             
             
        }
        while(soma < 300);
        
        InOut.iconeOraculo(this.nome, "Missão concluída " + warrior.getNome() + "!\nAté a próxima jornada!");
        
        
        return level03Completo = true;
        
    }
       
}
