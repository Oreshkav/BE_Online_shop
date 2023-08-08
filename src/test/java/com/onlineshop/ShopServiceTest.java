package com.onlineshop;


import com.onlineshop.controller.dto.ShopDTO;
import com.onlineshop.domain.Shop;
import com.onlineshop.repository.ShopRepository;
import com.onlineshop.service.ShopService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ShopServiceTest {

  @Autowired
  private ShopService shopService;

  @Autowired
  private ShopRepository shopRepository;

  @Test
  public void findAllShopsTest() {
    ShopDTO shopKharkiv = new ShopDTO(null, "Shop Kharkiv");
    shopService.add(shopKharkiv);

    ShopDTO shopDnipro = new ShopDTO(null, "Shop Dnipro");
    shopService.add(shopDnipro);

    List<ShopDTO> shopsTest = shopService.findAllShops();
    Assertions.assertEquals(2, shopsTest.size());
  }




}
