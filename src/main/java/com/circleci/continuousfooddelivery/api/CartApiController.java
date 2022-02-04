package com.circleci.continuousfooddelivery.api;

import com.circleci.continuousfooddelivery.jpa.CartJpa;
import com.circleci.continuousfooddelivery.jpa.MenuItemJpa;
import com.circleci.continuousfooddelivery.model.Cart;
import com.circleci.continuousfooddelivery.model.MenuItem;
import com.circleci.continuousfooddelivery.repositories.CartRepo;
import com.circleci.continuousfooddelivery.repositories.MenuRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-01-31T03:17:46.722516300-05:00[America/New_York]")
@RestController
@RequestMapping("${openapi.continousFoodDelievery.base-path:/CFD/1.0.0}")
public class CartApiController implements CartApi {

    @Autowired
    private CartRepo repository;

    @Autowired
    private MenuRepo menuRepo;

    private final NativeWebRequest request;

    @Autowired
    private ModelMapper modelMapper;

    @org.springframework.beans.factory.annotation.Autowired
    public CartApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public ResponseEntity<Void> addCartItem(MenuItem menuItem, HttpServletRequest req) {
        if (menuItem == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        CartJpa cart = getCart(req);

        MenuItemJpa menuItemJpa = menuRepo.getById(menuItem.getId());
        menuItemJpa.addToCart(cart);
        menuRepo.save(menuItemJpa);

        cart.addItem(menuItemJpa);
        repository.save(cart);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteCartItem(Integer itemId, HttpServletRequest req) {
        CartJpa cart = getCart(req);

        if (cart.removeItem(itemId)) {
            repository.save(cart);

            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Cart> listCart(Integer limit, HttpServletRequest req) {
        CartJpa cart = getCart(req);

        List<MenuItemJpa> items = cart.getItems();

        if (limit != null) {
            items = items.subList(0, limit);
        }

        return ResponseEntity.ok(new Cart(items.stream()
                .map(item -> modelMapper.map(item, MenuItem.class)).collect(Collectors.toList())));
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    public CartJpa getCart(HttpServletRequest req) {
        return repository.findById(req.getRemoteHost()).orElseGet(() -> {
            CartJpa cart = new CartJpa();
            cart.setId(req.getRemoteHost());
            return repository.save(cart);
        });
    }

}
