package es.banco.controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.banco.modelo.Negocio;
import es.banco.modelo.TarjetaCredito;
import es.banco.modelo.TarjetaParaPago;


/**
 * Servlet implementation class RealizarPagoServlet
 */
@WebServlet("/RealizarPago")
public class RealizarPagoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RealizarPagoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String numero=request.getParameter("numero");
		String contrasenha=request.getParameter("contrasenha");
		String numeroComprobacion=request.getParameter("numeroComprobacion");
		int importe=Integer.parseInt(request.getParameter("importe"));
		
		//String tipo=request.getParameter("tipo");
		//int id=Integer.parseInt(request.getParameter("id"));
		
		String comprobarPago=request.getParameter("enviar");
		Negocio negocio= new Negocio();
		TarjetaParaPago tarjetaparapago=negocio.comprobarPago(numero, contrasenha, numeroComprobacion, importe);
		
		// meter la tarjeta en el request.. uso el metodo setAttribute
	    request.setAttribute("tarjetaparapago", tarjetaparapago);
	    String n="codigo sin terminar";
		//String mensaje=negocio.actualizar(id,matricula,marca,modelo,color,numCaballos,marchas);
		request.setAttribute("mensaje", n);
		RequestDispatcher rd=request.getRequestDispatcher("vistaMensaje.jsp");
		rd.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
  
	
}
		
	

