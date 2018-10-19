package jogo;
import java.util.Scanner;


public class JogoVelha {
        
    static int TAM = 3, PROF = -1;
   //int[][] jogadas={{0,0},{0,1},{0};
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        Tabuleiro t = new Tabuleiro(TAM);
        
        Minimax mm = new Minimax(TAM,PROF);
        
        System.out.println("Jogo da Velha \n Boa Sorte");
        
        t.imprimirTab();
        
        for(int i=0;i<=4;i++){
        	int l, c;
            System.out.printf("Sua Jogada:\r\nLinha [0 - %d]: ", (TAM - 1));
            l = entrada.nextInt();
            System.out.printf("Coluna [0 - %d]: ", (TAM-1));
            c = entrada.nextInt();
    
           if( t.jogadaValida(l,c))
            t.fazerJogada(l, c);
            t.imprimirTab();
         
           
            if(!mm.teste_terminal(t.tabuleiro)){
                
                Tabuleiro.tabuleiro = mm.decisao_minimax(t.tabuleiro);
                System.out.println("Jogada do Computador");
                t.imprimirTab();
                if(mm.teste_terminal(t.tabuleiro)){
                	break;
                }
            }
            
        }
        
        
        
                if(mm.ganhou(t.tabuleiro, 1)){
                    System.out.println("Computador Ganhou");
                }else{ 
                	if(mm.ganhou(t.tabuleiro, -1)){
                    	System.out.println("Voce Ganhou!!");
                	}else{
                		System.out.println("Empate!");
                	}
                }
   }
}
  
