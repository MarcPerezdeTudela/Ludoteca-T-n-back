package com.ccsw.tutorial.loan;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ccsw.tutorial.loan.model.Loan;

/**
 * @author ccsw
 */
public interface LoanRepository extends CrudRepository<Loan, Long> {

    @Query("select l from Loan l where (:game_id is null or l.game.id = :game_id)" +
            " and (:client_id is null or l.customer.id = :customer_id)" +
            " and (:loanDate is null or (:loanDate between l.loanDate and l.returnDate))")
    List<Loan> find(@Param("game_id") Long game_id, @Param("client_id") Long client_id,
            @Param("loanDate") Date loanDate);

    /**
     * Método para recuperar un listado paginado de
     * {@link com.ccsw.tutorial.loan.model.Loan}
     * 
     * @param page
     * @return
     */
    Page<Loan> findAll(Pageable pageable);

}
