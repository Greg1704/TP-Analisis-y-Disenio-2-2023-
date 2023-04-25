package modelo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import controlador.Observador;

import java.net.InetAddress;

public class Cliente implements Runnable {

	private Socket cliente;
	private int puertoAConectar;
	private String ipAConectar,ipLocal;
	private BufferedReader in;
	private PrintWriter out;
	private boolean listo = false;
	private List<Observador> observadores = new ArrayList<>();
	
	public Cliente(String ipAConectar, int puerto) {
		this.puertoAConectar = puerto;
		this.ipAConectar = ipAConectar;
		try {
			InetAddress localHost = InetAddress.getLocalHost();
			this.ipLocal = localHost.getHostAddress();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.run();
	}
	
	public void addObserver(Observador channel) {
        this.observadores.add(channel);
    }

    public void removeObserver(Observador channel) {
        this.observadores.remove(channel);
    }
    
	public String getIpLocal() {
		return ipLocal;
	}
	
	@Override
	public void run() {

		try {
			cliente = new Socket(ipAConectar, puertoAConectar);
			out = new PrintWriter(cliente.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
			ManejaInput m = new ManejaInput();
			Thread t = new Thread(m);
			t.start();
			
		} catch (IOException e) {
			// tratar con alguna pavada como cerrar conexion o algo
		}
}
	
	public void mandarMensaje(String mensaje) {
		out.println(mensaje); // SE MANDA DIRECTAMENTE A SERVIDOR. SE VE EN LA VENTANA EL MENSAJE ENVIADO YA QUE SE RECIBE DEL SERVIDOR LUEGO (EN LA PARTE DONDE SE INVOCA REPARTE())
	}
	
	public void cerrarConversacion() {
		listo = true;
		try {
			in.close();
			out.close();
			if (!cliente.isClosed()) {
				cliente.close();
			}
		} catch (IOException e) {
			System.out.println("no cierra cliente porque hay una excepcion");
			System.out.println(e.getLocalizedMessage());
		}
	}
	 
	
	public class ManejaInput implements Runnable {

		@Override
		public void run() {
			try {
				while (!listo) {
					String mensaje;
					while ((mensaje = in.readLine()) != null) {
						if (mensaje.equals("/cerrar/") || mensaje.equals("/enCharla/")) {
							observadores.get(0).mostrarUsuarioOcupado();
							cerrarConversacion();
						} else {
							observadores.get(0).mostrarMensajeTextArea(mensaje); // entra mensaje de servidor, entonces MUESTRO
						}
					}
				}
			} catch (IOException e) {
				cerrarConversacion();
			}
		}
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//	InputUsuario inUsuario = new InputUsuario();
	//	Thread hiloInput = new Thread(inUsuario);
	//	hiloInput.start();
		
	//	String mensajeEntrante;
	//	while ((mensajeEntrante = in.readLine()) != null) {
		//	System.out.println(mensajeEntrante);
			// aca hacer algo para mostrar en ventana de cliente
	//	}
	
	
	
	// TODO ESTO NO SE USARIA
	/*
	public class InputUsuario implements Runnable {

		private BufferedReader input;
		
		@Override
		public void run() {
			try {
			input = new BufferedReader(new InputStreamReader(System.in));
			while (!listo) {
				String mensaje = input.readLine(); // esto hay q cerrarlo
				out.println(mensaje);
			}
			input.close(); // esto habria q fijarse , porq quiero ver si se cierra cuando sale del while
			} catch (IOException e) {
				cerrarConversacion();
			}
			
		}
		/* 
		public void cierraLocalInput() {
			input.close();
		}
		*/ 
	
