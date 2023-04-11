import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable {

    public static ArrayList<ClientHandler> clientHandlers = new ArrayList<>(); //Forma de percorrer os clientes e enviar a mensagem para todos;
    private Socket socket;
    private BufferedReader bufferedReader; //Para ler;
    private BufferedWriter bufferedWriter; //Para escrever;
    private String clientUsername;
    public ClientHandler(Socket socket) { //É o unico argumento necessario de passar no construtor, devido á instanciaçao no Server;
        try {
            this.socket = socket;
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); //Enviar informação;
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream())); //Ler informação;
            this.clientUsername = bufferedReader.readLine(); // Ler o input do cliente e associar a nome;
            clientHandlers.add(this); //Adicionar clientes a ClientHandler, atraves da referencia "this";
            broadcastMessage("SERVER : " + clientUsername + " has entered the chat!"); // Envia mensagem para todos os clientes, a avisar que alguem entrou no chat;
        } catch (IOException e) {
            closeEverything(socket, bufferedReader, bufferedWriter); //Método para terminar as sockets e streams;
        }
    }
    @Override
    public void run() {
        String messageFromClient;

        while (socket.isConnected()) { //Enquanto a socket estiver conectada;
            try {
                messageFromClient = bufferedReader.readLine(); //Lê a o input da mensagem e emite para todos os clientes;
                broadcastMessage(messageFromClient);
            } catch (IOException e) {
                closeEverything(socket, bufferedReader, bufferedWriter);
                break;
            }
        }
    }
    public void broadcastMessage(String messageToSend) {
        for (ClientHandler clientHandler : clientHandlers) { // Para cada ch em ch's, percorre a ArrayList;
            try {
                if (!clientHandler.clientUsername.equals(clientUsername));
                     //Se o cliente nao for ele proprio, envia, passa para a proxima linha;
                clientHandler.bufferedWriter.write(messageToSend);
                clientHandler.bufferedWriter.newLine();
                clientHandler.bufferedWriter.flush();
            } catch (IOException e) {
                closeEverything(socket, bufferedReader, bufferedWriter);
            }
        }
    }
    public void removeClientHandler() { //Ao remover client do chat, enviar mensagem para todos a avisar;
        clientHandlers.remove(this);
        broadcastMessage("SERVER: " + clientUsername + " has left the chat!");
    }
    public void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter){
        removeClientHandler();
        //Método para fechar as streams e sockets;
        try{
            if(bufferedReader != null){
                bufferedReader.close();
            }
            if(bufferedWriter != null){
                bufferedWriter.close();
            }
            if(socket != null){
                socket.close();
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
