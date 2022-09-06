package com.ccsw.tutorial.loan.model;

import java.util.Date;

import com.ccsw.tutorial.customer.model.CustomerDto;
import com.ccsw.tutorial.game.model.GameDto;

public class LoanDto {

    private Long id;
    private CustomerDto customerDto;
    private GameDto gameDto;
    private Date loanDate;
    private Date returnDate;

    /**
     * @return id
     */
    public Long getId() {

        return this.id;
    }

    /**
     * @param id new value of {@link #getId}.
     */
    public void setId(Long id) {

        this.id = id;
    }

    /**
     * @return customerDto
     */

    public CustomerDto getCustomerDto() {

        return this.customerDto;
    }

    /**
     * @param customerDto new value of {@link #getCustomerDto}.
     */

    public void setCustomerDto(CustomerDto customerDto) {

        this.customerDto = customerDto;
    }

    /**
     * @return gameDto
     */

    public GameDto getGameDto() {

        return this.gameDto;
    }

    /**
     * @param gameDto new value of {@link #getGameDto}.
     */

    public void setGameDto(GameDto gameDto) {

        this.gameDto = gameDto;
    }

    /**
     * @return loanDate
     */

    public Date getLoanDate() {

        return this.loanDate;
    }

    /**
     * @param loanDate new value of {@link #getLoanDate}.
     */

    public void setLoanDate(Date loanDate) {

        this.loanDate = loanDate;

    }

    /**
     * @return returnDate
     */

    public Date getReturnDate() {

        return this.returnDate;
    }

    /**
     * @param returnDate new value of {@link #getReturnDate}.
     */

    public void setReturnDate(Date returnDate) {

        this.returnDate = returnDate;
    }

}
