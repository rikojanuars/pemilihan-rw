package com.pemilihan.rw.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Table(name = "kandidat")
@Entity
public class Kandidat implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nama_kandidat")
    private String namaKandidat;

    @Column(name = "nomor_urut", length = 2)
    private String nomorUrut;

    @Column(name = "foto")
    private String foto;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+7")
    @Column(name = "tahun_pencalonan")
    private LocalDate tahunPencalonan;

}
