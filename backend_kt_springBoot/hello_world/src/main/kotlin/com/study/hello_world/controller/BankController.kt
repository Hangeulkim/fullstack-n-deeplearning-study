package com.study.hello_world.controller

import com.study.hello_world.model.Bank
import com.study.hello_world.service.BankService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/banks")
class BankController(private val service: BankService) {

	@ExceptionHandler(NoSuchElementException::class)
	fun handleNotFound(e: NoSuchElementException): ResponseEntity<String> =
		ResponseEntity(e.message, HttpStatus.NOT_FOUND)

	@ExceptionHandler(IllegalArgumentException::class)
	fun handleNotFound(e: IllegalArgumentException): ResponseEntity<String> =
		ResponseEntity(e.message, HttpStatus.BAD_REQUEST)

	@GetMapping
	fun helloWorld(): Collection<Bank> = service.getBanks()

	@GetMapping("/{accountNumber}")
	fun getBBank(@PathVariable accountNumber: String) = service.getBank(accountNumber)

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	fun addBank(@RequestBody bank: Bank): Bank = service.addBank(bank)

	@PatchMapping
	fun updateBank(@RequestBody bank: Bank): Bank = service.updateBank(bank)

	@DeleteMapping("/{accountNumber}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	fun deleteBank(@PathVariable accountNumber: String): Unit = service.deleteBank(accountNumber)
}
