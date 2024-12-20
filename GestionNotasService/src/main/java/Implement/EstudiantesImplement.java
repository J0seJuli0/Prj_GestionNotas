package Implement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connection.ClassConnection;
import Interface.EstudiantesInterface;
import Model.Estudiantes;
import Model.Padre;

public class EstudiantesImplement implements EstudiantesInterface{

	public void RegistrarEstudiantes(Estudiantes est) {
		String sql = "INSERT INTO estudiantes VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = null; 
		try {
			ps = ClassConnection.conectarMySQL().prepareStatement(sql);
			ps.setString(1, est.getNombre());
			ps.setString(2, est.getDni());
			//FOMRATEAMOS
			java.sql.Date sqlDate = new java.sql.Date(est.getFechaNacimiento().getTime());
			ps.setDate(3, sqlDate);
			ps.setString(4, est.getGenero());
			ps.setString(5, est.getDireccion());
			ps.setString(6, est.getTelefono());
			ps.setString(7, est.getCorreo());
			if (est.getPadre() != null) {
	            ps.setInt(8, est.getPadre().getIdPadre()); 
	        } else {
	            throw new SQLException("El estudiante debe tener un padre asignado.");
	        }
			int y=ps.executeUpdate();
			if (y>0) {
				System.out.println("Dato registrado correctamente.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void ActualizarEstudiantes(Estudiantes est) {
	    String sql = "UPDATE estudiantes SET nombre=?, dni=?, fecha_nacimiento=?, genero=?, direccion=?, telefono=?, correo=?, id_padre=? WHERE id_estudiante=?";
	    PreparedStatement ps = null;
	    try {
	        ps = ClassConnection.conectarMySQL().prepareStatement(sql);
	        ps.setString(1, est.getNombre());
	        ps.setString(2, est.getDni());

	        java.sql.Date sqlDate = new java.sql.Date(est.getFechaNacimiento().getTime());
	        ps.setDate(3, sqlDate);

	        if (est.getGenero().equals("M") || est.getGenero().equals("F") || est.getGenero().equals("Otro")) {
	            ps.setString(4, est.getGenero());
	        } else {
	            throw new SQLException("Valor de g�nero no v�lido");
	        }

	        ps.setString(5, est.getDireccion());
	        ps.setString(6, est.getTelefono());
	        ps.setString(7, est.getCorreo());

	        if (est.getPadre() != null) {
	            ps.setInt(8, est.getPadre().getIdPadre());
	        } else {
	            throw new SQLException("El estudiante debe tener un padre asignado.");
	        }

	        ps.setInt(9, est.getIdEstudiante()); 

	        int resultado = ps.executeUpdate();
	        if (resultado > 0) {
	            System.out.println("Dato actualizado correctamente.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


	public Estudiantes BuscarEstudiantes(Estudiantes est) {
		String sql = "SELECT * FROM estudiantes WHERE id_estudiante=?";
		PreparedStatement ps= null;
		ResultSet rs = null;
		Estudiantes estu = new Estudiantes();
		try {
			ps = ClassConnection.conectarMySQL().prepareStatement(sql);
			ps.setInt(1, est.getIdEstudiante());
			rs=ps.executeQuery();
			if (rs.next()) {
				estu.setIdEstudiante(rs.getInt(1));
				estu.setNombre(rs.getString(2));
				estu.setDni(rs.getString(3));
				estu.setFechaNacimiento(rs.getDate(4));
				estu.setGenero(rs.getString(5));
				estu.setDireccion(rs.getString(6));
				estu.setTelefono(rs.getString(7));
				estu.setCorreo(rs.getString(8));
				Padre pad = new Padre();
				pad.setIdPadre(rs.getInt(9));
				estu.setPadre(pad);
			}
		} catch (SQLException e) {
				e.printStackTrace();
		}
		return estu;
	}

	public List<Estudiantes> ListarEstudiantes() {
	    String sql = "SELECT e.id_estudiante, e.nombre, e.dni, e.fecha_nacimiento, e.genero, e.direccion, e.telefono, e.correo, p.nombre " +
	                 "FROM estudiantes e " +
	                 "LEFT JOIN padres p ON e.id_padre = p.id_padre";
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    List<Estudiantes> listado = new ArrayList<Estudiantes>();
	    try {
	        ps = ClassConnection.conectarMySQL().prepareStatement(sql);
	        rs = ps.executeQuery();
	        while (rs.next()) {
	            Estudiantes estu = new Estudiantes();
	            estu.setIdEstudiante(rs.getInt(1));  
	            estu.setNombre(rs.getString(2));   
	            estu.setDni(rs.getString(3));      
	            estu.setFechaNacimiento(rs.getDate(4));
	            estu.setGenero(rs.getString(5));  
	            estu.setDireccion(rs.getString(6)); // direccion
	            estu.setTelefono(rs.getString(7));  // telefono
	            estu.setCorreo(rs.getString(8));    // correo
	            
	            Padre pad = new Padre();
	            pad.setNombre(rs.getString(9));     // nombre del padre
	            estu.setPadre(pad);

	            listado.add(estu);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (ps != null) ps.close();
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    }
	    return listado;
	}

}
