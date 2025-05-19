package com.femtech.client_service.client.customer;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.lang.annotation.Documented;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_Customer")
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String firstname;
    private String middlename;
    private String lastname;
    private String email;
    @ManyToOne
    @JoinColumn(name = "address", nullable = false)
    private Address address;
}
