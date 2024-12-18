package Implement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connection.ClassConnection;
import Interface.ReportesInterface;
import Model.Reportes;

public class ReportesImplement implements ReportesInterface{

	public void RegistrarReportes(Reportes rep) {
		String sql = "INSERT INTO reportes VALUES(null, ?, ?, ?)";
		PreparedStatement ps =  null;
		try {
			
			ps = ClassConnection.conectarMySQL().prepareStatement(sql);
			ps.setInt(1, rep.getIdEstudiante());

			java.sql.Date sqlDate = new java.sql.Date(rep.getFecha().getTime());
	        ps.setDate(2, sqlDate);
	        
			ps.setString(3, rep.getRendimiento());
			int y = ps.executeUpdate();
			if (y>0) {
				System.out.println("Reporte registrado Correctamente.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void ActualizarReportes(Reportes rep) {
		String sql= "UPDATE reportes SET id_estudiante=?, fecha=?, rendimiento=? WHERE id_reporte=?";
		PreparedStatement ps= null;
		try {
			if (rep.getFecha() ==null) {
				rep.setFecha(new java.sql.Date(new java.util.Date().getTime()));
			}
			ps = ClassConnection.conectarMySQL().prepareStatement(sql);
			ps.setInt(1, rep.getIdEstudiante());

			java.sql.Date sqlDate = new java.sql.Date(rep.getFecha().getTime());
	        ps.setDate(2, sqlDate);
	        
			ps.setString(3, rep.getRendimiento());
			ps.setInt(4, rep.getIdReporte());
			int w=ps.executeUpdate();
			if (w>0){
				System.out.println("Reporte actualizado correctamente.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void EliminarReportes(Reportes rep) {
		String sql = "DELETE FROM reportes WHERE id_reporte=?";
		PreparedStatement ps= null;
		try {
			ps = ClassConnection.conectarMySQL().prepareStatement(sql);
			ps.setInt(1, rep.getIdReporte());
			int g=ps.executeUpdate();
			if (g>0) {
				System.out.println("Reporte eliminado correctamente.");
			}else {
				System.out.println("Error al eliminar el reporte.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public Reportes BuscarReportes(Reportes rep) {
		String sql = "SELECT * FROM reportes WHERE id_reporte=?";
		PreparedStatement ps= null;
		ResultSet rs=null;
		Reportes rp = new Reportes();
		try {
			ps = ClassConnection.conectarMySQL().prepareStatement(sql);
			ps.setInt(1, rep.getIdReporte());
			rs=ps.executeQuery();
			if (rs.next()) {
				rp.setIdReporte(rs.getInt(1));
				rp.setIdEstudiante(rs.getInt(2));
				rp.setFecha(rs.getDate(3));
				rp.setRendimiento(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rp;
	}

	public List<Reportes> ListarReportes() {
		String sql = "SELECT * FROM reportes";
		  PreparedStatement ps= null;
		  ResultSet rs=null;
		  List<Reportes> lista = new ArrayList<Reportes>();
		  try {
			ps = ClassConnection.conectarMySQL().prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()){
				Reportes repo = new Reportes();
				repo.setIdReporte(rs.getInt(1));
				repo.setIdEstudiante(rs.getInt(2));
				repo.setFecha(rs.getDate(3));
				repo.setRendimiento(rs.getString(4));
				lista.add(repo);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

}
