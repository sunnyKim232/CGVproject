package com.koreait.cgvproject.entity;

import com.koreait.cgvproject.dto.TicketDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SequenceGenerator(
        name="seq_ticket",
        sequenceName = "seq_ticket",
        initialValue = 1,
        allocationSize = 1
)
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ticket")
    private Long ticode;

    @ManyToOne
    @JoinColumn(name="schecode")
    private Schedule schedule;


    @ManyToOne
    @JoinColumn(name="memIdx")
    private Member member;

    private String seat;

    private String price;

    private Long totperson;

    @CreatedDate
    private LocalDateTime paydate;

    private LocalDateTime candate;

    private String usepoint;

    private String totprice;

    public TicketDTO toDTO(){
        return TicketDTO.builder()
                .ticode(ticode)
                .totperson(totperson)
                .seat(seat)
                .scheduleDTO(schedule.toDTO())
                .memberDTO(member.toDTO())
                .price(price)
                .paydate(paydate)
                .candate(candate)
                .usepoint(usepoint)
                .totprice(totprice)
                .build();

    }

}
