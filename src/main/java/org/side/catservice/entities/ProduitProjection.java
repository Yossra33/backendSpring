package org.side.catservice.entities;

import org.springframework.data.rest.core.config.Projection;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@Projection(name="p1",types = Produit.class)
public interface ProduitProjection {
    public double getPrice();
    public String getDesignation();

}
