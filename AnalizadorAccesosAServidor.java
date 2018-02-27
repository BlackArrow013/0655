import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.ArrayList;
/**
 * Esta clase analiza los accesos al servidor. Se compondrá de dos métodos, uno
 * que importará un documento de texto con los accesos al servidor y otro que 
 * obtendrá qué hora tiene más accesos.
 * 
 * @author (Jorge Jaular Lasaga) 
 * @version (25/02/2018)
 */
public class AnalizadorAccesosAServidor
{
    // Un atributo de tipo HashMap parametrizado con enteros y asociados a una colección de la clase Acceso.
    HashMap<Integer, ArrayList<Acceso>> registroDeAccesos;
    
    /**
     * El constructor de la clase. Crea un analizador de accesos al servidor.
     */
    public AnalizadorAccesosAServidor(){
        // Inicialización del atributo declarado anteriormente.
        registroDeAccesos = new HashMap<>();
    }

    /**
     * Este método permite cargar los datos de acceso al servidor.
     * 
     * @param nombreArchivo - se introduce el nombre del archivo que servirá para cargar los datos.
     */
    public void analizarArchivoDeLog(String nombreArchivo)
    {
        registroDeAccesos.clear();
        try {
            File archivo = new File(nombreArchivo);
            Scanner sc = new Scanner(archivo);            
            while (sc.hasNextLine()) {  
                String[] datos = sc.nextLine().split(" ");
                int dia = Integer.parseInt(datos[0]);
                int mes = Integer.parseInt(datos[1]);
                int ano = Integer.parseInt(datos[2]);
                int hora = Integer.parseInt(datos[3]); 
                int minuto = Integer.parseInt(datos[4]);
                Acceso acceso = new Acceso(dia, mes, ano, hora, minuto);
                if(registroDeAccesos.containsKey(hora)) {
                    registroDeAccesos.get(hora).add(acceso);
                }
                else {
                    ArrayList<Acceso> coleccion = new ArrayList<>();
                    coleccion.add(acceso);
                    registroDeAccesos.put(hora, coleccion);
                }
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Este método comprueba a qué hora se produjeron más conexiones o accesos al servidor. Devuelve la hora con más conexiones, y en caso de empate devuelve la hora más alta. Si no hay conexiones
     * devuelve -1.
     * @return horaConMasAccesos - devuelve la hora con más conexiones. 
     */
    public int obtenerHoraMasAccesos() {
        int numeroDeAccesos = 0;
        int horaConMasAccesos = -1;
        if (!registroDeAccesos.isEmpty()) {
            for(ArrayList<Acceso> acceso : registroDeAccesos.values()) {
                if(acceso.get(0).getHoraAcceso() > horaConMasAccesos && acceso.size() >= numeroDeAccesos){   
                    numeroDeAccesos = acceso.size();     
                    horaConMasAccesos = acceso.get(0).getHoraAcceso();    
                }    
            }
        }
        else {
            System.out.println("No ha habido accesos.");
        }
        return horaConMasAccesos;
    }
}
