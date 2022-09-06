package com.ccsw.tutorial.loan.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ccsw.tutorial.customer.model.Customer;
import com.ccsw.tutorial.game.model.Game;

/**
 * @author ccsw
 */
@Entity
@Table(name = "Loan")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

    @Column(name = "loan_date", nullable = false)
    private Date loanDate;

    @Column(name = "return_date", nullable = false)
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
    public Customer getCustomer() {

        return this.customer;
    }

    /**
     * @param customer new value of {@link #getCustomer}.
     */
    public void setCustomer(Customer customer) {

        this.customer = customer;
    }

    /**
     * @return game
     */
    public Game getGame() {

        return this.game;
    }

    /**
     * @param game new value of {@link #getGame}.
     */
    public void setGame(Game game) {

        this.game = game;
    }

    /**
     * @return loaDate
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