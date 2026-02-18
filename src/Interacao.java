 import java.util.Scanner;// tem que importar o scanner todas vez que
 // interagir com o usuario, ou seje,essa porra aqui vai ser a base pros exercicios

public class Interacao {
    public static void main(String[] args) {Scanner leitor = new  Scanner(System.in);
        System.out.println("Hello world!");
    }
    String nome;
    int idade;

    Scanner leitor = new Scanner(System.in);
    System.out.print("Digite ai seu nome: ");
    String nome = leitor.nextLine();

    System.out.print("Agora digite sua idade: ");
    int idade = leitor.nextLine();

    System.out.printf("Salve %s! Voce tem %d certo?", nome, idade);
    leitor.close();
}