
package api;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.*;


public class Api{
    


   
  List<Constructor> listacostructor = new ArrayList();
public List<Constructor> cone () throws MalformedURLException, IOException{
            URL url;
            url = new URL("https://rickandmortyapi.com/api/character");
       
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //indicamos por que verbo HTML ejecutaremos la solicitud
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                //si la respuesta del servidor es distinta al codigo 200 lanzaremos una Exception
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            //creamos un StringBuilder para almacenar la respuesta del web service
            StringBuilder sb = new StringBuilder();
            
            
            int cp;
            while ((cp = br.read()) != -1) {
                sb.append((char) cp);
            }
            //en la cadena output almacenamos toda la respuesta del servidor
            String output = sb.toString();
            //convertimos la cadena a JSON a traves de la libreria GSON
            JSONObject jo = new JSONObject(output);
            JSONArray array1 =  jo.getJSONArray("results");
            int i=0;
           
            for (i = 0; i < array1.length(); i++) {
                JSONObject item = array1.getJSONObject(i);
                String id = String.valueOf(item.getInt("id"));
                String nombre = item.getString("name");
               
                String status = item.getString("status");
                String species = item.getString("species");
                String gender = item.getString("gender");
                String imagen = item.getString("image");
                  Constructor constructor = new Constructor(id, nombre, status, species, gender, imagen);
                listacostructor.add(constructor);
                System.out.println("Json Traido : "+ i +"  :" + id + " : " + nombre + ": " + imagen+" :" + status+" : " + species  );
            }
       
            return listacostructor;
            
}
public List<Constructor> buscar (String nombre1) throws IOException {
    Constructor busqueda = new Constructor();
     List<Constructor> listbusqueda = new ArrayList();
    cone();
     System.out.println("parametro : " + nombre1 );
    for (int i = 0; i < listacostructor.size(); i++) {
        if (listacostructor.get(i).getNombre().equals(nombre1)) {
           
            
            System.out.println("Registro Encontrado : " + listacostructor.get(i));
            String nombre = listacostructor.get(i).getNombre();
            String id = listacostructor.get(i).getId();
            String status = listacostructor.get(i).getStatus();
            String specie = listacostructor.get(i).getSpecie();
            String gender = listacostructor.get(i).getGender();
            String imagen = listacostructor.get(i).getImagen();
           
           busqueda = new Constructor(id, nombre, status, specie, gender, imagen);
        listbusqueda.add(busqueda);
            
        }
        else{
            System.out.println("No se encontro registro");
        }
    }
 
return listbusqueda ; 
}

  
}

           
