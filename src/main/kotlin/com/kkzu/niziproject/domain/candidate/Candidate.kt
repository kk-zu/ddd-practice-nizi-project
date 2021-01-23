package com.kkzu.niziproject.domain.candidate

import com.kkzu.niziproject.domain.DomainException
import java.util.*

class Candidate {

    val candidateId: String
    val name: CandidateName
    var dropedoutPart1: Boolean
        private set
    var dropedoutPart2: Boolean
        private set
    var passed: Boolean
        private set
    var pendant: Pendant
        private set
//    TODO: オーディション実装後に実装する
//    val auditionId: String

    constructor(name: CandidateName) {
        this.candidateId = UUID.randomUUID().toString()
        this.name = name
        this.dropedoutPart1 = false
        this.dropedoutPart2 = false
        this.passed = false
        this.pendant = Pendant()
    }

    /**
     * パート１キューブをセットする
     * @param cube パート１キューブ
     */
    fun acquireCubeByPart1(cube: Cube) {
        if (this.dropedoutPart1 || this.dropedoutPart2)
            throw DomainException("すでに脱落した候補者です。")
        if (this.passed)
            throw DomainException("合格済の候補者です。")
        this.pendant = Pendant(
                this.pendant.part1cubes.plus(cube),
                this.pendant.part2cubes
        )
    }

    /**
     * パート２キューブをセットする
     * @param cube パート２キューブ
     */
    fun acquireCubeByPart2(cube: Cube) {
        if (this.dropedoutPart1 || this.dropedoutPart2)
            throw DomainException("すでに脱落した候補者です。")
        if (this.passed)
            throw DomainException("合格済の候補者です。")
        this.pendant = Pendant(
                this.pendant.part1cubes,
                this.pendant.part2cubes.plus(cube)
        )
    }

    /**
     * パート１脱落
     */
    fun dropoutPart1() {
        if (this.dropedoutPart1 || this.dropedoutPart2)
            throw DomainException("すでに脱落した候補者です。")
        if (this.passed)
            throw DomainException("合格済の候補者です。")
        this.dropedoutPart1 = true
    }

    /**
     * パート２脱落
     */
    fun dropoutPart2() {
        if (this.dropedoutPart1 || this.dropedoutPart2)
            throw DomainException("すでに脱落した候補者です。")
        if (this.passed)
            throw DomainException("合格済の候補者です。")
        this.dropedoutPart2 = true
    }

    /**
     * オーディションに合格
     */
    fun pass() {
        if (this.dropedoutPart1 || this.dropedoutPart2)
            throw DomainException("すでに脱落した候補者です。")
        if (this.passed)
            throw DomainException("合格済の候補者です。")
        this.passed = true
    }

}
