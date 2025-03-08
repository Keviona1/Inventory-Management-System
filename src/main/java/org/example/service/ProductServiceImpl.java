package org.example.service;

import org.example.config.HibernateConfig;
import org.example.converter.ProductConverter;
import org.example.dao.ProductDao;
import org.example.dao.ProductDaoImpl;
import org.example.dto.ProductDto;
import org.example.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ProductServiceImpl implements ProductService{
    private final SessionFactory sessionFactory = HibernateConfig.getSessionFactory();

    private final ProductDao productDao = new ProductDaoImpl(sessionFactory);



    @Override
    public Product createProduct(ProductDto productDto) {
     Product product = ProductConverter.convertDtoToEntity(productDto);
     productDao.save(product);
     return product;
    }

    @Override
    public Product findOne(Long id) {
        return productDao.findById(id);
    }


}
