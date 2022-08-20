package com.samsungconek.service.product;

import com.samsungconek.model.dto.ProductDto;
import com.samsungconek.model.entity.Category;
import com.samsungconek.model.entity.Product;
import com.samsungconek.repository.IProductRepository;
import com.samsungconek.utils.CustomResponse;
import com.samsungconek.utils.exception.BusinessAssert;
import com.samsungconek.utils.exception.BusinessExceptionCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        List<Product> products = productRepository.findAll();
        BusinessAssert.isTrue(products.size() > 0, BusinessExceptionCode.EMPTY_LIST, "Danh sách rỗng");
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        BusinessAssert.isTrue(productOptional.isPresent(), BusinessExceptionCode.NOT_EXIST, "Không tồn tại");
        return productOptional.get();
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public CustomResponse deleteById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        BusinessAssert.isTrue(productOptional.isPresent(), BusinessExceptionCode.NOT_EXIST, "Không tồn tại");
        productRepository.deleteById(id);
        return new CustomResponse();
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Iterable<Product> findProductsByCategories(List<Category> categories) {
        return null;
    }

    @Override
    public Product save(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setDiscount(productDto.getDiscount());
        product.setPrice(productDto.getPrice());
        product.setColor(productDto.getColor());
        product.setCategories(productDto.getCategories());
        product.setPriority(productDto.getPriority());
        product.setStatus(productDto.isStatus());
        product.setStock(productDto.getStock());
        product.setContent(productDto.getContent());
        return productRepository.save(product);
    }

    @Override
    public Product update(Long id, ProductDto productDto) {
        Optional<Product> productOptional = productRepository.findById(id);
        BusinessAssert.isTrue(productOptional.isPresent(), BusinessExceptionCode.NOT_EXIST, "Không tồn tại");
        Product product = new Product();
        product.setId(id);
        product.setName(productDto.getName());
        product.setDiscount(productDto.getDiscount());
        product.setPrice(productDto.getPrice());
        product.setColor(productDto.getColor());
        product.setCategories(productDto.getCategories());
        product.setPriority(productDto.getPriority());
        product.setStatus(productDto.isStatus());
        product.setStock(productDto.getStock());
        product.setContent(productDto.getContent());
        return productRepository.save(product);
    }
}
