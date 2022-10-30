package ru.test.app.weather.persistance.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.UUID;

@Accessors(chain = true)
@Getter
@Setter
@Entity
public class Weather {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(nullable = false)
    @EqualsAndHashCode.Include
    private UUID id;
    private BigDecimal lon;
    private BigDecimal lat;
    private Double temp;
    private Double feels_like;
    private Double temp_min;
    private Double temp_max;
    private Integer dt;
    private String base;
    private String name;
    private String country;



}
