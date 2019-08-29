package com.cellranger.util.dao;

import javax.persistence.*;

@Entity
public class CellRangerWebSummary {
    @Id
    @Column(length = 150)
    public String F1;

    @OneToOne
    public long F2;

    @Column(nullable = true)
    public Long F3;

    // TODO...
}