package model;

public class Orders {
    private int id;
    private String nume_client;
    private String nume_produs;
    private int pret;
    private int cantitate;
    /**
     * Constructs an Orders object with the specified id, client name, product name, price, and quantity.
     *
     * @param id           the id of the order
     * @param nume_client  the client name
     * @param nume_produs  the product name
     * @param pret         the price of the product
     * @param cantitate    the quantity of the product
     */
    public Orders(int id,String nume_client,String nume_produs,int pret,int cantitate)
    {
        this.setId(id);
        this.setCantitate(cantitate);
        this.setNume_client(nume_client);
        this.setNume_produse(nume_produs);
        this.setPret(pret);
    }
    /**
     * Constructs an Orders object with the specified client name, product name, and quantity.
     *
     * @param nume_client  the client name
     * @param nume_produse  the product name
     * @param cantitate    the quantity of the product
     */
    public Orders(String nume_client,String nume_produse,int cantitate)
    {

        this.setCantitate(cantitate);
        this.setNume_client(nume_client);
        this.setNume_produse(nume_produse);
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNume_client() {
        return nume_client;
    }
    public void setNume_client(String nume_client) {
        this.nume_client = nume_client;
    }
    public String getNume_produse() {
        return nume_produs;
    }
    public void setNume_produse(String nume_produse) {
        this.nume_produs = nume_produse;
    }
    public int getPret() {
        return pret;
    }
    public void setPret(int pret) {
        this.pret = pret;
    }
    public int getCantitate() {
        return cantitate;
    }
    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }
    @Override
    public String toString() {
        return "Order: " +
                "[ id=" + id +
                ", client name=" + nume_client +
                ", product name=" + nume_produs +
                ", quantity=" + cantitate +
                ",price="+pret + "]";
    }



}
