package Implement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connection.ClassConnection;
import Interface.DocentesInterface;
import Model.Docentes;

public class DocentesImplement implements DocentesInterface{

	public void RegistrarDocentes(Docentes doc) {
		String sql = "INSERT INTO docentes VALUES (null, ?, ?, ?, ?, ?)";
		PreparedStatement ps = null; 
		try {
			ps = ClassConnection.conectarMySQL().prepareStatement(sql);
			ps.setString(1, doc.getNombre());
			ps.setString(2, doc.getDni());
			ps.setString(3, doc.getTelefono());
			ps.setString(4, doc.getCorreo());
			ps.setString(5, doc.getEspecialidad());
			int y=ps.executeUpdate();
			if (y>0) {
				System.out.println("Dato registrado correctamente.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void ActualizarDocentes(Docentes doc) {
		String sql = "UPDATE docentes SET nombre=?, dni=?, telefono=?, correo=?, especialidad=? WHERE id_docente=?";
		PreparedStatement ps = null;
		try {
			ps = ClassConnection.conectarMySQL().prepareStatement(sql);
			ps.setString(1, doc.getNombre());
			ps.setString(2, doc.getDni());
			ps.setString(3, doc.getTelefono());
			ps.setString(4, doc.getCorreo());
			ps.setString(5, doc.getEspecialidad());
			ps.setInt(6, doc.getIdDocente());
			int v=ps.executeUpdate();
			if (v>0) {
				System.out.println("Dato actualizado correctamente.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public Docentes BuscarDocentes(Docentes doc) {
		String sql = "SELECT * FROM docentes WHERE id_docente=?";
		PreparedStatement ps= null;
		ResultSet rs = null;
		Docentes doce = new Docentes();
		try {
			ps = ClassConnection.conectarMySQL().prepareStatement(sql);
			ps.setInt(1, doc.getIdDocente());
			rs=ps.executeQuery();
			if (rs.next()) {
				doce.setIdDocente(rs.getInt(1));
				doce.setNombre(rs.getString(2));
				doce.setDni(rs.getString(3));
				doce.setTelefono(rs.getString(4));
				doce.setCorreo(rs.getString(5));
				doce.setEspecialidad(rs.getString(6));
				
			}
		} catch (SQLException e) {
				e.printStackTrace();
		}
		return doce;
	}

	public List<Docentes> ListarDocentes() {
		String sql = "SELECT * FROM docentes";
		PreparedStatement ps = null;
		ResultSet rs= null;
		List<Docentes> listado = new ArrayList<Docentes>();
		try {
			ps = ClassConnection.conectarMySQL().prepareStatement(sql);
			rs=ps.executeQuery();
			while (rs.next()) {
				Docentes doce= new Docentes();
				doce.setIdDocente(rs.getInt(1));
				doce.setNombre(rs.getString(2));
				doce.setDni(rs.getString(3));
				doce.setTelefono(rs.getString(4));
				doce.setCorreo(rs.getString(5));
				doce.setEspecialidad(rs.getString(6));
				listado.add(doce);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listado;
	}

}
