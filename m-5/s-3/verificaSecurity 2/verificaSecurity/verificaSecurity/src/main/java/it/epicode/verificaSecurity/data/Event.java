package it.epicode.verificaSecurity.data;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "events")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_seguenza")
    @SequenceGenerator(name = "event_seguenza", sequenceName = "event_seguenza")
    private Long id;

    private String eventName;

    private String location;

    private String description;

    private int PlacesOccupied;


    private int maxParticipants;

    @Temporal(TemporalType.TIMESTAMP)
    private Date eventDate;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
