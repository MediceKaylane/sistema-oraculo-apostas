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

    public Oraculo(String nome, Guerreiro warrior) {
        this.nome = nome;
        this.warrior = warrior;
    }
    

    
    public boolean loadLevel01 (){
        boolean level01Completo = false;
        int resposta = random.nextInt(99) + 1;
        System.out.println("numero sorteado:" + resposta);
        
        
        for(int i = 0; i < warrior.getVidaInicial() + 1; i++){
            
            if(warrior.getQntdVidas() == 0){                                          //Avisa que o jogador perdeu e encerra o programa caso as vidas
                InOut.MsgDeErro("Oráculo", "Suas vidas acabaram! Você perdeu!");        //tenham acabado
                System.exit(0);
            }
            
            //explicar para o usuario o jogo (a preencher)
            
            
            
            int respostaJogador = InOut.leInt(warrior.getNome() + ", " + "qual o seu palpite?");         //Recebe o palpite do jogador
                
                if(respostaJogador == resposta){                                                    //Se o jogador acertar, a Oráculo avisa o acerto
                    InOut.MsgSemIcone("Oráculo:", "Parabéns!\n Você completou o primeiro nível");
                    level01Completo = true;
                    
                    if(tentativasLevel01 == 0){              //Caso o jogador acerte na primeira tentativa, equipa o item definido
                        warrior.getbolsa(6); //id item supremo
                    }
                    
                    break;
                    
                } else{
                    
                    if(respostaJogador > resposta){                                                                 //Caso o jogador erre, da as dicas de
                        InOut.MsgDeAviso("Oráculo:", "Uma dica: o número secreto é menor que o seu palpite");       //maior ou menor do que o palpite
                    } 
                    else if(respostaJogador < resposta){
                        InOut.MsgDeAviso("Oráculo", "Uma dica: o número secreto é maior que o seu palpite");
                    }
                    
                  warrior.diminuirVida();                     //Guerreiro perde uma vida e tentativas do nível 1 aumenta
                  tentativasLevel01++;
                }
        }
        
        return level01Completo;
    }
    
    public boolean loadLevel02 () {
        
        boolean level02Completo = false;
        
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
            InOut.MsgDeErro("opss, deu red", erro.getMessage());
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
            //explicacao do game com um obs palavras sem potuacao 
            InOut.MsgSemIcone("Parabéns você chegou no nível 2!", "Agora vamos entender como o jogo funciona, ok?");
            InOut.MsgSemIcone("Entendendo o Nível..","Neste nível você digita uma palavra.\nCada letra tem uma pontuação diferente.\nA soma do ponto de cada letra determina sua pontuação final!");
            InOut.MsgSemIcone("DICA", "Tem letras que valem muitos pontos\nEstas compõem palavra mais difíceis no vocabulário.");
            
            
        //1 fase, escreve o tanto que quiser até chegar a 100 pontos
        InOut.MsgSemIcone("Fase Aprendizado", "Sua palavra deve ter uma pontuação total de 100 pontos\nEu sei, você não sabe os pontos de cada letra...\nEntão tente deduzir!");
        do
        {
             String palavra = InOut.leString("Insira sua palavra:").toLowerCase();
             
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
                 InOut.MsgDeAviso("Palavra inválida!", "Estávamos preparados para isso...\nDigite uma palavra válida.");
             }
             //falta inserir a logica das vidas
             if(soma >= 100){
                 InOut.MsgSemIcone("Parabéns!", "Você passou dessa fase com " + soma + " pontos");
             }
             else{
                 InOut.MsgSemIcone("Quase lá..", "Sua pontuação atual: " + soma + " pontos");
             }
        }
        while(soma < 100);
        
        //2 fase tem 3 chances se as palavras nao somarem 600 pontos perde uma vida
        
         InOut.MsgSemIcone("Fase Economia", "Esta fase contém 3 rodadas.\nAo total sua pontuação deve ser maior ou igual a 600");
        do
        {
            soma = 0;
            for(int i = 0; i < 3; i++){
                String palavra = InOut.leString("Insira sua palavra:").toLowerCase();
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
                    InOut.MsgDeAviso("Palavra inválida!", "Estávamos preparados para isso...\nDigite uma palavra válida.");  
                }
                
                if(soma >= 600){
                 InOut.MsgSemIcone("Parabéns!", "Você passou dessa fase com " + soma + " pontos");
                }
                else if(soma > 300){
                    InOut.MsgSemIcone("Não desista!", "Sua pontuação atual: " + soma + " pontos");
                }
                else{
                    InOut.MsgSemIcone("Quase lá..", "Sua pontuação atual: " + soma + " pontos");
                }
            }
            
            //falta inserir a logica das vidas
             
             
        }
        while(soma < 600);
        
        //fase precisao: digitar duas palavras acima de 300 pontos mas a palavra tem que ter no maximo 6 letras
       
        InOut.MsgSemIcone("Fase Precisão", "Esta fase contém 2 rodadas.\nAo total sua pontuação deve ser maior ou igual a 600");
        InOut.MsgSemIcone("", "Achou fácil?\nNão se empolgue..");
        InOut.MsgSemIcone("", "Sua palavra pode ter no máximo 6 letras hahaha");
        do
        {
            soma = 0;
            for(int i = 0; i < 2; i++){
                String palavra = InOut.leString("Insira sua palavra:").toLowerCase();
                
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
                        InOut.MsgDeAviso("Palavra inválida!", "Estávamos preparados para isso...\nDigite uma palavra válida.");  
                    } 
                    
                    if(soma >= 300){
                        InOut.MsgSemIcone("Parabéns!", "Você passou dessa fase com " + soma + " pontos");
                    }
                    else if(soma > 150){
                        InOut.MsgSemIcone("Não desista!", "Sua pontuação atual: " + soma + " pontos");
                    }
                    else{
                        InOut.MsgSemIcone("Quase lá..", "Sua pontuação atual: " + soma + " pontos");
                    }

                }
                else{
                    InOut.MsgDeAviso("Palavra inválida!", "Sua palavra deve conter no máximo 6 letras!");
                }
                
            }
            
            //falta inserir a logica das vidas
             
             
        }
        while(soma < 300);
        
        
        return level02Completo;
        
    }
       
}
