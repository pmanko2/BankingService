package com.example.helpers

import com.example.dtos.AccountBalanceDto
import com.example.dtos.DepositRequestDto
import com.example.models.BankAccount
import javax.inject.Singleton

@Singleton
open class AccountHelper {
    private val bankAccounts: MutableMap<Int, BankAccount>

    // creating an in memory representation of all our bank accounts. Since AccountHelper is a Singleton we are
    // guaranteed that this representation will only be initialized once on app start up
    init {
        // these are just arbitrary initial balances for these 3 bank accounts. Feel free to change around for testing
        // purposes
        mutableMapOf(
            1 to BankAccount(1, 0.0),
            2 to BankAccount(2, 35.0),
            3 to BankAccount(3, -20.0)
        ).also { bankAccounts = it }
    }

    /**
     * Queries the bankAccounts Map to get the desired BankAccount and returns the account's current balance.
     *
     * TODO What happens if the id does not exist in our Map? ! is the non-null assertion operator that will throw an
     *  exception if bankAccounts[id] is null. See if you can handle this case in a better fashion.
     *
     *  Some more reading about Kotlin null safety here: https://kotlinlang.org/docs/null-safety.html
     */
    fun getBalanceForAccount(id: Int): AccountBalanceDto {
        return bankAccounts[id]!!.getAccountBalance()
    }

    /**
     * Adds the given deposit amount to a bank account and returns the new balance of that bank account.
     */
    fun depositToAccount(deposit: DepositRequestDto): AccountBalanceDto {
        return updateBankAccountById(deposit.bankAccountId, deposit.amount).getAccountBalance()
    }

    /**
     * TODO create a withdrawFromAccount() method similar to above. Make sure to include error checking!
     *
     * fun withdrawFromAccount(): {
     * }
     */

    private fun updateBankAccountById(bankAccountId: Int, depositAmount: Double): BankAccount {
        /**
         * TODO implement this method.
         *  1. Get the desired BankAccount using the bankAccountId parameter. (Remember that we are currently storing
         *  the bank accounts in the bankAccounts MutableMap variable declared above)
         *  2. Deposit the depositAmount into this bank account
         *  3. Save the updated bank account back to our bankAccounts variable
         *  4. Return the updated BankAccount
         *  5. Handle null bank accounts that can't be found in our bankAccounts Map
         */
        return BankAccount(1, 1.0)
    }
}
