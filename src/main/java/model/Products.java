package model;

import dao.ProductsDAO;

import javax.swing.*;
import java.util.NoSuchElementException;

public class Products
{
    private int id;
    private String nume;
    private int cantitate;
    private int pret;
    /**
     * Constructs a Products object with the specified id, name, quantity, and price.
     *
     * @param id        the id of the product
     * @param nume      the name of the product
     * @param cantitate the quantity of the product
     * @param pret      the price of the product
     */
    public Products(int id,String nume,int cantitate,int pret)
    {
        this.setId(id);
        this.setNume(nume);
        this.setCantitate(cantitate);
        this.setPret(pret);
    }
    /**
     * Constructs a Products object with the specified name, quantity, and price.
     *
     * @param nume      the name of the product
     * @param cantitate the quantity of the product
     * @param pret      the price of the product
     */
    public Products(String nume,int cantitate,int pret)
    {
        this.setNume(nume);
        this.setCantitate(cantitate);
        this.setPret(pret);
    }

    public Products()
    {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public int getPret() {
        return pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    @Override
    public String toString() {
        return "Product: " + "[ id=" + id + ", name=" + nume + ", price=" + pret + ", stock=" + cantitate + "]";
    }


}

