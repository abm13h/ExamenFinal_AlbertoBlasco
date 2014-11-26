package es.banco.modelo;

import java.util.ArrayList;

import javax.jws.WebService;

import es.banco.integracion.TarjetaCreditoDAO;
import es.banco.modelo.TarjetaCredito;

public class Negocio 
{
	private TarjetaCreditoDAO tarjetacreditodao = TarjetaCreditoDAO.getInstance();
	
	public int DarAlta(String numero, int cupoMaximo, int cupoDisponible, String tipo, String numeroComprobacion, String contrasenha)
	{     
		  TarjetaCredito tarjetacredito= new TarjetaCredito(numero, cupoMaximo, cupoDisponible, tipo, numeroComprobacion, contrasenha);
	      int id = tarjetacreditodao.darAlta(tarjetacredito);
	      return  id;
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

	//public String borrar(int id) {
	//	String msg;
			//	int cochesBorrados=cochedao.borrar(id);
			//	if(cochesBorrados>=1){
				//		msg="SE HAN BORRADO"+cochesBorrados +"coches";
				//	}else{
				//		msg="No se ha podido borrar";
				//	}
			//	return msg;
			//}
		
	//public String actualizar(int id, String matricula, String marca, String modelo,
	//			String color, int numCaballos, boolean marchas) {
	//		String msg;
	//		int cochesactualizados=cochedao.actualizar(id,matricula,marca,modelo,color,numCaballos,marchas);
	//			msg="Coches actualizados :"+cochesactualizados;
	//		return msg;
	//	}
		

}
