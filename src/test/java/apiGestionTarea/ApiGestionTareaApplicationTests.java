package apiGestionTarea;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ApiGestionTareaApplicationTests {

	@Autowired
	private DataSource dataSource;

	@Test
	void contextLoads() {

	}

	@Test
	void testDatabaseConnection() {
		try (Connection connection = dataSource.getConnection()) {
			assertNotNull(connection, "La conexión de la BD existe.");
			assertTrue(!connection.isClosed(), "La conexión a la bd esta abierta");
			System.out.println("¡¡¡Conexión exitosa a la base de datos.!!!!");
		} catch (SQLException e) {
			e.printStackTrace();
			assertTrue(false, "No se pudo conectar a la bd.");
			System.out.println("Conexión Fallida ");
		}
	}
}
