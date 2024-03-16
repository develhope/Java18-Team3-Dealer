package com.develhope.spring.Buyer.Service;

import com.develhope.spring.Buyer.DTO.BuyerDTO;
import com.develhope.spring.Buyer.Entity.Buyer;
import com.develhope.spring.Buyer.Repository.BuyerRepository;
import com.develhope.spring.Order.Repository.OrderRepository;
import com.develhope.spring.Purchase.Repository.PurchaseRepository;
import com.develhope.spring.Rental.RentalRepository.RentalRepository;
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

    //metodo per vedere i propri ordini
//    public List<Orders> getOrders(Long buyerId, Long orderId) {
//        Optional<Buyer> user = buyerRepository.findById(buyerId);
//        if (user.isPresent()) {
//            Optional<Orders> orderList = orderRepository.findById(orderId);
//        }
//        return null;
//    }
    //vedere gli acquisti
//    public List<Purchase> getPurchase(Long buyerId, Long purchaseId){
//        Optional<Buyer> buyer = buyerRepository.findById(buyerId);
//        if(buyer.isPresent()){
//            Optional<Purchase> purchaseList = purchaseRepository.findById(purchaseId);
//        }
//        return null;
//    }



    //modifica utente
    public Buyer updateBuyer(Long buyerId, BuyerDTO buyerDTO) {
        Buyer saveDTO = convertToEntity(buyerDTO);
        Buyer buyerUpdate = buyerRepository.findById(buyerId).orElse(null);
        if (buyerUpdate != null) {
            buyerUpdate.setFirstName(saveDTO.getFirstName());
            buyerUpdate.setLastName(saveDTO.getLastName());
            buyerUpdate.setEmail(saveDTO.getEmail());
            buyerUpdate.setPassword(saveDTO.getPassword());
            buyerUpdate.setTelephoneNumber(saveDTO.getTelephoneNumber());
            return buyerRepository.save(buyerUpdate);
        }
        return null;
    }

    /*SELECT * FROM Rental WHERE buyerId = ?1*/

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
