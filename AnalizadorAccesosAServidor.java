import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
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
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void analizarArchivoDeLog(String nombreArchivo)
    {
        try {
            File archivo = new File(nombreArchivo);
            Scanner sc = new Scanner(archivo);            
            while (sc.hasNextLine()) {  
                System.out.println(sc.nextLine());
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
