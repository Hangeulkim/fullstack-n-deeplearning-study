package com.study.hello_world.controller

import com.study.hello_world.model.Bank
import com.study.hello_world.service.BankService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/banks")
class BankController(private val service: BankService) {

	@GetMapping
	fun helloWorld(): Collection<Bank> = service.getBanks()
}
