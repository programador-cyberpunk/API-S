import java.util.Scanner;
public class Calculation {
    // a ideia desse codigo é pegar as notas do semestre do corno em questao
    // e definir se ele vai ou nao passar usando if else e o Scanner
    String nome;
    double nota1;
    double nota2;
    double nota3;
    int res;
    // decidi usar o double pro caso de usar como faculdade e dar a nota quebrada
    public static void main(String[] args){
        Scanner Calculon = new Scanner(System.in);

        //pegando as notas e o nome
       System.out.print("Digite um teu nomne maconheiro: ");
        String nome = Calculon.nextLine();

       System.out.print("Digite um nota 1: ");
       double nota1 = Calculon.nextDouble();
       System.out.print("Digite um nota 2: ");
       double nota2 = Calculon.nextDouble();
       System.out.print("Digite um nota 3: ");
       double nota3 = Calculon.nextDouble();

       Calculation calc = new Calculation(int res = nota1 + nota2 + nota3);
        if(int res =>7){
            System.out.print("Parabens seu corno, vc passou....");
            int res = Calculon.nextLine();
        }else if(res == 7){
            System.out.print("Passou seu corno, mas fica de olho");
        }else{
            System.out.print("Se fudeu, estude mais no proximo semestre corninho");
        }
       }
    }
}
