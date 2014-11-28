package es.banco.controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import es.banco.modelo;

/**
 * Servlet implementation class ValidarServlet
 */
@WebServlet("/Validar")
public class ValidarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	         String usuario= request.getParameter("usuario");
	         String contrasenha = request.getParameter("contrasenha");
	         
	         //BaseDatos bbdd = BaseDatos.getInstance();
	         RequestDispatcher rd;
	         
	         //if(bbdd.validarUsario(usuario, contrasenha)==true) {
	             // permitirle ver la siguiente pagina
	             rd= request.getRequestDispatcher("inicio.html");
	         //}else
	         {
	             //loggeese otra vez......
	             String mensaje= "Datos de logeo incorrectos";
	             
	             request.setAttribute("mensaje",mensaje);
	             
	            // redirigir a index....	 
	             rd= request.getRequestDispatcher("index.jsp");
	         }
	         
	         rd.forward(request,response);
	}

}
