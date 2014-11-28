package es.banco.modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style=Style.RPC)
public interface NegocioWS 
{
	@WebMethod
	public abstract String comprobarPago(
			String numero, 
            String contrasenha,
            String numeroComprobacion, 
            int importe);
	
    @WebMethod
	public abstract String actualizar(
			int cupoDisponible, 
			int id);

}