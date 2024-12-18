package Implement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import Connection.ClassConnection;
import Interface.UsuarioInterface;
import Model.Usuarios;
public class UsuariosImplement implements UsuarioInterface{

	public void RegistrarUsuarios(Usuarios usu) {
		String passBc = BCrypt.hashpw(usu.getContrasena(), BCrypt.gensalt());
		String bd = "INSERT INTO usuarios VALUES(null,?,?,?)";
		PreparedStatement ps = null;
		try {
			ps = ClassConnection.conectarMySQL().prepareStatement(bd);
			ps.setString(1, usu.getUsuario());
			ps.setString(2, passBc);
			ps.setString(3, usu.getTipoUsuario());
			int x = ps.executeUpdate();
			if (x>0) {
				System.out.println("Usuario Registrado Correctamente");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean IniciarSession(String usu, String pass){
		String sql= "SELECT contrasena FROM usuarios WHERE usuario=?";
		PreparedStatement ps = null;
		ResultSet rs= null;
		try {
			ps=ClassConnection.conectarMySQL().prepareStatement(sql);
			ps.setString(1, usu);
			rs =ps.executeQuery();
			if (rs.next()) {
				String passBC = rs.getString("contrasena");
				return BCrypt.checkpw(pass, passBC);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
