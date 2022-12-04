package com.restaurant.controller;

import com.restaurant.Transformer.MenuItemTransformer;
import com.restaurant.Transformer.UserTransformer;
import com.restaurant.dto.MenuItemDto;
import com.restaurant.dto.StatusDTO;
import com.restaurant.dto.UserDto;
import com.restaurant.entities.CategoryEntity;
import com.restaurant.entities.MenuItemEntity;
import com.restaurant.entities.RestaurantEntity;
import com.restaurant.entities.UserEntity;
import com.restaurant.service.CategoryService;
import com.restaurant.service.MenuItemService;
import com.restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/menuItem")
public class MenuItemEntityController {
    @Autowired
    private MenuItemService menuItemService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private RestaurantService restaurantService;

    @PostMapping("/create")
    public ResponseEntity<StatusDTO> create(@ModelAttribute MenuItemDto menuItemDto){
        try {
            CategoryEntity categoryEntity = this.categoryService.findById(Long.parseLong(menuItemDto.getCategoryDto().getId()));
            if(categoryEntity==null){
                return new ResponseEntity(new StatusDTO(0,"Category Not Found with this Id"),HttpStatus.NOT_FOUND);
            }
            RestaurantEntity restaurantEntity = this.restaurantService.findById(Long.parseLong(menuItemDto.getRestaurantDto().getId()));
            if(restaurantEntity==null){
                return new ResponseEntity(new StatusDTO(0,"Restaurant Not Found with this Id"),HttpStatus.NOT_FOUND);
            }
            MenuItemEntity menuItem = MenuItemTransformer.getMenuItemEntityFromDto(menuItemDto);
            menuItem = this.menuItemService.create(menuItem);
            MenuItemDto itemDto = MenuItemTransformer.getMenuItemDtoFromEntity(menuItem);
            return new ResponseEntity(new StatusDTO(1,"Menu Item Created Succesfully ",itemDto), HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e);
            return new ResponseEntity(new StatusDTO(0,"Exception Accured "+e.getMessage()),HttpStatus.OK);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<StatusDTO> update(@ModelAttribute MenuItemDto menuItemDto){
        try {
            MenuItemEntity menuItem1 = this.menuItemService.findById(Long.parseLong(menuItemDto.getId()));
            if(menuItem1==null){
                return new ResponseEntity(new StatusDTO(0,"Menu Item Not Found with this Id"),HttpStatus.NOT_FOUND);
            }
            CategoryEntity categoryEntity = this.categoryService.findById(Long.parseLong(menuItemDto.getCategoryDto().getId()));
            if(categoryEntity==null){
                return new ResponseEntity(new StatusDTO(0,"Category Not Found with this Id"),HttpStatus.NOT_FOUND);
            }
            RestaurantEntity restaurantEntity = this.restaurantService.findById(Long.parseLong(menuItemDto.getRestaurantDto().getId()));
            if(restaurantEntity==null){
                return new ResponseEntity(new StatusDTO(0,"Restaurant Not Found with this Id"),HttpStatus.NOT_FOUND);
            }
            MenuItemEntity updateMenuItemEntity = MenuItemTransformer.updateMenuItemEntity(menuItem1, menuItemDto);
            updateMenuItemEntity = this.menuItemService.update(updateMenuItemEntity);
            return new ResponseEntity(new StatusDTO(1,"Menu Item Updated Successfully ",updateMenuItemEntity), HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e);
            return new ResponseEntity(new StatusDTO(0,"Exception Accured "+e.getMessage()),HttpStatus.OK);
        }
    }

    @GetMapping("/{menuItemId}")
    public ResponseEntity<StatusDTO> findById(@PathVariable Long menuItemId){
        try {
            MenuItemEntity menuItemEntity = this.menuItemService.findById(menuItemId);
            if(menuItemEntity==null){
                return new ResponseEntity(new StatusDTO(0,"Menu Item Not Found With ths Id"),HttpStatus.NOT_FOUND);
            }
            MenuItemDto menuItemDto = MenuItemTransformer.getMenuItemDtoFromEntity(menuItemEntity);
            return new ResponseEntity(menuItemDto,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(new StatusDTO(0,"Exception Accured"),HttpStatus.OK);
        }
    }

    @GetMapping("/find-all")
    public ResponseEntity<StatusDTO> findAll() {
        try {
            List<MenuItemEntity> menuItemEntities = this.menuItemService.findAll();
            List<MenuItemDto> menuItemDtos = MenuItemTransformer.getAllMenuItemDtos(menuItemEntities);
            return new ResponseEntity(menuItemDtos,HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(new StatusDTO(0,"Exception Accured"),HttpStatus.OK);
        }
    }
    @DeleteMapping("/delete-all")
    public ResponseEntity<StatusDTO> deleteAll() {
        try {
            this.menuItemService.deleteAll();
            return new ResponseEntity(new StatusDTO(1,"All Menu Item Deleted Successfully"),HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(new StatusDTO(0,"Exception Accured"),HttpStatus.OK);
        }
    }
    @DeleteMapping("/delete/{menuItemId}")
    public ResponseEntity<StatusDTO> deleteById(@PathVariable Long menuItemId) {
        try {
            MenuItemEntity menuItemEntity = this.menuItemService.findById(menuItemId);
            if(menuItemEntity==null){
                return new ResponseEntity(new StatusDTO(0,"All Menu Item Id Not Exists "),HttpStatus.NOT_FOUND);
            }
            this.menuItemService.delete(menuItemId);
            return new ResponseEntity(new StatusDTO(1,"Menu Item Deleted Successfully"),HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(new StatusDTO(0,"Exception Accured"),HttpStatus.OK);
        }
    }

}
