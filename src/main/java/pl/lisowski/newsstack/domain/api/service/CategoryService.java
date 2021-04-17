package pl.lisowski.newsstack.domain.api.service;

import pl.lisowski.newsstack.domain.api.DTO.CategoryFullInfoDto;
import pl.lisowski.newsstack.domain.api.DTO.CategoryNameDto;
import pl.lisowski.newsstack.domain.category.Category;
import pl.lisowski.newsstack.domain.category.CategoryDao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CategoryService {
    private CategoryDao categoryDao = new CategoryDao();

    public List<CategoryNameDto> findAllCategoryNames() {
        return categoryDao.findAll()
                .stream().map(CategoryNameMapper::map)
                .collect(Collectors.toList());
    }

    public Optional<CategoryFullInfoDto> findById(int categoryId) {
        return categoryDao.findById(categoryId)
                .map(CategoryFullInfoMapper::map);
    }

    private static class CategoryNameMapper {
        static CategoryNameDto map(Category c) {     // DAO->DTO
            return new CategoryNameDto(
                    c.getId(),
                    c.getName()
            );
        }
    }
    private static class CategoryFullInfoMapper {
        static CategoryFullInfoDto map(Category c) {  // DAO->DTO
            return new CategoryFullInfoDto(
                    c.getId(),
                    c.getName(),
                    c.getDescription()
            );
        }
    }
}
