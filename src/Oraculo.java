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

/**
 * Classe que representa o Oráculo do jogo.
 * Ele controla os desafios, interação com o jogador
 * e a progressão entre os níveis.
 */

public class Oraculo {
    Random random = new Random();
    
    public int tentativas = 0;
    private String nome;
    private Guerreiro warrior;
    private List<Charada> charadas = new ArrayList<>();
    private List<Integer> palpites = new ArrayList<>();
    private List<String> palavrasUsadas = new ArrayList<>();
    private List<String> palavrasRodadas = new ArrayList<>();

    public Oraculo(String nome, Guerreiro warrior) {
        this.nome = nome;
        this.warrior = warrior;
    }
    
    /**
     * Classe interna que representa uma charada
     * com pergunta e resposta.
     */
    class Charada{
        String pergunta, resposta;
        
        public Charada(String pergunta, String resposta){
            this.pergunta = pergunta;
            this.resposta = resposta;
        }
    }
    
    /**
     * Define o nome do Oráculo.
     * @param name 
     */
    //tratamento de erro nome oraculo
    public void atribuirNome (String name){
        this.nome = name; 
    }
    
    /**
     * Retorna o guerreiro associado ao oráculo.
     * 
     * @return objeto Guerreiro
     */
    public Guerreiro getWarrior() {
        return warrior;
    }
    
    /**
     * Retorna a lista de charadas do jogo.
     * 
     * @return lista de charadas
     */
    public List<Charada> getCharadas() {
        return charadas;
    }
    
    /**
     * tratamento de erro nome oraculo
     * @return 
     */
    public boolean verificarNome (){
        if(this.nome.isBlank() || this.nome.isEmpty()){
            return false;
        }
        else{
            return true;
        }
    }
    
    /**
     * Decide se o jogador merece uma vida extra
     * baseado no tamanho do texto digitado.
     */
    public boolean decidirVidaExtra(String pedidoMisericordia){
        boolean vidaExtra = false;
        
        if(pedidoMisericordia.length() > 5){
            warrior.aumentarVida();
            InOut.iconeOraculo(this.nome, "Teu pedido demonstrou merecimento da divina misericórdia, e tu serás recompensado");
            vidaExtra = true;
        }
        else{
            InOut.iconeOraculo(this.nome, "Teu pedido não demonstrou merecimento da divina misericórdia, e tu não serás recompensado");
        }
        
        return vidaExtra;
    }
    
    /**
     * Contextualiza os personagens e o jogo
     */
    public void prologoIntroducao (){
        InOut.iconeOraculo(this.nome, "Sei que você não se lembra de nada...mas eu vou te ajudar a sair desse lugar. \nAnos atrás o mundo foi repartido em dois e você ficou aqui comigo... no Mundo Perdido");
        InOut.iconeOraculo(this.nome, "Sua saída é composta de 3 desafios:\nA passagem pela ruína da tribo antiga, \nOs abismos onde a gravidade não existe  \nA luta contra os guardas do portal.");
        InOut.iconeOraculo(this.nome, "O Oráculo " + this.nome + "\n" +
        "acolhe o valente Guerreiro " + warrior.getNome() +
        ", que inicia sua jornada com " + warrior.getQntdVidas() + " vidas sob seu destino.");
    }
    
    /**
     * Exibe um relatório final da partida.
     * 
     * Mostra:
     * - Quantidade de vidas perdidas
     * - Palpites realizados no nível 1
     * - Respostas das charadas do nível 2
     * - Total de tentativas no nível 3
     */
    
    public void relatorioPartida(){
        String mensagem = "Ao fim da jornada, revelam-se os feitos do Guerreiro:\n"
            + "As vidas que perdeu: " + warrior.getVidasPerdidas()
            + "\nOs palpites que ousou no primeiro: " + palpites
            + "\nDesafio e a verdade oculta do segundo:\n";

        for (int i = 0; i < charadas.size(); i++) {
            mensagem += charadas.get(i).resposta + "\n";
        }

        mensagem += "\nO Guerreiro ousou ao todo " + tentativas + " tentativa(s) no terceiro";

        InOut.iconeOraculo(this.nome, mensagem);
    }
    
    
    /**
     * Exibe a mensagem de vitória do jogador.
     * Ocorre quando todos os desafios são concluídos com sucesso.
     */
    public void vencedor (){
        InOut.iconeOraculo(this.nome, "Após superar todos os desafios, o Guerreiro " + warrior.getNome() + 
                " conquista o Novo Mundo e tem seu nome eternizado entre os dignos.");
    }
    
    
    /**
     * Exibe a mensagem de derrota do jogador.
     * Ocorre quando o guerreiro fica sem vidas.
     */
     public void perdedor (){
        InOut.iconeOraculo(this.nome, "Sem forças para prosseguir, o Guerreiro " + warrior.getNome() +
                " sucumbe aos desafios e permanece no Mundo Perdido, esquecido pelo destino.");
    }
     
     /**
      * Carrega todas as palavras válidas a partir de um arquivo de texto
      * e armazena em um Set para evitar duplicatas e permitir busca rápida.
      *
      * Cada linha do arquivo representa uma palavra do dicionário.
      * Linhas vazias são ignoradas.
      *
      * @return um Set contendo todas as palavras válidas do dicionário
      */
     private Set<String> carregarDicionario(){
         
         Set<String> dicionario = new HashSet<>(); 
        
        //abrindo br-sem-acentos.txt e passando para o hash dicionario
        
        try  //try: tenta isso e se der errado joga no exception erro
        {
            File arq = new File("src/br-sem-acentos.txt"); //obj aponta para o arquivo txt
            Scanner leitorArq = new Scanner (arq); //fopen(arq, "r");
            
            //hashset p/ armazenar dicionario e a leitura ser instatanea
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
        return dicionario;
     }
     
     
     /**
      * Cria e inicializa a tabela de pontuação das letras do jogo.
      *
      * Cada caractere é associado a um valor inteiro que será utilizado
      * para calcular a pontuação total das palavras inseridas pelo jogador.
      *
      * @return um Map contendo as letras e suas respectivas pontuações
      */
     private Map<Character, Integer> carregarTabelaPontuacao (){
         
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
        
        return tabelaPontuacao;
     }
     
     
     /**
      * Exibe a introdução do nível 3 ao jogador.
      *
      * Apresenta o contexto do desafio, explica as regras de pontuação
      * das palavras e fornece dicas estratégicas para o jogador.
      */
     private void introducaoNivel3(){
         
        //introducao level03
        InOut.iconeOraculo(this.nome, "Uau, você chegou no último desafio! Vamos enfrentar esses guardas!!");
        InOut.iconeOraculo(this.nome, "Sua quantidade de vidas atual: " + warrior.getQntdVidas() + " vidas.");    
            
        //explicacao do game com um obs palavras sem potuacao 
        InOut.iconeOraculo(this.nome, "Agora vamos entender como esse desafio funciona");
        InOut.iconeOraculo(this.nome, "Você insere no portal celeste uma palavra sem acentos mesmo se ela tiver.\nCada letra tem uma pontuação diferente.\nA soma do ponto de cada letra determina sua pontuação final!");
        InOut.iconeOraculo(this.nome, "Você está na era medieval nem todas as palavras do seu mundo eles reconhecem");
        InOut.iconeOraculo("DICA:", "Nem sempre a palavra mais longa vence: \nuse letras raras para alcançar pontuações maiores.");
         
     }
     
     
     
    /**
    * Fase 1 do nível 3:
    * O jogador deve inserir palavras válidas até atingir
    * pelo menos 100 pontos somando o valor das letras.
    * 
    * - Palavras repetidas não são permitidas
    * - Palavras inválidas não pontuam
    * - A cada erro, o jogador pode perder vidas
    */
     private void nivel03Fase1(Set<String> dicionario, Map<Character, Integer> tabelaPontuacao) {
         //1 fase, escreve o tanto que quiser até chegar a 100 pontos
        InOut.iconeOraculo(this.nome, "Sua palavra deve ter uma pontuação total de 100 pontos\nEu sei, você não sabe os pontos de cada letra...\nEntão tente deduzir!");
        
        //fase 1
        int soma = 0;
        String palavra;
        do
        {
            if(warrior.getQntdVidas() == 0){
                if(warrior.isPedidoMisericordia() == false){
                    this.decidirVidaExtra(warrior.vidaExtra());
                }
            }
                
            if(warrior.getQntdVidas() == 0){
                InOut.iconeOraculo(this.nome, "Suas vidas acabaram!");
                perdedor();
                System.exit(0);
            }
            
               while(true){
                    palavra = InOut.leStringGuerreiro("Insira sua palavra:").toLowerCase();
                
                    if(palavrasUsadas.contains(palavra)){
                        InOut.iconeOraculo(this.nome, "Você já usou essa palavra, seja mais criativo.");
                    }
                    else{break;}
                }
                
                
             
             if(dicionario.contains(palavra))
             {
                for(char letra : palavra.toCharArray()){
                    if (tabelaPontuacao.containsKey(letra)){
                        Integer valor = tabelaPontuacao.get(letra);
                        soma += valor;
                    }
                }
                palavrasUsadas.add(palavra);
             }
             else{
                 InOut.iconeOraculo("Palavra inválida!", "Eles estavam preparados para isso...\nDigite uma palavra válida");
                 ++tentativas;
                 if(warrior.getQntdVidas() != 1){
                    InOut.iconeOraculo(this.nome, "Sua quantidade de vidas atual: " + (warrior.getQntdVidas() - 1) + " vidas.");
                 }
             }
             
             if(soma >= 100){
                 InOut.iconeOraculo("Parabéns!", "Você passou dessa fase com " + soma + " pontos");
                 palavrasRodadas.addAll(palavrasUsadas);
                 palavrasUsadas.clear();
             }
             else if (soma != 0){
                 InOut.iconeOraculo("Quase lá..", "Sua pontuação atual: " + soma + " pontos");
                 warrior.diminuirVida();
                 ++tentativas;
             }
             else if (soma == 0){
                 warrior.diminuirVida();
             }
        }
        while(soma < 100); 
     }
     
    /**
    * Fase 2 do nível 3:
    * O jogador tem 3 rodadas para somar pelo menos 600 pontos.
    * 
    * - Cada rodada aceita uma palavra
    * - Palavras não podem ser repetidas (nem de fases anteriores)
    * - Caso não atinja a pontuação mínima, perde uma vida
    * - Pode tentar novamente enquanto tiver vidas
    */
     
      private void nivel03Fase2(Set<String> dicionario, Map<Character, Integer> tabelaPontuacao) {
        //fase 2
        int soma = 0;
        String palavra;
        
        //fase 2 tem 3 chances se as palavras nao somarem 600 pontos perde uma vida
        InOut.iconeOraculo(this.nome, "Esta fase contém 3 rodadas.\nAo total sua pontuação deve ser maior ou igual a 600");
        
        do
        {
            if(warrior.getQntdVidas() == 0){
                if(warrior.isPedidoMisericordia() == false){
                    this.decidirVidaExtra(warrior.vidaExtra());
                }
            }
                
            if(warrior.getQntdVidas() == 0){
                InOut.iconeOraculo(this.nome, "Suas vidas acabaram!");
                perdedor();
                System.exit(0);
            }
            
            soma = 0;
            for(int i = 0; i < 3; i++){
                while(true){
                    palavra = InOut.leStringGuerreiro("Insira sua palavra:").toLowerCase();
                
                    if(palavrasUsadas.contains(palavra) || palavrasRodadas.contains(palavra)){
                        InOut.iconeOraculo(this.nome, "Você já usou essa palavra, seja mais criativo.");
                    }
                    else{break;}
                }

                if(dicionario.contains(palavra))
                {
                    for(char letra : palavra.toCharArray()){
                        if (tabelaPontuacao.containsKey(letra)){
                            Integer valor = tabelaPontuacao.get(letra);
                            soma += valor;
                        }
                    }
                    palavrasUsadas.add(palavra);
                }
                else{
                    InOut.iconeOraculo("Palavra inválida!", "Eles estavam preparados para isso...\nDigite uma palavra válida.");  
                }
                
                if(soma >= 600){
                 InOut.iconeOraculo("Parabéns!", "Você passou dessa fase com " + soma + " pontos");
                 palavrasRodadas.addAll(palavrasUsadas);
                 palavrasUsadas.clear();
                 break;
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
                ++tentativas;
                if(warrior.getQntdVidas() != 0){
                    InOut.iconeOraculo(this.nome, "Tente essa fase novamente, você vai conseguir!");
                    InOut.iconeOraculo(this.nome, "Sua quantidade de vidas atual: " + warrior.getQntdVidas() + " vidas.");
                } 
                palavrasUsadas.clear();
            }
             
             
        }
        while(soma < 600);
        
        
      }
      
    /**
    * Fase 3 do nível 3:
    * O jogador deve atingir pelo menos 300 pontos em 2 rodadas.
    * 
    * Regras:
    * - Cada palavra pode ter no máximo 6 letras
    * - Palavras repetidas não são permitidas
    * - Deve usar palavras válidas do dicionário
    * - Se não atingir a pontuação mínima, perde uma vida
    */
      
      private void nivel03Fase3(Set<String> dicionario, Map<Character, Integer> tabelaPontuacao) {
          
        //fase 3 
        int soma = 0;
        String palavra;
        
        //fase 3 digitar duas palavras acima de 300 pontos mas a palavra tem que ter no maximo 6 letras
        InOut.iconeOraculo(this.nome, "Esta fase contém 2 rodadas.\nAo total sua pontuação deve ser maior ou igual a 300");
        InOut.iconeOraculo(this.nome, "Achou fácil?\nNão se empolgue..");
        InOut.iconeOraculo(this.nome, "Sua palavra pode ter no máximo 6 letras");
        
        
        do
        {
            if(warrior.getQntdVidas() == 0){
                if(warrior.isPedidoMisericordia() == false){
                    this.decidirVidaExtra(warrior.vidaExtra());
                }
            }
                
            if(warrior.getQntdVidas() == 0){
                InOut.iconeOraculo(this.nome, "Suas vidas acabaram!");
                perdedor();
                System.exit(0);
            }
            
            soma = 0;
            for(int i = 0; i < 2; i++){
                        
                while(true){
                    palavra = InOut.leStringGuerreiro("Insira sua palavra:").toLowerCase();
                
                    if(palavrasUsadas.contains(palavra)|| palavrasRodadas.contains(palavra)){
                        InOut.iconeOraculo(this.nome, "Você já usou essa palavra, seja mais criativo.");
                    }
                    else{break;}
                }
 
                
                if(palavra.length() <= 6){
                    if(dicionario.contains(palavra))
                    {
                        for(char letra : palavra.toCharArray()){
                            if (tabelaPontuacao.containsKey(letra)){
                                Integer valor = tabelaPontuacao.get(letra);
                                soma += valor;
                            }
                        } 
                    palavrasUsadas.add(palavra);
                    }
                    else{
                        InOut.iconeOraculo("Palavra inválida!", "Eles estavam preparados para isso...\nDigite uma palavra válida.");
                    } 
                    
                    if(soma >= 300){
                        InOut.iconeOraculo("Parabéns!", "Você passou dessa fase com " + soma + " pontos");
                        palavrasRodadas.add(palavra);
                        palavrasUsadas.clear();
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
                ++tentativas;
                if(warrior.getQntdVidas() != 0){
                    InOut.iconeOraculo(this.nome, "Tente essa fase novamente, você vai conseguir!");
                    InOut.iconeOraculo(this.nome, "Sua quantidade de vidas atual: " + warrior.getQntdVidas() + " vidas.");
                }
               palavrasUsadas.clear();
                
            }
             
             
            
            
        }
        while(soma < 300);
        
        InOut.iconeOraculo(this.nome, "Missão concluída! \nVocê venceu todos os desafios e tem acesso liberado ao Novo Mundo " + warrior.getNome() + "!\nAté a próxima jornada!");
        
    }
    


    /**
     * Executa o primeiro nível do jogo, onde o jogador deve adivinhar
     * um número aleatório entre 1 e 100.
     * O jogador perde uma vida a cada erro e recebe dicas indicando
     * se o número secreto é maior ou menor que o palpite informado.
     * Caso acerte, o nível é concluído e pode receber uma recompensa.
     *
     * Se as vidas acabarem, o jogo é encerrado.
     * @return true se o jogador completar o nível com sucesso, false caso contrário
     */
    public boolean loadLevel01 (){
        boolean level01Completo = false;
        int resposta = random.nextInt(99) + 1;
        System.out.println("numero sorteado:" + resposta);
        
        //explicar para o usuario o jogo
            InOut.iconeOraculo(this.nome, "No primeiro desafio você deve acertar: \nQual número foi sorteado de 1 a 100 para a tribo liberar sua passagem para o abismo");
        
        
        for(int i = 0; i < warrior.getVidaInicial() + 2; i++){
            
            if(warrior.getQntdVidas() == 0){                                            //Avisa que o jogador perdeu e encerra o programa caso as vidas tenham acabado
                if(warrior.isPedidoMisericordia() == false){
                    this.decidirVidaExtra(warrior.vidaExtra());
                }
            }
                
            if(warrior.getQntdVidas() == 0){
                InOut.iconeOraculo(this.nome, "Suas vidas acabaram!");
                perdedor();
                System.exit(0);
            }
            
            //qtnd vidas do usuario
            if(i != 0){
                InOut.iconeOraculo(this.nome, "Sua quantidade de vidas atual: " + warrior.getQntdVidas() + " vidas.");
            }
            
            
            
            
            int respostaJogador = InOut.leIntGuerreiro(warrior.getNome() + ", " + "qual o seu palpite? (numeros de 0 a 100)");         //Recebe o palpite do jogador
            palpites.add(respostaJogador);
                
                if(respostaJogador == resposta){                                                    //Se o jogador acertar, a Oráculo avisa o acerto
                    InOut.iconeOraculo(this.nome, "Parabéns!\n Você conseguiu atravessar a ruína! A tribo antiga te liberou!");
                    level01Completo = true;
                    
                    if(tentativas < 4){              //Caso o jogador acerte na primeira tentativa, equipa o item definido
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
                  tentativas++;
                }
        }
        
        for (int i = 0; i < 5; i++) {
            warrior.aumentarVida();
        }
        return level01Completo;
    }
    
    /**
     * Executa o segundo nível do jogo, onde o jogador deve responder corretamente
     * uma sequência de 4 charadas.
     *
     * A cada erro, o jogador perde uma vida. O jogo continua até que o jogador
     * acerte a charada atual ou fique sem vidas.
     *
     * Caso o jogador acerte uma charada de primeira tentativa, ele recebe um item
     * especial que pode conceder vantagens, como dicas nas próximas charadas
     * ou benefícios adicionais.
     *
     * Se todas as charadas forem respondidas corretamente, o nível é concluído.
     * Caso as vidas acabem, o jogo é encerrado. 
     * @return true se o jogador completar o nível com sucesso.
     */
    public boolean loadLevel02(){
        boolean levelCompleto = false, dePrimeira;
        String respostaCharada, respostaJogador;
        tentativas = 0;
        
        //Adiciona cada charada e suas respostas na lista de charadas
        charadas.add(new Charada("O que é, o que é:\nQuanto mais você tira, maior ele fica?", "buraco"));
        charadas.add(new Charada("O que é, o que é:\nSempre corre, mas nunca anda?", "rio"));
        charadas.add(new Charada("O que é, o que é:\nTem cabeça e tem dente, mas não é gente?", "alho"));
        charadas.add(new Charada("O que é, o que é:\nQuanto mais você usa, mais fino ele fica?", "lapis"));
        
        //Explicação da segunda fase
        InOut.iconeOraculo(this.nome, "Parabéns você chegou no abismo onde a gravidade não existe e ganhou 5 vidas para enfrentar esse desafio! Vamos lá...");
        InOut.iconeOraculo(this.nome, "Sua quantidade de vidas atual: " + warrior.getQntdVidas() + " vidas.");
        InOut.iconeOraculo(this.nome, "Deixa eu te explicar as regras para resistir:");
        InOut.iconeOraculo(this.nome, "Eu vou te dar 4 charadas, a sua tarefa é acertar as respostas de cada uma.\nSe você não acertar...\nPerde uma vida.");
        InOut.iconeOraculo(this.nome, "Vamos testar suas capacidades:");
        
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
                        InOut.iconeOraculo("Pedra Supreme", "Tua precisão no desafio anterior não passou despercebida… por isso, foste agraciado com o poder da "
                                + "Pedra Suprema que lhe concede a resposta dessa charada!");
                        InOut.iconeOraculo("Pedra Supreme", "buraco");
                    }
                case 1:
                    if(warrior.itemEquipado(0)){
                        InOut.iconeOraculo(this.nome, "Você acertou a charada anterior de primeira. Concedo-lhes o Capacete de Ferro que contém uma dica");
                        InOut.iconeOraculo(this.nome, "Dica:\nÉ algo molhado");
                    }
                case 2:
                    if(warrior.itemEquipado(2)){
                        InOut.iconeOraculo(this.nome, "Você acertou a charada anterior de primeira. Concedo-lhes o Escudo de Madeira que contém uma dica");
                        InOut.iconeOraculo(this.nome, "Dica:\nComeça com a");
                    }
                case 3:
                    if(warrior.itemEquipado(3)){
                        InOut.iconeOraculo(this.nome, "Você acertou a charada anterior de primeira. Concedo-lhes as Botas de Couro que contém uma dica");
                        InOut.iconeOraculo(this.nome, "Dica:\nTem 5 letras");
                    }
            }
                
            //Enquanto o jogador não acertar, a oráculo vai continuar pedindo a resposta até que ele não tenha mais vidas
            while(true){
                if(warrior.getQntdVidas() == 0){
                    if(warrior.isPedidoMisericordia() == false){
                        this.decidirVidaExtra(warrior.vidaExtra());
                    }
                }
                
                if(warrior.getQntdVidas() == 0){
                    InOut.iconeOraculo(this.nome, "Suas vidas acabaram!");
                    perdedor();
                    System.exit(0);
                }
                
                //Recebe a resposta do jogador em letrar minúsculas e sem espaços. Ex: buraco, um buraco, o buraco, etc
                respostaJogador = InOut.leStringGuerreiro("Insira sua resposta (sem acentos:) ):").toLowerCase().replace(" ", "");

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
                    if(warrior.getQntdVidas() == 1){
                        InOut.iconeOraculo(this.nome, "Tua resposta é errada.");
                    } else{
                        InOut.iconeOraculo(this.nome, "Errado, tenta de novo:");
                        InOut.iconeOraculo(this.nome, "Sua quantidade de vidas atual: " + (warrior.getQntdVidas() - 1) + " vidas.");
                    }
                    
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
                        InOut.iconeOraculo(this.nome, "Você acertou a charada anterior de primeira. Concedo-lhes o Peitoral de Malha que lhe dá uma vida");
                        break;
                    }

                }
        
        }
        
        //Se o jogador passou por todas as charadas, define levelCompleto como true
        warrior.desequiparItem(0);
        warrior.desequiparItem(2);
        warrior.desequiparItem(3);
        warrior.desequiparItem(4);
        levelCompleto = true;
        
        InOut.iconeOraculo(this.nome, "Você acertou todas?\nMeus parabéns, Essas não estavam tão faceis assim! Agora você pode enfrentar os guardas do portal e ser livre!!");
        return levelCompleto;
    }
    
    /**
     * Executa o terceiro nível do jogo.
     * 
     * O nível é dividido em 3 fases:
     * - Fase 1: atingir 100 pontos com palavras
     * - Fase 2: atingir 600 pontos em 3 rodadas
     * - Fase 3: atingir 300 pontos com limite de letras
     * 
     * Utiliza um dicionário de palavras válidas e uma tabela de pontuação.
     * 
     * @return true quando o nível é concluído com sucesso
     */
    public boolean loadLevel03 () {
        
        boolean level03Completo = false;
        
        //metodo carregar dicionario 
        Set<String> dicionario = carregarDicionario();
        
        //tabela pontuacao
        Map<Character, Integer> tabelaPontuacao = carregarTabelaPontuacao();
        
        //explicao da fase
        introducaoNivel3();
        
        //fase 01
        nivel03Fase1(dicionario, tabelaPontuacao);
        
        //fase 02
        nivel03Fase2(dicionario, tabelaPontuacao);
        
        //fase 03
        nivel03Fase3(dicionario, tabelaPontuacao);
        
        
        return level03Completo = true;
        
    }    
}
