package es.banco.integracion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import java.util.logging.Level;
import java.util.logging.Logger;



import es.banco.modelo.TarjetaCredito;

public class TarjetaCreditoDAO {
    
	     private Connection cx;
	     private static TarjetaCreditoDAO tarjetacreditoDao=null;
	     
	     private TarjetaCreditoDAO(){
	     }
	     public static TarjetaCreditoDAO getInstance(){
	    	 if(TarjetaCreditoDAO.tarjetacreditoDao==null)
	    		 TarjetaCreditoDAO.tarjetacreditoDao= new TarjetaCreditoDAO();
	    	 return TarjetaCreditoDAO.tarjetacreditoDao;
	     }
	   
	     private void conectar() {
	     try {
	            Class.forName("com.mysql.jdbc.Driver");
	            cx= DriverManager.getConnection("jdbc:mysql://localhost:3306/banco","root","root");
	            cx.setAutoCommit(false);
	     }
    catch(SQLException e) {
             
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Error en SQL ", e);
         }
	     catch(ClassNotFoundException e) {
	         Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "No se encuentra lib mySQL ", e);
         }
     
	    
	    
	      
	     }
	     private void desconectar() {
	         try {
	             if(cx!=null)
	                cx.close();
	        } catch (SQLException e) {
	           
	            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Error al cerrar conexión ", e);
	        }
	         
	         
	     }
	       public int darAlta(TarjetaCredito tarjetacredito) {
	              int id=0;
	            try {
	                int ultimoID=0;
	                //1. conectar
	                conectar();
	                //2.Preparar la sql (query)
	                PreparedStatement ps =cx.prepareStatement("INSERT INTO tarjetacredito VALUES(?,?,?,?,?,?,?)"); 
	                // 2.1 setear los interrogantes...
	                ps.setString(1, tarjetacredito.getNumero());
	                ps.setInt(2, tarjetacredito.getCupoMaximo());
	                ps.setInt(3, tarjetacredito.getCupoDisponible());
	                ps.setString(4, tarjetacredito.getTipo());
	                ps.setString(5, tarjetacredito.getNumeroComprobacion());
	                ps.setString(6, tarjetacredito.getContrasenha());
	                
	                //ultimoID=ultimoId();
	                //ultimoID=ultimoID+1;
	                //ps.setInt(7, ultimoID); // no se cómo se pone el valor de ultimoID
	                
	                ps.setInt(7, 0);
	                
	                //3. Ejecutar la consulta
	                 int filasAfectadas =ps.executeUpdate();
	               
	                   //4.  hacer el commit....
	                 cx.commit();
	                 if(filasAfectadas>=1) {
	                     id= ultimoId();    
	               }
	               
	            } catch (SQLException e) {
	                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Error SQL ", e);
	            }
	            finally {
	                //.5.cerrar la conexión
                    desconectar();
	              }
	         return id;
	    }
	       
	    public TarjetaCredito consultarUno(int id) {
	       TarjetaCredito p = new TarjetaCredito();
	         try {
	          //1. conectar
	        	     conectar();
	          //2. preparar la consulta
	               PreparedStatement ps;
	               ps = cx.prepareStatement("SELECT * FROM tarjetacredito WHERE ID=?");
	              // 2.1 setear los ?
	                   ps.setInt(1, id);
	                  // 3, ejecutar la consulta
	                    ResultSet rs =ps.executeQuery();  
	                //4. llenar el objeto coche.. con los datos de respuesta de BBDD..
	                    //Nota: La respuesta viene en un objeto ResultSet
	                  if(rs.next()) {
	                           p.setNumero(rs.getString("numero"));
	                           p.setCupoMaximo(rs.getInt("cupoMaximo"));
	                           p.setCupoDisponible(rs.getInt("cupoDisponible"));
	                           p.setTipo(rs.getString("tipo"));
	                           p.setNumeroComprobacion(rs.getString("numeroComprobacion"));
	                           p.setContrasenha(rs.getString("contrasenha"));
	            	           p.setId(rs.getInt("id"));
	                       }
	          
	       } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Error SQL ", e);
	        }
	           finally {
	               //5.desconectar
	                 desconectar();
	           }
	       return p;
	       }
	    
	       //public ArrayList<TarjetaCredito> consultarTodos() {
	       // ArrayList<TarjetaCredito> coches= new ArrayList<TarjetaCredito>();
	       
	       // try {
	       //     //1. conectar
	       //     conectar();
	       //     //2. preparar la sentencia
	       //     PreparedStatement ps = cx.prepareStatement("SELECT * FROM COCHE");
	       //     //3. ejecutar la consulta
	       //     ResultSet consulta = ps.executeQuery();
	       //     //4. bajar el resultado de la consulta y ponerlo en el arrayList
	       //     while(consulta.next()) {
	       //         TarjetaCredito p = new TarjetaCredito();
	       //         p.setId(consulta.getInt("id"));
	       //         p.setMatricula(consulta.getString("matricula"));
	       //         p.setMarca(consulta.getString("marca"));
	       //         p.setModelo(consulta.getString("modelo"));
	       //         p.setColor(consulta.getString("color"));
	       //         p.setNumCaballos(consulta.getInt("numCaballos"));
	       //         p.setMarchas(consulta.getBoolean("marchas"));	                
	       //         coches.add(p);
	       //     }
	       //    
	       // } catch (SQLException e) {
	       //     
	       //     Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Error SQL ", e);
	       // }
	       // finally {
	       //     //5.desconectar
	       //       desconectar();
	       // }
	       // 
	       // return coches;
	       //}
	    
	    
	    public int  ultimoId() {
	    	int  id=0;
	    	try {
	    		//1. conectar
	    		conectar();
	    		//2. preparar la sentencia
	    		PreparedStatement ps = cx.prepareStatement("SELECT MAX(ID) AS ULTIMO FROM tarjetacredito");
	    		//3. ejecutar la consulta
	    		ResultSet consulta = ps.executeQuery();
	    		//4. bajar el resultado de la consulta y ponerlo en el arrayList
	    		if(consulta.next()) {
	    			id=consulta.getInt("ULTIMO");
	    		}
	    		
	    	} catch (SQLException e) {
	    		    		
	    		 Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Calculo ultimo id", e);
	    		
	    		
	    	
	    	}
	    	finally {
                //5.desconectar
                  desconectar();
            }
	    	return id;
	    }
	    //public ArrayList<TarjetaCredito> consultarMatricula(String matricula) {
	    //	ArrayList<TarjetaCredito> coches= new ArrayList<TarjetaCredito>();
	    //	try {
	    //		//1. conectar
	    //		conectar();
	    //		//2. preparar la sentencia
	    //		PreparedStatement ps = cx.prepareStatement("SELECT * FROM COCHE WHERE MATRICULA LIKE ?");
	    //		// 2.1 setear el interrogante
	    //		ps.setString(1, "%"+matricula+"%");
	    //		//3. ejecutar la consulta
	    //		ResultSet consulta = ps.executeQuery();
	    //		//4. bajar el resultado de la consulta y ponerlo en el arrayList
	    //		while(consulta.next()) {
	    //			TarjetaCredito p = new TarjetaCredito();
	    //			p.setId(consulta.getInt("id"));
	    //			p.setMatricula(consulta.getString("matricula"));
	    //			p.setMarca(consulta.getString("marca"));
	    //			p.setModelo(consulta.getString("modelo"));
	    //			p.setColor(consulta.getString("color"));
	    //			p.setNumCaballos(consulta.getInt("numCaballos"));
	    //			p.setMarchas(consulta.getBoolean("marchas"));
	    //			coches.add(p);
	    //		}
	    //		
	    //	} catch (SQLException e) {
	    //		
	    //	    Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Calculo ultimo id", e);
	    //	}
	    //	finally {
	    //        //5.desconectar
	    //          desconectar();
	    //    }
	    //	return coches;
	    //}
	    
	    //public int borrar(int id) {
	    //	int filasAfectada=0;
	    //	try {
	    //		conectar();
	    //		PreparedStatement ps = cx.prepareStatement("DELETE FROM COCHE WHERE ID=?");
	    //		ps.setInt(1,id);
	    //		filasAfectada=ps.executeUpdate();
	    //		cx.commit();
	    //			} catch (SQLException e) {
	    //		// TODO Auto-generated catch block
	    //			    Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Error SQL ", e);
	    //	}     finally {
	    //        //5.desconectar
	    //        desconectar();
	    //  }  
	    //	return filasAfectada;
	    //}
	    
	    public int actualizar(int cupoDisponible,
	    		              int id) {
	    	int filasAfectada=0;
	    	try {
	    		conectar();
	    		PreparedStatement ps = cx.prepareStatement("UPDATE tarjetacredito SET cupoDisponible=? WHERE ID=?");
	    		ps.setInt(1, cupoDisponible);
	    		ps.setInt(2, id);
	    		filasAfectada=ps.executeUpdate();
	    		cx.commit();
	    	
	    	} catch (SQLException e) {
	    		
	    	    Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Error SQL ", e);
	    	}   
	    	finally {
                //5.desconectar
                  desconectar();
            }
	    	return filasAfectada;
	    }
}
	    			
	    	
	    
	    
	                
	                
	                
