import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Servidor {
    public static void main(String args[]) {
        try (ServerSocket servidor = new ServerSocket(5000)) {
            // LAÇO EXTERNO: Mantém o servidor rodando para sempre, aceitando novos clientes
            while (true) {
                try (Socket conexao = servidor.accept();
                        DataInputStream entrada = new DataInputStream(conexao.getInputStream());
                        DataOutputStream saida = new DataOutputStream(conexao.getOutputStream())) {

                    // LAÇO INTERNO: Mantém as múltiplas rodadas com o cliente que acabou de
                    // conectar
                    while (true) {

                        String jogadaCliente = entrada.readUTF();

                        String[] jogadas = { "PEDRA", "PAPEL", "TESOURA" };

                        // gerar número aleatório e mapear para as possíveis jogadas
                        Random random = new Random();
                        int indiceAleatorio = random.nextInt(3);

                        String jogadaServidor = jogadas[indiceAleatorio];
                        String resultadoJogo = "inseriu uma jogada inválida.";

                        if (jogadaServidor.equals(jogadaCliente)) {
                            resultadoJogo = "empatou.";
                        }

                        else if (jogadaCliente.equals("PEDRA")) {
                            if (jogadaServidor.equals("PAPEL"))
                                resultadoJogo = "perdeu.";
                            else if (jogadaServidor.equals("TESOURA"))
                                resultadoJogo = "ganhou!";
                        }

                        else if (jogadaCliente.equals("TESOURA")) {
                            if (jogadaServidor.equals("PAPEL"))
                                resultadoJogo = "ganhou!";
                            else if (jogadaServidor.equals("PEDRA"))
                                resultadoJogo = "perdeu.";
                        }

                        else if (jogadaCliente.equals("PAPEL")) {
                            if (jogadaServidor.equals("PEDRA"))
                                resultadoJogo = "ganhou!";
                            else if (jogadaServidor.equals("TESOURA"))
                                resultadoJogo = "perdeu.";
                        }

                        String placar = "Servidor jogou " + jogadaServidor + ". Você " + resultadoJogo;

                        saida.writeUTF(placar);
                    }

                } catch (IOException e) {
                    // Quando o cliente digitar "SAIR" e fechar o app, a conexão cai.
                    // O erro vem para cá, este loop interno acaba, mas o laço externo
                    // continua rodando e volta para o servidor.accept() esperando o próximo
                    // jogador.
                    System.out.println("Cliente desconectado. Aguardando novo jogador...");
                }
            }
        } catch (IOException e) {
            System.out.println("Não foi possível iniciar o servidor na porta 5000.");
            e.printStackTrace();
        }
    }
}
