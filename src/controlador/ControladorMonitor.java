package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import controlador.ControladorServer;
import controlador.IComunicacion;
import modelo.Mensaje;
import modelo.Monitor;
import ventana.IVista;
import ventana.VentanaMonitor;

public class ControladorMonitor implements ActionListener, IComunicacion, WindowListener {

	Monitor monitor;
	VentanaMonitor vm;
	private static ControladorMonitor instancia = null;
	
	public ControladorMonitor() {
		this.monitor = Monitor.getInstance();
		this.vm = new VentanaMonitor();
		this.vm.setControlador(this);
	}
	
	public static ControladorMonitor getInstancia() {
		if (instancia == null)
			instancia = new ControladorMonitor();
		return instancia;
	}
	
	
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mostrarIntentoDeConexion(String ip, int puerto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mostrarMensajeTextArea(Mensaje mensaje) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mostrarUsuarioOcupado() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mostrarUsuarioNoDisponible() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mostrarCierreSesion() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mostrarConexionErronea() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mostrarConexxionErroneaServer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mostrarPuertoErroneo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mostrarPuertoEnUso() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cerrarInstancia() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void aceptaInicioSesion() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mandarMensaje(Mensaje mensaje) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(IVista.cerrarMonitor)) {
			System.exit(0);
	}
		
	}

}
