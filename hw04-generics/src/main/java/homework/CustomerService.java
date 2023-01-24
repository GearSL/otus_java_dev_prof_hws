package homework;


import java.util.*;

public class CustomerService {

    //todo: 3. надо реализовать методы этого класса
    //важно подобрать подходящую Map-у, посмотрите на редко используемые методы, они тут полезны

    private final TreeMap<Customer, String> customers = new TreeMap<>(Comparator.comparingLong(Customer::getScores));

    public Map.Entry<Customer, String> getSmallest() {
        //Возможно, чтобы реализовать этот метод, потребуется посмотреть как Map.Entry сделан в jdk
        Map.Entry<Customer, String> result = customers.firstEntry();

        return getCustomerStringEntry(result);
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        //Customer nextCustomer = customers.navigableKeySet().stream().filter(person -> person.getScores()>customer.getScores()).findFirst().get();
        Map.Entry<Customer, String> result = customers.higherEntry(customer);

        return getCustomerStringEntry(result);
    }

    public void add(Customer customer, String data) {
        customers.put(customer, data);
        System.out.println(customers);
    }

    private Map.Entry<Customer, String> getCustomerStringEntry(Map.Entry<Customer, String> result) {
        if(result == null){
            return null;
        }

        long customerId = result.getKey().getId();
        long customerScore = result.getKey().getScores();
        String customerName = result.getKey().getName();
        String customerData = result.getValue();

        return Map.entry(new Customer(customerId, customerName, customerScore), customerData);
    }
}
