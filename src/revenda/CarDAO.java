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
                carro.setId(rs.getInt("id"));
                carro.setNome(rs.getString("nome"));
                carro.setRenavam(rs.getString("renavam"));
                carro.setAirBag(rs.getBoolean("air_bag"));
                carro.setArCondicionado(rs.getBoolean("ar_cond"));
                carro.setCdPlayer(rs.getBoolean("cd_player"));
                carro.setDirecaoHidraulica(rs.getBoolean("direcao_hidraulica"));
                carro.setVidroEletrico(rs.getBoolean("vidro_eletrico"));
                carro.setTravaEletrica(rs.getBoolean("trava_eletrica"));
                carro.setCambioAutomatico(rs.getBoolean("cambio_automatico"));
                carro.setAlarme(rs.getBoolean("alarme"));
                carro.setZeroKm(rs.getBoolean("zero_km"));
                carro.setDesembacadorTraseiro(rs.getBoolean("desembacador_traseiro"));
                carro.setRodasLiga(rs.getBoolean("rodas_liga"));
                carro.setKm(Integer.parseInt(rs.getString("km")));
                carro.setCor(rs.getString("cor"));
                carro.setPrecoCompra(rs.getFloat("preco_compra"));
                carro.setPrecoVenda(rs.getFloat("preco_venda"));

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
                carro.setId(rs.getInt("id"));
                carro.setNome(rs.getString("nome"));
                carro.setRenavam(rs.getString("renavam"));
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
                + "nome = \"" + c.getNome() + "\""
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

    public void deleteCar(Car c) {
        DbConnector.connect();
        Connection conn = DbConnector.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("DELETE FROM car WHERE id = ?");
            stmt.setInt(1, c.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            DbConnector.disconnect();
        }

    }

}
