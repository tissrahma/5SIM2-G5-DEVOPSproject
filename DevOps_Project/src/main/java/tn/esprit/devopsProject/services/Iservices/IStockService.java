package tn.esprit.devopsProject.services.Iservices;

import tn.esprit.devopsProject.entities.Stock;

import java.util.List;

public interface IStockService {

    Stock addStock(Stock stock);
    Stock retrieveStock(Long id);
    List<Stock> retrieveAllStock();

}
