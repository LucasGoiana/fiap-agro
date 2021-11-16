package br.com.fiap.agro.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class EmailDatasDTO {
    private List<DatasDto> SendEmail = new ArrayList<>();

}
