package co.com.administrador.administradorhotel.Controller;

import co.com.administrador.administradorhotel.Domain.Cargo;
import co.com.administrador.administradorhotel.Domain.Empleado;
import co.com.administrador.administradorhotel.Service.empleado.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;


    @GetMapping("/{numeroDocumento}/empleado")
    public Empleado findById(@PathVariable String numeroDocumento){
        return empleadoService.findById(numeroDocumento);
    }
    @PostMapping("/empleado")
    public void insert (@RequestBody Empleado empleado){
        empleadoService.insert(empleado);
    }

    @PutMapping("/{numeroDocumento}/empleado")
    public void update (@RequestBody Empleado empleado, @PathVariable String numeroDocumento){
        empleadoService.update(empleado, numeroDocumento);
    }

    @PutMapping("/empleado/inactivo/{numeroDocumento}")
    public void updateEstadoInactivo (@PathVariable String numeroDocumento){
        empleadoService.updateEstadoInactivo(numeroDocumento);
    }
    @PutMapping("/empleado/activo/{numeroDocumento}")
    public void   vincular(@PathVariable String numeroDocumento){
        empleadoService.vincular(numeroDocumento);
    }
    @DeleteMapping("/{numeroDocumento}/empleado")
    public void  delete (@PathVariable String numeroDocumento){
        empleadoService.delete(numeroDocumento);

    }
    @GetMapping("/empleados")
    public List<Empleado> list (){
        return  empleadoService.findAll();
    }


}
