package tn.esprit.devops_project;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;


import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.annotation.Rollback;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.repositories.StockRepository;
import tn.esprit.devops_project.services.StockServiceImpl;
import org.mockito.Mockito.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@SpringBootTest



public class StockTest {

    @InjectMocks
    private StockServiceImpl stockService;

    @Mock
    private StockRepository stockRepository;
//
//
//    @Test
//    void addStockTest() {
//        // Create a new stock
//        Stock newStock = new Stock();
//        newStock.setTitle("stock name");
//        when(stockRepository.save(newStock)).thenReturn(newStock);
//        Stock resultStock = stockService.addStock(newStock);
//        assertNotNull(resultStock);
//        assertEquals(newStock.getTitle(), resultStock.getTitle());
//        verify(stockRepository, times(1)).save(newStock);
//    }
//
//
//    @Test
//    public void retrieveStockTest(){
//        Long stockid=1L;
//Stock stock =new Stock();
//when(stockRepository.findById(stockid)).thenReturn(Optional.of(stock));
//Stock result =stockService.retrieveStock(stockid);
//assertNotNull(result);
//    verify(stockRepository, times(1)).findById(stockid);
//}
//
//    @Test
//    public void testAddStock() {
//        // Create a Stock object
//        Stock stock = new Stock();
//        stock.setIdStock(1L);
//        stock.setTitle("Test Stock");
//        Mockito.when(stockRepository.save(Mockito.any(Stock.class))).thenReturn(stock);
//        Stock savedStock = stockService.addStock(stock);
//        Mockito.verify(stockRepository, Mockito.times(1)).save(stock);
//        assertNotNull(savedStock);
//        assertEquals(stock.getIdStock(), savedStock.getIdStock());
//        assertEquals(stock.getTitle(), savedStock.getTitle());
//    }


    @Test
    public void testAddStock() {
        Stock stockToAdd = new Stock();
        stockToAdd.setIdStock(1L);
        stockToAdd.setTitle("Test Stock");

        when(stockRepository.save(stockToAdd)).thenReturn(stockToAdd);

        Stock savedStock = stockService.addStock(stockToAdd);

        System.out.println("Expected Stock: " + stockToAdd);
        System.out.println("Actual Stock: " + savedStock);

        assertEquals(stockToAdd, savedStock);
    }

    @Test
    public void testRetrieveStock() {
        Long stockId = 1L;
        Stock stock = new Stock();
        stock.setIdStock(stockId);
        stock.setTitle("Test Stock");

        when(stockRepository.findById(stockId)).thenReturn(Optional.of(stock));

        Stock retrievedStock = stockService.retrieveStock(stockId);

        assertEquals(stock, retrievedStock);
    }

    @Test
    public void testRetrieveStockNotFound() {
        Long nonExistentStockId = 2L;

        when(stockRepository.findById(nonExistentStockId)).thenReturn(Optional.empty());

        assertThrows(NullPointerException.class, () -> stockService.retrieveStock(nonExistentStockId));
    }

    @Test
    public void testRetrieveAllStock() {
        List<Stock> stockList = new ArrayList<>();
        stockList.add(new Stock(1L, "Stocki 1"));
        stockList.add(new Stock(2L, "Stock 2"));

        when(stockRepository.findAll()).thenReturn(stockList);

        List<Stock> retrievedStockList = stockService.retrieveAllStock();

        assertEquals(stockList, retrievedStockList);
    }


}
