package myFinances.apiFinaces.DTOs.Custo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import myFinances.apiFinaces.Model.Categoria;

@Getter
@AllArgsConstructor
public class CustoDTO {

    private String description;
    private Double value;
    private Categoria category;
}
