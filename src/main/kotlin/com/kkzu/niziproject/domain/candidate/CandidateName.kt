package com.kkzu.niziproject.domain.candidate

class CandidateName {

    private val firstName: String
    private val lastName: String

    constructor(firstName: String, lastName: String) {
        this.firstName = firstName
        this.lastName = lastName
    }

    /**
     * 表示名
     * @return {@code lastName} を返します
     */
    fun nickname(): String {
        return this.lastName
    }

}
