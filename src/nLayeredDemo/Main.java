/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nLayeredDemo;

import nLayeredDemo.bussiness.abstracts.ProductService;
import nLayeredDemo.bussiness.concretes.ProductManager;
import nLayeredDemo.core.JLoggerManagerAdapter;
import nLayeredDemo.dataAccess.concretes.AbcProductDao;
import nLayeredDemo.dataAccess.concretes.HibernateProductDao;
import nLayeredDemo.entities.concretes.Product;

/**
 *
 * @author yahya
 */
public class Main {
    public static void main(String[] args){
        // entityler hariç new yapıyorsan ilerde sıkıntı çıkar
        // spring ile düzenlenecek kısım bu alttaki newleme
        ProductService productService = new ProductManager(new AbcProductDao(), new JLoggerManagerAdapter());
        Product product = new Product(1,2,"armut",12,50);
        productService.add(product);
    }
}
