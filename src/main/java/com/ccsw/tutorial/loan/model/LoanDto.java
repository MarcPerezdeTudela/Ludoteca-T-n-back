package com.ccsw.tutorial.loan.model;

import java.util.Date;

import com.ccsw.tutorial.customer.model.CustomerDto;
import com.ccsw.tutorial.game.model.GameDto;

public class LoanDto {

    private Long id;
    private CustomerDto customer;
    private GameDto game;
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
     * @return customer
     */

    public CustomerDto getCustomer() {

        return this.customer;
    }

    /**
     * @param customer new value of {@link #getcustomer}.
     */

    public void setCustomer(CustomerDto customer) {

        this.customer = customer;
    }

    /**
     * @return gameDto
     */

    public GameDto getGame() {

        return this.game;
    }

    /**
     * @param gameDto new value of {@link #getGameDto}.
     */

    public void setGame(GameDto game) {

        this.game = game;
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
