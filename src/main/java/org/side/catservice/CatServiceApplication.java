package org.side.catservice;

import org.side.catservice.dao.ProduitRepository;
import org.side.catservice.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@SpringBootApplication
public class CatServiceApplication  implements CommandLineRunner {
  @Autowired
   private  ProduitRepository produitRepository;
  @Autowired
  private RepositoryRestConfiguration restConfiguration;


    public static void main(String[] args) {
        SpringApplication.run(CatServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        restConfiguration.exposeIdsFor(Produit.class);
        produitRepository.save(new Produit(null,"ordinateur", 2100,3));
        produitRepository.save(new Produit(null,"imprimante", 3400,2));
        produitRepository.save(new Produit(null,"souris", 500,4));
        produitRepository.save(new Produit(null,"clavier", 200,5));


        produitRepository.findAll().forEach(p-> System.out.println(p.toString()));

    }
}
