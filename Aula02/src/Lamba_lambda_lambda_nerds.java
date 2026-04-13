import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Lamba_lambda_lambda_nerds {
    // antes do lambda
    Collections.sort(nome, new Comparator<String>(){
            @Override
             public int compare;(String s1, String s2){
                return Integer.compare(s1.length(), s2.length());
        }
    });
    // como lambda
Collections.sort(nomes, (s1, s2) -> Integer.compare(s1.length(), s2.length()));

//par ou impar
Predicate<Integer> isEven = numero-> numero % 2 == 0;
System.out.println(isEven(10));

// transforma a string no seu comprimento (*INTEGER)
    Function<String, Integer> getLength = texto -> texto.length();
System.out.println(getLength.apply("Java"));

//agora com um void
    Consumer<String> printText = texto -> System.out.println(texto);
    printText.accept("Salve Satanas");

 //suplier
 Supplier<LocalDateTime> now = () -> LocalDateTime.now();
 System.out.println(now.get());

 //interfaces
    @FunctionalInterface
     public interface TextFormatter{
        String format(String text);

     //converter maiusculas
     TextFormatter toUpperCase = text -> texto.toUpperCase();

     //exclama
     TextFormatter toUpperCase = text -> texto + "!!!";
        System.out.println(toUpperCase.format("java"));
        System.out.println(addExclamation.format("Atenção"));
 }
}
