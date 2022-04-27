package by.bntu.fitr.poisit.service.impl;

import by.bntu.fitr.poisit.dao.repository.PurchasesRepository;
import by.bntu.fitr.poisit.entity.Purchase;
import by.bntu.fitr.poisit.service.PurchasesService;

import java.util.List;

public class PurchasesServiceImpl implements PurchasesService {
    PurchasesRepository purchasesRepository;

    public PurchasesServiceImpl(PurchasesRepository purchasesRepository) {
        this.purchasesRepository = purchasesRepository;
    }

    @Override
    public List<Purchase> getAllPurchases(int accountId) {
        return purchasesRepository.findPurchasesByAccountId(accountId);
    }
}
