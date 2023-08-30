package com.example.menu.repository;

import com.example.ceo.domain.entity.Menu;
import com.example.menu.domain.response.MenuResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    @Query("select " +
            "new" +
            "com.example.ceo.domain.response" +
            ".MenuResponse(m.id, m.name, m.price)" +
    "from Menu m " +
    "join m.store s " +
    "where s.id = :storeId")
    Page<MenuResponse> findByStore(Long storeId, PageRequest request);
}
