package com.example.ceo.service;

import com.example.ceo.domain.entity.Owner;
import com.example.ceo.domain.request.OwnerRequest;
import com.example.ceo.domain.response.OwnerResponse;
import com.example.ceo.repository.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class OwnerService {
    private final OwnerRepository ownerRepository;

    public void save(OwnerRequest request){
        ownerRepository.save(request.toEntity());
    }

    public OwnerResponse getById(UUID ownerId){
        Owner owner = ownerRepository.findById(ownerId)
                .orElseThrow(() -> new IllegalArgumentException("NO CEO"));
        return new OwnerResponse(owner.getId(), owner.getName(), owner.getNumber());
    }
}
