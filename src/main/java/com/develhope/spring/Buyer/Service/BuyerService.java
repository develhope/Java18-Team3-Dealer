package com.develhope.spring.Buyer.Service;

import com.develhope.spring.Buyer.Entity.Buyer;
import com.develhope.spring.Buyer.Repository.BuyerRepository;
import com.develhope.spring.Order.Entity.Order;
import com.develhope.spring.Order.Repository.OrderRepository;
import com.develhope.spring.Rental.Entity.Rental;
import com.develhope.spring.Rental.RentalRepository.RentalRepository;
import com.develhope.spring.Vehicle.Entity.Vehicle;
import com.develhope.spring.Vehicle.Repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuyerService {
    @Autowired
    private BuyerRepository buyerRepository;
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private RentalRepository rentalRepository;
    @Autowired
    private OrderRepository orderRepository;

    //metodo per la creazione di un cliente
    public Buyer createBuyer(Buyer buyer) {
        return buyerRepository.save(buyer);
    }

    //metodo per eliminare un cliente
    public void deleteBuyerByID(Long buyer_id) {
        buyerRepository.deleteById(buyer_id);
    }

    //metodo per la ricerca di un veicolo tramite ID
    public Vehicle findVehicleById(Long vehicleId) {
        return vehicleRepository.findById(vehicleId).orElse(null);
    }

    //metodo per vedere i propri ordini
    public List<Order> getOrders(Long buyer_id, Long orderId) {
        Optional<Buyer> user = buyerRepository.findById(buyer_id);
        if (user.isPresent()) {
            Optional<Order> orderList = orderRepository.findById(orderId);
        }
        return null;
    }


    //metodo per la cancellazione di un ordine
    public void deleteOrderById(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    //modifica utente
    public Buyer updateBuyer(Long buyer_id, Buyer buyer) {
        Buyer buyerUpdate = buyerRepository.findById(buyer_id).orElse(null);
        if (buyerUpdate != null) {
            buyerUpdate.setBuyer_id(buyer.getBuyer_id());
            buyerUpdate.setFirstName(buyer.getFirstName());
            buyerUpdate.setLastName(buyer.getLastName());
            buyerUpdate.setEmail(buyer.getEmail());
            buyerUpdate.setPassword(buyer.getPassword());
            buyerUpdate.setTelephoneNumber(buyer.getTelephoneNumber());
            return buyerRepository.save(buyerUpdate);
        }
        return null;
    }

    //Creare un noleggio
    public Rental createRent(Rental rental) {
        return rentalRepository.save(rental);
    }

    //Vedere i propri noleggi
    public List<Rental> rentalList() {
        return rentalRepository.findAll();
    }

}

