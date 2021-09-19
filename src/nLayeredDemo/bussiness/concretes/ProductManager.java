package nLayeredDemo.bussiness.concretes;

import java.util.List;
import nLayeredDemo.bussiness.abstracts.ProductService;
import nLayeredDemo.core.LoggerService;
import nLayeredDemo.dataAccess.abstracts.ProductDao;
import nLayeredDemo.entities.concretes.Product;

public class ProductManager implements ProductService {

    private ProductDao productDao;// constructor ile enjekte edilir
    private LoggerService loggerService;// servisi dahil ettik kendi servisimizle
    public ProductManager(ProductDao productDao, LoggerService loggerService) {//hibernate e bağlı değiliz şuan
        this.productDao = productDao;
        this.loggerService = loggerService;
    }

    @Override
    public void add(Product product) {
        if (product.getCategoryId() == 1) {
            System.out.println("bu kategoride ürün kabulü mümkün değil");
            return;
        }
        // buraya normalde kullanacağımız şey hibernate i çağırmak ama tek hibernate 
        // ama ilerde hibernate i kullanmayacak olursak patlarızzzz o yüzden dependency injection yapılır 
        //  oda productDao üzerinden bir yapı oluşturulur
        this.productDao.add(product);//hibernate ile bağlılık bitti
        this.loggerService.logToSystem("deneme");
    }

    @Override
    public List<Product> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
