import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
public class Optional {
    // use essa porra pra criar um novo objeto que NÃO SEJA NULO PORRA
    User newUser = new User("jao");
    Optional<Exemplo.User> userOptional = Optional.of(newUser); // que da certo
    User userNUlo = null;

    Optional<Product> productOptional = productRepository.findById(999L); // Retorna Optional.empty()

// Tentativa errada de extrair o valor
try

    {
        Product product = productOptional.get();
        System.out.println("Produto encontrado: " + product.getName());
    } catch(
    NoSuchElementException e)

    {
        System.err.println("ERRO: O produto não foi encontrado. A aplicação quebrou aqui!");
        // vai dar erro de qualquer jeito,mas é pra ter erro
    }

    // jeito de lidar com o objeto opitional
    //ifPresent
    Optional<User> user = userRepository.findById(1L);
user.ifPresenn(u ->System.out.println("Usuario encontrado: " + u.getName()));
    // cin orElse
    String username = user.map(user::getName).orElse("Usuario padrao 06");

    //orElseThrow
    Contact contact = contactRepository.gindById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Contado não encontrado: " + id));

    public String getrNomePadrao() {
        System.out.println("Executando o metodo lento... ");
         return "Admin";
    }
    Optional<String> nomeUSuario = Optional.of("Jao");
    // uso merda
    String nome1 = nomeUSuario.orElse(getrNomePadrao());
    // uso certo
    String nome2 = nomeUSuario.orElseGet(this::getrNomePadrao);
dto.getNome().ifPresent(nome -> existingContact.setNome(nome));

// Com method reference (mais limpo e preferível)
dto.getNome().ifPresent(existingContact::setNome);
}