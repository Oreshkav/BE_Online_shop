package com.onlineshop.controller;

import com.onlineshop.controller.dto.CountryDTO;
import com.onlineshop.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminCountryController {

  @Autowired
  private CountryService countryService;

  @GetMapping("/country/all")
  private List<CountryDTO> findAll() {
    return countryService.findAll();
  }

  @PostMapping("/country/add")
  public CountryDTO addCountry(@RequestBody CountryDTO country) {
    return countryService.add(country);
  }

  @PutMapping("/country/update/{id}")
  public ResponseEntity<CountryDTO> updateCountry(@RequestBody CountryDTO country,
                                                  @PathVariable Integer id) {
    CountryDTO countryDTO = countryService.update(id, country);
    if(countryDTO == null ) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(countryDTO);
    //вернет правильный заголовок с ошибкой 404
  }

  @DeleteMapping("/country/delete/{id}")
  public CountryDTO deleteCountry(@PathVariable Integer id) {
    return countryService.delete(id);
  }

}
