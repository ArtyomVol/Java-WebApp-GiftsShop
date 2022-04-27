package by.bntu.fitr.poisit.dao.repository;


import by.bntu.fitr.poisit.entity.Purchase;

import java.util.List;

public interface PurchasesRepository {
    List<Purchase> findPurchasesByAccountId(int accountId);
}
