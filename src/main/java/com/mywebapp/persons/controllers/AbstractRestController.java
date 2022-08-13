package com.mywebapp.persons.controllers;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class AbstractRestController<T, R extends JpaRepository<T, ?>> {
    protected R repo;

    public AbstractRestController(R repo) {
        this.repo = repo;
    }

    @ApiOperation("получение списка элементов")
    @GetMapping
    public List<T> getAll(@PageableDefault Pageable pageable ){
        return repo.findAll(pageable).getContent();
    }

    @ApiOperation("получение одного элемента")
    @GetMapping("{id}")
    public T getOne(@PathVariable("id") T dbObject){
        return dbObject;
    }

    @ApiOperation("добавление одного элемента")
    @PostMapping
    public T addOne(@RequestBody T object){
        return repo.save(object);
    }

    @ApiOperation("изменение элемента")
    @PutMapping("{id}")
    public T updateOne(@PathVariable("id") T dbObject, @RequestBody T object){
        BeanUtils.copyProperties(object, dbObject, "id");
        return repo.save(dbObject);
    }

    @ApiOperation("удаление элемента")
    @DeleteMapping("{id}")
    public void deleteOne(@PathVariable("id") T dbObject){
        repo.delete(dbObject);
    }
}
