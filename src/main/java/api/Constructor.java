
package api;

import java.util.ArrayList;
import java.util.List;


public class Constructor {
  String  id ,nombre , status, specie,gender,imagen;
   String buscador;

    public Constructor(String buscador) {
        this.buscador = buscador;
    }

    public String getBuscador() {
        return buscador;
    }

    public void setBuscador(String buscador) {
        this.buscador = buscador;
    }
public  Constructor(){
}
  

  
   
    public Constructor(String id, String nombre, String status, String specie, String gender, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.status = status;
        this.specie = specie;
        this.gender = gender;
        this.imagen = imagen;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }



  
  
}
