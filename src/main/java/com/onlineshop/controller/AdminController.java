package com.onlineshop.controller;

import com.onlineshop.controller.dto.CountryDTO;
import com.onlineshop.controller.dto.ShopDTO;
import com.onlineshop.service.CountryService;
import com.onlineshop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Администрирование записей БД:
 * - редактирование справочника стран (countries)
 * - редактирование справочника поставшиков (suppliers)
 * - редактирование справочника покупателей (customers)
 * - редактирование справочника товаров (products)
 * - редактирование справочника магазинов (shops)
 * <p>
 * Управление товарными запасами:
 * - оформление поставки товара в магазин(ы)
 * - оформление отгрузки товара покупателю согласно заказу
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

  @Autowired
  private CountryService countryService;

  @Autowired
  private ShopService shopService;

  @GetMapping("/country/all")
  private List<CountryDTO> findAll() {
    return countryService.findAll();
  }

  @PostMapping("/country/add")
  public CountryDTO addCountry(@RequestBody CountryDTO country) {
    return countryService.add(country);
  }

  @PutMapping("/country/update/{id}")
  public CountryDTO updateCountry(@RequestBody CountryDTO country, @PathVariable Integer id) {
    return countryService.update(id, country);
  }

  @DeleteMapping("/country/delete/{id}")
  public CountryDTO deleteCountry(@PathVariable Integer id) {
    return countryService.delete(id);
  }

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
