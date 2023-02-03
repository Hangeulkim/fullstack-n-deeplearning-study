package com.study.hello_world.service

import com.study.hello_world.datasource.BankDataSource
import com.study.hello_world.model.Bank
import org.springframework.stereotype.Service

@Service
class BankService(private val dataSource: BankDataSource) {
	fun getBanks(): Collection<Bank> {
		return dataSource.retrieveBanks()
	}

	fun getBank(accountNumber: String): Bank = dataSource.retrieveBank(accountNumber)

	fun addBank(bank: Bank): Bank = dataSource.createBank(bank)

	fun updateBank(bank: Bank): Bank = dataSource.updateBank(bank)

	fun deleteBank(accountNumber: String): Unit = dataSource.deleteBank(accountNumber)
}
