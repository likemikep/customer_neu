package com.hska.customer;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private CustomerRepository customerRepository;
    private CustomerNotFoundException customerException;

    public CustomerController(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @GetMapping("/all")
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @PutMapping
    public void addCustomer(@RequestBody Customer customer) {
        this.customerRepository.insert(customer);
    }

    @PostMapping
    public void update(@RequestBody Customer customer) {
        this.customerRepository.save(customer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        this.customerRepository.deleteById(id);
    }

    @GetMapping("/customer/{nachname}/{vorname}")
    public Customer findCustomer(@PathVariable("nachname") String nachname
        ,@PathVariable("vorname") String vorname) {

        Customer c=new Customer();
        List<Customer> customers=
            this.customerRepository.findAllByNachname(nachname);

        for(int i=0; i<customers.size();i++){
            if(customers.get(i).getVorname().equals(vorname)){
                c=customers.get(i);
            }
            else{
                //Funktioniert noch nicht
                //throw new customerException("Nichts gefunden");
            }
        }
        return c;
    }

    @GetMapping("/credit/{credit}")
    public Boolean isCreditWorthy(@RequestBody Customer customer,
                                  @PathVariable("credit") double credit) {

        return (customer.getGehalt()>=(credit/10));
    }
}
