package com.samsungconek.service.product;

import com.samsungconek.model.dto.ProductDto;
import com.samsungconek.model.entity.Category;
import com.samsungconek.model.entity.Product;
import com.samsungconek.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService extends IGeneralService<Product> {
    Page<Product> findAll(Pageable pageable);

    Iterable<Product> findProductsByCategories(List<Category> categories);

    Product save (ProductDto productDto);

    Product update (Long id, ProductDto productDto);
}