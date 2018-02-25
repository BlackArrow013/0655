
/**
 * La clase acceso representa un único acceso al servidor de datos, de manera
 * que contendrá la información perteneciente al momento del acceso.
 * 
 * @author (Jorge Jaular Lasaga) 
 * @version (25/02/2018)
 */
public class Acceso
{
    // Representa el día de acceso.
    private int dia;
    // Representa el mes de acceso.
    private int mes;
    // Representa el año de acceso.
    private int ano;
    // Representa la hora de forma literal dentro de la hora de acceso.
    private int hora;
    // Representa los minutos dentro de la hora de acceso.
    private int minutos;
    /**
     * El constructor de la clase Acceso. Se permite indicar en qué momento
     * se accedió a los datos.
     */
    public Acceso(int dia, int mes, int ano, int hora, int minutos)
    {
        // Inicialización de las variables
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.hora = hora;
        this.minutos = minutos;
    }

    /**
     * Este método devuelve la hora de acceso.
     * @return horaAcceso - devuelve la hora de acceso.
     */
    public int getHoraAcceso()
    {
        return hora;
    }
}
