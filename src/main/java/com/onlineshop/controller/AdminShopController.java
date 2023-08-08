package com.onlineshop.controller;

import com.onlineshop.controller.dto.ShopDTO;
import com.onlineshop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/admin")
public class AdminShopController {

  @Autowired
  private ShopService shopService;

  @GetMapping("/shop/all")
  private List<ShopDTO> findAllShops() {
    return shopService.findAllShops();
  }

  @PostMapping("/shop/add")
  public ShopDTO addShop(@RequestBody ShopDTO shop) {
    return shopService.add(shop);
  }

  @PutMapping("/shop/update/{id}")
  public ShopDTO updateShop(@RequestBody ShopDTO shop, @PathVariable Integer id) {
    return shopService.update(id, shop);
  }

  @DeleteMapping("/shop/delete/{id}")
  public ShopDTO deleteShop(@PathVariable Integer id) {
    return shopService.delete(id);
  }
}
