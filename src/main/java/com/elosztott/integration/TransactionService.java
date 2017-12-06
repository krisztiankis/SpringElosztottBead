package com.elosztott.integration;

import com.elosztott.model.Transaction;

public interface TransactionService {
    public void applyTransfer(Transaction t);
}
