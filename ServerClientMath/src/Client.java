import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	
	public static void main(String[] args) throws IOException {
		
		int serverPortNumber = 5000;

		Socket clientSocket = new Socket("localhost", serverPortNumber);

		PrintWriter printWriterObj = new PrintWriter(clientSocket.getOutputStream());
		
		String message = "What is sqrt 4 ?";
		
		String message2 = "What is sin 90 ?";
		
		String message3 = "What is cos 75 ?";
		
		String message4 = "What is add 44 and 33 ?";

		printWriterObj.println(message);
	
		printWriterObj.flush();
	
		InputStreamReader inputStreamReaderObj = new InputStreamReader(clientSocket.getInputStream());

		BufferedReader bufferReaderObj = new BufferedReader(inputStreamReaderObj);

		String receivedMessage = bufferReaderObj.readLine();

		System.out.println(clientSocket.getInetAddress() + " IP adresli ve " + clientSocket.getPort()
		+ " port numarasinin cevabi : " + receivedMessage);
		
	}
}