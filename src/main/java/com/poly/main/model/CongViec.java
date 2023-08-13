package com.poly.main.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author hangnt
 */
@Entity
@Table(name = "cong_viec")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class CongViec {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // tu tang
    private Long id;

    @Column(name = "ten_cong_viec")
    private String tenCongViec;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "the_loai_id", referencedColumnName = "id")
    private TheLoai theLoai;

    @Column(name = "trang_thai")
    private int trangThai;

    @Column(name = "thoi_gian_hoan_thanh")
    private Date thoiGianHoanThanh;

}
