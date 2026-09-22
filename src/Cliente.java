import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String args[]) {
        try (Socket conexao = new Socket("127.0.0.1", 5000);
                DataOutputStream jogadaCliente = new DataOutputStream(conexao.getOutputStream());
                DataInputStream jogadaServidor = new DataInputStream(conexao.getInputStream());
                Scanner scanner = new Scanner(System.in);) {

            System.out.println("Seja bem-vindo(a) ao Jogo - Pedra, Papel e Tesoura");
            while (true) {
                System.out.println("Digite a sua jogada (PEDRA, PAPEL, TESOURA) ou SAIR para terminar: ");
                String jogada = scanner.nextLine();
                if(jogada.equalsIgnoreCase("SAIR")) {
                    break;
                }
                jogada = jogada.toUpperCase();

                // Request
                jogadaCliente.writeUTF(jogada);
                // Response
                String resposta = jogadaServidor.readUTF();
                System.out.println(resposta);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
