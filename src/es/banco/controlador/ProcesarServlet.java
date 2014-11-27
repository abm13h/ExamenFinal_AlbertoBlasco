package es.banco.controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.banco.modelo.Negocio;

/**
 * Servlet implementation class RealizarPagoServlet
 */
@WebServlet("/Procesar")
public class ProcesarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcesarServlet() {
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
		String numeroComprobacion=request.getParameter("numeroComprobacion");
		String contrasenha=request.getParameter("contrasenha");
		int id=Integer.parseInt(request.getParameter("id"));
		
		String actualizar=request.getParameter("actualizar");
		Negocio negocio= new Negocio();
		String n="";
		
		if(actualizar!=null)
		{
			n=negocio.actualizar(cupoDisponible, id);
		}
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
		
	

