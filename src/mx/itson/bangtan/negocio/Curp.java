/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.bangtan.negocio;

/**
 * 
 * @author michelle Valle
 */
public class Curp {
   
        private static char[] VOCALS = {'A', 'E', 'I', 'O', 'U'};

        public String generaCurp(String Nombre1, String Nombre2, String Apellido1, String Apellido2, String anio, String mes, String dia, String sexo, String estado){
       
        String finalCURP="";
        Nombre1 = clean(Nombre1);
        Nombre2 = clean(Nombre2);
        Apellido1 = clean(Apellido1);
        Apellido2 = clean(Apellido2);

        StringBuilder curp = new StringBuilder();
        curp.append(char1(Nombre1, Apellido1, Apellido2));
        curp.append(anio.substring(2));
        curp.append(mes);
        curp.append(dia);
        curp.append(sexo.substring(0,1));
        curp.append(estado);
        curp.append(char2(Nombre1, Apellido1, Apellido2));
        
       
        return curp.toString();
}
        

    public String char1(String Nombre1, String Apellido1, String Apellido2){
        
        String B1="", B2="", B3="", B4="", C="";
        B1=Apellido1.substring(0, 1);
        B2=vocalInterna(Apellido1);
        B3=Apellido2.substring(0, 1);
        B4=Nombre1.substring(0, 1);
                
        C=B1+B2+B3+B4;
        return C;
        
    }

    public String char2(String Nombre1, String Apellido1, String Apellido2){
       
        String B14, B15="", B16="", C="";
        B14 = consonanteInterna(Apellido1);
        B15 = consonanteInterna(Apellido2);
        B16 = consonanteInterna(Nombre1);
        
        C = B14+B15+B16;
        return C;
        
    }
    
  
    public String vocalInterna(String inputVocal){
        String vocal="";
        inputVocal = inputVocal.substring(1);
        String[] arregloVocal = inputVocal.split("(?!^)");
        for (String a: arregloVocal){
            if (a.equalsIgnoreCase("a")||a.equalsIgnoreCase("e")||a.equalsIgnoreCase("i")||a.equalsIgnoreCase("o")||a.equalsIgnoreCase("u")) {
                
                vocal=a;
                break;
                
            } 
        }
        
        return vocal;
        
    }

   
    public String consonanteInterna(String inputConsonante){
        String consonante="";
        inputConsonante=inputConsonante.substring(1);
        String[] arregloConsonante = inputConsonante.split("(?!^)");
        for (String b: arregloConsonante){
            if(
                    b.equalsIgnoreCase("b")||
                    b.equalsIgnoreCase("c")||
                    b.equalsIgnoreCase("d")||
                    b.equalsIgnoreCase("f")||
                    b.equalsIgnoreCase("g")||
                    b.equalsIgnoreCase("h")||
                    b.equalsIgnoreCase("j")||
                    b.equalsIgnoreCase("k")||
                    b.equalsIgnoreCase("l")||
                    b.equalsIgnoreCase("m")||
                    b.equalsIgnoreCase("n")||
                    b.equalsIgnoreCase("ñ")||
                    b.equalsIgnoreCase("p")||
                    b.equalsIgnoreCase("q")||
                    b.equalsIgnoreCase("r")||
                    b.equalsIgnoreCase("s")||
                    b.equalsIgnoreCase("t")||
                    b.equalsIgnoreCase("v")||
                    b.equalsIgnoreCase("w")||
                    b.equalsIgnoreCase("x")||
                    b.equalsIgnoreCase("y")||
                    b.equalsIgnoreCase("z")){
                consonante=b;
                break;
            }
        }
        return consonante;
        
    }

   
    public String clean(String input){
        input = input
                .toUpperCase()
                .replace(" ", "")
                .replace(".", "")
                .replace(",", "")
                .replace("!", "")
                .replace("¡", "")
                .replace("á", "a")
                .replace("é", "e")
                .replace("í", "i")
                .replace("ó", "o")
                .replace("ú", "u");
        return input;
    }
}
