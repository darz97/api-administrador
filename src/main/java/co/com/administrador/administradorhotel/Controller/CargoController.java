package co.com.administrador.administradorhotel.Controller;

import co.com.administrador.administradorhotel.Domain.Cargo;
import co.com.administrador.administradorhotel.Service.cargo.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cargos")
public class CargoController {
    @Autowired
    private CargoService cargoService;

    @GetMapping("/{id}/cargo")
    public Cargo findById(@PathVariable Long id){
        return cargoService.findById(id);
    }
    @PostMapping("/cargo")
    public void insert (@RequestBody Cargo cargo){
        cargoService.insert(cargo);
    }
    @PutMapping("/{id}/cargo")
    public void update (@RequestBody Cargo cargo, @PathVariable Long id){
        cargoService.update(cargo, id);
    }
    @DeleteMapping("/{id}/cargo")
    public void  delete (@PathVariable Long id){
        cargoService.delete(id);
    }
    @GetMapping("/cargos")
    public List<Cargo> list (){
        return  cargoService.findAll();
    }


}
