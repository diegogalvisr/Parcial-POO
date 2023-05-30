/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectomundial.DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import proyectomundial.model.UsuarioDTO;
import proyectomundial.util.BasedeDatos;


public class UsuarioDAO {
    
        public ArrayList<UsuarioDTO> obtenerUsuarios() {
        ArrayList<UsuarioDTO> admins = new ArrayList<>();
        try {
            BasedeDatos.conectar();
            ResultSet resultado = BasedeDatos.ejecutarSQL("SELECT * FROM poo.users");

            if (resultado != null) { // Verificar que el resultado no sea null
                while (resultado.next()) {
                    String usuario = resultado.getString("username");
                    String clave = resultado.getString("password");
                    admins.add(new UsuarioDTO(usuario,clave));
                }
            } else {
                System.out.println("No se pudo ejecutar la consulta SQL.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            BasedeDatos.desconectar(); // Cerrar la conexión
        }

        return admins;
    }
    public boolean validarUsuario(String user, String pass) {
        List<UsuarioDTO> usuarios = obtenerUsuarios();
        for (UsuarioDTO usuario : usuarios) {
            if (usuario.getUsuario().equals(user) && usuario.getContra().equals(pass)) {
                return true; // el usuario y la clave son correctos
            }
        }
        return false; // el usuario o la clave son incorrectos
    }
}
