/*
 * Sistema de administracion de telas y paños.
 * Superintendencia de Maquinas, Planta Nueva Aldea.
 * Arauco 2019 - Practica Profesional.
 */

package prueba1;
import java.util.Scanner;

/**
 *
 * @author Álvaro Elgueda Labra - Univerisad de Talca.
 * 
 */
public class Lector
{
    private Scanner scanner;
    
    public Lector()
    {
        this.scanner = new Scanner(System.in);
    }
    
    
    /**
     * Lee y comprueba un entero por teclado.
     * 
     */
    public int leerEntero()
    {        
        while( !this.scanner.hasNextInt())
        {
            this.scanner.nextLine();
            System.out.println("Error, ingrese un numero positivo.");            
        }
                
        int opcion = this.scanner.nextInt();
        return opcion;
    }   
    
    /**
     * Lee y comprueba un string por teclado.
     * 
     * @return 
     */
    public String ingresarTexto()
    {
        /*while( !this.scanner.hasNextLine() )
        {
            this.scanner.nextInt();
            System.out.println("Error, ingrese un nombre.");            
        }*/
        String texto = this.scanner.nextLine();
        return texto;
    }
    
    public String buffer()
    {
        return this.scanner.nextLine();
    }
}
