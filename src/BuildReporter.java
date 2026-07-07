package src;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BuildReporter {
    public static void main(String[] args) {
        // Coleta a data e hora do momento exato do Build
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        
        // Estrutura o HTML que será o artefato de entrega
        String htmlContent = "<!DOCTYPE html>\n" +
                "<html lang='pt-BR'>\n" +
                "<head>\n" +
                "    <meta charset='UTF-8'>\n" +
                "    <meta name='viewport' content='width=device-width, initial-scale=1.0'>\n" +
                "    <title>Pipeline de CI/CD - CEUB</title>\n" +
                "    <link href='[https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css](https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css)' rel='stylesheet'>\n" +
                "</head>\n" +
                "<body class='bg-gray-100 flex items-center justify-center h-screen'>\n" +
                "    <div class='bg-white p-8 rounded-lg shadow-xl text-center max-w-md w-full border-t-8 border-green-500'>\n" +
                "        <div class='text-green-500 text-6xl mb-4'>✓</div>\n" +
                "        <h1 class='text-2xl font-bold mb-2 text-gray-800'>Build & Deploy Automatizados</h1>\n" +
                "        <p class='text-gray-600 mb-6 font-semibold'>Oficina de Gerência de Configuração - Pós-Graduação CEUB</p>\n" +
                "        \n" +
                "        <div class='bg-green-50 border border-green-200 p-4 rounded-md mb-6'>\n" +
                "            <span class='text-xs text-green-700 font-bold uppercase tracking-wider block mb-1'>Status do Ambiente</span>\n" +
                "            <p class='text-lg font-bold text-green-800'>PRODUÇÃO ONLINE</p>\n" +
                "        </div>\n" +
                "        \n" +
                "        <div class='text-left text-sm text-gray-700 bg-gray-50 p-4 rounded border border-gray-200 mb-4'>\n" +
                "            <p><strong>Tecnologia de Build:</strong> Java Compiler & Executor</p>\n" +
                "            <p><strong>Orquestrador:</strong> GitHub Actions Pipeline</p>\n" +
                "            <p class='mt-2'><strong>Data de Construção:</strong> <span class='text-blue-600 font-mono'>" + timestamp + " UTC</span></p>\n" +
                "        </div>\n" +
                "        <p class='text-xs text-gray-400 mt-6'>Gerência de Configuração e Automação de Software</p>\n" +
                "    </div>\n" +
                "    <p> Aluno Lucca presente </p> \n" +
                "</body>\n" +
                "</html>";

        // Grava o arquivo index.html que será servido no GitHub Pages
        try (FileWriter writer = new FileWriter("index.html")) {
            writer.write(htmlContent);
            System.out.println("Sucesso: Relatório de Build 'index.html' gerado com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro crítico ao gerar o relatório: " + e.getMessage());
            System.exit(1); // Força falha no processo de Build
        }
    }
}
