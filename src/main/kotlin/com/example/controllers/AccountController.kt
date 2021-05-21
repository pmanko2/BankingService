package com.example.controllers

import com.example.dtos.AccountBalanceDto
import com.example.dtos.DepositRequestDto
import com.example.helpers.AccountHelper
import io.micronaut.context.annotation.Context
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*

@Controller("/accounts")
@Context
class AccountController(
    private val accountHelper: AccountHelper
) {
    /**
     * Defines an HTTP GET route to get information about a user's current balance given a bank account id
     */
    @Get("/{id}")
    fun getAccountBalance(@PathVariable id: Int): HttpResponse<AccountBalanceDto> {
        val accountBalance = accountHelper.getBalanceForAccount(id);
        return HttpResponse.ok(accountBalance)
    }

    /**
     * Defines an HTTP POST route to deposit money into a bank account. Returns an AccountBalanceDto with information
     * about the updated balance
     */
    @Post(consumes = [MediaType.APPLICATION_JSON])
    fun deposit(@Body deposit: DepositRequestDto): HttpResponse<AccountBalanceDto> {
        val newAccountBalance = accountHelper.depositToAccount(deposit)
        return HttpResponse.ok(newAccountBalance)
    }

    /**
     * TODO create a withdraw controller method similar to the deposit() method above. Think about if/how the withdrawal
     *  POST body will need to be different. Could you just reuse the DepositRequestDto body that's being used for the
     *  deposit() method?
     *
     *  Things to think about:
     *
     *  1. Can you reuse the DepositRequestBody as the POST body for this method? Or does the user request data need
     *     to change in any way?
     *
     *  2. How would you design the response to the user? For the deposit method we show the user their updated bank
     *     account balance. What else would the user need in the response when they are withdrawing money.
     */
}
