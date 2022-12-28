package hayk.harutyunyan.shop.controller;

import hayk.harutyunyan.shop.bean.InsertDto;
import hayk.harutyunyan.shop.service.InsertService;
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
@RequestMapping("/api/insert")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class InsertController {

    private final InsertService insertService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok().body(insertService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return ResponseEntity.ok().body(insertService.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody InsertDto dto){
        insertService.create(dto);
        return ResponseEntity.ok().body("ok");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody InsertDto dto){
        return ResponseEntity.ok().body(insertService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        insertService.delete(id);
        return ResponseEntity.ok().body("ok");
    }
}
