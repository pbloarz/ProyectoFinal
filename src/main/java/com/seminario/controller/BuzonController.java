package com.seminario.controller;

import java.util.List;

import com.seminario.model.Buzon;
import com.seminario.service.BuzonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("api/buzon")
public class BuzonController {

    @Autowired private BuzonService buzonService;

    @PostMapping("/crear")
    public ResponseEntity<Object> create(@RequestBody Buzon buzon){
        return buzonService.create(buzon);
    }
    @GetMapping("/findByid")
    public ResponseEntity<Object> findByid(@RequestParam int id){
        return buzonService.findByid(id);
    }
    @PutMapping("/edit")
    public ResponseEntity<Object> edit(@RequestBody Buzon buzon){
        return buzonService.edit(buzon);
    }
    @GetMapping("/list")
    public ResponseEntity<Object> list(){
        return buzonService.list();
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") int id){
        return buzonService.delete(id);
    }
    @GetMapping("/findByRangeDate")
    public List<Buzon> findByRangeDate(@RequestParam String desde, @RequestParam String hasta){
        return buzonService.findByRangeDate(desde, hasta);
    }

}
