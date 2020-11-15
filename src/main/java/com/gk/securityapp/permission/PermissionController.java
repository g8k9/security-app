package com.gk.securityapp.permission;

import com.gk.securityapp.common.controller.BaseController;
import com.gk.securityapp.permission.service.PermissionService;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static lombok.AccessLevel.PROTECTED;

@RestController
@RequestMapping("/permissions")
@Slf4j
@RequiredArgsConstructor
public class PermissionController extends BaseController<PermissionDTO, Integer> {
    @NonNull
    @Getter(PROTECTED)
    PermissionService service;

    @Override
    @PostMapping("/")
    public ResponseEntity<PermissionDTO> create(@RequestBody PermissionDTO body) {
        return super.create(body);
    }

    @Override
    @GetMapping("/")
    public ResponseEntity<List<PermissionDTO>> getAll() {
        return super.getAll();
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<PermissionDTO> getById(@PathVariable Integer id) {
        return super.getById(id);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<PermissionDTO> update(@PathVariable Integer id, @RequestBody PermissionDTO body) {
        return super.update(id, body);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        return super.delete(id);
    }
}
