import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
 
public class Server {

	public static void main(String[] args) throws IOException {
		int portNumber = 5000;
		double yanit = 0.0;

		ServerSocket serverSocketObj = new ServerSocket(portNumber); 

		System.out.println(serverSocketObj.getLocalPort() + " numarali port uzerinden mesaj bekliyorum..");

		Socket connectionSocketObj = serverSocketObj.accept(); 

		System.out.println("Client soruyor...");

		InputStreamReader inputStreamReaderObj = new InputStreamReader(connectionSocketObj.getInputStream());

		BufferedReader bufferReaderObj = new BufferedReader(inputStreamReaderObj);

		String questionMessage = bufferReaderObj.readLine();
		
		System.out.println(connectionSocketObj.getInetAddress() + " IP adresli ve " + connectionSocketObj.getPort()
		+ " port numarasinin sorusu : " + questionMessage);

		String[] diziStrings = questionMessage.split(" ");
		
		String questionString = diziStrings[2];
				
		if(questionString.equals("sqrt")) {
			double sayi =Double.parseDouble(diziStrings[3]);
			yanit = Math.sqrt(sayi);
		}
		else if(questionString.equals("sin")) {
			double sayi = Double.parseDouble(diziStrings[3]);
			yanit = Math.sin(sayi);
		}
		else if(questionString.equals("cos")) {
			double sayi = Double.parseDouble(diziStrings[3]);
			yanit = Math.cos(sayi);
		}
		else if(questionString.equals("add")) {
			int sayi1 = Integer.parseInt(diziStrings[3]);
			int sayi2 = Integer.parseInt(diziStrings[5]);
			yanit = Math.addExact(sayi1, sayi2);
		}
		
		System.out.println(yanit);

		PrintWriter printWriterObj = new PrintWriter(connectionSocketObj.getOutputStream());

		printWriterObj.println(yanit);

		printWriterObj.flush();

	}
	
}
