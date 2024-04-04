package com.develhope.spring.Rental.Entity;

import com.develhope.spring.User.Entity.Users;
import com.develhope.spring.Vehicle.Entity.Vehicle;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Table
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rentalId;
    @Column
    private OffsetDateTime startDate;
    @Column
    private OffsetDateTime endDate;
    @Column
    private BigDecimal dailyCost;
    @Column
    private BigDecimal totalCost;
    @Column(nullable = false)
    private boolean paidFlag;
    @Enumerated(EnumType.STRING)
    private RentalStatus rentalStatus;
    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Users seller;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Users customer;
    @OneToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    @Override
    public String toString() {
        return "Rental{" +
                "rentalId=" + rentalId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", dailyCost=" + dailyCost +
                ", totalCost=" + totalCost +
                ", paidFlag=" + paidFlag +
                ", rentalStatus=" + rentalStatus +
                ", seller=" + seller +
                ", customer=" + customer +
                ", vehicle=" + vehicle +
                '}';
    }
}

