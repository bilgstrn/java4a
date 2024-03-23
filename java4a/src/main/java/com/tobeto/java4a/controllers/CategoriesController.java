package com.tobeto.java4a.controllers;

import com.tobeto.java4a.entities.Category;
import com.tobeto.java4a.repositories.CategoryRepository;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@RequestMapping("/api/categories")
@RestController
public class CategoriesController
{
    private CategoryRepository categoryRepository;

    public CategoriesController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @PostMapping
    public String add(@RequestBody Category category)
    {
        // TODO: Doğru noktaya taşı.
        if(category.getName().length() < 3)
            throw new RuntimeException("EN az 3 haneli bir isim girin.");

        categoryRepository.save(category);
        return "Başarıyla Eklendi.";
    }

    @PutMapping
    public String update(@RequestBody Category category)
    {
        categoryRepository.save(category);
        return "Başarıyla Güncellendi";
    }

    @DeleteMapping
    public String delete(@RequestParam int id)
    {
        Category category = categoryRepository
                .findById(id)
                .orElseThrow(()-> new RuntimeException("Böyle bir kategori bulunamadı."));
        // ex fırladığında bu satıra geçilmez.
        categoryRepository.delete(category);

        return "Başarıyla Silindi";
    }
}
