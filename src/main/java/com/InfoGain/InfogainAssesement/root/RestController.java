package com.InfoGain.InfogainAssesement.root;


import com.InfoGain.InfogainAssesement.root.Customer.Customer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;
import java.util.stream.Collectors;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    Map<Integer, Customer> customerList = new HashMap<>(); // Customer list based on three purchase amounts

    @RequestMapping(value="/v1/getCustomerList", method = RequestMethod.GET)
    public List<String> getAllCustomerListAndPurchases(){

        customerList.put(1 , new Customer(1, "Rob", 121.35));
        customerList.put(2 , new Customer(2, "Tina", 72.23));
        customerList.put(3 , new Customer(3, "Jack", 248.23));

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
        if(c.getCustomerPurchase()>100){
            points = (((int)c.getCustomerPurchase())-100)*2 + 50;
        }else if (c.getCustomerPurchase() <100 && c.getCustomerPurchase()>50){
            points = ((int)c.getCustomerPurchase())-50;
        }
        return "Total spending of customer with " +id+ " named:" +c.getCustomerName()+" amount: "+c.getCustomerPurchase() +" gained points: "+points.toString();
    }

    @RequestMapping(value="/v1/getCustomerPointsUsingAmountSpent/{amount}", method = RequestMethod.GET)
    @ResponseBody
    public String getPoints(@PathVariable("amount") double amount){
        Integer points = null;
        if(amount >100){
            points = (((int)amount)-100)*2 + 50;
        }else{
            points = ((int)amount)-50;
        }
        return "Total points: "+points.toString() + " will be gained for the amount of: "+amount;
    }

}
