package Implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import Connection.ClassConnection;
import Interface.PadresInterface;
import Model.Padre;

public class PadreImplement implements PadresInterface{

	public void RegistrarPadres(Padre pad, String contrasenia) {
		String sqlPadres = "INSERT INTO padres VALUES(null, ?, ?, ?, ?)";
		String sqlUsuario = "INSERT INTO usuarios VALUES(null, ?, ?, ?)";
		
		PreparedStatement psPadres = null;
		PreparedStatement psUsu = null;
		try {
			Connection cnn = ClassConnection.conectarMySQL();
			cnn.setAutoCommit(false);
			
			//INSERTAMOS EN LA TABLA PADRES
			psPadres = cnn.prepareStatement(sqlPadres);
			psPadres.setString(1, pad.getNombre());
			psPadres.setString(2, pad.getDni());
			psPadres.setString(3, pad.getTelefono());
			psPadres.setString(4, pad.getCorreo());
			psPadres.executeUpdate();
			
			//ENCRIPTAMOS LA CONTRASENIA
			String passBc = BCrypt.hashpw(contrasenia, BCrypt.gensalt());
			
			//INSERTAMOS EN LA TABLA USUARIO
			psUsu = cnn.prepareStatement(sqlUsuario);
			psUsu.setString(1, pad.getCorreo());
			psUsu.setString(2, passBc);
			psUsu.setString(3, "padre");
			psUsu.executeUpdate();
			
			cnn.commit();
			System.out.println("Registrado correctamente.");
			
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				if (psPadres != null) {
					psPadres.getConnection().rollback();
				}
				System.out.println("A ocurrido un error.");
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		} finally {
			try {
				if (psPadres !=null)psPadres.close();
				if (psUsu != null) psUsu.close();
			} catch (SQLException close) {
				close.spliterator();
			}
		}
		
	}

	public void ActualizarPadres(Padre pad) {
		String sql = "UPDATE padres SET nombre=?, dni=?, telefono=?, correo=? WHERE id_padre=?";
		PreparedStatement ps = null;
		try {
			ps = ClassConnection.conectarMySQL().prepareStatement(sql);
			ps.setString(1, pad.getNombre());
			ps.setString(2, pad.getDni());
			ps.setString(3, pad.getTelefono());
			ps.setString(4, pad.getCorreo());
			ps.setInt(5, pad.getIdPadre());
			int w = ps.executeUpdate();
			if (w > 0) {
				System.out.println("Datos Actualizados correctamente.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Padre BuscarPadre(Padre pad) {
		String sql = "SELECT * FROM padres WHERE id_padre=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Padre pr = new Padre();
		try {
			ps = ClassConnection.conectarMySQL().prepareStatement(sql);
			ps.setInt(1, pad.getIdPadre());
			rs=ps.executeQuery();
			if (rs.next()) {
				pr.setIdPadre(rs.getInt(1));
				pr.setNombre(rs.getString(2));
				pr.setDni(rs.getString(3));
				pr.setTelefono(rs.getString(4));
				pr.setCorreo(rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pr;
	}

	public List<Padre> ListadoPadres() {
		String sql = "SELECT * FROM padres";
		PreparedStatement ps= null;
		ResultSet rs = null;
		List<Padre> lista = new ArrayList<Padre>();
		try {
			ps = ClassConnection.conectarMySQL().prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Padre  pr = new Padre();
				pr.setIdPadre(rs.getInt(1));
				pr.setNombre(rs.getString(2));
				pr.setDni(rs.getString(3));
				pr.setTelefono(rs.getString(4));
				pr.setCorreo(rs.getString(5));
				lista.add(pr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

}
