package bussinesLayer;

import dao.ClientDAO;
import dao.ProductsDAO;
import model.Products;

import java.util.NoSuchElementException;

public class ProductBLL {
    ProductsDAO productDAO=new ProductsDAO();
    /**
     * Inserează un nou produs în sursa de date.
     *
     * @param product Produsul care urmează să fie inserat.
     * @return Produsul inserat.
     */
    public Products insertProduct(Products product) {
        return productDAO.insert(product);
    }
    /**
     * Actualizează un produs existent în sursa de date.
     *
     * @param product Produsul actualizat.
     * @param nume    Numele produsului care urmează să fie actualizat.
     * @return Produsul actualizat.
     */
    public Products updateProduct(Products product,String nume) {
        return productDAO.update(product, nume);
    }
    /**
     * Șterge un produs din sursa de date după nume.
     *
     * @param nume Numele produsului care urmează să fie șters.
     */
    public void deleteProduct(String nume) {
        productDAO.delete(nume);
    }
    /**
     * Găsește un produs după nume în sursa de date.
     *
     * @param nume Numele produsului căutat.
     * @return Produsul găsit.
     * @throws NoSuchElementException Dacă produsul nu este găsit în sursa de date.
     */
    public Products findProductByNume(String nume) {
        Products st= (Products) this.productDAO.findById(nume);
        if (st == null) {
            throw new NoSuchElementException("The Product with nume=" + nume + " was not found!");
        }
        return (Products) st;

    }

}
