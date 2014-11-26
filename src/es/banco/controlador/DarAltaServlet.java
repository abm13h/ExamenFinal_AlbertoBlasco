package es.banco.controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.banco.modelo.TarjetaCredito;
import es.banco.modelo.Negocio;

/**
 * Servlet implementation class DarAltaServlet
 */
@WebServlet("/DarAlta")
public class DarAltaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DarAltaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String numero=request.getParameter("numero");
		int cupoMaximo=Integer.parseInt(request.getParameter("cupoMaximo"));
		int cupoDisponible=Integer.parseInt(request.getParameter("cupoDisponible"));
		String tipo=request.getParameter("tipo");
		String tipoBBDD;
		if(tipo.equals("tipoV")){
			tipoBBDD="VISA";
		}else{
			tipoBBDD="MasterCard";
		}
		String numeroComprobacion=request.getParameter("numeroComprobacion");
		String contrasenha=request.getParameter("contrasenha");
		
		Negocio negocio= new Negocio();
		int id=negocio.DarAlta(numero, cupoMaximo, cupoDisponible, tipoBBDD, numeroComprobacion, contrasenha);
		TarjetaCredito e=negocio.consultarUno(id);
		request.setAttribute("coche",e);
		//redirigir a la vistaIndividual
		RequestDispatcher rd;
		rd= request.getRequestDispatcher("vistaIndividual.jsp");
		rd.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
}
		
		
	     
		
	

