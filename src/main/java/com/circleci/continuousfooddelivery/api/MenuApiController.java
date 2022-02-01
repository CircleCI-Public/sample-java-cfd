package com.circleci.continuousfooddelivery.api;

import com.circleci.continuousfooddelivery.jpa.MenuItemJpa;
import com.circleci.continuousfooddelivery.repositories.MenuRepo;
import com.circleci.continuousfooddelivery.model.Menu;
import com.circleci.continuousfooddelivery.model.MenuItem;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-01-31T03:17:46.722516300-05:00[America/New_York]")
@RestController
@RequestMapping("${openapi.continousFoodDelievery.base-path:/CFD/1.0.0}")
public class MenuApiController implements MenuApi {

    @Autowired
    private MenuRepo repository;

    private final NativeWebRequest request;

    @Autowired
    private ModelMapper modelMapper;

    @org.springframework.beans.factory.annotation.Autowired
    public MenuApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<Void> addMenuItem(MenuItem menuItem) {
        if (menuItem != null) {
            repository.save(modelMapper.map(menuItem, MenuItemJpa.class));

            return new ResponseEntity<>(HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Menu> listMenu(Integer limit) {
        if (repository.count() == 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        Page<MenuItemJpa> page = repository.findAll(limit != null ? Pageable.ofSize(limit) : Pageable.unpaged());
        List<MenuItem> items = page.stream().map(this::convertToDto).collect(Collectors.toList());

        return ResponseEntity.ok(new Menu(items));
    }

    @Override
    public ResponseEntity<MenuItem> showMenuItemById(Integer itemId) {
        if (repository.existsById(itemId)) {
            MenuItemJpa item = repository.getById(itemId);
            return ResponseEntity.ok(convertToDto(item));
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    private MenuItem convertToDto(MenuItemJpa menuItemJpa) {
        return modelMapper.map(menuItemJpa, MenuItem.class);
    }
}
