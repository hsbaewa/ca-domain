package kr.co.hs.domain.entity

data class SimpleEntity(
    val text: String
) : Entity {
    override var isCachedData: Boolean = false
    override var isRemoteData: Boolean = false
}