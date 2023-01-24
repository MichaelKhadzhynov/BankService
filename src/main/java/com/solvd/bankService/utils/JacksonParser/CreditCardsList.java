package com.solvd.bankService.utils.JacksonParser;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.solvd.bankService.dao.mySQL.CreditCardDAO;
import com.solvd.bankService.models.CreditCard;

import java.util.List;
import java.util.Objects;

public class CreditCardsList {

    @JsonProperty("credit_cards_list")
    private List<CreditCard> creditCardsList  = CreditCardDAO.getInstance().getCreditCardList();

    public List<CreditCard> getCreditCardsList() {
        return creditCardsList;
    }

    public void setCreditCardsList(List<CreditCard> creditCardsList) {
        this.creditCardsList = creditCardsList;
    }

    @Override
    public String toString() {
        return "CreditCardsList{" +
               "creditCardsList=" + creditCardsList +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditCardsList that = (CreditCardsList) o;
        return Objects.equals(creditCardsList, that.creditCardsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(creditCardsList);
    }
}
