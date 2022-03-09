package com.koreait.cgvproject.dto;

import com.koreait.cgvproject.entity.Seathtml;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SeathtmlDTO {
    private long stIdx;
    private Long hcode;
    private String stRow;
    private String stCol;
    private String rowEmpty;
    private String colEmpty;

    public Seathtml toEntity(){
        return Seathtml.builder()
                .hcode(hcode)
                .stRow(stRow)
                .stCol(stCol)
                .colEmpty(colEmpty)
                .rowEmpty(rowEmpty)
                .build();
    }
}
