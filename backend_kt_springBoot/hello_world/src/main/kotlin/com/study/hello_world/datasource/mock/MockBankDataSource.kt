package com.study.hello_world.datasource.mock

import com.study.hello_world.datasource.BankDataSource
import com.study.hello_world.model.Bank
import org.springframework.stereotype.Repository

@Repository
class MockBankDataSource : BankDataSource {
	val banks = listOf(
		Bank("1234", 3.14, 18),
		Bank("110", 17.0, 0),
		Bank("5678", 0.0, 100),
	)

	override fun retrieveBanks(): Collection<Bank> = banks
}
