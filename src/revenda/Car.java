/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package revenda;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Lucas
 */
public class Car {
    
    private int id;
    private String nome;
    private String renavam;
    private int ano_modelo;
    private int ano_fabricacao;
    private String combustivel;
    private String placa;
    private String marca;
    private String modelo;
    private boolean ar_condicionado;
    private boolean air_bag;
    private boolean cd_player;
    private boolean direcao_hidraulica;
    private boolean vidro_eletrico;
    private boolean trava_eletrica;
    private boolean cambio_automatico;
    private boolean alarme;
    private boolean zero_km;
    private boolean desembacador_traseiro;
    private boolean rodas_liga;
    private int km;
    private String cor;
    private Date data_fabricacao;
    private float preco_compra;
    private float preco_venda;

    public Car() {

    }
    
    public int getId(){
       return id; 
    }

    public void setId(int id){
        this.id = id;
    }
    
    public int id(){
        return id;
       
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public int getAnoModelo() {
        return ano_modelo;
    }

    public void setAnoModelo(int ano_modelo) {
        this.ano_modelo = ano_modelo;
    }

    public int getAnoFabricacao() {
        return ano_fabricacao;
    }

    public void setAnoFabricacao(int ano_fabricacao) {
        this.ano_fabricacao = ano_fabricacao;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public boolean arCondicionado() {
        return ar_condicionado;
    }
    
    public int arCondicionadoInt() {
        return ar_condicionado ? 1 : 0;
    }

    public void setArCondicionado(boolean ar_condicionado) {
        this.ar_condicionado = ar_condicionado;
    }

    public boolean airBag() {
        return air_bag;
    }

     public int airBagInt() {
        return air_bag ? 1 : 0;
    }
    public void setAirBag(boolean air_bag) {
        this.air_bag = air_bag;
    }
    
    public String getDataFabricacaoString(){
        if(this.getDataFabricacao() != null){
            return  new SimpleDateFormat("yyyy-MM-dd").format(this.getDataFabricacao()); 
        } else {
            return null;
        }
    }
    public boolean cdPlayer() {
        return cd_player;
    }
    
     public int cdPlayerInt() {
        return cd_player ? 1 : 0;
    }
    

    public void setCdPlayer(boolean cd_player) {
        this.cd_player = cd_player;
    }

    public boolean direcaoHidraulica() {
        return direcao_hidraulica;
    }
    
    public int direcaoHidraulicaInt() {
        return direcao_hidraulica ? 1 : 0;
        
        }

    public void setDirecaoHidraulica(boolean direcao_hidraulica) {
        this.direcao_hidraulica = direcao_hidraulica;
    }

    public boolean vidroEletrico() {
        return vidro_eletrico;
    }
    
      public int vidroEletricoInt() {
        return vidro_eletrico ? 1 : 0;
    }

    public void setVidroEletrico(boolean vidro_eletrico) {
        this.vidro_eletrico = vidro_eletrico;
    }

    public boolean travaEletrica() {
        return trava_eletrica;
    }
    public int travaEletricaInt() {
        return trava_eletrica ? 1 : 0;
    }
    public void setTravaEletrica(boolean trava_eletrica) {
        this.trava_eletrica = trava_eletrica;
    }

    public boolean cambioAutomatico() {
        return cambio_automatico;
    }
    
     public int cambioAutomaticoInt() {
        return cambio_automatico ? 1 : 0;
    }

    public void setCambioAutomatico(boolean cambio_automatico) {
        this.cambio_automatico = cambio_automatico;
    }

    public boolean alarme() {
        return alarme;

    }
    
     public int AlarmeInt() {
        return alarme ? 1 : 0;

    }
     
       public void setAlarme(boolean alarme) {
        this.alarme = alarme;
    }

    public boolean zeroKm() {
        return zero_km;
    }
    
    public int zeroKmInt() {
        return zero_km ? 1 : 0;
    }

    public void setZeroKm(boolean zero_km) {
        this.zero_km = zero_km;
    }

    public boolean desembacadorTraseiro() {
        return desembacador_traseiro;
    }
    
    public int desembacadorTraseiroInt() {
        return desembacador_traseiro ? 1 : 0;
    }

    public void setDesembacadorTraseiro(boolean desembacador_traseiro) {
        this.desembacador_traseiro = desembacador_traseiro;
    }

    public boolean rodasLiga() {
        return rodas_liga;
    }
    
     public int rodasLigaInt() {
        return rodas_liga ? 1 : 0;
    }

    public void setRodasLiga(boolean rodas_liga) {
        this.rodas_liga = rodas_liga;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Date getDataFabricacao() {
        return data_fabricacao;
    }

    public void setDataFabricacao(Date data_fabricacao) {
        this.data_fabricacao = data_fabricacao;
    }

    public float getPrecoCompra() {
        return preco_compra;
    }

    public void setPrecoCompra(float preco_compra) {
        this.preco_compra = preco_compra;
    }

    public float getPrecoVenda() {
        return preco_venda;
    }

    public void setPrecoVenda(float preco_venda) {
        this.preco_venda = preco_venda;
    }

    public String debug() {
        StringBuilder result = new StringBuilder();
        String newLine = System.getProperty("line.separator");

        result.append(this.getClass().getName());
        result.append(" Object {");
        result.append(newLine);

        //determine fields declared in this class only (no fields of superclass)
        Field[] fields = this.getClass().getDeclaredFields();

        //print field names paired with their values
        for (Field field : fields) {
            result.append("  ");
            try {
                result.append(field.getName());
                result.append(": ");
                //requires access to private field:
                result.append(field.get(this));
            } catch (IllegalAccessException ex) {
                System.out.println(ex);
            }
            result.append(newLine);
        }
        result.append("}");

        return result.toString();
    }
}
