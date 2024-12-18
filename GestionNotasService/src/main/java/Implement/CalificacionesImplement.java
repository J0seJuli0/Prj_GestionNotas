package Implement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connection.ClassConnection;
import Interface.CalificacionesInterface;
import Model.Calificaciones;
import Model.Cursos;
import Model.Estudiantes;

public class CalificacionesImplement implements CalificacionesInterface {

    public void RegistrarCalificacion(Calificaciones cal) {
        String sql = "INSERT INTO calificaciones VALUES (null, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = null;
        try {
            ps = ClassConnection.conectarMySQL().prepareStatement(sql);

            if (cal.getEstudiantes() != null) {
	            ps.setInt(1, cal.getEstudiantes().getIdEstudiante());
	        } else {
	            throw new SQLException("La calificación debe tener un estudiante asignado.");
	        }

            if (cal.getCursos() != null) {
	            ps.setInt(2, cal.getCursos().getIdCurso());
	        } else {
	            throw new SQLException("La calificación debe tener un curso asignado.");
	        }
            
            ps.setDouble(3, cal.getNota());

            java.sql.Date sqlDate = new java.sql.Date(cal.getFecha().getTime());
            ps.setDate(4, sqlDate);

            ps.setString(5, cal.getComentarios());
            ps.setString(6, cal.getTipoEvaluacion());

            int y = ps.executeUpdate();
            if (y > 0) {
                System.out.println("Dato registrado correctamente.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void ActualizarCalificacion(Calificaciones cal) {
        String sql = "UPDATE calificaciones SET id_estudiante = ?, id_curso = ?, nota = ?, fecha = ?, comentarios = ?, tipo_evaluacion = ? WHERE id_calificacion= ?";
        PreparedStatement ps = null;
        try {
            ps = ClassConnection.conectarMySQL().prepareStatement(sql);

            if (cal.getEstudiantes() != null) {
	            ps.setInt(1, cal.getEstudiantes().getIdEstudiante());
	        } else {
	            throw new SQLException("La calificación debe tener un estudiante asignado.");
	        }
            
            if (cal.getCursos() != null) {
	            ps.setInt(2, cal.getCursos().getIdCurso());
	        } else {
	            throw new SQLException("La calificación debe tener un curso asignado.");
	        }
            
            ps.setDouble(3, cal.getNota());

            java.sql.Date sqlDate = new java.sql.Date(cal.getFecha().getTime());
            ps.setDate(4, sqlDate);

            ps.setString(5, cal.getComentarios());
            ps.setString(6, cal.getTipoEvaluacion());

            ps.setInt(7, cal.getIdCalificacion());

            int y = ps.executeUpdate();
            if (y > 0) {
                System.out.println("Dato actualizado correctamente.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Calificaciones> ListadoCalificaciones() {
        String sql = "SELECT cal.id_calificacion, e.id_estudiante, e.nombre, cur.id_curso, cur.nombre_curso, cal.nota, cal.fecha, cal.comentarios, cal.tipo_evaluacion " +
                     "FROM calificaciones cal " +
                     "JOIN estudiantes e ON cal.id_estudiante = e.id_estudiante " +
                     "JOIN cursos cur ON cal.id_curso = cur.id_curso";
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Calificaciones> listado = new ArrayList<Calificaciones>();
        try {
            ps = ClassConnection.conectarMySQL().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Calificaciones cal = new Calificaciones();
                cal.setIdCalificacion(rs.getInt(1));

                // Crear el estudiante con su nombre
                Estudiantes estu = new Estudiantes();
                estu.setIdEstudiante(rs.getInt(2));
                estu.setNombre(rs.getString(3)); // Nombre del estudiante

                // Crear el curso con su nombre
                Cursos cur = new Cursos();
                cur.setIdCurso(rs.getInt(4));
                cur.setNombreCurso(rs.getString(5)); // Nombre del curso

                cal.setEstudiantes(estu);
                cal.setCursos(cur);
                cal.setNota(rs.getDouble(6));
                cal.setFecha(rs.getDate(7));
                cal.setComentarios(rs.getString(8));
                cal.setTipoEvaluacion(rs.getString(9));

                listado.add(cal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listado;
    }

}
