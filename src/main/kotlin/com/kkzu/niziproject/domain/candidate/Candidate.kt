package com.kkzu.niziproject.domain.candidate

import java.util.*

class Candidate {

    var candidateId: String
    val name: CandidateName
    var dropedoutPart1: Boolean
    var dropedoutPart2: Boolean
    var passed: Boolean
    var pendant: Pendant
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
        if (this.dropedoutPart1 || this.dropedoutPart2) throw IllegalArgumentException()
        this.pendant = Pendant(
                this.pendant.part1cubes,
                this.pendant.part2cubes.plus(cube)
        )
    }

}
