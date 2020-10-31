package org.side.catservice;


import lombok.experimental.Delegate;
import org.side.catservice.dao.ProduitRepository;
import org.side.catservice.entities.Produit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")

public class ProduitRestServices {

    @Autowired
   private ProduitRepository produitRepository;

    @GetMapping(value = "/listProduits")
    public List<Produit> listProduits () {
    return produitRepository.findAll();

}
  
    @GetMapping(value = "/listProduits/{id}")
    public Produit  listProduits( @PathVariable (name="id")Long id){
        return produitRepository.findById(id).get();
        

    }
    @PutMapping (value = "/listProduits/{id}")
    public Produit  update(@PathVariable (name="id")Long id, @RequestBody Produit p) {
        p.setId(id);
        return produitRepository.save(p);
    }
    @PostMapping  (value = "/listProduits")
    public Produit  save(  @RequestBody Produit p) {

        return produitRepository.save(p);
    }

    @DeleteMapping (value = "/listProduits/{id}")
    public String  delete (@PathVariable (name="id")Long id) {
        produitRepository.deleteById(id);


return "ok";



    }}
