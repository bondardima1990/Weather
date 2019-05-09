package com.dima.weather.data.mappers;

public interface Mapper<F, M> {

    M from(F data);
    F to(F model);
}
