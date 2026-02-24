import java.util.Scanner;
public class Calculation {
    // a ideia desse codigo é pegar as notas do semestre do corno em questao
    // e definir se ele vai ou nao passar usando if else e o Scanner
    String nome;
    double nota1;
    double nota2;
    double nota3;
    double media;
    // decidi usar o double pro caso de usar como faculdade e dar a nota quebrada
    public static void main(String[] args){
        Scanner Calculon = new Scanner(System.in);

        //pegando as notas e o nome
       System.out.print("Digite um teu nome maconheiro: ");
        String nome = Calculon.nextLine();

       System.out.print("Digite um nota 1: ");
       double nota1 = Calculon.nextDouble();
       System.out.print("Digite um nota 2: ");
       double nota2 = Calculon.nextDouble();
       System.out.print("Digite um nota 3: ");
       double nota3 = Calculon.nextDouble();
       double media = (nota1 + nota2 + nota3) / 3;

        System.out.print("Resultado de "+nome+": "+media);

        //logica do if
        if(media>7){

        }else{
            System.out.println("Se fudeu, estude mais no proximo semestre!");
        }
       }
    }
}
