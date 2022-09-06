package com.ccsw.tutorial.loan;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ccsw.tutorial.loan.model.Loan;
import com.ccsw.tutorial.loan.model.LoanDto;
import com.ccsw.tutorial.loan.model.LoanSearchDto;

/**
 * @author ccsw
 */

public interface LoanService {

    /**
     * Recupera un {@link com.ccsw.tutorial.loan.model.Loan} a través de su ID
     * 
     * @param id
     * @return
     */
    Loan get(Long id);

    /**
     * Método para recuperar un listado paginado de
     * {@link com.ccsw.tutorial.loan.model.Loan}
     * 
     * @param dto
     * @return
     */
    Page<Loan> findPage(LoanSearchDto dto);

    /**
     * Método para crear o actualizar un
     * {@link com.ccsw.tutorial.loan.model.Loan}
     * 
     * @param id
     * @param data
     */
    void save(Long id, LoanDto data);

    /**
     * Método para crear o actualizar un
     * {@link com.ccsw.tutorial.loan.model.Loan}
     * 
     * @param id
     */
    void delete(Long id);

    /**
     * Recupera un listado de prestamos
     * 
     * @return
     */
    List<Loan> findAll();
}