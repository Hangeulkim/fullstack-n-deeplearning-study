package com.study.hello_world.datasource

import com.study.hello_world.model.Bank

interface BankDataSource {

	fun retrieveBanks(): Collection<Bank>

	fun retrieveBank(accountNumber: String): Bank

	fun createBank(bank: Bank): Bank

	fun updateBank(bank: Bank): Bank
}
