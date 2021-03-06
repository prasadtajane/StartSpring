package com.prasad.spring.persistence;

import java.util.Optional;

import com.prasad.spring.persistence.entity.Weather;

public class SimpleOptional {
	
	public static void main(String ags[])	{

		Weather wthr = new Weather();
		//Weather wthr = null;
		System.out.println(wthr);

		Optional<Weather> op = Optional.ofNullable(wthr);
		if (op.isPresent())
			System.out.println(op.get());
		
		wthr.setCity("Delhi");
		wthr.setDescription("Hot day");
		
		//System.out.println(op.get());
		
		op.ifPresent((wth) -> System.out.println(wth));
		op.ifPresent(System.out::println);
		
		Weather wth = op.orElseThrow(() -> new RuntimeException("Not Present"));
		System.out.println(wth);
		
	}
	
}
