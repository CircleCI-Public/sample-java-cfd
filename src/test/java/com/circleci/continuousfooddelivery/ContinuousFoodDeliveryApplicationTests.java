package com.circleci.continuousfooddelivery;

import com.circleci.continuousfooddelivery.jpa.MenuItemJpa;
import com.circleci.continuousfooddelivery.model.MenuItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ContinuousFoodDeliveryApplicationTests {

    private ModelMapper modelMapper = new ModelMapper();

    @Test
    void mapMenuItemJpaToDto() {
        MenuItemJpa item = new MenuItemJpa("Water", "Fresh from the tap", 1.99f, 1);
        MenuItem mapped = modelMapper.map(item, MenuItem.class);

        Assertions.assertEquals(item.getId(), mapped.getId());
        Assertions.assertEquals(item.getDescription(), mapped.getDescription());
        Assertions.assertEquals(String.valueOf(item.getPrice()), mapped.getPrice().toString());
        Assertions.assertEquals(item.getImageId(), mapped.getImageId());
    }

    @Test
    void contextLoads() {
    }

}
