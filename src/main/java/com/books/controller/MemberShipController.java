package com.books.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.books.dao.MemberShipRepository;
import com.books.model.MemberShip;

@RestController
public class MemberShipController {
	@Autowired
	MemberShipRepository memberShipRepository;
	
	@GetMapping("memberShip/add")
	public void memberShip(@RequestParam("rs") Integer rs,@RequestParam("userId") Integer userId )
	{
		MemberShip member =new MemberShip();
		LocalDate localDate= LocalDate.now();
		member.setStart(localDate);
		member.setUserId(userId);
		member.setEnd(localDate);
		

		if(rs==1)
		{
		       
		         LocalDate date2 =localDate.plusDays(30);
		     
		        member.setEnd(date2);
		        System.out.println(date2);
		        memberShipRepository.save(member);
	      
			
		}else if(rs==2)
		{
			 LocalDate date2 =localDate.plusDays(30);
		     
		        member.setEnd(date2);
		        System.out.println(date2);
		        memberShipRepository.save(member);
		}
	else
		{
       
			 LocalDate date2 =localDate.plusDays(90); 
			 
	     
	        member.setEnd(date2);
	        memberShipRepository.save(member);
	     
	
		}
		
	}

}
