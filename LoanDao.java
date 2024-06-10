package org.example.banksystem.dao;

import java.io.IOException;
import java.util.List;

public interface LoanDao {
    void findAllLoans() throws IOException;
    public List<Loan> findAllLoans();
}
