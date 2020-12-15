package com.gk.securityapp.role;

import com.gk.securityapp.common.controller.BaseController;
import com.gk.securityapp.role.services.RoleService;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static lombok.AccessLevel.PROTECTED;

@RestController
@RequestMapping("/roles")
@Slf4j
@RequiredArgsConstructor
public class RoleController extends BaseController<RoleDTO, Integer> {

    @NonNull
    @Getter(PROTECTED)
    RoleService service;

    @Override
    @PostMapping
    public ResponseEntity<RoleDTO> create(@RequestBody RoleDTO body) {
        return super.create(body);
    }

    @Override
    @GetMapping("/")
    public ResponseEntity<List<RoleDTO>> getAll() {
        return super.getAll();
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<RoleDTO> getById(@PathVariable Integer id) {
        return super.getById(id);
    }


    @Override
    @PutMapping("/{id}")
    public ResponseEntity<RoleDTO> upsert(@PathVariable Integer id, @RequestBody RoleDTO body) {
        return super.upsert(id, body);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        return super.delete(id);
    }
}
