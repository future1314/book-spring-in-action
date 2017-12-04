package com.getset.bsia.mvc.dao;

import com.getset.bsia.mvc.entity.Spittle;

import java.util.List;

public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);
    Spittle findSpittle(long id);
}
