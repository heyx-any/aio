package org.engdream.auth.web.controller;

import io.swagger.annotations.ApiOperation;
import org.engdream.auth.entity.UrlFilter;
import org.engdream.auth.service.UrlFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth/url-filter")
public class UrlFilterController {

    @Autowired
    private UrlFilterService urlFilterService;

    @ApiOperation(value = "get all")
    @GetMapping
    public List<UrlFilter> list() {
        return urlFilterService.findAll();
    }

    @ApiOperation(value = "create")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UrlFilter create(UrlFilter urlFilter) {
        return urlFilterService.createUrlFilter(urlFilter);
    }

    @ApiOperation(value = "update by id")
    @PutMapping
    public UrlFilter update( UrlFilter urlFilter) {
        return urlFilterService.updateUrlFilter(urlFilter);
    }

    @ApiOperation(value = "delete by id")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        urlFilterService.deleteUrlFilter(id);
    }

}
