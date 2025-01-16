package com.example.lab11;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class EvenimentNotFoundException  extends RuntimeException{
	public EvenimentNotFoundException(String mesaj) {
		super(mesaj);
		}
}
