package Implement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connection.ClassConnection;
import Interface.CursosInterface;
import Model.Cursos;
import Model.Docentes;
import Model.Estudiantes;
import Model.Padre;

public class CursosImplement implements CursosInterface{

	public void RegistrarCursos(Cursos cur) {
		String sql = "INSERT INTO cursos VALUES (null, ?, ?, ?)";
		PreparedStatement ps = null; 
		try {
			ps = ClassConnection.conectarMySQL().prepareStatement(sql);
			ps.setString(1, cur.getNombreCurso());
			ps.setString(2, cur.getDescripcion());
			if (cur.getDocente() != null) {
	            ps.setInt(3, cur.getDocente().getIdDocente()); 
	        } else {
	            throw new SQLException("El curso debe tener un docente asignado.");
	        }
			int y=ps.executeUpdate();
			if (y>0) {
				System.out.println("Dato registrado correctamente.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void ActualizarCursos(Cursos cur) {
		String sql = "UPDATE cursos SET nombre_curso=?, descripcion=?, id_docente=? WHERE id_curso=?";
		PreparedStatement ps = null;
		try {
			ps = ClassConnection.conectarMySQL().prepareStatement(sql);
			ps.setString(1, cur.getNombreCurso());
			ps.setString(2, cur.getDescripcion());
			if (cur.getDocente() != null) {
	            ps.setInt(3, cur.getDocente().getIdDocente()); 
	        } else {
	            throw new SQLException("El curso debe tener un docente asignado.");
	        }
			ps.setInt(4, cur.getIdCurso());
			int y=ps.executeUpdate();
			if (y>0) {
				System.out.println("Dato actualizado correctamente.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public Cursos BuscarCurso(Cursos cur) {
	    String sql = "SELECT * FROM cursos c JOIN docentes d ON c.id_docente = d.id_docente WHERE c.id_curso=?";
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    Cursos curs = new Cursos();
	    try {
	        ps = ClassConnection.conectarMySQL().prepareStatement(sql);
	        ps.setInt(1, cur.getIdCurso()); 
	        rs = ps.executeQuery();
	        if (rs.next()) {
	            curs.setIdCurso(rs.getInt("id_curso"));
	            curs.setNombreCurso(rs.getString("nombre_curso"));
	            curs.setDescripcion(rs.getString("descripcion"));
	            
	            Docentes doce = new Docentes();
	            doce.setIdDocente(rs.getInt("id_docente"));
	            doce.setNombre(rs.getString("nombre")); 
	            curs.setDocente(doce); 
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return curs;
	}
	
	

	public List<Cursos> ListarCursos() {
	    String sql = "SELECT c.id_curso, c.nombre_curso, c.descripcion, d.id_docente, d.nombre " +
	                 "FROM cursos c JOIN docentes d ON c.id_docente = d.id_docente";
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    List<Cursos> listado = new ArrayList<Cursos>();
	    
	    try {
	        ps = ClassConnection.conectarMySQL().prepareStatement(sql);
	        rs = ps.executeQuery();
	        
	        while (rs.next()) {
	            Cursos curs = new Cursos();
	            curs.setIdCurso(rs.getInt("id_curso"));
	            curs.setNombreCurso(rs.getString("nombre_curso"));
	            curs.setDescripcion(rs.getString("descripcion"));
	            
	            Docentes doce = new Docentes();
	            doce.setIdDocente(rs.getInt("id_docente"));
	            doce.setNombre(rs.getString("nombre")); 
	            
	            curs.setDocente(doce);
	            listado.add(curs);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return listado;
	}


}
