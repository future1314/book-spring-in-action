package com.getset.bsia.mvc.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Spitter not found.")
public class SpitterNotFoundExcepiton extends RuntimeException {
}
