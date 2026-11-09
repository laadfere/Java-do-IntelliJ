package br.edu.udf.backendseguro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.security.SecureRandom;
import java.util.Base64;

@SpringBootApplication
public class BackendseguroApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendseguroApplication.class, args);
        // Gerar Chave
        //jwtSecret();
    }

    private static void jwtSecret() {
        // Cria um array de 32 bytes (256 bits) para armazenar a chave secreta
        byte[] randomBytes = new byte[32];
        // Gera bytes aleatórios criptograficamente seguros e preenche o array
        new SecureRandom().nextBytes(randomBytes);

        // Converte a chave binária para uma string em Base64,
        // facilitando o armazenamento em arquivos de configuração
        String base64Key = Base64.getEncoder().encodeToString(randomBytes);

        // Exibe um cabeçalho informativo no console
        System.out.println("=== CHAVE JWT GERADA DINAMICAMENTE (256 bits) ===");
        // Exibe a propriedade pronta para ser copiada para o application.properties ou yaml
        System.out.println("app.jwt.secret=" + base64Key);
        // Exibe um rodapé para destacar a saída no console
        System.out.println("=================================================");
    }
}