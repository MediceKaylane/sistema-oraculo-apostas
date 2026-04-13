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
        
        try
        {
            File arq = new File("br-sem-acentos.txt"); //obj aponta para o arquivo txt
            Scanner leitorArq = new Scanner (arq); //"fopen(arq, "r");
            
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
            System.out.println("opss, deu red");
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
            
        //1 fase, escreve o tanto que quiser até chegar a 50 pontos
        do
        {
             String palavra = InOut.leString("Insira sua palavra:").toLowerCase();
        
            for(char letra : palavra.toCharArray())
            {
                if (tabelaPontuacao.containsKey(letra))
                {
                    Integer valor = tabelaPontuacao.get(letra);
                    soma += valor;
                    System.out.println("Pontuacao" + soma);
                }
            }

        }
        while(soma < 50);
       
        
        
        return level02Completo;
        
    }
       
}
