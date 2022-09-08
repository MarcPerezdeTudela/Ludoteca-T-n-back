package com.ccsw.tutorial.loan;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.ccsw.tutorial.customer.CustomerServiceImpl;
import com.ccsw.tutorial.game.GameServiceImpl;
import com.ccsw.tutorial.loan.model.Loan;
import com.ccsw.tutorial.loan.model.LoanDto;
import com.ccsw.tutorial.loan.model.LoanSearchDto;

@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    LoanRepository loanRepository;

    @Autowired
    GameServiceImpl gameService;

    @Autowired
    CustomerServiceImpl customerService;

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
        Loan loan = new Loan();

        BeanUtils.copyProperties(data, loan, "id", "game", "customer");
        loan.setCustomer(customerService.get(data.getCustomer().getId()));
        loan.setGame(gameService.get(data.getGame().getId()));

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

    @Override
    public List<Loan> find(Long game_id, Long customer_id, Date loanDate) {
        return this.loanRepository.find(game_id, customer_id, loanDate);
    }

}
