package ru.spring.webcollections.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.spring.webcollections.domains.WEBCollection;

import java.util.List;

public interface WEBCollectionRepos extends CrudRepository<WEBCollection, Integer> {

    List<WEBCollection> findByName(String name);
}