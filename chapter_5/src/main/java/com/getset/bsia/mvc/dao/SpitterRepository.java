package com.getset.bsia.mvc.dao;

import com.getset.bsia.mvc.entity.Spitter;

public interface SpitterRepository {
    Spitter save(Spitter spitter);
    Spitter findOne(String username);
}
