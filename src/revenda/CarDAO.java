package revenda;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class CarDAO {

    public CarDAO() {

    }

    public static Car getCarById(int id) {
        DbConnector.connect();
        Connection conn = DbConnector.getConnection();
        Statement stmt = null;
        Car carro = null;

        try {

            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM car WHERE id = " + id);

            while (rs.next()) {
                carro = new Car();
                carro.fillWithResultSet(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CarDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

        }

        return carro;
    }

    public static boolean insertCar(Car c) {
        DbConnector.connect();

        String query = "INSERT INTO car ("
                + "nome,renavam,ano_modelo,ano_fabricacao,combustivel,"
                + "placa,marca,modelo,ar_cond,air_bag,cd_player,direcao_hidraulica,"
                + "vidro_eletrico,trava_eletrica,cambio_automatico,alarme,zero_km,desembacador_traseiro,"
                + "rodas_liga,km,cor,data_fabricacao,preco_compra,preco_venda"
                + ")"
                + "VALUES ("
                + "\"" + c.getNome() + "\","
                + "\"" + c.getRenavam() + "\","
                + "\"" + c.getAnoModelo() + "\","
                + "\"" + c.getAnoFabricacao() + "\","
                + "\"" + c.getCombustivel() + "\","
                + "\"" + c.getPlaca() + "\","
                + "\"" + c.getMarca() + "\","
                + "\"" + c.getModelo() + "\","
                + "\"" + c.arCondicionadoInt() + "\","
                + "\"" + c.airBagInt() + "\","
                + "\"" + c.cdPlayerInt() + "\","
                + "\"" + c.direcaoHidraulicaInt() + "\","
                + "\"" + c.vidroEletricoInt() + "\","
                + "\"" + c.travaEletricaInt() + "\","
                + "\"" + c.cambioAutomaticoInt() + "\","
                + "\"" + c.AlarmeInt() + "\","
                + "\"" + c.zeroKmInt() + "\","
                + "\"" + c.desembacadorTraseiroInt() + "\","
                + "\"" + c.rodasLigaInt() + "\","
                + "\"" + c.getKm() + "\","
                + "\"" + c.getCor() + "\","
                + "\"" + c.getDataFabricacaoString() + "\","
                + "\"" + c.getPrecoCompra() + "\","
                + "\"" + c.getPrecoVenda() + "\""
                + ")";

        Statement statement;
        try {
            statement = DbConnector.getConnection().createStatement();
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            DbConnector.disconnect();
            return false;
        }

        DbConnector.disconnect();
        return true;
    }

    public static List<Car> list() {
        DbConnector.connect();
        Connection conn = DbConnector.getConnection();
        Statement stmt = null;
        List<Car> list = new ArrayList<>();

        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM car");

            while (rs.next()) {
            	Car carro = new Car();
                carro.fillWithResultSet(rs);
                list.add(carro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CarDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

        }

        return list;

    }

    public static boolean editCar(int id, Car c) {
        DbConnector.connect();

        String query = "UPDATE car SET "
                + "nome = \"" + c.getNome() + "\","
                + "renavam = \"" + c.getRenavam() + "\","
                + "ano_modelo = \"" + c.getAnoModelo()+ "\","
                + "ano_fabricacao = \"" + c.getAnoFabricacao()+ "\","
                + "combustivel = \"" + c.getCombustivel()+ "\","
                + "placa = \"" + c.getPlaca()+ "\","
                + "marca = \"" + c.getMarca()+ "\","
                + "modelo = \"" + c.getModelo()+ "\","
                + "ar_cond = \"" + c.arCondicionadoInt() + "\","
                + "air_bag = \"" + c.airBagInt() + "\","
                + "cd_player = \"" + c.cdPlayerInt() + "\","
                + "direcao_hidraulica = \"" + c.direcaoHidraulicaInt() + "\","
                + "vidro_eletrico = \"" + c.vidroEletricoInt() + "\","
                + "trava_eletrica = \"" + c.travaEletricaInt() + "\","
                + "cambio_automatico = \"" + c.cambioAutomaticoInt() + "\","
                + "alarme = \"" + c.AlarmeInt() + "\","
                + "zero_km = \"" + c.zeroKmInt() + "\","
                + "desembacador_traseiro = \"" + c.desembacadorTraseiroInt() + "\","
                + "rodas_liga = \"" + c.rodasLigaInt() + "\","
                + "km = \"" + c.getKm()+ "\","
                + "cor = \"" + c.getCor()+ "\","
                + "data_fabricacao = \"" + c.getDataFabricacaoString()+ "\","
                + "preco_compra = \"" + c.getPrecoCompra()+ "\","
                + "preco_venda = \"" + c.getPrecoVenda()+ "\" "
                + "WHERE id = " + id;

        System.out.println(query);
        // create a Statement from the connection
        Statement statement;
        try {
            statement = DbConnector.getConnection().createStatement();
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            DbConnector.disconnect();
            return false;
        }

        DbConnector.disconnect();
        return true;
    }

    public static boolean deleteCar(Car c) {
        DbConnector.connect();
        Connection conn = DbConnector.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("DELETE FROM car WHERE id = ?");
            stmt.setInt(1, c.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            return false;
        } finally {
            DbConnector.disconnect();
        }
        
        return true;
    }

}
