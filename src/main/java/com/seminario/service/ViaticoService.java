package com.seminario.service;


import java.util.Date;
import java.util.List;

import com.seminario.model.Viatico;
import com.seminario.repository.ViaticosDao;
import com.seminario.response.RespuestaPersonalizada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

//import org.apache.log4j.*;

@Service
public class ViaticoService {
    

    //private static final Logger logger = Logger.getLogger(ViaticoService.class);

    @Autowired
    ViaticosDao viaticosDao; 

    // METODOS GET 

    /***
     * 
     * @return 
     */
    public ResponseEntity<Object> obtenerViaticos(){
        ResponseEntity<Object> respuesta;
        try {
            List<Viatico>  lstViaticos= viaticosDao.findAll();
            if (lstViaticos.size() == 0) {
                throw new Exception("Error");
            }
            respuesta= ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(lstViaticos, HttpStatus.OK);
        } catch (Exception e) {
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			respuesta = new ResponseEntity<>("Problemas al cargar los viaticos",HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    /***
     * 
     * @param fechaIni
     * @param fechaFin
     * @return 
     */
    public ResponseEntity<Object> obtenerViaticosFechas(Date fechaIni, Date fechaFin) {
        ResponseEntity<Object> respuesta;
		try {
			List<Viatico> lstViaticos = viaticosDao.findByFechas(fechaIni, fechaFin);
            respuesta = ResponseEntity.ok(HttpStatus.OK);
			respuesta = new ResponseEntity<>(lstViaticos, HttpStatus.OK);
		}catch(Exception e) {
			//logger.error(e);
			respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			respuesta = new ResponseEntity<>("Disculpa tenemos un error tratando de consultar los Viaticos en el rango de fechas", HttpStatus.BAD_REQUEST);
			
		}
       return respuesta;
	}

    // METODO POST 

    /***
     * 
     * @param viaticoNuevo
     * @return 
     */
    public ResponseEntity<Object> agregarViatico (Viatico viaticoNuevo){
        ResponseEntity<Object> respuesta;
        try {
            RespuestaPersonalizada res = new RespuestaPersonalizada("Viatico generado correctamente", HttpStatus.OK);
            res.setObjectoRespuesta(viaticosDao.save(viaticoNuevo));
            respuesta= ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            RespuestaPersonalizada res = new RespuestaPersonalizada("Error al generar el viatico ", HttpStatus.BAD_REQUEST);
            respuesta= ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    // METODO PUT

    /***
     * 
     * @param viaticoModificar
     * @return
     */

    public ResponseEntity<Object> modificarViatico (Viatico viaticoModificar){
        ResponseEntity<Object> respuesta;
        try {
            RespuestaPersonalizada res = new RespuestaPersonalizada("Viatico fue modificado correctamente", HttpStatus.OK);
            res.setObjectoRespuesta(viaticosDao.save(viaticoModificar));
            respuesta= ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            RespuestaPersonalizada res = new RespuestaPersonalizada("Error al modificar el viatico ", HttpStatus.BAD_REQUEST);
            respuesta= ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    // METODO DELETE

    /****
     * 
     * @param id
     * @return
     */

    public ResponseEntity<Object> eliminarViatico (Integer id){
        ResponseEntity<Object> respuesta;
        try {
            RespuestaPersonalizada res = new RespuestaPersonalizada("Viatico fue eliminado correctamente", HttpStatus.OK);
            res.setObjectoRespuesta(viaticosDao.findById(id));
            viaticosDao.deleteById(id);
            respuesta= ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            RespuestaPersonalizada res = new RespuestaPersonalizada("Error al eliminar el viatico ", HttpStatus.BAD_REQUEST);
            respuesta= ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
}
