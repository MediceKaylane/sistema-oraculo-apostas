import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/** 
 * A classe <i>leDadosWin</i> permite a leitura de dados de tipos nativos e de   
 * instancias da classe <i>String</i> a partir do teclado, atraves de uma 
 * janela. Basicamente esta classe encapsula o funcionamento dos metodos da clase
 * <i>JOptionPane</i>, que pode ser usado como entrada padrao de dados.
 * <ul>
 * <li>Os metodos sao estaticos para facilitar o uso da classe
 * <li>Criacao de metodos sobrecarregados para que valores <i>default</i> possam ser 
 *     usados
 * <li>Tratamento das excecoes
 * </ul>  
 */
public class InOut {
	/**
	 * Este metodo eh para entrada de uma String. Tem como parametro de entrada
	 * uma String que indicara para o usuario qual o dado que sera lido naquele
	 * momento por aquela caixa de texto e retorna a String lida
	 * 
	 * @param frase que sera usada para o usuario saber qual dado sera lido
	 * @return String que foi lida
	 */
	public static String leString (String frase){
		String Entrada;
		
		Entrada = JOptionPane.showInputDialog (null, frase, "Entrada de dados", JOptionPane.QUESTION_MESSAGE);
		return Entrada;
	}
	
	/**
	 * Este metodo eh para entrada de um objeto do tipo byte. Tem como parametro 
	 * de entrada uma String que indicara para o usuario qual o dado que sera 
	 * lido naquele momento por aquela caixa de texto. 
	 * Le entao uma String e a converte para um objeto do tipo byte. 
	 * Se na conversao ocorrer algum erro, o processo sera feito novamente, 
	 * ou seja, sera lida outra String e convertida para byte. O processo soh 
	 * para quando a conversao for bem sucedida.  
	 * 
	 * @param frase que sera usada para o usuario saber qual dado sera lido
	 * @return um objeto do tipo byte
	 */
	public static byte leByte (String frase){
		byte num = 0;
		String Entrada;
		boolean ERRO;
		
		do{
			try{
				Entrada = JOptionPane.showInputDialog (null, frase, "Entrada de dados", JOptionPane.QUESTION_MESSAGE);
				num = Byte.parseByte(Entrada);
				ERRO = false;
			}
			catch(NumberFormatException e){
				JOptionPane.showMessageDialog(null, "VALOR DEVE SER UM NUMERO DO TIPO " +
								    "BYTE", "   >>>      ERRO     <<<", 
								    JOptionPane.ERROR_MESSAGE);
				ERRO = true;
			}
		}while (ERRO);	
		return num;
	}
	
	/**
	 * Este metodo eh para entrada de um objeto do tipo short. Tem como parametro 
	 * de entrada uma String que indicara para o usuario qual o dado que sera
	 * lido naquele momento por aquela caixa de texto. 
	 * Le entao uma String e a converte para um objeto do tipo short. 
	 * O processo so para quando a conversao for bem sucedida.  
	 * 
	 * @param frase que sera usada para o usuario saber qual dado sera lido
	 * @return um objeto do tipo short
	 */
	public static short leShort (String frase){
		short num=0;
		String Entrada;
		boolean ERRO;
		
		do{
			try{
				Entrada = JOptionPane.showInputDialog (null, frase, "Entrada de dados", JOptionPane.QUESTION_MESSAGE);
				num = Short.parseShort(Entrada);
				ERRO = false;
			}
			catch(NumberFormatException e){
				JOptionPane.showMessageDialog(null, "VALOR DEVE SER UM NUMERO DO TIPO " +
								    "SHORT", "   >>>      ERRO     <<<", 
								    JOptionPane.ERROR_MESSAGE);
				ERRO = true;
			}
		}while (ERRO);	
		return num;
	}
	
	/**
	 * Este metodo eh para entrada de um objeto do tipo int. Tem como parametro 
	 * de entrada uma String que indicara para o usuario qual o dado que sera 
	 * lido naquele momento por aquela caixa de texto. 
	 * Le entao uma String e a converte para um objeto do tipo int. 
	 * O processo so para quando a conversao for bem sucedida.  
	 * 
	 * @param frase que sera usada para o usuario saber qual dado sera lido
	 * @return um objeto do tipo int
	 */
	public static int leInt (String frase){
		int num = 0;
		String Entrada;
		boolean ERRO;
		
		do{
			try{
				Entrada = JOptionPane.showInputDialog (null, frase, "Entrada de dados", JOptionPane.QUESTION_MESSAGE);
				num = Integer.parseInt(Entrada);
				ERRO = false;
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null, "VALOR DEVE SER UM NUMERO DO TIPO " +
								    "INTEIRO ", "   >>>      ERRO     <<<", 
								    JOptionPane.ERROR_MESSAGE);
				ERRO = true;
			}
		}while (ERRO);		
		return num;
	}
	
	/**
	 * Este metodo eh para entrada de um objeto do tipo long. Tem como parametro 
	 * de entrada uma String que indicara para o usuario qual o dado que sera
	 * lido naquele momento por aquela caixa de texto. 
	 * Le entao uma String e a converte para um objeto do tipo long. 
	 * O processo so para quando a conversao for bem sucedida.  
	 * 
	 * @param frase que sera usada para o usuario saber qual dado sera lido
	 * @return um objeto do tipo long
	 */
	public static long leLong (String frase){
		long num = 0;
		String Entrada;
		boolean ERRO;
		
		do{
			try{
				Entrada = JOptionPane.showInputDialog (null, frase, "Entrada de dados", JOptionPane.QUESTION_MESSAGE);
				num = Long.parseLong(Entrada);
				ERRO = false;
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null, "VALOR DEVE SER UM NUMERO DO TIPO " +
								    "LONG ", "   >>>      ERRO     <<<", 
								    JOptionPane.ERROR_MESSAGE);
				ERRO = true;
			}
		}while (ERRO);		
		return num;
	}

	/**
	 * Este metodo eh para entrada de um objeto do tipo float. Tem como parametro 
	 * de entrada uma String que indicara para o usuario qual o dado que sera 
	 * lido naquele momento por aquela caixa de texto. 
	 * Le entao uma String e a converte para um objeto do tipo float. 
	 * O processo so para quando a conversao for bem sucedida.  
	 * 
	 * @param frase que sera usada para o usuario saber qual dado sera lido
	 * @return um objeto do tipo float
	 */
	public static float leFloat (String frase){
		float num = 0;
		String Entrada;
		boolean ERRO;
		
		do{
			try{
				Entrada = JOptionPane.showInputDialog (null, frase, "Entrada de dados", JOptionPane.QUESTION_MESSAGE);
				num = Float.parseFloat(Entrada);
				ERRO = false;
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null, "VALOR DEVE SER UM NUMERO DO TIPO " +
 								    "FLOAT", "   >>>      ERRO     <<<", 
								    JOptionPane.ERROR_MESSAGE);
				ERRO = true;
			}
		}while (ERRO);	
		return num;
	}

	/**
	 * Este metodo eh para entrada de um objeto do tipo double. Tem como paraametro 
	 * de entrada uma String que indicara para o usuario qual o dado que sera
	 * lido naquele momento por aquela caixa de texto. 
	 * Le entao uma String e a converte para um objeto do tipo double. 
	 * O processo so para quando a conversao for bem sucedida.  	 
	 * 
	 * @param frase que sera usada para o usuario saber qual dado sera lido
	 * @return um objeto do tipo double
	 */
	public static double leDouble (String frase){
		double num = 0;
		String Entrada;
		boolean ERRO;
		
		do{
			try{
				Entrada = JOptionPane.showInputDialog (null, frase, "Entrada de dados", JOptionPane.QUESTION_MESSAGE);
				num = Double.parseDouble(Entrada);
				ERRO = false;
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null, "VALOR DEVE SER UM NUMERO DO TIPO " +
								    "DOUBLE", "   >>>      ERRO     <<<", 
								    JOptionPane.ERROR_MESSAGE);
				ERRO = true;
			}
		}while (ERRO);	
		return num;
	}

	/**
	 * Este metodo eh para entrada de um objeto do tipo char. Tem como parametro 
	 * de entrada uma String que indicara para o usuario qual o dado que sera
	 * lido naquele momento por aquela caixa de texto. 
	 * Le entao uma String e retorna apenas o primeiro caracter da String.  
	 * 
	 * @param frase que sera usada para o usuario saber qual dado sera lido
	 * @return um objeto do tipo char
	 */
	public static char leChar (String frase){
		String Entrada;
		boolean ERRO;
		
		do{
			Entrada = JOptionPane.showInputDialog (null, frase, "Entrada de dados", JOptionPane.QUESTION_MESSAGE);
			if (Entrada.length()!= 0)
				ERRO = false;
			else
				ERRO = true;
		}while (ERRO);
		return Entrada.charAt(0);
	}
        
        /**
        * Exibe uma mensagem com o ícone do guerreiro.
        * 
        * @param frase mensagem a ser exibida
        */

        public static void iconeGuerreiro(String frase){

            ImageIcon icon = new ImageIcon(
                "src/img/guerreiro.jpeg"
            );

            JOptionPane.showMessageDialog(
                null,
                frase,
                "Guerreiro",
                JOptionPane.INFORMATION_MESSAGE,
                icon
            );
        }
        
        /**
        * Exibe uma caixa de entrada com o ícone do guerreiro
        * e retorna o texto digitado pelo usuário.
        * 
        * @param frase mensagem exibida ao usuário
        * @return texto digitado
        */
        
        public static String leStringGuerreiro(String frase){
            String Entrada;

            ImageIcon icon = new ImageIcon(
                "src/img/guerreiro.jpeg"
            );

            Entrada = (String) JOptionPane.showInputDialog( 
                null, 
                frase, 
                "Entrada de dados", 
                JOptionPane.QUESTION_MESSAGE, 
                icon, 
                null, 
                null 
            ); 
            return Entrada;
        }
        
        
        /**
        * Lê um número inteiro do usuário com tratamento de erro.
        * Continua pedindo até o usuário digitar um valor válido.
        * 
        * @param frase mensagem exibida
        * @return número inteiro digitado ou -1 se cancelar
        */
        
        public static int leIntGuerreiro(String frase){
            int num = 0;
            String entrada;
            boolean erro;

            ImageIcon icon = new ImageIcon(
                "src/img/guerreiro.jpeg"
            );

            do {
                try {
                    entrada = (String) JOptionPane.showInputDialog(
                        null,
                        frase,
                        "Entrada de dados",
                        JOptionPane.QUESTION_MESSAGE,
                        icon,
                        null,
                        null
                    );

                    // se cancelar
                    if (entrada == null) {
                        return -1;
                    }

                    num = Integer.parseInt(entrada);
                    erro = false;

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(
                        null,
                        "Digite um número inteiro válido!",
                        ">>> ERRO <<<",
                        JOptionPane.ERROR_MESSAGE,
                        icon
                    );
                    erro = true;
                }

            } while (erro);

            return num;
        }
        
        /**
        * Exibe uma mensagem com o ícone do oráculo.
        * 
        * @param nome nome do oráculo
        * @param frase mensagem a ser exibida
        */

        public static void iconeOraculo(String nome, String frase){

            ImageIcon icon = new ImageIcon(
                "src/img/oraculo.jpeg"
            );

            JOptionPane.showMessageDialog(
                null,
                frase,
                "Oráculo " + nome,
                JOptionPane.INFORMATION_MESSAGE,
                icon
            );
        }
        
        /**
        * Exibe uma caixa de entrada com o ícone do oráculo
        * e retorna o texto digitado.
        * 
        * @param frase mensagem exibida
        * @return texto digitado pelo usuário
        */
        
        public static String leStringOraculo(String frase){
            String Entrada;

            ImageIcon icon = new ImageIcon(
                "src/img/oraculo.jpeg"
            );

            Entrada = (String) JOptionPane.showInputDialog( 
                null, 
                frase, 
                "Entrada de dados", 
                JOptionPane.QUESTION_MESSAGE, 
                icon, 
                null, 
                null 
            ); 
            return Entrada;
        }

	
	/**
	 * Este metodo foi criado para mandar uma mensagem com o icone de
	 * ERRO
	 *  
	 * @param cabecalho que aparecera no topo da mensagem
	 * @param frase     que aparecera dentro da caixa de mensagem
	 */
	public static void MsgDeErro(String cabecalho, String frase){
		JOptionPane.showMessageDialog(null, frase, cabecalho,  JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Este metodo foi criado para mandar uma mensagem com o icone de
	 * INFORMACAO
	 *  
	 * @param cabecalho que aparecer no topo da mensagem
	 * @param frase     que aparecera dentro da caixa de mensagem
	 */
	public static void MsgDeInformacao(String cabecalho, String frase){
		JOptionPane.showMessageDialog(null, frase, cabecalho, JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Este metodo foi criado para mandar uma mensagem sem icone 
	 *  
	 * @param cabecalho que aparecera no topo da mensagem
	 * @param frase     que aparecera dentro da caixa de mensagem
	 */
	public static void MsgSemIcone(String cabecalho, String frase){
		JOptionPane.showMessageDialog(null, frase, cabecalho, JOptionPane.PLAIN_MESSAGE);
	}
	
	/**
	 * Este metodo foi criado para mandar uma mensagem com o icone de
	 * AVISO
	 *  
	 * @param cabecalho que aparecera no topo da mensagem
	 * @param frase     que aparecera dentro da caixa de mensagem
	 */
	public static void MsgDeAviso (String cabecalho, String frase){
		JOptionPane.showMessageDialog(null, frase, cabecalho, JOptionPane.WARNING_MESSAGE);
	}
	
	
/**
 * Exemplos...
 * @param args : Entrada de dados do cmd
 */
        //public static void main(String [] args){
        void main() {
		String nome = leString("Digite o seu nome: ");
		int idade = leInt("Digite a sua idade: ");
		
		MsgDeInformacao("MsgDeInformacao", nome + " tem " + idade + " anos." );
		MsgSemIcone("MsgSemIcone", nome + " tem " + idade + " anos." );
		MsgDeAviso("MsgDeAviso", nome + " tem " + idade + " anos." );
	}
}
