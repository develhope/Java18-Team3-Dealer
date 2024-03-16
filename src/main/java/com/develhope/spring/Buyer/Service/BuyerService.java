package com.develhope.spring.Buyer.Service;

import com.develhope.spring.Buyer.DTO.BuyerDTO;
import com.develhope.spring.Buyer.Entity.Buyer;
import com.develhope.spring.Buyer.Repository.BuyerRepository;
import com.develhope.spring.Order.Entity.Orders;
import com.develhope.spring.Order.Repository.OrderRepository;
import com.develhope.spring.Purchase.Entity.Purchase;
import com.develhope.spring.Purchase.Repository.PurchaseRepository;
import com.develhope.spring.Rental.Entity.Rental;
import com.develhope.spring.Rental.RentalRepository.RentalRepository;
import com.develhope.spring.Vehicle.Entity.Vehicle;
import com.develhope.spring.Vehicle.Entity.VehicleStatus;
import com.develhope.spring.Vehicle.Repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
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
    @Autowired
    private PurchaseRepository purchaseRepository;

    //metodo per la creazione di un cliente
    public Buyer createBuyer(BuyerDTO buyerDTO) {
       Buyer saveDTO = convertToEntity(buyerDTO);
        return buyerRepository.save(saveDTO);
    }

    //metodo per eliminare un cliente
    public void deleteBuyerByID(Long buyerId) {
        buyerRepository.deleteById(buyerId);
    }

    //metodo per la ricerca di un veicolo tramite ID
//    public Vehicle findVehicleById(Long vehicleId) {
//        return vehicleRepository.findById(vehicleId).orElse(null);
//    }

    //metodo per vedere i propri ordini
    public List<Orders> getOrders(Long buyerId, Long orderId) {
        Optional<Buyer> user = buyerRepository.findById(buyerId);
        if (user.isPresent()) {
            Optional<Orders> orderList = orderRepository.findById(orderId);
        }
        return null;
    }
    //vedere gli acquisti
    public List<Purchase> getPurchase(Long buyerId, Long purchaseId){
        Optional<Buyer> buyer = buyerRepository.findById(buyerId);
        if(buyer.isPresent()){
            Optional<Purchase> purchaseList = purchaseRepository.findById(purchaseId);
        }
        return null;
    }


    //metodo per la cancellazione di un ordine
    public void deleteOrderById(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    //modifica utente
    public Buyer updateBuyer(Long buyerId, Buyer buyer) {
        Buyer buyerUpdate = buyerRepository.findById(buyerId).orElse(null);
        if (buyerUpdate != null) {
            //buyerUpdate.setBuyerId(buyer.getBuyerId());
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

    private Buyer convertToEntity(BuyerDTO buyerDTO){
        Buyer buyer = new Buyer();
        buyer.setFirstName(buyerDTO.getFirstName());
        buyer.setLastName(buyerDTO.getLastName());
        buyer.setEmail(buyerDTO.getEmail());
        buyer.setPassword(buyerDTO.getPassword());
        buyer.setTelephoneNumber(buyerDTO.getTelephoneNumber());
        return buyer;
    }
    private BuyerDTO convertToDTO(Buyer buyer){
        BuyerDTO buyerDTO = new BuyerDTO();
        buyerDTO.setFirstName(buyer.getFirstName());
        buyerDTO.setLastName(buyer.getLastName());
        buyerDTO.setEmail(buyer.getEmail());
        buyerDTO.setPassword(buyer.getEmail());
        buyerDTO.setTelephoneNumber(buyer.getTelephoneNumber());
        return buyerDTO;
    }
//@Query(value = "SELECT * FROM Vehicle WHERE VehicleStatus = ORDERABLE", nativeQuery = true)
//    List<Vehicle> findyByStatusOrderable();
//@Query(value = "SELECT * FROM Vehicle WHERE VehicleStatus = PURCHASABLE", nativeQuery = true)
//List<Vehicle> findyByStatusPurchasable();
}
//@Query(value = "SELECT brand FROM Vehicle", nativeQuery = true)
//List<Vehicle> findByBrand(String brand);

//List<Vehicle> findByModel(String model);

//List<Vehicle> findByColor(String color);

//List<Vehicle> findByPrice(String price);
