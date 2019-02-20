/*
 * Sistema de administracion de telas y paños.
 * Superintendencia de Maquinas, Planta Nueva Aldea.
 * Arauco 2019 - Practica Profesional.
 */

package prueba1;

/**
 *
 * @author Álvaro Elgueda Labra - Univerisad de Talca.
 * 
 */

public class Menu 
{
    //private final Lector lector;
    //private int opcion;
    //private String texto;
    String negro = "\033[30m"; 
    String rojo = "\033[31m"; 
    String verde = "\033[32m"; 
    String amarillo = "\033[33m"; 
    String azul = "\033[34m"; 
    String morado = "\033[35m"; 
    String cyan = "\033[36m"; 
    String blanco = "\033[37m"; 
    String reset = "\u001B[0m";
    
    public Menu()
    {
        //this.lector = new Lector();
        
        
    }
    
   public void mainMenu()
   {
       System.out.println("1. Ingresar Equipo");
       System.out.println("2. Modificar Equipo");
       System.out.println("3. Eliminar Equipo");
       System.out.println("4. Ver Equipos");
       System.out.println("6. Hoja de calculo.");
       System.out.println("0. Salir");
   }

    public void printExit() 
    {
        System.out.println("Saliendo del sistema de registro de equipos.");
        System.out.println("Álvaro Elgueda Labra - Univerisad de Talca.");
        System.out.println("Arauco 2019.");
    }

    /*
    void printIngresarEquipo()
    {
        System.out.println("Nombre del equipo: ");
        this.lector.ingresarTexto();
        System.out.println("descripcion: ");
        System.out.println("Fecha de ingreso: ");
        System.out.println(": ");
    }*/
    
    public void printModificarEquipo()
    {
        System.out.println("1. Modificar Nombre.");
        System.out.println("2. Modificar codigo.");
        System.out.println("3. Modificar descripcion.");
        System.out.println("0. Volver al menu principal.");
        System.out.println("*** Deshabilitado ***");
        System.out.println("4. Modificar fechaIngeso.");
        System.out.println("5. Modificar fechaSalida.");
        
    }
    
    public void printTipoEquipos()
    {
        System.out.println("1. Pick Up");
        System.out.println("2. 2da Prensa");
        System.out.println("3. 3ra Superior");
        System.out.println("4. 3ra Inferior");
        System.out.println("5. Tela Superior");
        System.out.println("6. Tela Inferior");
        System.out.println("7. Manta");
        System.out.println("8. C.Transversal");
        System.out.println("9. Extremo Seco");
        System.out.println("10. Extremo Humedo");
        System.out.println("0. Volver menu anterior");
    }
    
    public void printOpciones()
    {
        System.out.println("1. Agregar Equipo");
        System.out.println("2. Cambiar Equipo");
        System.out.println("3. Modificar Equipo");
        System.out.println("*** Deshabilitado ***");
        System.out.println("3. Eliminar Equipo");
    }
    
    public void menuPrincipal()
    {
        System.out.println("1. Registrar equipo.");
        System.out.println("2. Modificar datos de equipo.");
        System.out.println("3. Ver equipos.");
        System.out.println("4. Importar a Excel");
        System.out.println("5. Cargar BD");
        System.out.println("0. Salir");
    }
    
    public void printError()
    {
        System.out.println("");
        System.out.println(this.rojo+"*************************************************");
        System.out.println(this.rojo+"* Error en la generacion del Archivo.");
        System.out.println(this.rojo+"*************************************************"+this.reset);
        System.out.println("");
    }
    public void printExito()
    {
        System.out.println("");
        System.out.println(this.verde+"*************************************************");
        System.out.println(this.verde+"* Archivo generado exitosamente.");
        System.out.println(this.verde+"*************************************************"+this.reset);
        System.out.println("");
    }
    
        public void printErrorFecha()
    {
        System.out.println("");
        System.out.println(this.rojo+"*************************************************");
        System.out.println(this.rojo+"* Error en la Fecha ingresada.");
        System.out.println(this.rojo+"* Debe ser modificada.");
        System.out.println(this.rojo+"*************************************************"+this.reset);
        System.out.println("");
    }
        
    public void ppino()
    {
        int numFilas = 4;

        System.out.println();
        for(int altura = 1; altura<=numFilas; altura++)
        {
            for(int blancos = 1; blancos<=numFilas-altura; blancos++)
            {
                System.out.print(" ");
            }
            for(int asteriscos=1; asteriscos<=(altura*2)-1; asteriscos++)
            {
                System.out.print(this.verde+"*");
            }
            System.out.println();
        }
        for(int altura = 3; altura<=numFilas; altura++)
        {
            for(int blancos = 1; blancos<=numFilas-altura; blancos++)
            {
                System.out.print(" ");
            }
            for(int asteriscos=1; asteriscos<=(altura*2)-1; asteriscos++)
            {
                System.out.print(this.verde+"*");
            }
            System.out.println();
        }
        for(int altura = 3; altura<=numFilas; altura++)
        {
            for(int blancos = 1; blancos<=numFilas-altura; blancos++)
            {
                System.out.print(" ");
            }
            for(int asteriscos=1; asteriscos<=(altura*2)-1; asteriscos++)
            {
                System.out.print(this.verde+"*");
            }
            System.out.println();
        }
            System.out.println(this.amarillo+"  **");
            System.out.println(this.amarillo+"  **");
            System.out.println(this.amarillo+"  **"+this.reset);
    }
}
