package com.InfoGain.InfogainAssesement.root;


import com.InfoGain.InfogainAssesement.root.Customer.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    Map<Integer, Customer> customerList = new HashMap<>(); // Customer list based on three purchase amounts
    @RequestMapping(value="/v1/getCustomerList", method = RequestMethod.GET)
    public List<String> getAllCustomerListAndPurchases(){

        customerList.put(1 , new Customer(1, "Rob", ((Math.random()*(700-1)))+1)); //Random amounts between 0-700
        customerList.put(2 , new Customer(2, "Tina", ((Math.random()*(200-10)))+10)); // Random amounts between 0-200
        customerList.put(3 , new Customer(3, "Jack", ((Math.random()*(70-50)))+50)); //Random amount betweeb 50-70

        List<String> stringList =  new ArrayList<>();
        Iterator<Customer> it = customerList.values().iterator();
        while (it.hasNext()){
            Customer c = it.next();
            stringList.add(c.toString());
        }
        return stringList;
    }
    @RequestMapping(value="/v1/getCustomerPoints/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getPoints(@PathVariable("id") int id){

        Integer points = null;
        Customer c = customerList.get(id);
        if(c == null){
            return serviceUnavailable();
        }
        if(c.getCustomerPurchase()>100){
            points = (int)(((c.getCustomerPurchase())-100)*2 )+ 50;
        }else if (c.getCustomerPurchase() <100 && c.getCustomerPurchase()>50){
            points = (int)((c.getCustomerPurchase()))-50;
        }
        return "Total spending of customer with " +id+ " named:" +c.getCustomerName()+" amount: "+c.getCustomerPurchase() +" gained points: "+points.toString();
    }

    @RequestMapping(value="/v1/getCustomerPointsUsingAmountSpent/{amount}", method = RequestMethod.GET)
    @ResponseBody
    public String getPoints(@PathVariable("amount") double amount){
        Integer points = null;
        if(amount >100){
            points = (int)((amount-100)*2) + 50;
        }else{
            points = (int)(amount)-50;
        }
        return "Total points: "+points.toString() + " will be gained for the amount of: "+amount;
    }
    @ResponseBody
    @ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "No Customer")
    public String serviceUnavailable() {
        return "SERVICE_UNAVAILABLE (CODE 503). No Customer Transactions exist at the Moment\n";
    }

}
