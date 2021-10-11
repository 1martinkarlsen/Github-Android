package dk.vixo.githubandroid.github.domain.model

import dk.vixo.githubandroid.github.data.network.dto.OwnerDTO

data class Repository(
    val id: Long,
    val name: String,
    val fullName: String,
    val description: String,
    val owner: OwnerDTO,
    val stars: Long,
    val watchers: Long,
    val pullRequestUrl: String
)