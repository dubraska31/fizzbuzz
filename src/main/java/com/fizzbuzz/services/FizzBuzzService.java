package com.fizzbuzz.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.fizzbuzz.dto.FizzBuzzResponse;
import com.fizzbuzz.entity.FizzBuzzTransacciones;
import com.fizzbuzz.repository.FizzBuzzTransaccionesRepository;

@Service
public class FizzBuzzService {

	@Autowired
	FizzBuzzTransaccionesRepository fizzBuzzTransaccionesRepository;

	public FizzBuzzResponse getFizzBuzz(int min, int max) {

		int fizzBuzzCont = 0;
		int fizzCont = 0;
		int buzzCont = 0;

		StringBuilder sb = new StringBuilder();

		// mensaje de error que valida cuando los numeros son incorrectos
		if (min > max) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Los parámetros enviados son incorrectos");
		}

		for (int i = min; i <= max; i++) {

			if (i % 3 == 0) {
				if (i % 5 == 0) {
					sb.append("FizzBuzz");
					fizzBuzzCont++;

				} else {
					sb.append("Fizz");
					fizzCont++;
				}
			} else if (i % 5 == 0) {
				sb.append("Buzz");
				buzzCont++;

			} else {
				sb.append(i);
			}

			if (i != max) {
				sb.append(",");
			}

		}

		FizzBuzzResponse fizzBuzzResponse = new FizzBuzzResponse();
		fizzBuzzResponse.setTimestamp(new Date());

		if (fizzBuzzCont > 0) {
			fizzBuzzResponse.setCode("001");
			fizzBuzzResponse.setDescription("se encontraron múltiplos de 3 y 5");

		} else {
			if (fizzCont > 0) {
				fizzBuzzResponse.setCode("002");
				fizzBuzzResponse.setDescription("se encontraron múltiplos de 3");
			} else {
				if (buzzCont > 0) {
					fizzBuzzResponse.setCode("003");
					fizzBuzzResponse.setDescription("se encontraron múltiplos de 5");
				} else {

					fizzBuzzResponse.setCode("004");
					fizzBuzzResponse.setDescription("no se encontraron múltiplos");
				}
			}
		}

		fizzBuzzResponse.setList(sb.toString());

		FizzBuzzTransacciones fizzBuzzTransacciones = new FizzBuzzTransacciones(min, max, sb.toString(), new Date());
		fizzBuzzTransaccionesRepository.save(fizzBuzzTransacciones);

		return fizzBuzzResponse;
	}

	public List<FizzBuzzTransacciones> getTransacciones() {
		return fizzBuzzTransaccionesRepository.findAll();
	}
}
