package myFinances.apiFinaces.Controller;

import myFinances.apiFinaces.DTOs.Renda.RendaDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/renda")
@RestController
public class RendaController {

    @PostMapping
    public void cadastrarRenda(@RequestBody RendaDTO dto){

        System.out.println(dto.toString());
    }


}
