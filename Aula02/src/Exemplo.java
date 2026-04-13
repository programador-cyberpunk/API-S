import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Exemplo {

    // Método que simula uma operação custosa (ex: acesso a banco, chamada de API)
    public static String getExpensiveDefaultValue() {
        System.out.println(">>> Executando método custoso para obter valor padrão...");
        // Simula um delay
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "default_value";
    }

    public static void main(String[] args) {
        Map<String, String> configs = Map.of("key1", "value1");

        System.out.println("--- Teste com um Optional que contém valor ---");
        Optional<String> optionalWithValue = Optional.of("value1");

        // Usando orElse(): O método custoso SERÁ chamado desnecessariamente.
        System.out.println("Usando orElse():");
        String value1 = optionalWithValue.orElse(getExpensiveDefaultValue());
        System.out.println("Resultado: " + value1);

        System.out.println("\n"); // Separador

        // Usando orElseGet(): O método custoso NÃO será chamado.
        System.out.println("Usando orElseGet():");
        String value2 = optionalWithValue.orElseGet(() -> getExpensiveDefaultValue()); // ou OptionalExample::getExpensiveDefaultValue
        System.out.println("Resultado: " + value2);

        System.out.println("\n--- Teste com um Optional vazio ---");
        Optional<String> emptyOptional = Optional.empty();

        // Com Optional vazio, ambos chamarão o método, mas orElseGet() continua sendo a prática mais segura.
        System.out.println("Usando orElse() com Optional vazio:");
        String value3 = emptyOptional.orElse(getExpensiveDefaultValue());
        System.out.println("Resultado: " + value3);
    }
    // Simula uma entidade do banco de dados
    class User {
        private Long id;
        private String name;
        private String email;
        // Construtores, Getters e Setters...
        public User(Long id, String name, String email) { this.id = id; this.name = name; this.email = email; }
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        @Override public String toString() { return "User{id=" + id + ", name='" + name + "', email='" + email + "'}"; }
    }

    // Simula a classe que acessa o banco de dados
    class UserRepository {
        // Um mapa para simular nossa tabela de usuários no banco
        private final Map<Long, User> database = new HashMap<>();

        public UserRepository() {
            // Populando o "banco" com dados iniciais
            database.put(1L, new User(1L, "Ana", "ana@email.com"));
            database.put(2L, new User(2L, "Carlos", "carlos@email.com"));
        }

        // O método de busca já retorna um Optional, como faz o Spring Data JPA
        public Optional<User> findById(Long id) {
            return Optional.ofNullable(database.get(id));
        }

        public User save(User user) {
            database.put(user.id, user);
            return user;
        }
    }
   //Simula a camada de serviço com a lógica de negócio
    class UserService {
        private final UserRepository userRepository;

        public UserService(UserRepository userRepository) {
            this.userRepository = userRepository;
        }

        public Optional<User> updateUserEmail(Long userId, String newEmail) {
            // 1. Busca o usuário. O retorno já é um Optional<User>.
            return userRepository.findById(userId)
                    .filter(user -> isEmailValid(newEmail)) // 2. Continua apenas se o email for válido.
                    .map(user -> {                          // 3. Se tudo estiver ok, transforma o objeto.
                        user.setEmail(newEmail);
                        return userRepository.save(user);   // 4. Salva e retorna o usuário atualizado.
                    });
        }

        private boolean isEmailValid(String email) {
            return email != null && email.contains("@");
        }
    }
    // Simula a camada que recebe as "requisições"
    class UserController {
        private final UserService userService;

        public UserController(UserService userService) {
            this.userService = userService;
        }

        public String handleUpdateEmailRequest(Long id, String newEmail) {
            // O "Controller" chama o serviço e lida com o Optional retornado.
            return userService.updateUserEmail(id, newEmail)
                    .map(user -> "200 OK - Usuário atualizado: " + user.toString()) // Se sucesso, formata a resposta OK.
                    .orElse("404 Not Found - Usuário não encontrado ou email inválido."); // Se vazio, formata a resposta de erro.
        }
    }

    // Ponto de entrada da nossa aplicação simulada
    public class MainApplication {
        public static void main(String[] args) {
            // Injeção de dependência manual: criamos e conectamos as camadas.
            UserRepository userRepository = new UserRepository();
            UserService userService = new UserService(userRepository);
            UserController userController = new UserController(userService);

            // --- Simulação das Requisições ---

            // Teste 1: Caso de sucesso
            System.out.println("Tentativa 1: Atualizando usuário com ID 1...");
            String response1 = userController.handleUpdateEmailRequest(1L, "ana.nova@email.com");
            System.out.println("Resposta: " + response1);
            System.out.println("--------------------");

            // Teste 2: Caso de falha (usuário não existe)
            System.out.println("Tentativa 2: Atualizando usuário com ID 99...");
            String response2 = userController.handleUpdateEmailRequest(99L, "fantasma@email.com");
            System.out.println("Resposta: " + response2);
        }
    }
    // Com lambda

}
