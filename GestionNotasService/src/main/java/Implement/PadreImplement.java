package Implement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connection.ClassConnection;
import Interface.PadresInterface;
import Model.Padre;

public class PadreImplement implements PadresInterface{
	
	public void RegistrarPadres(Padre pad) {
		String sql = "INSERT INTO padres VALUES(null, ?, ?, ?, ?)";
		PreparedStatement ps= null;
		try {
			ps = ClassConnection.conectarMySQL().prepareStatement(sql);
			ps.setString(1, pad.getNombre());
			ps.setString(2, pad.getDni());
			ps.setString(3, pad.getTelefono());
			ps.setString(4, pad.getCorreo());
			ps.executeUpdate();
			int y=ps.executeUpdate();
			if (y>0) {
				System.out.println("Dato registrado correctamente.");
			}
		}catch (SQLException e) {
				e.printStackTrace();
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
