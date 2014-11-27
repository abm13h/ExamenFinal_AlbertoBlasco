package es.banco.modelo;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style=Style.RPC)
public interface NegocioWS {
	@WebMethod
	public abstract String actualizar(int cupoDisponible, int id);

}