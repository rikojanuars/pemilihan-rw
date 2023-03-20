package com.pemilihan.rw.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Table(name = "token_pemilih")
@Entity
@NoArgsConstructor
public class TokenPemilih implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "token", length = 5)
    private String token;

    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+7")
    @Column(name = "tanggal_dibuat")
    private LocalDateTime tanggalDibuat;

    @UpdateTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+7")
    @Column(name = "tanggal_dipakai")
    private LocalDateTime tanggalDipakai;

    @Column(name = "id_kandidat", nullable = true)
    private Integer idKandidat;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_kandidat", insertable = false, updatable = false)
    private Kandidat kandidat;

    @Column(name = "id_periode")
    private int idPeriode;

    @ManyToOne
    @JoinColumn(name = "id_periode", insertable = false, updatable = false)
    private Periode periode;

    @Column(name = "status")
    private Boolean status;

    public TokenPemilih(String token, int idPeriode, Boolean status) {
        this.token = token;
        this.idPeriode = idPeriode;
        this.status = status;
    }
}
