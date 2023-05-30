/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectomundial.model;

public class UsuarioDTO {
   private String usuario;
   private String contra;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public UsuarioDTO(String usuario, String contra) {
        this.usuario = usuario;
        this.contra = contra;
    }

    public UsuarioDTO() {
    }
   
   
}
