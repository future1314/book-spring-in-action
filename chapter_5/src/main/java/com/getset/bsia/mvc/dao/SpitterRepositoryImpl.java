package com.getset.bsia.mvc.dao;

import com.getset.bsia.mvc.entity.Spitter;
import org.springframework.stereotype.Repository;

@Repository
public class SpitterRepositoryImpl implements SpitterRepository {
    @Override
    public Spitter save(Spitter spitter) {
        spitter.setId(12L);
        return spitter;
    }

    @Override
    public Spitter findOne(String username) {
        return new Spitter(12L, "San", "Zhang", "zhangsan", "123456");
    }
}
