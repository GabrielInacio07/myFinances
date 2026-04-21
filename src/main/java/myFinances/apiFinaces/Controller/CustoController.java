package myFinances.apiFinaces.Controller;

import lombok.RequiredArgsConstructor;
import myFinances.apiFinaces.DTOs.Custo.CustoDTO;
import myFinances.apiFinaces.Service.CustoService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/custo")
@RequiredArgsConstructor
@RestController
public class CustoController {

    private final CustoService service;

    @PostMapping
    public ResponseEntity<Void> saveCust(@RequestBody CustoDTO dto){

        service.saveCusto(dto);

        return ResponseEntity.status(201).build();
    }

}
