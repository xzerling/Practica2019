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
        System.out.println("9. Nivel TADB2");
        System.out.println("10. Nivel TADB3");
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
        System.out.println("0. Salir");
    }
    
}
