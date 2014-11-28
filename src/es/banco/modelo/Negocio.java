package es.banco.modelo;

import java.util.ArrayList;

import javax.jws.WebService;

import es.banco.integracion.TarjetaCreditoDAO;
import es.banco.modelo.TarjetaCredito;
@WebService(endpointInterface="es.concesionario.banco.NegocioWS")
public class Negocio implements NegocioWS 
{
	private TarjetaCreditoDAO tarjetacreditodao = TarjetaCreditoDAO.getInstance();
	
	public String DarAlta(String numero, int cupoMaximo, int cupoDisponible, String tipo, String numeroComprobacion, String contrasenha)
	{     
		  String msg;
	      TarjetaCredito tarjetacredito= new TarjetaCredito(numero, cupoMaximo, cupoDisponible, tipo, numeroComprobacion, contrasenha);
	      int tarjetasinsertadas=tarjetacreditodao.darAlta(tarjetacredito);
		  msg="Tarjeta dada de alta correctamente";
		  return msg;
		  
	}
	
	public TarjetaCredito consultarUno(int id) 
	{
	       // validar si el q solicita la consulta tiene autorizacion
	        TarjetaCredito tarjetacredito = tarjetacreditodao.consultarUno(id);
	        return tarjetacredito;
	}

    //public ArrayList<TarjetaCredito> consultarTodos() {
    		
	/* (non-Javadoc)
	 * @see es.banco.modelo.NegocioWS#actualizar(int, int)
	 */
	
	public String actualizar(int cupoDisponible,
				             int id) 
	{
			String msg;
			int tarjetasactualizadas=tarjetacreditodao.actualizar(cupoDisponible, id);
				msg="Tarjetas actualizadas :" + tarjetasactualizadas;
			return msg;
	}
	//@Override
	public TarjetaCredito comprobarPago(String numero) 
	{
		 TarjetaCredito tarjetacredito = tarjetacreditodao.comprobarPago(numero);
	     return tarjetacredito;
    		  
    	}

	@Override
	public String comprobarPago(String numero, 
			                    String contrasenha,
			                    String numeroComprobacion, 
			                    int importe) 
	{
		return null;
	}    
       
		//return "";
	    
	    // Si el numero de tarjeta es correcto, comprobar 
	    // si el resto de datos tecleados son correctos:
	    // si la contraseña
	    
	    //String msg;
	    //if(tarjetacompra.isEmpty()){
	    //	msg="El número de la tarjeta no existe.";
	    //}else{
	    //	msg="El número de la tarjeta sí existe.";
	    //}
	    //return tarjetaparapago;
	    	
	} 
	    


