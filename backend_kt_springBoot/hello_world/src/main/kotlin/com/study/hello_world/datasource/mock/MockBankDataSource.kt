package com.study.hello_world.datasource.mock

import com.study.hello_world.datasource.BankDataSource
import com.study.hello_world.model.Bank
import org.springframework.stereotype.Repository

@Repository
class MockBankDataSource : BankDataSource {
	val banks = mutableListOf(
		Bank("1234", 3.14, 18),
		Bank("110", 17.0, 0),
		Bank("5678", 0.0, 100),
	)

	override fun retrieveBanks(): Collection<Bank> = banks

	override fun retrieveBank(accountNumber: String): Bank =
		banks.firstOrNull() { it.accountNumber == accountNumber }
			?: throw NoSuchElementException("Could not find a bank with account number $accountNumber aaa")

	override fun createBank(bank: Bank): Bank {
		if (banks.any { it.accountNumber == bank.accountNumber }) {
			throw IllegalArgumentException("Bank with account number ${bank.accountNumber} already exist")
		}
		banks.add(bank)

		return bank
	}

	override fun updateBank(bank: Bank): Bank {
		val currentBank = banks.firstOrNull { it.accountNumber == bank.accountNumber }
			?: throw NoSuchElementException("Could not find a bank with account number $bank.accountNumber aaa")

		banks.remove(currentBank)
		banks.add(bank)

		return bank
	}

	override fun deleteBank(accountNumber: String) {
		val currentBank = banks.firstOrNull { it.accountNumber == accountNumber }
			?: throw NoSuchElementException("Could not find a bank with account number $accountNumber aaa")

		banks.remove(currentBank)
	}
}
