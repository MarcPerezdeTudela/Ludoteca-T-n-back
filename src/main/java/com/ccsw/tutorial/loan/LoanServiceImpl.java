package com.ccsw.tutorial.loan;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.ccsw.tutorial.loan.model.Loan;
import com.ccsw.tutorial.loan.model.LoanDto;
import com.ccsw.tutorial.loan.model.LoanSearchDto;

@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    LoanRepository loanRepository;

    @Override
    public Loan get(Long id) {
        return this.loanRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Loan> findPage(LoanSearchDto dto) {
        return this.loanRepository.findAll(dto.getPageable());
    }

    @Override
    public void save(Long id, LoanDto data) {
        Loan loan = null;
        if (id != null)
            loan = this.get(id);
        else
            loan = new Loan();

        BeanUtils.copyProperties(data, loan, "id");

        this.loanRepository.save(loan);

    }

    @Override
    public void delete(Long id) {
        this.loanRepository.deleteById(id);

    }

    @Override
    public List<Loan> findAll() {

        return (List<Loan>) this.loanRepository.findAll();

    }

}
