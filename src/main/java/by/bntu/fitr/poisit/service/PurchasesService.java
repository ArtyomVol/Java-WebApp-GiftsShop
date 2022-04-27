package by.bntu.fitr.poisit.service;

import by.bntu.fitr.poisit.entity.Purchase;

import java.util.List;

public interface PurchasesService {
    List<Purchase> getAllPurchases(int accountId);
}
