package com.example.store.domain.request;

import com.example.ceo.domain.entity.Owner;
import com.example.ceo.domain.entity.Store;

import java.util.UUID;

public record StoreRequest(
        String location, String name, String img
        ){
    public Store toEntity(UUID ownerId){
        return Store.builder()
                .name(name)
                .img(img)
                .location(location)
                .owner(Owner.builder().id(ownerId).build())
                .build();

    }
}
