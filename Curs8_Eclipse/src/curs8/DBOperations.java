package curs8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author vali
 */
public class DBOperations {

	String error;
	Connection con;
	// Conectarea la baza de date

	public DBOperations() {
	}

	public void connect() throws ClassNotFoundException, SQLException, Exception {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca?useSSL=false", "root", "");
		} catch (ClassNotFoundException cnfe) {
			error = "ClassNotFoundException: Nu s-a gasit driverul bazei de date.";
			throw new ClassNotFoundException(error);
		} catch (SQLException cnfe) {
			error = "SQLException: Nu se poate conecta la baza de date.";
			throw new SQLException(error);
		} catch (Exception e) {
			error = "Exception: A aparut o exceptie neprevazuta in timp ce se stabilea legatura la baza de date.";
			throw new Exception(error);
		}
	}
	// end connect()

	public ResultSet vedeTabel(String tabel) throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String queryString = ("select * from `biblioteca`.`" + tabel + "`;");
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(queryString);
		} catch (SQLException sqle) {
			error = "SQLException: Interogarea nu a fost posibila.";
			throw new SQLException(error);
		} catch (Exception e) {
			error = "A aparut o exceptie in timp ce se extrageau datele.";
			throw new Exception(error);
		}
		return rs;
	}
	// end vedeTabel()
	public ResultSet TabelScrieri() throws SQLException, Exception{
		ResultSet rs = null;
		try {
			String queryString = ("select idscriere, a.nume AS nume, a.prenume AS prenume, c.titlu AS titlu, s.durata AS durata from autori_carti s INNER JOIN autori a ON s.idautor = a.idautor INNER JOIN carti c ON s.idcarte = c.idcarte ORDER BY idscriere;");
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(queryString);
		} catch (SQLException sqle) {
			error = "SQLException: Interogarea nu a fost posibila.";
			throw new SQLException(error);
		} catch (Exception e) {
			error = "A aparut o exceptie in timp ce se extrageau datele.";
			throw new Exception(error);
		}
		return rs;
	}

	public void disconnect() throws SQLException {
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException sqle) {
			error = ("SQLException: Nu se poate inchide conexiunea la baza de date.");
			throw new SQLException(error);
		}
	} // disconnect()

	public void adaugaCarte(String titlu, Long an, String gen, Long nrpagini, String editura) throws SQLException {
		try {
			// create a prepared SQL statement
			Statement stmt;
			stmt = con.createStatement();
			stmt.executeUpdate("insert into `biblioteca`.`carti`(titlu, an, gen, nrpagini, editura) values('" + titlu + "', '" + an + "', '" + gen + "', '" + nrpagini + "', '" + editura + "');");
		} catch (SQLException sqle) {
			error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate.";
			throw new SQLException(error);
		}
	}
	

	public void adaugaAutor(String nume, String prenume, Long nrcarti, String nationalitate) throws SQLException {
		try {
			// create a prepared SQL statement
			Statement stmt;
			stmt = con.createStatement();
			stmt.executeUpdate("insert into `biblioteca`.`autori`(nume, prenume, nrcarti, nationalitate) values('" + nume + "', '" + prenume + "', '" + nrcarti + "', '" + nationalitate + "');");
		} catch (SQLException sqle) {
			error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate.";
			throw new SQLException(error);
		}
	}
	
	public void adaugaScriere(Long idautor, Long idcarte, Long durata) throws SQLException {
		try {
			// create a prepared SQL statement
			Statement stmt;
			stmt = con.createStatement();
			stmt.executeUpdate("insert into `biblioteca`.`autori_carti`(idautor, idcarte, durata) values('" + idautor + "', '" + idcarte + "', '" + durata + "');");
		} catch (SQLException sqle) {
			error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate.";
			throw new SQLException(error);
		}
	}
	
	public void stergeTabela(String tabela, String denumirePK, Long id) throws SQLException, Exception {
		if (con != null) {
			try {
				// create a prepared SQL statement
				Statement stmt;
				stmt = con.createStatement();
				stmt.executeUpdate("delete from " + tabela + " where " + denumirePK + " = '" + id + "';");
			} catch (SQLException sqle) {
				error = "ExceptieSQL: Stergere nereusita; este posibil sa existe duplicate.";
				throw new SQLException(error);
			}
		} else {
			error = "Exceptie: Conexiunea cu baza de date a fost pierduta.";
			throw new Exception(error);
		}
	} // end of stergeTabela()

	public void modificaTabela(String tabela, String primarykey, long ID, String[] campuri, String[] valori)
			throws SQLException, Exception {
		String update = "update " + tabela + " set ";
		String temp = "";
		if (con != null) {
			try {
				for (int i = 0; i < campuri.length; i++) {
					if (i != (campuri.length - 1)) {
						
						temp = temp + campuri[i] + "='" + valori[i] + "', ";
					} else {
						temp = temp + campuri[i] + "='" + valori[i] + "' where " + primarykey + " = '" + ID + "';";
					}
				}
				update = update + temp;
				// create a prepared SQL statement
				Statement stmt;
				stmt = con.createStatement();

				stmt.executeUpdate(update);
			} catch (SQLException sqle) {
				error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate.";
				throw new SQLException(error);
			}
		} else {
			error = "Exceptie: Conexiunea cu baza de date a fost pierduta.";
			throw new Exception(error);
		}
	} // end of modificaTabela()
	
	public void afisare(ResultSet rs) throws ClassNotFoundException, SQLException, Exception{
		long idcarte, an, nrpagini;
		String titlu, gen, editura;
		while(rs.next()){
			idcarte = rs.getLong("idcarte");
			titlu = rs.getString("titlu");
			an = rs.getLong("an");
			gen = rs.getString("gen");
			nrpagini = rs.getLong("nrpagini");
			editura = rs.getString("editura");
			System.out.println("idcarte = " + idcarte + ", titlu = " + titlu + ", an = " + an + ", gen = " + gen + ", nrpagini = " + nrpagini + ", editura = " + editura);
		}
	}
}