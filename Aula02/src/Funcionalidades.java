import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Funcionalidades {
    Function<Integer, Integer> dobrar = x -> x * 2;
    int resultado = dobrar.apply(5);

    public static List<Integer> aplicarFuncaoLista(List<Integer> lista, Function<Integer, Integer> funcao) {
        List<Integer> novaLista = new ArrayList<>();
        for (Integer item: lista){
            novaLista.add(funcao.apply(item));
        }
        return novaLista;
    }

    List<Integer> numero = Arrays.asList(1,2,3);
    List<Integer> numeroDobrado = aplicarFuncaoLista(numero,dobrar);

    public static List<Integer> acplicarFuncaoLista(List<Integer, Integer> criarMultiplicador(int multiplicador){
        return numero -> numero * multiplicador;
    }
    Function<Integer, Integer> triplicar = criaMultiplicador(3);
    Function<Integer, Integer> quintuplicador = criaMultiplicador(5);

   int resultadoTriplo = triplicar.apply(10);
   int resultadoQuinto = quintuplicador.apply(10);
}


