package com.onlineshop.controller;

import com.onlineshop.controller.dto.ProductDTO;
import com.onlineshop.controller.dto.ProductsDTO;
import com.onlineshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Операции с товарными позициями (доступно для всех):
 * - найти все товарные позиции
 * - найти товарную позицию по id
 * - найти товарные позиции по части описания
 * - найти товарные позиции по категории
 */

@RestController
@RequestMapping("/product")
public class ProductController {

  @Autowired
  private ProductService productService;

  @GetMapping("/all")
  public ProductsDTO findAll() {
    return productService.findAll();
  }

  @GetMapping("/{id}")
  public ProductDTO findById(@PathVariable Integer id) {
    return productService.findById(id);
  }

  @GetMapping("/description/{partDescription}")
  public ProductsDTO findByPartDescription(@PathVariable String partDescription) {
    return productService.findByPartDescription(partDescription);
  }

  @GetMapping("/all/category/{categoryId}")
  public ProductsDTO findByCategory(@PathVariable Integer categoryId) {
    return productService.findByCategoryId(categoryId);
  }
}
