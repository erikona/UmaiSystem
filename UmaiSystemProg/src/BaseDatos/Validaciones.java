
package BaseDatos;


public class Validaciones {
    
    
    
    
   public boolean Esdigito(String texto){
       
       return texto.matches("^[0-9]+$");
   }
   public boolean EsTelefono(String texto){
       
       return texto.matches("^([0-9]\\s*-*){10}$");
   }
   public boolean EsNombre(String texto){
       
       return texto.matches("^\\s*[A-Za-zÑñáéíóúÁÉÍÓÚ]+\\s*$");
       //return texto.matches("^([a-zA-ZÑñáéíóúÁÉÍÓÚ]{2,}?){2,}+$");
   }
   public boolean EsTexto(String texto){
       return texto.matches("^([A-Za-z]+\\s*)+$");
   }
    
}
