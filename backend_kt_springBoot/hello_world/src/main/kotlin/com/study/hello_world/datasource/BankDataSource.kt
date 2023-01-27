package com.study.hello_world.datasource

import com.study.hello_world.model.Bank

interface BankDataSource {

	fun retrieveBanks(): Collection<Bank>
}
