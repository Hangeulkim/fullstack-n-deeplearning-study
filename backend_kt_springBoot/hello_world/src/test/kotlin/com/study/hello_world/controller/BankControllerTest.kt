package com.study.hello_world.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.study.hello_world.model.Bank
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.*

@SpringBootTest
@AutoConfigureMockMvc
internal class BankControllerTest @Autowired constructor(
	val mockMvc: MockMvc,
	val objectMapper: ObjectMapper,

	) {
	val baseUrl = "/api/banks"

	@Nested
	@DisplayName("GET /api/banks")
	@TestInstance(TestInstance.Lifecycle.PER_CLASS)
	inner class GetBanks {
		@Test
		fun `should return all banks`() {
			// when/then
			mockMvc.get(baseUrl)
				.andDo { print() }


				//then
				.andExpect {
					status { isOk() }
					content { contentType(MediaType.APPLICATION_JSON) }
					jsonPath("$[0].accountNumber") { value("1234") }
				}

		}
	}

	@Nested
	@DisplayName("GET /api/bank/{accountNumber}")
	@TestInstance(TestInstance.Lifecycle.PER_CLASS)
	inner class getBank {
		@Test
		fun `should return the bank with the given account number`() {
			// given
			val accountNumber = 1234

			// when
			mockMvc.get("$baseUrl/$accountNumber")

				// then
				.andDo { print() }
				.andExpect {
					status { isOk() }
					content { MediaType.APPLICATION_JSON }
					jsonPath("$.trust") { value(3.14) }
					jsonPath("$.transactionFee") { value(18) }
				}
		}

		@Test
		fun `should return Not Found if the account number does not exist`() {
			// given
			val accountNumber = "does_not_exist"

			// when/then

			mockMvc.get("$baseUrl/$accountNumber")
				.andDo { print() }
				.andExpect { status { isNotFound() } }

		}

	}


	@Nested
	@DisplayName("POST /api/banks")
	@TestInstance(TestInstance.Lifecycle.PER_CLASS)
	inner class PostNewBank {
		@Test
		fun `should add the new bank`() {
			// given
			val newBank = Bank("acc123", 31.415, 2)

			// when
			val performPost = mockMvc.post(baseUrl) {
				contentType = MediaType.APPLICATION_JSON
				content = objectMapper.writeValueAsString(newBank)
			}

			// then
			performPost.andDo { print() }
				.andExpect {
					status { isCreated() }
					content {
						contentType(MediaType.APPLICATION_JSON)
						json(objectMapper.writeValueAsString(newBank))
					}
				}

			mockMvc.get("$baseUrl/${newBank.accountNumber}")
				.andExpect { content { json(objectMapper.writeValueAsString(newBank)) } }
		}

		@Test
		fun `should return BAD REQUEST if bank with given accountnubmer already exist`() {
			// given
			val invalidBank = Bank("1234", 12.3, 12)

			// when
			val performPost = mockMvc.post(baseUrl) {
				contentType = MediaType.APPLICATION_JSON
				content = objectMapper.writeValueAsString(invalidBank)
			}

			// then
			performPost
				.andDo { print() }
				.andExpect { status { isBadRequest() } }

		}

	}

	@Nested
	@DisplayName("PATCH /api/banks")
	@TestInstance(TestInstance.Lifecycle.PER_CLASS)
	inner class PatchExistingBank {
		@Test
		fun `should update an existing bank`() {
			// given
			val updatedBank = Bank("1234", 1.0, 11)

			// when
			val performPatchRequest = mockMvc.patch(baseUrl) {
				contentType = MediaType.APPLICATION_JSON
				content = objectMapper.writeValueAsString(updatedBank)
			}

			// then
			performPatchRequest
				.andDo { print() }
				.andExpect {
					status { isOk() }
					content {
						contentType(MediaType.APPLICATION_JSON)
						json(objectMapper.writeValueAsString(updatedBank))
					}
				}

			mockMvc.get("$baseUrl/${updatedBank.accountNumber}")
				.andExpect { content { { json(objectMapper.writeValueAsString(updatedBank)) } } }

		}

		@Test
		fun `should return BAD REQUEST if no bank with given account number exists`() {
			// given
			val invalidBank = Bank("does_not_exist", 1.0, 1)

			// when
			val performPatchRequest = mockMvc.patch(baseUrl) {
				contentType = MediaType.APPLICATION_JSON
				content = objectMapper.writeValueAsString(invalidBank)
			}

			// then
			performPatchRequest
				.andDo { print() }
				.andExpect { status { isNotFound() } }

		}


	}

	@Nested
	@DisplayName("DELETE /api/banks/{accountNumber}")
	@TestInstance(TestInstance.Lifecycle.PER_CLASS)
	inner class DeleteExistingBank {
		@Test
		fun `should delete the bank with the given account number`() {
			// given
			val accountNumber = 1234

			// when
			mockMvc.delete("$baseUrl/$accountNumber")

				// then
				.andDo { { print() } }
				.andExpect {
					status { isNoContent() }
				}

			mockMvc.get("$baseUrl/$accountNumber")
				.andExpect { status { isNotFound() } }
		}

		@Test
		fun `should return NOT FOUND if no bank with given account number exists`() {
			// given
			val invalidAccountNumber = "does_not_exist"

			// when
			mockMvc.delete("$baseUrl/$invalidAccountNumber")

				// then
				.andDo { print() }
				.andExpect { status { isNotFound() } }

		}

	}

}
