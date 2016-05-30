import java.util.Scanner;
public class Main {
    static Scanner leer=new Scanner(System.in);
    static String [][] data=new String[50][10];
    static int legajo=100;
    static int cant_empleados=0;
    public static void menu(){
        int opc=0;
        while (opc<1 || opc>=8) {
            System.out.println(" Gestor de Legajos\n" +
                    "1.\tCarga de empleado.\n" + //incluye el punto 3
                    "2.\tModificacion de datos personales.\n" + //incluye puntos 2 y 4
                    "3.\tLiquidar sueldos.\n" +
                    "4.\tPresentar listado de datos.\n" + // cargar submenu
                    "5.\tSalir.");
            opc = leer.nextInt();
        }
        switch (opc){
            case 1:
                cargar();
                break;
            case 2:
                mode();
                break;
            case 3:
                liqSueldos();
                break;
            case 4:
                opc6();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                break;
        }
    }

    private static void opc6() {
        int opc=0;
        while (opc<1 || opc>=6) {
            System.out.printf(" \n\nPresentar listado de: \n" +
                    "1.\tPromedio general de sueldos.\n" +
                    "2.\tSueldo de X empleado.\n" +
                    "3.\tCantidad de empleados y promedio de sueldo por departamento.\n" +
                    "4.\tHoras extra por empleado.\n" +
                    "5.\tSalir.\n");
            opc = leer.nextInt();
        }
        switch(opc){
            case 1:
                promgral();
                break;
            case 2:
                sueldoemp();
                break;
            case 3:
                promempdepto();
                break;
            case 4:
                hextrasxemp();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                break;
        }
    }

    private static void hextrasxemp() {
        System.out.println("Nro legajo \tApellido \tNombre \tHoras Extra");
        for(int i=0;i<=cant_empleados;i++){
            System.out.printf(data[i][0]+" \t"+data[i][1]+" \t"+data[i][2]+" \t"+data[i][8]+" \n");
        }
        menu();
    }

    private static void promempdepto() {
        System.out.println("Ingrese el departamento (\"A\",\"B\",\"C\"): ");
        String depto=leer.next();
        int cant_emp_depto=0, promedio=0;
        for(int i=0;i<=cant_empleados;i++){
            if(depto==data[i][5]){
                cant_emp_depto++;
                promedio+=Integer.parseInt(data[i][9]);
            }
        }
        promedio/=cant_emp_depto;
        System.out.println("El departamento "+depto+" tiene "+cant_emp_depto+" y el promedio de sus sueldos es: "+promedio);
        menu();
    }

    private static void sueldoemp() {
        System.out.println("Ingrese nro de legajo: ");
        int nro_legajo=leer.nextInt();
        for(int i=0;i<=cant_empleados;i++){
            if(nro_legajo==Integer.parseInt(data[i][0])){
                System.out.println("El sueldo de "+data[i][1]+", "+data[i][2]+" con numero de legajo "+data[i][0]+" es: "+data[i][9]);
            }
        }
        menu();
    }

    private static void promgral() {
        int promedio=0;
        for(int i=0;i<=cant_empleados;i++){
            promedio+=Integer.parseInt(data[i][9]);
        }
        promedio/=cant_empleados;
        System.out.println("Son "+cant_empleados+" empleados y el promedio general de sueldos es: "+promedio);
        menu();
    }

    private static void liqSueldos() {
        System.out.println("Ingrese Nro de legajo: ");
        int legajo1=leer.nextInt();
        int sueldoin=0;
        for(int i=0;i<=cant_empleados;i++){
            if(legajo1==Integer.parseInt(data[i][0])){
                switch (Integer.parseInt(data[i][7])){
                    case 1:
                        sueldoin=10000;
                        break;
                    case 2:
                        sueldoin=8600;
                        break;
                    case 3:
                        sueldoin=5000;
                        break;
                    case 4:
                        sueldoin=4000;
                        break;
                    case 5:
                        sueldoin=3500;
                        break;
                    default:
                        break;
                }
                System.out.println("Nro. de legajo: "+legajo1+"\n"+
                        "Apellido y nombre: "+data[i][1]+", "+data[i][2]+"\n"+
                        "Sueldo Bruto: "+sueldoin+"\n"+
                        "Horas extras: "+data[i][8]+"\n"+
                        "Sueldo neto a cobrar: "+data[i][9]);
            }
        }
    }

    private static void mode() {
        System.out.println("Ingrese el Nro. de LEGAJO: ");
        int legajo1=leer.nextInt();
        for(int i=0; i<cant_empleados; i++) {
            if(legajo1==Integer.parseInt(data[i][0])) {  //convertimos el valor a int para comparar 2 enteros
                System.out.println(" Seleccione la opcion a modificar: \n" +
                        "1.\tAPELLIDO.\n" +
                        "2.\tNOMBRE.\n" +
                        "3.\tDIRECCION.\n" +
                        "4.\tTELEFONO.\n" +
                        "5.\tDEPARTAMENTO.\n" +
                        "6.\tNro de Legajo del JEFE.\n" + // cargar submenu
                        "7.\tCATEGORIA.\n" +
                        "8.\tCantidad de HORAS EXTRAS.\n" +
                        "9.\tSalir.");
                int j=leer.nextInt();
                switch (j) {
                    case 1:
                        System.out.println("Ingrese el APELLIDO: ");
                        data[i][1] = leer.next();
                        break;
                    case 2:
                        System.out.println("Ingrese el NOMBRE: ");
                        data[i][2] = leer.next();
                        break;
                    case 3:
                        System.out.println("Ingrese la DIRECCION: ");
                        data[i][3] = leer.next();
                        break;
                    case 4:
                        System.out.println("Ingrese el TELEFONO: ");
                        data[i][4] = leer.next();
                        break;
                    case 5:
                        System.out.println("Ingrese el DEPARTAMENTO (\"A\",\"B\",\"C\"): ");
                        data[i][5] = leer.next();
                        break;
                    case 6:
                        System.out.println("Ingrese el nro de Legajo del JEFE: ");
                        data[i][6] = leer.next();
                        break;
                    case 7:
                        System.out.println("Ingrese CATEGORIA (1. Jefe, 2. Encargado, 3. Oficial, 4. Medio Oficial, 5. Peon) :");
                        data[i][7] = leer.next();
                        break;
                    case 8:
                        System.out.println("Ingrese cantidad de HORAS EXTRAS: ");
                        data[i][8] = leer.next();
                        break;
                    case 9:
                        System.exit(0);
                    default: break;
                }
                sueldo(i);
            }
        }
        menu();

    }

    private static void cargar() {
        System.out.println("Ingrese cantidad de empleados a ingresar: ");
        int cant=leer.nextInt();
        for(int i=0; i<cant; i++,legajo++) {
            for (int j=1; j<9;++j) {
                data[i][0]=Integer.toString(legajo);
                switch (j) {
                    case 1:
                        System.out.println("Ingrese el APELLIDO: ");
                        data[i][j] = leer.nextLine();
                        break;
                    case 2:
                        System.out.println("Ingrese el NOMBRE: ");
                        break;
                    case 3:
                        System.out.println("Ingrese la DIRECCION: ");
                        break;
                    case 4:
                        System.out.println("Ingrese el TELEFONO: ");
                        break;
                    case 5:
                        System.out.println("Ingrese el DEPARTAMENTO (\"A\",\"B\",\"C\"): ");
                        break;
                    case 6:
                        System.out.println("Ingrese el nro de Legajo del JEFE: ");
                        break;
                    case 7:
                        System.out.println("Ingrese CATEGORIA (1. Jefe, 2. Encargado, 3. Oficial, 4. Medio Oficial, 5. Peon) :");
                        break;
                    case 8:
                        System.out.println("Ingrese cantidad de HORAS EXTRAS: ");
                        break;

                    default: break;
                }
                data[i][j] = leer.nextLine();
            }
            sueldo(i);
            System.out.println("Nro de legajo: " + legajo);
            System.out.println("Sueldo: "+data[i][9]);
            cant_empleados++;
        }
        menu();
    }

    private static void sueldo(int i) {
        switch (Integer.parseInt(data[i][7])){
            case 1:
                data[i][9]=Integer.toString(10000);
                break;
            case 2:
                data[i][9]=Integer.toString(8600);
                break;
            case 3:
                data[i][9]=Integer.toString(5000);
                break;
            case 4:
                data[i][9]=Integer.toString(4000);
                break;
            case 5:
                data[i][9]=Integer.toString(3500);
                break;
            default:
                break;
        }
        int sueldoin=Integer.parseInt(data[i][9]);
        int hextra=sueldoin/100;
        int cant_hextras=Integer.parseInt(data[i][8]);
        hextra*=cant_hextras;
        sueldoin+=hextra; //sueldoin=sueldoin+hextra;
        data[i][9]=Integer.toString(sueldoin);
    }

    public static void main(String[] args) {menu();}
}