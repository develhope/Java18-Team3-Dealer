package com.develhope.spring.Order.Service;

import com.develhope.spring.Exception.CustomExceptions;
import com.develhope.spring.Order.DTO.OrdersStatusDTO;
import com.develhope.spring.Order.Entity.OrderStatus;
import com.develhope.spring.Order.Entity.Orders;
import com.develhope.spring.Order.Repository.OrderRepository;
import com.develhope.spring.User.Entity.Role;
import com.develhope.spring.User.Entity.Users;
import com.develhope.spring.Vehicle.Dto.VehicleDTO;
import com.develhope.spring.Vehicle.Entity.Vehicle;
import com.develhope.spring.Vehicle.Entity.VehicleStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public void createOrder(Users user, Orders orders) {
        if (user.getRole() == Role.CUSTOMER || user.getRole() == Role.SELLER) {
            if (orders.getVehicle().getVehicleStatus() == VehicleStatus.ORDERABLE) {
                orderRepository.save(orders);
            } else {
                throw new CustomExceptions.InvalidStatusException("Orders can only be created with orderable vehicles");
            }
        } else {
            throw new CustomExceptions.AccessDeniedException("You don't have access");
        }
    }

    public List<Orders> getAllOrders(Users user) {
        if (user.getRole() == Role.CUSTOMER) {
            List<Orders> ordersList = orderRepository.findAll();
            // List<VehicleDTO> vehicleDTOList = new ArrayList<>();
            if (ordersList.isEmpty()) {
                throw new IllegalArgumentException("No vehicle found");
            }
//        else {
//            for (Orders order : ordersList) {
//                ordersDTOList.add(convertToDTO(order));
//            }
//        }
            return ordersList;
        } else {
            throw new CustomExceptions.AccessDeniedException("You don't have access");
        }
    }

    public Orders getOrderById(Long orderId, Users user) {
        if (user.getRole() == Role.SELLER) {
            Orders order = orderRepository.findById(orderId).orElse(null);
            if (order == null) {
                throw new CustomExceptions.InvalidIdException("Order with this id not found: " + orderId);
            }
            return order;
            // return convertToDTO(order);
        } else {
            throw new CustomExceptions.AccessDeniedException("You don't have access");
        }
    }

    public List<Orders> getOrdersByStatus(Users user, OrderStatus orderStatus) {
        if (user.getRole() == Role.SELLER) {

            if (orderStatus == OrderStatus.COMPLETED
                    || orderStatus == OrderStatus.PENDING
                    || orderStatus == OrderStatus.PROGRESS) {
                //    List<OrdersDTO> ordersDTOList = new ArrayList<>();
                List<Orders> ordersList = orderRepository.getAllOrdersStatus(orderStatus.toString());
//                for (Vehicle vehicle : vehicleList) {
//                    vehicleDTOList.add(convertToDTO(vehicle));
//                }
                return ordersList;
            } else {
                throw new CustomExceptions.InvalidStatusException("Type not valid: " + orderStatus);
            }

        } else {
            throw new CustomExceptions.AccessDeniedException("You don't have access");
        }
    }

//    public void updateOrders(Long orderId, Users user, VehicleDTO updateVehicleDTO) {
//        if (user.getRole() == Role.ADMIN) {
//            Vehicle vehicle = vehicleRepository.findById(vehicleId).orElse(null);
//            if (vehicle == null) {
//                throw new CustomExceptions.InvalidIdException("Vehicle with this id not found: " + vehicleId);
//            }
//            Vehicle updateVehicle = convertToEntity(updateVehicleDTO);
//            vehicle.setBrand(updateVehicle.getBrand());
//            vehicle.setModel(updateVehicle.getModel());
//            vehicle.setDisplacement(updateVehicle.getDisplacement());
//            vehicle.setColor(updateVehicle.getColor());
//            vehicle.setPower(updateVehicle.getPower());
//            vehicle.setTransmission(updateVehicle.getTransmission());
//            vehicle.setRegistrationYear(updateVehicle.getRegistrationYear());
//            vehicle.setFullType(updateVehicle.getFullType());
//            vehicle.setPrice(updateVehicle.getPrice());
//            vehicle.setDiscount(updateVehicle.getDiscount());
//            vehicle.setAccessories(updateVehicle.getAccessories());
//            vehicle.setIsNew(updateVehicle.getIsNew());
//            vehicle.setVehicleStatus(updateVehicle.getVehicleStatus());
//            vehicle.setVehicleType(updateVehicle.getVehicleType());
//            vehicleRepository.save(vehicle);
//        } else {
//            throw new CustomExceptions.AccessDeniedException("Only admin can");
//        }
//    }

    public Orders chanceStatus(Long orderId, Users user, OrdersStatusDTO ordersStatusDTO) {
        if (user.getRole() == Role.SELLER) {
            Orders order = orderRepository.findById(orderId).orElse(null);
            if (order == null) {
                throw new CustomExceptions.InvalidIdException("Order with this id not found: " + orderId);
            }
            if (ordersStatusDTO.getOrderStatus() == OrderStatus.COMPLETED
                    || ordersStatusDTO.getOrderStatus() == OrderStatus.PROGRESS
                    || ordersStatusDTO.getOrderStatus() == OrderStatus.PENDING) {
                order.setOrderStatus(ordersStatusDTO.getOrderStatus());
                orderRepository.save(order);
               // return convertToDTO(vehicle);
                return order;
            } else {
                throw new CustomExceptions.InvalidStatusException("Status not valid: " + ordersStatusDTO.getOrderStatus());
            }
        } else {
            throw new CustomExceptions.AccessDeniedException("You don't have access");
        }
    }

    public void deleteOrders(Long orderId, Users user) {
        if (user.getRole() == Role.CUSTOMER || user.getRole() == Role.SELLER) {
            Orders order = orderRepository.findById(orderId).orElse(null);
            if (order == null) {
                throw new CustomExceptions.InvalidIdException("Order with this id not found: " + orderId);
            } else {
                orderRepository.deleteById(orderId);
            }
        } else {
            throw new CustomExceptions.AccessDeniedException("You don't have access");
        }
    }

}
