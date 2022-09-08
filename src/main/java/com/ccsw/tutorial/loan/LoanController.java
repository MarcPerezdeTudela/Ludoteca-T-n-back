package com.ccsw.tutorial.loan;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ccsw.tutorial.config.mapper.BeanMapper;
import com.ccsw.tutorial.loan.model.Loan;
import com.ccsw.tutorial.loan.model.LoanDto;
import com.ccsw.tutorial.loan.model.LoanSearchDto;

/**
 * @author ccsw
 */

@RequestMapping(value = "/loan")
@RestController
@CrossOrigin(origins = "*")
public class LoanController {

    @Autowired
    LoanService loanService;

    @Autowired
    BeanMapper beanMapper;

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<LoanDto> find(@RequestParam(value = "game_id", required = false) Long game_id,
            @RequestParam(value = "customer_id", required = false) Long customer_id,
            @RequestParam(value = "loan_date", required = false) Date loanDate) {

        List<Loan> loans = loanService.find(game_id, customer_id, loanDate);
        return beanMapper.mapList(loans, LoanDto.class);
    }

    /**
     * Método para recuperar un listado paginado de
     * {@link com.ccsw.tutorial.loan.model.Loan}
     * 
     * @param dto
     * @return
     */
    @RequestMapping(path = "", method = RequestMethod.POST)
    public Page<LoanDto> findPage(@RequestBody LoanSearchDto dto) {

        return this.beanMapper.mapPage(this.loanService.findPage(dto), LoanDto.class);
    }

    /**
     * Método para crear o actualizar un
     * {@link com.ccsw.tutorial.loan.model.Loan}
     * 
     * @param id
     * @param data datos de la entidad
     */
    @RequestMapping(path = { "", }, method = RequestMethod.PUT)
    public void save(@PathVariable(name = "id", required = false) Long id, @RequestBody LoanDto data) {

        System.out.println("\n");
        this.loanService.save(id, data);
    }

    /**
     * Método para crear o actualizar un
     * {@link com.ccsw.tutorial.loan.model.Loan}
     * 
     * @param id PK de la entidad
     */
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {

        this.loanService.delete(id);
    }
}