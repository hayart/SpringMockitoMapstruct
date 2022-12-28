package hayk.harutyunyan.shop.controller;

import hayk.harutyunyan.shop.bean.SaleDto;
import hayk.harutyunyan.shop.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sale")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SaleController {

    private final SaleService saleService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok().body(saleService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return ResponseEntity.ok().body(saleService.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody SaleDto dto){
        saleService.create(dto);
        return ResponseEntity.ok().body("ok");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody SaleDto dto){
        return ResponseEntity.ok().body(saleService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        saleService.delete(id);
        return ResponseEntity.ok().body("ok");
    }
}
