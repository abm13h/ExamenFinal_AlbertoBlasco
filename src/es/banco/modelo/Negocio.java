package es.banco.modelo;

import java.util.ArrayList;

import javax.jws.WebService;

import es.banco.integracion.TarjetaCreditoDAO;
import es.banco.modelo.TarjetaCredito;

public class Negocio 
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
            // //reglas...
          //  //-....
          // ArrayList<TarjetaCredito> coches=cochedao.consultarTodos();
	      //  return coches;
	      //}

	//public ArrayList<TarjetaCredito> consultarMatricula(String matricula) {
	//    ArrayList<TarjetaCredito> coches=cochedao.consultarMatricula(matricula);
	//    return coches;
	//}

		
	public String actualizar(int cupoDisponible,
				             int id) {
			String msg;
			int tarjetasactualizadas=tarjetacreditodao.actualizar(cupoDisponible, id);
				msg="Tarjetas actualizadas :" + tarjetasactualizadas;
			return msg;
		}

	public TarjetaParaPago comprobarPago(String numero, 
			             String contrasenha,
			             String numeroComprobacion, 
			             int importe) 
	{
	    
	    TarjetaParaPago tarjetaparapago = tarjetacreditodao.consultarNumero(numero);
	    return tarjetaparapago;
	    
	    // Si el numero de tarjeta es correcto, comprobar 
	    // si el resto de datos tecleados son correctos:
	    // si la contraseña
	    
	    //String msg;
	    //if(tarjetacompra.isEmpty()){
	    //	msg="El número de la tarjeta no existe.";
	    //}else{
	    //	msg="El número de la tarjeta sí existe.";
	    //}
	    //return msg;
	    	
	} 
	    //return tarjetacompra;
}

